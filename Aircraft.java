import java.util.ArrayList;

public class Aircraft extends AirVehicle{
    private double cargoWeight;
    private double storage;
    private double maxCargoWeight;
    private int maxJeepStorage;
    private int maxJetStorage;
    private ArrayList<Jet> jetInAircraft = new ArrayList<>();
    private ArrayList<Jeep> jeepInAircraft = new ArrayList<>();
    private int currentJets = 0;
    private int currentJeeps = 0;


    public Aircraft(int engineNum, int wingNum, int manufactureYear, String serialNum, int speed, String location, int cost, int altitude, int partSwapWorth, double cargoWeight, double storage, double maxCargoWeight, int maxJeepStorage, int maxJetStorage, int parts, int minParts, int maxParts) {
        super(engineNum, wingNum, manufactureYear, serialNum, speed, location, cost, altitude, partSwapWorth,parts,minParts,maxParts);
        this.cargoWeight = cargoWeight;
        this.storage = storage;
        this.maxCargoWeight = maxCargoWeight;
        this.maxJeepStorage = maxJeepStorage;
        this.maxJetStorage = maxJetStorage;
    }

    public boolean addJeep(Jeep jeep) {
        if (currentJeeps < maxJeepStorage) {
            jeepInAircraft.add(jeep);
            currentJeeps++;
            return true;
        }
        return false;
    }

    public boolean addJet(Jet jet) {
        if (currentJets < maxJetStorage) {
            jetInAircraft.add(jet);
            currentJets++;
            return true;
        }
        return false;
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



    public String toString() {
        return "Aircraft{" +
                "cargoWeight=" + cargoWeight +
                ", storage=" + storage +
                ", maxCargoWeight=" + maxCargoWeight +
                ", maxJeepStorage=" + maxJeepStorage +
                ", maxJetStorage=" + maxJetStorage +
                '}';
    }
}