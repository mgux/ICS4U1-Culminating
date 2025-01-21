/*
* Programmers: Tianyue, Luke, Michael
* Last Updated: 2025-01-20
* This is the database
* */

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

    public boolean addVehicle()
    {
        Scanner sc = new Scanner(System.in);
        String s = " ";
        boolean b = false;
        while (!s.equals("Jeep") && !s.equals("Tank") && !s.equals("Aircraft") && !s.equals("Jet") && !s.equals("Ship") && !s.equals("Submarine") && !s.equals("Satellite") && !s.equals("Rocket"))
        {
            System.out.println("Enter a type of vehicle: ");
            s = sc.nextLine();
            if (!s.equals("Jeep") && !s.equals("Tank") && !s.equals("Aircraft") && !s.equals("Jet") && !s.equals("Ship") && !s.equals("Submarine") && !s.equals("Satellite") && !s.equals("Rocket"))
            {
                System.out.println("Please make sure your input is formatted correctly!");
            }
        }
        while (!b)
        {
            try
            {
                if (s.equals("Jeep"))
                {
                    int n1, n2, n3, n4, n5, n6, n7, n8, n9;
                    double d;
                    String s1, s2;
                    System.out.println("Enter all qualities of the added Jeep");
                    System.out.println("Enter number of tires: ");
                    n1 = sc.nextInt();
                    System.out.println("Enter number of seats: ");
                    n2 = sc.nextInt();
                    System.out.println("Enter manufacture year: ");
                    n3 = sc.nextInt();
                    s1 = SerialNumGeneration.landVehicleGeneration();
                    System.out.println("Enter speed of jeep: ");
                    n4 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter location: ");
                    s2 = sc.nextLine();
                    System.out.println("Enter cost of jeep: ");
                    n5 = sc.nextInt();
                    System.out.println("Enter number of current parts on jeep: ");
                    n6 = sc.nextInt();
                    System.out.println("Enter maximum parts that can fit on jeep: ");
                    n7 = sc.nextInt();
                    System.out.println("Enter minimum parts that can fit on jeep: ");
                    n8 = sc.nextInt();
                    System.out.println("Enter storage space available in jeep: ");
                    n9 = sc.nextInt();
                    System.out.println("Enter current cargo weight on jeep: ");
                    d = sc.nextDouble();
                    landManager.addJeep(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8, n9, d);
                    b= true;
                }
                else if (s.equals("Tank"))
                {
                    int n1, n2, n3, n4, n5, n6, n7, n8, n9;
                    double d;
                    String s1, s2;
                    System.out.println("Enter all qualities of the added Tank");
                    System.out.println("Enter number of tires: ");
                    n1 = sc.nextInt();
                    System.out.println("Enter number of seats: ");
                    n2 = sc.nextInt();
                    System.out.println("Enter manufacture year: ");
                    n3 = sc.nextInt();
                    s1 = SerialNumGeneration.landVehicleGeneration();
                    System.out.println("Enter speed of tank: ");
                    n4 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter location: ");
                    s2 = sc.nextLine();
                    System.out.println("Enter cost of tank: ");
                    n5 = sc.nextInt();
                    System.out.println("Enter number of current parts on tank: ");
                    n6 = sc.nextInt();
                    System.out.println("Enter maximum parts that can fit on tank: ");
                    n7 = sc.nextInt();
                    System.out.println("Enter minimum parts that can fit on tank: ");
                    n8 = sc.nextInt();
                    System.out.println("Enter the ammunition: ");
                    n9 = sc.nextInt();
                    System.out.println("Enter the range of the tank: ");
                    d = sc.nextDouble();
                    landManager.addJeep(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8, n9, d);
                    b = true;
                }
                else if (s.equals("Ship"))
                {
                    double fuelCapacity;
                    boolean isNuclearPowered;
                    int manufactureYear;
                    String serialNum;
                    int speed;
                    String location;
                    int cost;
                    int parts;
                    int maxParts;
                    int minParts;
                    int buoyancy;
                    int numberOfGuns;
                    String type;
                    int maxTankStorage;
                    int maxJetStorage;
                    int maxSubmarineStorage;
                    int maxRocketStorage;
                    int maxAircraftStorage;
                    boolean docked;
                    System.out.println("Enter all qualities of the added Ship:");
                    System.out.println("Enter fuel capacity: ");
                    fuelCapacity = sc.nextDouble();
                    System.out.println("Is it nuclear powered? Enter true or false. ");
                    isNuclearPowered = sc.nextBoolean();
                    System.out.println("Enter the manufacture year: ");
                    manufactureYear = sc.nextInt();
                    serialNum = SerialNumGeneration.waterVehicleGeneration();
                    System.out.println("Enter the maximum speed: ");
                    speed = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the current location: ");
                    location = sc.nextLine();
                    System.out.println("Enter the cost: ");
                    cost = sc.nextInt();
                    System.out.println("Enter the number of parts currently on it: ");
                    parts = sc.nextInt();
                    System.out.println("Enter the maximum number of parts it can hold: ");
                    maxParts = sc.nextInt();
                    System.out.println("Enter the minimum required parts in order for it to function: ");
                    minParts = sc.nextInt();
                    System.out.println("Enter the buoyancy of the ship: ");
                    buoyancy = sc.nextInt();
                    System.out.println("Enter the number of guns the ship has: ");
                    numberOfGuns = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the type of ship: ");
                    type = sc.nextLine();
                    System.out.println("Enter the maximum number of tanks the ship can hold: ");
                    maxTankStorage = sc.nextInt();
                    System.out.println("Enter the maximum number of jets the ship can hold: ");
                    maxJetStorage = sc.nextInt();
                    System.out.println("Enter the maximum number of submarines the ship can hold: ");
                    maxSubmarineStorage = sc.nextInt();
                    System.out.println("Enter the maximum number of rockets the ship can hold: ");
                    maxRocketStorage = sc.nextInt();
                    System.out.println("Enter the maximum number of planes the ship can hold: ");
                    maxAircraftStorage = sc.nextInt();
                    System.out.println("Is the ship docked? Enter true or false.");
                    docked = sc.nextBoolean();
                    waterManager.addShip(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, maxParts, minParts, buoyancy, numberOfGuns, type, maxTankStorage, maxJetStorage, maxSubmarineStorage, maxRocketStorage, maxAircraftStorage, docked);
                    b = true;
                }
                else if (s.equals("Submarine"))
                {
                    double fuelCapacity;
                    boolean isNuclearPowered;
                    int manufactureYear;
                    String serialNum;
                    int speed;
                    String location;
                    int cost;
                    int parts;
                    int minParts;
                    int maxParts;
                    int depth;
                    int numberOfTorpedos;
                    int underWaterVisibility;
                    int maxTorpedos;
                    boolean docked;
                    System.out.println("Enter all qualities of the added Submarine: ");
                    System.out.println("Enter the fuel capacity: ");
                    fuelCapacity = sc.nextInt();
                    System.out.println("Is the submarine nuclear powered? Enter true or false");
                    isNuclearPowered = sc.nextBoolean();
                    System.out.println("Enter manufacture year: ");
                    manufactureYear = sc.nextInt();
                    serialNum = SerialNumGeneration.waterVehicleGeneration();
                    System.out.println("Enter maximum speed: ");
                    speed = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter current location: ");
                    location = sc.nextLine();
                    System.out.println("Enter cost: ");
                    cost = sc.nextInt();
                    System.out.println("Enter current parts on the submarine: ");
                    parts = sc.nextInt();
                    System.out.println("Enter the maximum number of parts it can hold: ");
                    maxParts = sc.nextInt();
                    System.out.println("Enter the minimum number of parts required to function: ");
                    minParts = sc.nextInt();
                    System.out.println("Enter current depth of the submarine: ");
                    depth = sc.nextInt();
                    System.out.println("Enter number of torpedos equipped: ");
                    numberOfTorpedos = sc.nextInt();
                    System.out.println("Enter the underwater visibility: ");
                    underWaterVisibility = sc.nextInt();
                    System.out.println("Enter the maximum number of torpedos equipped: ");
                    maxTorpedos = sc.nextInt();
                    System.out.println("Is the submarine docked? Enter true or false.");
                    docked = sc.nextBoolean();
                    waterManager.addSubmarine(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, minParts, maxParts, depth, numberOfTorpedos, underWaterVisibility, maxTorpedos, docked);
                    b = true;
                }

                else if (s.equals("Aircraft"))
                {
                    int engineNum;
                    int wingNum;
                    int manufactureYear;
                    String serialNum;
                    int speed;
                    String location;
                    int cost;
                    int altitude;
                    int cargoWeight;
                    double storage;
                    double maxCargoWeight;
                    int maxJeepStorage;
                    int parts;
                    int minParts;
                    int maxParts;
                    System.out.println("Enter all qualities of the Aircraft: ");
                    System.out.println("Enter the number of engines: ");
                    engineNum = sc.nextInt();
                    System.out.println("Enter the wing number: ");
                    wingNum = sc.nextInt();
                    System.out.println("Enter the manufacture year: ");
                    manufactureYear = sc.nextInt();
                    serialNum = SerialNumGeneration.airVehicleGeneration();
                    System.out.println("Enter the maximum speed of the aircraft");
                    speed = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the current location: ");
                    location = sc.nextLine();
                    System.out.println("Enter the cost: ");
                    cost = sc.nextInt();
                    System.out.println("Enter the current altitude: ");
                    altitude = sc.nextInt();
                    System.out.println("Enter the current cargo weight: ");
                    cargoWeight = sc.nextInt();
                    System.out.println("Enter the current storage of vehicles: ");
                    storage = sc.nextDouble();
                    System.out.println("Enter the maximum cargo weight the aircraft can hold");
                    maxCargoWeight = sc.nextDouble();
                    System.out.println("Enter the maximum number of jeeps it can hold");
                    maxJeepStorage = sc.nextInt();
                    System.out.println("Enter the current number of parts: ");
                    parts = sc.nextInt();
                    System.out.println("Enter the minimum number of parts required for it to function: ");
                    minParts = sc.nextInt();
                    System.out.println("Enter the maximum number of parts that it can hold: ");
                    maxParts = sc.nextInt();
                    airManager.addAircraft(engineNum, wingNum, manufactureYear, serialNum, speed, location, cost, altitude, cargoWeight, storage, maxCargoWeight, maxJeepStorage, parts, minParts, maxParts);
                    b = true;
                }
                else if (s.equals("Jet"))
                {
                    int engineNum;
                    int wingNum;
                    int manufactureYear;
                    String serialNum;
                    int speed;
                    String location;
                    int cost;
                    int altitude;
                    String missileType;
                    int agility;
                    int storageTaken;
                    int parts;
                    int minParts;
                    int maxParts;
                    System.out.println("Enter all qualities of the Jet: ");
                    System.out.println("Enter the number of engines: ");
                    engineNum = sc.nextInt();
                    System.out.println("Enter the wing number: ");
                    wingNum = sc.nextInt();
                    System.out.println("Enter the manufacture year: ");
                    manufactureYear = sc.nextInt();
                    serialNum = SerialNumGeneration.airVehicleGeneration();
                    System.out.println("Enter the maximum speed: ");
                    speed = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the current location: ");
                    location = sc.nextLine();
                    System.out.println("Enter the cost: ");
                    cost = sc.nextInt();
                    System.out.println("Enter the current altitude: ");
                    altitude = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the missile type: ");
                    missileType = sc.nextLine();
                    System.out.println("Enter the agility: ");
                    agility = sc.nextInt();
                    System.out.println("Enter the storage taken in other vehicles: ");
                    storageTaken = sc.nextInt();
                    System.out.println("Enter the current number of parts in the jet: ");
                    parts = sc.nextInt();
                    System.out.println("Enter the minimum number of parts required for the jet to function: ");
                    minParts = sc.nextInt();
                    System.out.println("Enter the maximum number of parts the jet can hold: ");
                    maxParts = sc.nextInt();
                    airManager.addJet(engineNum,  wingNum,  manufactureYear,  serialNum, speed,  location,  cost,  altitude,  missileType,  agility,  storageTaken, parts, minParts, maxParts);
                    b = true;
                }
                else if (s.equals("Satellite"))
                {
                    int n1;
                    String s1;
                    int n2;
                    String s2;
                    int n3;
                    String s3;
                    int n4;
                    int n5;
                    int n6;
                    int n7;
                    double d1;
                    double d2;
                    System.out.println("Enter all qualities of the Satellite: ");
                    System.out.println("Enter the current altitude: ");
                    n1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the camera type of the Satellite: ");
                    s1 = sc.nextLine();
                    System.out.println("Enter the manufacture year: ");
                    n2 = sc.nextInt();
                    s2 = SerialNumGeneration.spaceVehicleGeneration();
                    System.out.println("Enter the maximum speed of the Satellite: ");
                    n3 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the current location of the Satellite: ");
                    s3 = sc.nextLine();
                    System.out.println("Enter the cost of the rocket: ");
                    n4 = sc.nextInt();
                    System.out.println("Enter the current number of parts on the Satellite: ");
                    n5 = sc.nextInt();
                    System.out.println("Enter the maximum number of parts it can hold");
                    n6 = sc.nextInt();
                    System.out.println("Enter the minimum number of parts required to function: ");
                    n7 = sc.nextInt();
                    System.out.println("Enter the power cost for the Satellite: ");
                    d1 = sc.nextDouble();
                    System.out.println("Enter the diagonal length of the solar panel: ");
                    d2 = sc.nextDouble();
                    spaceManager.addSatellite(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7, d1, d2);
                    b=  true;
                }
                else {
                    int n1;
                    String s1;
                    int n2;
                    String s2;
                    int n3;
                    String s3;
                    int n4;
                    int n5;
                    int n6;
                    int n7;
                    int n8;
                    int n9;
                    int n10;
                    System.out.println("Enter all qualities of the Rocket: ");
                    System.out.println("Enter the current altitude: ");
                    n1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the camera type of the rocket: ");
                    s1 = sc.nextLine();
                    System.out.println("Enter the manufacture year: ");
                    n2 = sc.nextInt();
                    s2 = SerialNumGeneration.spaceVehicleGeneration();
                    System.out.println("Enter the maximum speed of the rocket: ");
                    n3 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the current location of the rocket: ");
                    s3 = sc.nextLine();
                    System.out.println("Enter the cost of the rocket: ");
                    n4 = sc.nextInt();
                    System.out.println("Enter the current number of parts on the rocket: ");
                    n5 = sc.nextInt();
                    System.out.println("Enter the maximum number of parts it can hold");
                    n6 = sc.nextInt();
                    System.out.println("Enter the minimum number of parts required to function: ");
                    n7 = sc.nextInt();
                    System.out.println("Enter the power of the engine: ");
                    n8 = sc.nextInt();
                    System.out.println("Enter the number of engines: ");
                    n9 = sc.nextInt();
                    System.out.println("Enter the maximum number of satellite it can hold: ");
                    n10 = sc.nextInt();
                    spaceManager.addRocket(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7, n8, n9, n10);
                    b = true;
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please make sure your input is in the correct format!");
                sc.nextLine();
            }
        }
        return b;
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
