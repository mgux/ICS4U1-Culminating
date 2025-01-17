import java.util.ArrayList;
import java.util.Objects;

public class AirManager {
    private final int CUR_YEAR = 2025;
    private int numAir;
    private int currentNum = 0;
    private ArrayList<AirVehicle> airVehicles = new ArrayList<>();

    public boolean repairAirVehicle(String serial) {
        AirVehicle air;
        air = searchVehicleSerial(serial);
        if (air == null) {
            return false;
        }
        if (air.getParts() == air.getMaxParts()) {
            return false;
        }
        // ZAZA ADD MORE
        return true;
    }

    public ArrayList<AirVehicle> searchVehicleWingNum(int wingNum) {
        ArrayList<AirVehicle> hasNumWing = new ArrayList<>();
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getWingNum() == wingNum) {
                hasNumWing.add(airVehicles.get(i));
            }
        }
        return hasNumWing;
    }

    public AirVehicle searchVehicleSerial(String serial) {
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getSerialNum().equals(serial)) {
                return airVehicles.get(i);
            }
        }
        return null;
    }

    public void sortSerial() {
        int n = airVehicles.size();
        boolean swapped = true;

        for (int i = 0; i < n - 1 && swapped; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (airVehicles.get(j).getSerialNum().compareTo(airVehicles.get(j + 1).getSerialNum()) > 0) {
                    String temp = airVehicles.get(j).getSerialNum();
                    airVehicles.get(j).setSerialNum(airVehicles.get(j + 1).getSerialNum());
                    airVehicles.get(j + 1).setSerialNum(temp);
                }
            }
        }
    }

    public AirVehicle findHighestVehicle() {
        AirVehicle highest = airVehicles.getFirst();
        for (int i = 1; i < airVehicles.size(); i++) {
            if (highest.compareAltitude(airVehicles.get(i)) > 0) {
                // might be the other way around
                highest = airVehicles.get(i);
            }
        }
        return highest;
    }

    public Aircraft findBiggestCargoWeight() {
        int biggest = 0;
        int index = 0;
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i) instanceof Aircraft) {
                if (((Aircraft) airVehicles.get(i)).getCargoWeight() > biggest) {
                    index = i;
                    biggest = ((Aircraft) airVehicles.get(i)).getCargoWeight();
                }
            }
        }

        return (Aircraft) airVehicles.get(index);
    }

    public ArrayList<Jet> findJetsWithMissileType(String type) {
        ArrayList<Jet> jets = new ArrayList<>();

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i) instanceof Jet) {
                if (((Jet) airVehicles.get(i)).getMissileType().equals(type)) {
                    jets.add((Jet) airVehicles.get(i));
                }
            }
        }

        return jets;
    }

    public ArrayList<AirVehicle> findAtLocation(String loc) {
        ArrayList<AirVehicle> air = new ArrayList<>();

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getLocation().equals(loc)) {
                air.add(airVehicles.get(i));
            }
        }
        return air;
    }

    public Jet findMostAgileJet() {
        int agile = 0;
        int index = 0;

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i) instanceof Jet) {
                if (((Jet) airVehicles.get(i)).getAgility() > agile) {
                    index = i;
                    agile = ((Jet) airVehicles.get(i)).getAgility();
                }
            }
        }

        return (Jet) airVehicles.get(index);
    }

    public ArrayList<AirVehicle> findEngineNum(int num) {
        ArrayList<AirVehicle> airWithEngineNum = new ArrayList<>();
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getEngineNum() == num) {
                airWithEngineNum.add(airVehicles.get(i));
            }
        }

        return airWithEngineNum;
    }

    public ArrayList<AirVehicle> findOverAge(int age) {
        ArrayList<AirVehicle> airOverAge = new ArrayList<>();

        for (int i = 0; i < airVehicles.size(); i++) {
            if (CUR_YEAR - airVehicles.get(i).getManufactureYear() > age) {
                airOverAge.add(airVehicles.get(i));
            }
        }
        return airOverAge;
    }

    public Jet findFastestJet() {
        int speed = 0;
        int index = 0;

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i) instanceof Jet) {
                if (( airVehicles.get(i)).getSpeed() > speed) {
                    index = i;
                    speed = airVehicles.get(i).getSpeed();
                }
            }
        }

        return (Jet) airVehicles.get(index);
    }

    public Aircraft findFastestAircraft() {
        int speed = 0;
        int index = 0;

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i) instanceof Aircraft) {
                if (( airVehicles.get(i)).getSpeed() > speed) {
                    index = i;
                    speed = airVehicles.get(i).getSpeed();
                }
            }
        }

        return (Aircraft) airVehicles.get(index);
    }

    public Aircraft mostExpensiveAircraft() {
        int price = 0;
        int index = 0;

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i) instanceof Aircraft) {
                if (( airVehicles.get(i)).getCost() > price) {
                    index = i;
                    price = airVehicles.get(i).getCost();
                }
            }
        }

        return (Aircraft) airVehicles.get(index);
    }

    public Jet mostExpensiveJet() {
        int price = 0;
        int index = 0;

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i) instanceof Jet) {
                if (( airVehicles.get(i)).getCost() > price) {
                    index = i;
                    price = airVehicles.get(i).getCost();
                }
            }
        }

        return (Jet) airVehicles.get(index);
    }

    public ArrayList<AirVehicle> searchVehicleWingNumber(int wingNum) {
        ArrayList<AirVehicle> airWingNum = new ArrayList<>();

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getWingNum() == wingNum) {
                airWingNum.add(airVehicles.get(i));
            }
        }
        return airWingNum;
    }

    public boolean addAircraft(int engineNum, int wingNum, int manufactureYear, int speed, String location, int cost, int altitude, int partSwapWorth, int cargoWeight, double storage, double maxCargoWeight, int maxJeepStorage, int maxJetStorage, int parts, int minParts, int maxParts) {
        Aircraft newAircraft = new Aircraft(engineNum,  wingNum,  manufactureYear,  speed,  location,  cost,  altitude,  partSwapWorth,  cargoWeight,  storage,  maxCargoWeight,  maxJeepStorage,  parts,  minParts,  maxParts);
        airVehicles.add(newAircraft);
        numAir++;
        return true;
    }

    public boolean addJet(int engineNum, int wingNum, int manufactureYear, int speed, String location, int cost, int altitude, int partSwapWorth, String missileType, int agility, int storageTaken, int parts, int minParts, int maxParts) {
        Jet newJet = new Jet(engineNum,  wingNum,  manufactureYear,  speed,  location,  cost,  altitude,  partSwapWorth,  missileType,  agility,  storageTaken, parts, minParts, maxParts);
        airVehicles.add(newJet);
        numAir++;
        return true;
    }

    public boolean removeAirVehicle(String serial) {
        if (searchVehicleSerial(serial) == null) {
            return false;
        }
        else {
            airVehicles.remove(searchVehicleSerial(serial));
            numAir--;
        }
        return true;
    }

    public Ship isCarriedJet(String serial) {
        Jet findJet = (Jet) searchVehicleSerial(serial);
        if (findJet == null) {
            return null;
        }
        return findJet.getContainedObject();
    }


    public AirManager() {
        numAir = 0;
    }
}