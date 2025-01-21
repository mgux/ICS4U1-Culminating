import java.io.*;
import java.util.ArrayList;

/*
* Programmer: Michael Gu
* Last Updated: 2025-01-20
* This program manages the air vehicles (jet and aircraft) with different methods
* */

public class AirManager {
    private final int CUR_YEAR = 2025;// The current year used to calculate the age of air vehicles.
    private ArrayList<AirVehicle> airVehicles;// List to store AirVehicle objects.

        // Constructor: Initializes the list of air vehicles.
    public AirManager() {
        airVehicles = new ArrayList<AirVehicle>();
    }

        /**
     * Reads aircraft data from a file and adds it to the airVehicles list.
     *  s The file path containing aircraft data.
     *  true if the aircraft is successfully read and added, false otherwise.
     */
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
                        in.readLine(),
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

        /**
     * Reads jet data from a file and adds it to the airVehicles list.
     *  s The file path containing jet data.
     *  true if the jet is successfully read and added, false otherwise.
     */
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
                        in.readLine(),
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
        }
        catch (IOException io)
        {
            isRead = false;
        }
        return isRead;
    }
    
    /**
     * Writes the details of all air vehicles to a file.
     *  s The file path to write to.
     *  true if writing is successful, false otherwise.
     */
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
                out.newLine();
            }
            out.close();
        }
        catch (IOException io)
        {
            isOut = false;
        }
        return isOut;
    }

    /**
     * Sorts the air Vehicles by manufacture year and then by location alphabetically.
     */
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
    /**
     * Searches for air vehicles by manufacture year and location.
     *  manufactureYear The manufacture year to search for.
     *  location The location to search for.
     *  A list of matching air vehicles.
     */
    public ArrayList<AirVehicle> searchManufactureLocation(int manufactureYear, String location) {
        ArrayList<AirVehicle> result = new ArrayList<>();
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getManufactureYear() == manufactureYear && airVehicles.get(i).getLocation().equals(location)) {
                result.add(airVehicles.get(i));
            }
        }

        return result;
    }

    /**
 * Searches for air vehicles with a specific number of wings.
 *  wingNum The number of wings to search for.
 *  A list of air vehicles that have the specified # of wings.
 */
    public ArrayList<AirVehicle> searchVehicleWingNum(int wingNum) {
        ArrayList<AirVehicle> hasNumWing = new ArrayList<>();
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getWingNum() == wingNum) {
                hasNumWing.add(airVehicles.get(i));
            }
        }
        return hasNumWing;
    }

    /**
 * Searches for an air vehicle with a specific serial number.
 *  serial The serial number to search for.
 *  The air vehicle with the specified serial number, or null if not found.
 */
    public AirVehicle searchVehicleSerial(String serial) {
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getSerialNum().equals(serial)) {
                return airVehicles.get(i);
            }
        }
        return null;
    }

    /**
 * Sorts the air vehicles by their serial numbers in ascending order.
 */
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

/**
 * Finds the air vehicle with the highest altitude capability.
 *  The air vehicle with the h=ighest altitude.
 */
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

    /**
 * Finds the aircraft with the largest cargo weight.
 *  The aircraft with the largest cargo weight.
 */

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

    /**
 * Finds all jets with a specific missile type.
 *  type The missile type to search for.
 *  A list of jets that have the specified missile type
 */
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

    /**
 * Finds all air vehicles located at a specific location.
 *  loca The location to search for.
 *  A list of air vehicles located at the specified location
 */
    public ArrayList<AirVehicle> findAtLocation(String loc) {
        ArrayList<AirVehicle> air = new ArrayList<>();

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getLocation().equals(loc)) {
                air.add(airVehicles.get(i));
            }
        }
        return air;
    }

    /**
 * Finds the jet with the highest agility
 *  The jet with the highest agility.
 */
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

    /**
 * Finds all air vehicles with a specific number of engines.
 *  num The number of engines to searchfor.
 *  A list of air vehicles with the specified number of engines.
 */
    public ArrayList<AirVehicle> findEngineNum(int num) {
        ArrayList<AirVehicle> airWithEngineNum = new ArrayList<>();
        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getEngineNum() == num) {
                airWithEngineNum.add(airVehicles.get(i));
            }
        }

        return airWithEngineNum;
    }
    
