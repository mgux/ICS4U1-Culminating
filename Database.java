import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.io.*;

public class Database {


    private LandManager landManager;
    private WaterManager waterManager;
    private AirManager airManager;
    private SpaceManager spaceManager;

    public LandManager getLandManager() {
        return landManager;
    }

    public WaterManager getWaterManager() {
        return waterManager;
    }

    public AirManager getAirManager() {
        return airManager;
    }

    public SpaceManager getSpaceManager() {
        return spaceManager;
    }




    public Database(LandManager l, WaterManager w, AirManager a, SpaceManager s) {
        this.landManager = l;
        this.waterManager = w;
        this.airManager = a;
        this.spaceManager = s;
    }

    public void sortManufactureLocation() {
        landManager.sortmanufactureLocation();
        waterManager.sortManufactureLocation();
        spaceManager.sortmanufactureLocation();
        airManager.sortManufactureLocation();
        System.out.println("Sorting by manufacture year and location was successful.");
    }

    public void sortSerial() {
        landManager.sortSerial();
        waterManager.sortSerial();
        airManager.sortSerial();
        spaceManager.sortSerial();
        System.out.println("Sorting by serial was successful.");
    }

    public void addRepairVehicleSerial(String serial) {
        LandVehicle l = landManager.searchSerial(serial);
        if (l == null) {
            WaterVehicle w = waterManager.searchVehicleSerial(serial);
            if (w == null) {
                AirVehicle a = airManager.searchVehicleSerial(serial);
                if (a == null) {
                    SpaceVehicle s = spaceManager.searchSerial(serial);
                    if (s == null) {
                        System.out.println("No existing vehicle found!");
                    }
                    else {
                        System.out.println("SpaceVehicle");
                        s.addRepair();
                        System.out.println("Repair successfully added!");
                    }

                }
                else {
                    System.out.println("AirVehicle");
                    a.addRepair();
                    System.out.println("Repair successfully added!");
                }

            }
            else {
                System.out.println("WaterVehicle");
                w.addRepair();
                System.out.println("Repair successfully added!");
            }

        }
        else {
            System.out.println("LandVehicle");
            l.addRepair();
            System.out.println("Repair successfully added!");
        }
    }

    public void removeVehicle(String serial) {
        LandVehicle l = landManager.searchSerial(serial);
        if (l == null) {
            WaterVehicle w = waterManager.searchVehicleSerial(serial);
            if (w == null) {
                AirVehicle a = airManager.searchVehicleSerial(serial);
                if (a == null) {
                    SpaceVehicle s = spaceManager.searchSerial(serial);
                    if (s == null) {
                        System.out.println("No existing vehicle found!");
                    }
                    else {
                        landManager.removeLandVehicle(serial);
                        System.out.println("SpaceVehicle removed!");
                    }

                }
                else {
                    System.out.println("AirVehicle");
                    airManager.removeAirVehicle(serial);
                    System.out.println("AirVehicle removed!");
                }

            }
            else {
                System.out.println("WaterVehicle");
                waterManager.removeWaterVehicle(serial);
                System.out.println("WaterVehicle removed!");
            }

        }
        else {
            landManager.removeLandVehicle(serial);
            System.out.println("LandVehicle removed!");
        }
    }

    public void searchSerialRepairs(String serial) {
        LandVehicle l = landManager.searchSerial(serial);
        if (l == null) {
            WaterVehicle w = waterManager.searchVehicleSerial(serial);
            if (w == null) {
                AirVehicle a = airManager.searchVehicleSerial(serial);
                if (a == null) {
                    SpaceVehicle s = spaceManager.searchSerial(serial);
                    if (s == null) {
                        System.out.println("No existing vehicle found!");
                    }
                    else {
                        System.out.println("SpaceVehicle");
                        System.out.println(s.getMostRecentRepairs());
                    }

                }
                else {
                    System.out.println("AirVehicle");
                    System.out.println(a.getMostRecentRepairs());
                }

            }
            else {
                System.out.println("WaterVehicle");
                System.out.println(w.getMostRecentRepair());
            }

        }
        else {
            System.out.println("LandVehicle");
            System.out.println(l.getMostRecentRepair());
        }
    }

