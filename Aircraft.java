import java.util.ArrayList;

public class Aircraft extends AirVehicle{
    private int cargoWeight;
    private double storage;
    private double maxCargoWeight;
    private int maxJeepStorage;
    private int maxJetStorage;
    private int currentJeeps = 0;
    private Ship containedVehicle = null;

    private ArrayList<Jeep> jeepInAircraft = new ArrayList<>();
    private ArrayList<Repairs> repairHistory = new ArrayList<>();


    public Aircraft(int engineNum, int wingNum, int manufactureYear, String serialNum, int speed, String location, int cost, int altitude, int cargoWeight, double storage, double maxCargoWeight, int maxJeepStorage, int parts, int minParts, int maxParts) {
        super(engineNum, wingNum, manufactureYear, serialNum, speed, location, cost, altitude,parts,minParts,maxParts);
        this.cargoWeight = cargoWeight;
        this.storage = storage;
        this.maxCargoWeight = maxCargoWeight;
        this.maxJeepStorage = maxJeepStorage;
    }

    public boolean addJeep(Jeep jeep) {
        if (currentJeeps < maxJeepStorage) {
            jeepInAircraft.add(jeep);
            currentJeeps++;
            return true;
        }
        return false;
    }

    public boolean removeJeep(String serial) {
        Jeep findJeep = searchVehicleSerial(serial);
        if (findJeep == null) {
            return false;
        }
        jeepInAircraft.remove(findJeep);
        currentJeeps--;
        return true;
    }

    public Jeep searchVehicleSerial(String serial) {
        for (int i = 0; i < jeepInAircraft.size(); i++) {
            if (jeepInAircraft.get(i).getSerialNum().equals(serial)) {
                return jeepInAircraft.get(i);
            }
        }
        return null;
    }

    public int compareEngineNum(Aircraft aircraft) {
        return this.getEngineNum() - aircraft.getEngineNum();
    }

    public int compareAltitude(Aircraft aircraft) {
        return this.getAltitude() - aircraft.getAltitude();
    }

    public int compareWingNum(Aircraft aircraft) {
        return this.getWingNum() - aircraft.getWingNum();
    }

    public int compareCargo(Aircraft aircraft) {
        return this.cargoWeight - aircraft.cargoWeight;
    }

    public int compareSpeed(Aircraft aircraft) {
        return this.getSpeed() - aircraft.getSpeed();
    }

    public Ship getContainedVehicle() {
        return containedVehicle;
    }

    public void setContainedVehicle(Ship containedVehicle) {
        this.containedVehicle = containedVehicle;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public double getStorage() {
        return storage;
    }

    public double getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public int getMaxJeepStorage() {
        return maxJeepStorage;
    }

    public int getMaxJetStorage() {
        return maxJetStorage;
    }

    public int getCurrentJeeps() {
        return currentJeeps;
    }

    public ArrayList<Jeep> getCurrentlyCarried() {
        return jeepInAircraft;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public void setMaxCargoWeight(double maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    public void setMaxJeepStorage(int maxJeepStorage) {
        this.maxJeepStorage = maxJeepStorage;
    }

    public void setMaxJetStorage(int maxJetStorage) {
        this.maxJetStorage = maxJetStorage;
    }


    public void setCurrentJeeps(int currentJeeps) {
        this.currentJeeps = currentJeeps;
    }
    
    public String toString() {
        return "Cargo Weight: " + cargoWeight + "\nStorage: " + storage + "Maximum cargo weight: " + maxCargoWeight + "Maximum jeep storage: " + maxJeepStorage + "Maximum jet storage: " + maxJetStorage + "Current Jeeps: " + currentJeeps + "Contained Vehicle: " + containedVehicle.getSerialNum() + "\n" + super.toString();
    }
}