/**
 * Finds all air vehicles older than a specified age.
 *  age The age threshold.
 *  a list of air vehicles older than the specified age.
 */
    public ArrayList<AirVehicle> findOverAge(int age) {
        ArrayList<AirVehicle> airOverAge = new ArrayList<>();

        for (int i = 0; i < airVehicles.size(); i++) {
            if (CUR_YEAR - airVehicles.get(i).getManufactureYear() > age) {
                airOverAge.add(airVehicles.get(i));
            }
        }
        return airOverAge;
    }

    /**
 * Finds the air vehicle with the highest speed
 *  The air vehicle with the highest speed.
 */
    public AirVehicle findFastestAirVehicle()
    {
        AirVehicle temp = null;
        for (int i = 0; i < airVehicles.size(); i++)
        {
            if (temp == null)
            {
                temp = airVehicles.get(i);
            }
            else
            {
                temp = temp.compareSpeed(airVehicles.get(i));
            }
        }
        return temp;
    }

    /**
 * Finds the fastest jet among all air vehicles.
 *  Te fastest jet.
 */

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

    /**
 * Finds the fastest aircraft among all air vehicles.
 *  The fastest aircraft.
 */
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

    /**
 * Finds the most expensive air vehicle.
 *  The most expensive air vehicle.
 */
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

    /**
 * Repairs an air vehicle by its serial number.
 *  s The serial number of the air vehicle to repair.
 *  true if the repair was successful, false if the vehicle was not found.
 */
    public boolean repairAirVehicle(String s)
    {
        AirVehicle temp = searchVehicleSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.addRepair();
    }
    
/**
 * Updates the parts of an air vehicle by its serial number.
 *  s The serial number of the air vehicle.
 *  n The number of parts to update.
 *  true if the parts were successfully updated, false if the vehicle was not found.
 */
    public boolean updateParts(String s, int n)
    {
        AirVehicle temp = searchVehicleSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.removeParts(n);
    }

/**
 * Finds the most expensive aircraft among all air vehicles.
 *  The most expensive aircrat.
 */
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
    
/**
 * Finds the most expensive jet among all air vehicle.
 *  The most expensive jet.
 */
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
    
/**
 * Searches for air vehicles with a specific number of wings.
 *  wingNum The number of wings to search for.
 *  A list of air vehicles with the specified number of wing.
 */
    public ArrayList<AirVehicle> searchVehicleWingNumber(int wingNum) {
        ArrayList<AirVehicle> airWingNum = new ArrayList<>();

        for (int i = 0; i < airVehicles.size(); i++) {
            if (airVehicles.get(i).getWingNum() == wingNum) {
                airWingNum.add(airVehicles.get(i));
            }
        }
        return airWingNum;
    }

    public boolean addAircraft(int engineNum, int wingNum, int manufactureYear, String serialNum, int speed, String location, int cost, int altitude, int cargoWeight, double storage, double maxCargoWeight, int maxJeepStorage, int parts, int minParts, int maxParts) {
        Aircraft newAircraft = new Aircraft(engineNum,  wingNum,  manufactureYear, serialNum, speed,  location,  cost,  altitude,  cargoWeight,  storage,  maxCargoWeight,  maxJeepStorage,  parts,  minParts,  maxParts);
        airVehicles.add(newAircraft);
        return true;
    }

    public boolean addJet(int engineNum, int wingNum, int manufactureYear, String serialNum, int speed, String location, int cost, int altitude, String missileType, int agility, int storageTaken, int parts, int minParts, int maxParts) {
        Jet newJet = new Jet(engineNum,  wingNum,  manufactureYear,  serialNum, speed,  location,  cost,  altitude,  missileType,  agility,  storageTaken, parts, minParts, maxParts);
        airVehicles.add(newJet);
        return true;
    }
/**
 * Removes a air vehicle by its serial number.
 *  serial The serial number of the air vehicle to remove.
 *  True if the air vehicle was successfully removed false otherwise
 */
    public boolean removeAirVehicle(String serial) {
        if (searchVehicleSerial(serial) == null) {
            return false;
        }
        else {
            airVehicles.remove(searchVehicleSerial(serial));
        }
        return true;
    }
/**
 * Finds the ship carrying ane specific jet by its serial number.
 *  serial The serial number of the jet.
 *  The ship carrying the jet, or null if not found.
 */
    public Ship isCarriedJet(String serial) {
        Jet findJet = (Jet) searchVehicleSerial(serial);
        if (findJet == null) {
            return null;
        }
        return findJet.getContainedObject();
    }

}