    public void searchSerial(String serial) {
        LandVehicle l = landManager.searchSerial(serial);
        if (l == null) {
            WaterVehicle w = waterManager.searchVehicleSerial(serial);
            if (w == null) {
                AirVehicle a = airManager.searchVehicleSerial(serial);
                if (a == null) {
                    SpaceVehicle s = spaceManager.searchSerial(serial);
                    if (s == null) {
                        System.out.println("No existing vehicle found!");
                    }
                    else {
                        System.out.println("SpaceVehicle");
                        System.out.println(s);
                    }

                }
                else {
                    System.out.println("AirVehicle");
                    System.out.println(a);
                }

            }
            else {
                System.out.println("WaterVehicle");
                System.out.println(w);
            }

        }
        else {
            System.out.println("LandVehicle");
            System.out.println(l);
        }
    }

    public boolean exportToFile(String fileName) {
        landManager.outLandVehicles(fileName);
        waterManager.outWaterVehicles(fileName);
        airManager.outAirVehicles(fileName);
        spaceManager.outSpaceVehicles(fileName);
        return true;
    }

    public void searchManufactureLocation(int year, String loc) {
        System.out.println("Vehicles made in " + year + " currently in " + loc + ": ");
        LandVehicle[] vehicles = landManager.searchManufactureLocation(year, loc);
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i].getSerialNum());
        }
        ArrayList<WaterVehicle> vehicles2 = waterManager.searchVehicleManufactureLocation(year,loc);
        for (int i = 0; i < vehicles2.size(); i++) {
            System.out.println(vehicles2.get(i).getSerialNum());
        }
        ArrayList<AirVehicle> vehicles3 = airManager.searchManufactureLocation(year,loc);
        for (int i = 0; i < vehicles3.size(); i++) {
            System.out.println(vehicles3.get(i).getSerialNum());
        }
        SpaceVehicle[] vehicles4 = spaceManager.searchManufactureLocation(year,loc);
        for (int i = 0; i < vehicles4.length; i++) {
            System.out.println(vehicles4[i].getSerialNum());
        }
    }

    public void findVehiclesOverAge(int age) {
        LandVehicle[] vehicles1 = landManager.findOverAge(age);
        for (int i = 0; i < vehicles1.length; i++) {
            System.out.println(vehicles1[i].getSerialNum());
        }
        ArrayList<WaterVehicle> vehicles2 = waterManager.findOverAge(age);
        for (int i = 0; i < vehicles2.size(); i++) {
            System.out.println(vehicles2.get(i).getSerialNum());
        }
        ArrayList<AirVehicle> vehicles3 = airManager.findOverAge(age);
        for (int i = 0; i < vehicles3.size(); i++) {
            System.out.println(vehicles3.get(i).getSerialNum());
        }
        SpaceVehicle[] vehicles4 = spaceManager.findOverAge(age);
        for (int i = 0; i < vehicles4.length; i++) {
            System.out.println(vehicles4[i].getSerialNum());
        }
    }

    public void findMostExpensiveVehicle() {
        ArrayList<Integer> mostExpensives = new ArrayList<>();
        AirVehicle mostExpensiveAir;
        WaterVehicle mostExpensiveWater;
        LandVehicle mostExpensiveLand;
        SpaceVehicle mostExpensiveSpace;
        int mostExpensiveVehicle;
        int num = 0;


        mostExpensiveAir = airManager.findMostExpensiveAirVehicle();
        mostExpensiveWater = waterManager.findMostExpensiveWaterVehicle();
        mostExpensiveLand = landManager.findMostExpensiveLand();
        mostExpensiveSpace = spaceManager.findMostExpensiveSpace();
        int mostExpensiveAirValue = mostExpensiveAir.getCost();
        int mostExpensiveWaterValue = mostExpensiveWater.getCost();
        int mostExpensiveSpaceValue = mostExpensiveSpace.getCost();
        int mostExpensiveLandValue = mostExpensiveLand.getCost();

        mostExpensives.add(mostExpensiveAirValue);
        mostExpensives.add(mostExpensiveWaterValue);
        mostExpensives.add(mostExpensiveSpaceValue);
        mostExpensives.add(mostExpensiveLandValue);

        mostExpensiveVehicle = mostExpensives.getFirst();
        for (int i = 1; i < mostExpensives.size(); i++) {
            if (mostExpensives.get(i) > mostExpensiveVehicle) {
                mostExpensiveVehicle = mostExpensives.get(i);
                num = i;
            }
        }

        System.out.print("The most expensive vehicle costs $" + mostExpensiveVehicle + " and is a");
        switch (num) {
            case 0:
                System.out.println(" air vehicle with serial " + mostExpensiveAir.getSerialNum());
                break;
            case 1:
                System.out.println(" water vehicle with serial " + mostExpensiveWater.getSerialNum());
                break;
            case 2:
                System.out.println(" space vehicle with serial " + mostExpensiveSpace.getSerialNum());
                break;
            case 3:
                System.out.println(" land vehicle with serial " + mostExpensiveLand.getSerialNum());
                break;
        }

    }



    public void findFastestVehicle() {
        Object fastest = null;
        int highestSpeed = 0;
        int choice = -1;
        Object fastestWater = waterManager.findFastestWater();
        if (fastestWater != null && ((WaterVehicle) fastestWater).getSpeed() > highestSpeed) {
            highestSpeed = ((WaterVehicle) fastestWater).getSpeed();
            fastest = fastestWater;
            choice = 0;
        }

        Object fastestLand = landManager.findFastestLand();
        if (fastestLand != null && ((LandVehicle) fastestLand).getSpeed() > highestSpeed) {
            highestSpeed = ((LandVehicle) fastestLand).getSpeed();
            fastest = fastestLand;
            choice = 1;
        }

        Object fastestAir = airManager.findFastestAirVehicle();
        if (fastestAir != null && ((AirVehicle) fastestAir).getSpeed() > highestSpeed) {
            highestSpeed = ((AirVehicle) fastestAir).getSpeed();
            fastest = fastestAir;
            choice = 2;
        }

        Object fastestSpace = spaceManager.findFastestSpace();
        if (fastestSpace != null && ((SpaceVehicle) fastestSpace).getSpeed() > highestSpeed) {
            highestSpeed = ((SpaceVehicle) fastestSpace).getSpeed();
            fastest = fastestSpace;
            choice = 3;
        }
        switch(choice){
            case 0:
                System.out.println("Fastest vehicle: " + ((WaterVehicle)fastest).getSerialNum());
                break;
            case 1:
                System.out.println("Fastest vehicle: " + ((LandVehicle)fastest).getSerialNum());
                break;

            case 2:
                System.out.println("Fastest vehicle: " + ((AirVehicle)fastest).getSerialNum());
                break;
            case 3:
                System.out.println("Fastest vehicle: " + ((SpaceVehicle)fastest).getSerialNum());
                break;
        }
    }

    public boolean exchangeParts(String sourceSerial, String targetSerial) {
        Scanner scanner = new Scanner(System.in);

        Object sourceVehicle = null;
        Object targetVehicle = null;

        // Determine the type of the source vehicle
        if ((sourceVehicle = waterManager.searchVehicleSerial(sourceSerial)) != null) {
            System.out.println("Source vehicle is a WaterVehicle.");
        } else if ((sourceVehicle = landManager.searchSerial(sourceSerial)) != null) {
            System.out.println("Source vehicle is a LandVehicle.");
        } else if ((sourceVehicle = airManager.searchVehicleSerial(sourceSerial)) != null) {
            System.out.println("Source vehicle is an AirVehicle.");
        } else if ((sourceVehicle = spaceManager.searchSerial(sourceSerial)) != null) {
            System.out.println("Source vehicle is a SpaceVehicle.");
        } else {
            System.out.println("Source vehicle not found.");
            return false;
        }

        // Determine the type of the target vehicle
        if ((targetVehicle = waterManager.searchVehicleSerial(targetSerial)) != null) {
            System.out.println("Target vehicle is a WaterVehicle.");
        } else if ((targetVehicle = landManager.searchSerial(targetSerial)) != null) {
            System.out.println("Target vehicle is a LandVehicle.");
        } else if ((targetVehicle = airManager.searchVehicleSerial(targetSerial)) != null) {
            System.out.println("Target vehicle is an AirVehicle.");
        } else if ((targetVehicle = spaceManager.searchSerial(targetSerial)) != null) {
            System.out.println("Target vehicle is a SpaceVehicle.");
        } else {
            System.out.println("Target vehicle not found.");
            return false;
        }

        // Prompt for the number of parts to exchange
        System.out.print("Enter the number of parts to exchange: ");
        int partsToExchange = scanner.nextInt();

        // Handle exchange based on specific vehicle types
        if (sourceVehicle instanceof WaterVehicle && targetVehicle instanceof WaterVehicle) {
            return performExchange((WaterVehicle) sourceVehicle, (WaterVehicle) targetVehicle, partsToExchange);
        } else if (sourceVehicle instanceof LandVehicle && targetVehicle instanceof LandVehicle) {
            return performExchange((LandVehicle) sourceVehicle, (LandVehicle) targetVehicle, partsToExchange);
        } else if (sourceVehicle instanceof AirVehicle && targetVehicle instanceof AirVehicle) {
            return performExchange((AirVehicle) sourceVehicle, (AirVehicle) targetVehicle, partsToExchange);
        } else if (sourceVehicle instanceof SpaceVehicle && targetVehicle instanceof SpaceVehicle) {
            return performExchange((SpaceVehicle) sourceVehicle, (SpaceVehicle) targetVehicle, partsToExchange);
        } else {
            System.out.println("Incompatible vehicle types for part exchange.");
            return false;
        }
    }

    // Helper method to perform the exchange for specific types
    private boolean performExchange(WaterVehicle sourceVehicle, WaterVehicle targetVehicle, int partsToExchange) {
        int sourcePartsRequired = partsToExchange * sourceVehicle.PART_SWAP_WORTH;

        if (sourceVehicle.getParts() < sourcePartsRequired) {
            System.out.println("Source vehicle does not have enough parts for this exchange.");
            return false;
        }

        sourceVehicle.setParts(sourceVehicle.getParts() - sourcePartsRequired);
        int targetPartsAdded = partsToExchange * targetVehicle.PART_SWAP_WORTH;
        targetVehicle.setParts(targetVehicle.getParts() + targetPartsAdded);

        System.out.println("Exchange completed successfully!");
        return true;
    }

    // Overloaded performExchange methods for other vehicle types
    private boolean performExchange(LandVehicle sourceVehicle, LandVehicle targetVehicle, int partsToExchange) {
        // Similar logic for LandVehicle
        int sourcePartsRequired = partsToExchange * sourceVehicle.PART_SWAP_WORTH;

        if (sourceVehicle.getParts() < sourcePartsRequired) {
            System.out.println("Source vehicle does not have enough parts for this exchange.");
            return false;
        }

        sourceVehicle.setParts(sourceVehicle.getParts() - sourcePartsRequired);
        int targetPartsAdded = partsToExchange * targetVehicle.PART_SWAP_WORTH;
        targetVehicle.setParts(targetVehicle.getParts() + targetPartsAdded);

        System.out.println("Exchange completed successfully!");
        return true;
    }

    private boolean performExchange(AirVehicle sourceVehicle, AirVehicle targetVehicle, int partsToExchange) {
        // Similar logic for AirVehicle
        int sourcePartsRequired = partsToExchange * sourceVehicle.PART_SWAP_WORTH;

        if (sourceVehicle.getParts() < sourcePartsRequired) {
            System.out.println("Source vehicle does not have enough parts for this exchange.");
            return false;
        }

        sourceVehicle.setParts(sourceVehicle.getParts() - sourcePartsRequired);
        int targetPartsAdded = partsToExchange * targetVehicle.PART_SWAP_WORTH;
        targetVehicle.setParts(targetVehicle.getParts() + targetPartsAdded);

        System.out.println("Exchange completed successfully!");
        return true;
    }

    private boolean performExchange(SpaceVehicle sourceVehicle, SpaceVehicle targetVehicle, int partsToExchange) {
        // Similar logic for SpaceVehicle
        int sourcePartsRequired = partsToExchange * sourceVehicle.PART_SWAP_WORTH;

        if (sourceVehicle.getParts() < sourcePartsRequired) {
            System.out.println("Source vehicle does not have enough parts for this exchange.");
            return false;
        }

        sourceVehicle.setParts(sourceVehicle.getParts() - sourcePartsRequired);
        int targetPartsAdded = partsToExchange * targetVehicle.PART_SWAP_WORTH;
        targetVehicle.setParts(targetVehicle.getParts() + targetPartsAdded);

        System.out.println("Exchange completed successfully!");
        return true;
    }

    public boolean readInput(String str)
    {
        boolean isIn = true;
        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader(str));
            String s = in.readLine();
            while (s != null)
            {
                try
                {
                    if (s.equals("Jeep"))
                    {
                        landManager.addJeep(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()));
                    }
                    else if (s.equals("Tank"))
                    {
                        landManager.addTank(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()));
                    }
                    else if (s.equals("Ship"))
                    {
                        waterManager.addShip(
                                Double.parseDouble(in.readLine()),  // fuelCapacity
                                Boolean.parseBoolean(in.readLine()), // isNuclearPowered
                                Integer.parseInt(in.readLine()),   // manufactureYear
                                in.readLine(),                     // serialNum
                                Integer.parseInt(in.readLine()),   // speed
                                in.readLine(),                     // location
                                Integer.parseInt(in.readLine()),   // cost
                                Integer.parseInt(in.readLine()),   // parts
                                Integer.parseInt(in.readLine()),   // maxParts
                                Integer.parseInt(in.readLine()),   // minParts
                                Integer.parseInt(in.readLine()),   // buoyancy
                                Integer.parseInt(in.readLine()),   // numberOfGuns
                                in.readLine(),                     // type
                                Integer.parseInt(in.readLine()),   // maxTankStorage
                                Integer.parseInt(in.readLine()),   // maxAircraftStorage
                                Integer.parseInt(in.readLine()),   // maxSubmarineStorage
                                Integer.parseInt(in.readLine()),   // maxRocketStorage
                                Integer.parseInt(in.readLine()),   // maxJetStorage
                                Boolean.parseBoolean(in.readLine()) // docked
                        );
                    }
                    else if (s.equals("Submarine"))
                    {
                        waterManager.addSubmarine(
                                Double.parseDouble(in.readLine()),  // fuelCapacity
                                Boolean.parseBoolean(in.readLine()), // isNuclearPowered
                                Integer.parseInt(in.readLine()),   // manufactureYear
                                in.readLine(),                     // serialNum
                                Integer.parseInt(in.readLine()),   // speed
                                in.readLine(),                     // location
                                Integer.parseInt(in.readLine()),   // cost
                                Integer.parseInt(in.readLine()),   // parts
                                Integer.parseInt(in.readLine()),   // maxParts
                                Integer.parseInt(in.readLine()),   // minParts
                                Integer.parseInt(in.readLine()),   // depth
                                Integer.parseInt(in.readLine()),   // numberOfTorpedos
                                Integer.parseInt(in.readLine()),   // underWaterVisibility
                                Integer.parseInt(in.readLine()),   // maxTorpedos
                                Boolean.parseBoolean(in.readLine()) // docked
                        );
                    }
                    else if (s.equals("Aircraft"))
                    {
                        airManager.addAircraft(
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
                    else if (s.equals("Jet"))
                    {
                        airManager.addJet(
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
                    else if (s.equals("Rocket"))
                    {
                        spaceManager.addRocket(Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()));
                    }
                    else
                    {
                        spaceManager.addSatellite(Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()));
                    }
                    s = in.readLine();
                    s = in.readLine();
                }
                catch(NumberFormatException nfx)
                {
                    isIn = false;
                }
                catch(NullPointerException npx)
                {
                    isIn = false;
                }
            }
            in.close();
        }
        catch (IOException iox)
        {
            isIn = false;
        }
        return isIn;
    }
}
