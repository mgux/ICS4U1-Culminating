import java.io.*;
import java.util.ArrayList;

/*
* Programmer: Michael Gu
* Last Updated: 2025-01-20
* This program manages the air vehicles (jet and aircraft) with different methods
* */

public class AirManager {
    private final int CUR_YEAR = 2025;
    private ArrayList<AirVehicle> airVehicles;

    public AirManager() {
        airVehicles = new ArrayList<AirVehicle>();
    }

    public boolean readAircraftVehicle(String s)
    {
        boolean isRead = true;
        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader(s));
            try
            {
                addAircraft(
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        in.readLine(),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Double.parseDouble(in.readLine()),
                        Double.parseDouble(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine())
                );


            }
            catch (NumberFormatException nfx)
            {
                isRead = false;
            }

            in.close();
            System.out.println("true");
        }
        catch (IOException io)
        {
            isRead = false;
        }
        return isRead;
    }

    public boolean readJetVehicle(String s)
    {
        boolean isRead = true;
        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader(s));
            try
            {
                addJet(
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        in.readLine(),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        in.readLine(),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine()),
                        Integer.parseInt(in.readLine())
                );

            }
            catch (NumberFormatException nfx)
            {
                isRead = false;
            }

            in.close();
            System.out.println("true");
        }
        catch (IOException io)
        {
            isRead = false;
        }
        return isRead;
    }

    public boolean outAirVehicles(String s)
    {
        boolean isOut = true;
        BufferedWriter out;
        try
        {
            out = new BufferedWriter(new FileWriter(s, true));
            for (int i = 0; i < airVehicles.size(); i++)
            {
                if (airVehicles.get(i) instanceof Aircraft)
                {
                    out.write("Aircraft\n");
                }
                else
                {
                    out.write("Jet\n");
                }
                out.write((airVehicles.get(i)).toString());
            }
            out.close();
        }
        catch (IOException io)
        {
            isOut = false;
        }
        return isOut;
    }


    public void sortManufactureLocation() {
        int n = airVehicles.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                AirVehicle current = airVehicles.get(j);
                AirVehicle min = airVehicles.get(minIndex);
                if (current.getManufactureYear() < min.getManufactureYear() ||
                        (current.getManufactureYear() == min.getManufactureYear() &&
                                current.getLocation().compareTo(min.getLocation()) < 0)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                AirVehicle temp = airVehicles.get(i);
                airVehicles.set(i, airVehicles.get(minIndex));
                airVehicles.set(minIndex, temp);
            }
        }
    }

    public ArrayList<AirVehicle> searchManufactureLocation(int manufactureYear, String location) {
        ArrayList<AirVehicle> result = new ArrayList<>();
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getManufactureYear() == manufactureYear && airVehicles.get(i).getLocation().equals(location)) {
                result.add(airVehicles.get(i));
            }
        }

        return result;
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
        AirVehicle temp;

        for (int i = 0; i < n - 1 && swapped; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (airVehicles.get(j).getSerialNum().compareTo(airVehicles.get(j + 1).getSerialNum()) > 0) {
                    temp = airVehicles.get(j);
                    airVehicles.set(j,airVehicles.get(j + 1));
                    airVehicles.set((j+1), temp);
                    swapped = true;
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

    public AirVehicle findMostExpensiveAirVehicle() {
        AirVehicle air = null;
        for (int i = 0; i < airVehicles.size(); i++)
        {
            if (air == null)
            {
                air = airVehicles.get(i);
            }
            else
            {
                if (air.compareCost(airVehicles.get(i)) < 0) {
                    air = airVehicles.get(i);
                }
            }
        }
        return air;
    }

    public boolean repairAirVehicle(String s)
    {
        AirVehicle temp = searchVehicleSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.addRepair();
    }

    public boolean updateParts(String s, int n)
    {
        AirVehicle temp = searchVehicleSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.removeParts(n);
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

    public boolean addAircraft(int engineNum, int wingNum, int manufactureYear, int speed, String location, int cost, int altitude, int cargoWeight, double storage, double maxCargoWeight, int maxJeepStorage, int parts, int minParts, int maxParts) {
        Aircraft newAircraft = new Aircraft(engineNum,  wingNum,  manufactureYear,  speed,  location,  cost,  altitude,  cargoWeight,  storage,  maxCargoWeight,  maxJeepStorage,  parts,  minParts,  maxParts);
        airVehicles.add(newAircraft);
        return true;
    }

    public boolean addJet(int engineNum, int wingNum, int manufactureYear, int speed, String location, int cost, int altitude, String missileType, int agility, int storageTaken, int parts, int minParts, int maxParts) {
        Jet newJet = new Jet(engineNum,  wingNum,  manufactureYear,  speed,  location,  cost,  altitude,  missileType,  agility,  storageTaken, parts, minParts, maxParts);
        airVehicles.add(newJet);
        return true;
    }

    public boolean removeAirVehicle(String serial) {
        if (searchVehicleSerial(serial) == null) {
            return false;
        }
        else {
            airVehicles.remove(searchVehicleSerial(serial));
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

}
