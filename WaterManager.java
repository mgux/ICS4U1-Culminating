/*
ICS4U1-12
Luke
01/19/2025
A.Y Jackson SS

A manager class which allows for direct comparison and manipulation of waterVehicles within it

*/
// Water Manager with methods and fields

import java.util.ArrayList;
import java.util.Objects;
import java.util.*;
import java.io.*;

public class WaterManager {
    private final int CUR_YEAR = 2025;
    private ArrayList<WaterVehicle> waterStorage;

   //constructor
    public WaterManager() {
        waterStorage = new ArrayList<WaterVehicle>();
    }

   //adds ship or submarine
    //add ship
    public boolean addShip(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost, int parts, int maxParts, int minParts, int buoyancy, int numberOfGuns, String type, int maxTankStorage, int maxJetStorage, int maxSubmarineStorage, int maxRocketStorage, int maxAircraftStorage, boolean docked) {
        Ship newShip = new Ship(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, maxParts, minParts, buoyancy, numberOfGuns, type, maxTankStorage, maxJetStorage, maxSubmarineStorage, maxRocketStorage, maxAircraftStorage, docked);
        waterStorage.add(newShip);
        return true;
    }

    //add submarine
    public boolean addSubmarine(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost, int parts, int minParts, int maxParts, int depth, int nomberOfTorpedos, int underWaterVisibility, int maxTorpedos, boolean docked){
        Submarine newSubmarine = new Submarine(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, minParts, maxParts, depth, nomberOfTorpedos, underWaterVisibility, maxTorpedos, docked);
        waterStorage.add(newSubmarine);
        return true;
    }
    
    //readsShip from file
    public boolean readShip(String fileName) {
        boolean isRead = true;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(fileName));
            try {
                addShip(
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

            } catch (NumberFormatException | NullPointerException ex) {
                isRead = false;
            }
            in.close();
        } catch (IOException io) {
            isRead = false;
        }
        return isRead;
    }

   //reads Submarine from file
    public boolean readSubmarine(String fileName) {
        boolean isRead = true;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(fileName));
            try {
                in.readLine();

                addSubmarine(

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
                System.out.println("true");
            } catch (NumberFormatException | NullPointerException ex) {
                isRead = false;
            }
            in.close();
        } catch (IOException io) {
            isRead = false;
        }
        return isRead;
    }

   //Outputs all water Vehicles to a file
    public boolean outWaterVehicles(String fileName) {
        boolean isOut = true;
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < waterStorage.size(); i++) {
                if (waterStorage.get(i) instanceof Submarine) {
                    out.write("Submarine\n");
                } else {
                    out.write("Ship\n");
                }
                out.write(waterStorage.get(i).toString());
                out.newLine();
            }
            out.close();
        } catch (IOException io) {
            isOut = false;
        }
        return isOut;
    }

   //Finds all water vehicles over a certain age
    public ArrayList<WaterVehicle> findOverAge(int age) {
        ArrayList<WaterVehicle> waterOverAge = new ArrayList<>();

        for (int i = 0; i < waterStorage.size(); i++) {
            if (CUR_YEAR - waterStorage.get(i).getManufactureYear() > age) {
                waterOverAge.add(waterStorage.get(i));
            }
        }
        return waterOverAge;
    }


   //Adds ship from console 
    public void addShipFromConsole() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Fuel Capacity: ");
            double fuelCapacity = Double.parseDouble(scanner.nextLine());

            System.out.print("Is Nuclear Powered (true/false): ");
            boolean isNuclearPowered = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Enter Manufacture Year: ");
            int manufactureYear = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Serial Number: ");
            String serialNum = scanner.nextLine();

            System.out.print("Enter Speed: ");
            int speed = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Location: ");
            String location = scanner.nextLine();

            System.out.print("Enter Cost: ");
            int cost = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Parts: ");
            int parts = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Parts: ");
            int maxParts = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Min Parts: ");
            int minParts = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Buoyancy: ");
            int buoyancy = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Number of Guns: ");
            int numberOfGuns = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Type: ");
            String type = scanner.nextLine();

            System.out.print("Enter Max Tank Storage: ");
            int maxTankStorage = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Aircraft Storage: ");
            int maxAircraftStorage = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Submarine Storage: ");
            int maxSubmarineStorage = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Rocket Storage: ");
            int maxRocketStorage = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Jet Storage: ");
            int maxJetStorage = Integer.parseInt(scanner.nextLine());

            System.out.print("Is Docked (true/false): ");
            boolean docked = Boolean.parseBoolean(scanner.nextLine());

            Ship ship = new Ship(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, maxParts, minParts, buoyancy, numberOfGuns, type, maxTankStorage, maxAircraftStorage, maxSubmarineStorage, maxRocketStorage, maxJetStorage, docked);
            waterStorage.add(ship);
            System.out.println("Ship added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values where applicable.");
        }
    }

   //Adds submarine from console
    public void addSubmarineFromConsole() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Fuel Capacity: ");
            double fuelCapacity = Double.parseDouble(scanner.nextLine());

            System.out.print("Is Nuclear Powered (true/false): ");
            boolean isNuclearPowered = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Enter Manufacture Year: ");
            int manufactureYear = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Serial Number: ");
            String serialNum = scanner.nextLine();

            System.out.print("Enter Speed: ");
            int speed = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Location: ");
            String location = scanner.nextLine();

            System.out.print("Enter Cost: ");
            int cost = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Parts: ");
            int parts = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Parts: ");
            int maxParts = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Min Parts: ");
            int minParts = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Depth: ");
            int depth = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Number of Torpedos: ");
            int numberOfTorpedos = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Underwater Visibility: ");
            int underWaterVisibility = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Torpedos: ");
            int maxTorpedos = Integer.parseInt(scanner.nextLine());

            System.out.print("Is Docked (true/false): ");
            boolean docked = Boolean.parseBoolean(scanner.nextLine());

            Submarine submarine = new Submarine(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, maxParts, minParts, depth, numberOfTorpedos, underWaterVisibility, maxTorpedos, docked);
            waterStorage.add(submarine);
            System.out.println("Submarine added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values where applicable.");
        }
    }


   //Removes water vehicle with a serial number
    public boolean removeWaterVehicle(String serial) {
        WaterVehicle vehicle = searchVehicleSerial(serial);
        if (vehicle == null) {
            return false;
        }
        waterStorage.remove(vehicle);
        return true;
    }

    public boolean updateParts(String serial, int parts) {
        WaterVehicle vehicle = searchVehicleSerial(serial);
        if (vehicle == null) {
            return false;
        }
        vehicle.setParts(parts);
        return true;
    }

   //Repairs water vehicle given serial
    public boolean repairWaterVehicle(String serial) {
        WaterVehicle vehicle = searchVehicleSerial(serial);
        if (vehicle == null || vehicle.getParts() == vehicle.getMaxParts()) {
            return false;
        }
        vehicle.setParts(vehicle.getMaxParts());
        return true;
    }

   //Gets last repair given serial
    public Repairs getLastRepair(String serial) {
        WaterVehicle vehicle = searchVehicleSerial(serial);
        if (vehicle == null) {
            return null;
        }
        return vehicle.getMostRecentRepair();
    }

   //Searches for a specific vehicle given serial
    public WaterVehicle searchVehicleSerial(String serial) {
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getSerialNum().equals(serial)) {
                return vehicle;
            }
        }
        return null;
    }

   //Gets vehcile given manufacture Date and location
    public ArrayList<WaterVehicle> searchVehicleManufactureLocation(int year, String location) {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getManufactureYear() == year && vehicle.getLocation().equals(location)) {
                result.add(vehicle);
            }
        }
        return result;
    }

   //Sorts with serial lethographically
    public void sortSerial() {
        waterStorage.sort((v1, v2) -> v1.getSerialNum().compareTo(v2.getSerialNum()));
    }

   //Sorts with manufacturer location lethographically
    public void sortManufactureLocation() {
        waterStorage.sort((v1, v2) -> v1.getLocation().compareTo(v2.getLocation()));
    }

   //Indicates the vehicle if it is being carried or not
    public boolean isBeingCarried(String serial) {
        Submarine sub = (Submarine) searchVehicleSerial(serial);
        return sub != null && sub.getContainedVehicle() != null;
    }

   //Sets all Submarines torpedo back to max as long as its carried
    public boolean reloadAllPossibleSubmarine() {
        boolean reloaded = false;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (isBeingCarried(sub.getSerialNum()) == true) {
                    sub.setNumberOfTorpedos(sub.getMaxTorpedos());
                    reloaded = true;
                }
            }
        }
        return reloaded;
    }
    
    
   // finds ship with most guns
    public Ship findShipWithMostGuns() {
        Ship result = null;
        int maxGuns = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getNumberOfGuns() > maxGuns) {
                    maxGuns = ship.getNumberOfGuns();
                    result = ship;
                }
            }
        }
        return result;
    }

   //finds submarine with most visibility
    public Submarine findSubmarineWithMostVisibility() {
        Submarine result = null;
        int maxVisibility = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (sub.getUnderWaterVisibility() > maxVisibility) {
                    maxVisibility = sub.getUnderWaterVisibility();
                    result = sub;
                }
            }
        }
        return result;
    }

   //Finds deepest submarine
    public Submarine findDeepestSubmarine() {
        Submarine result = null;
        int maxDepth = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (sub.getDepth() > maxDepth) {
                    maxDepth = sub.getDepth();
                    result = sub;
                }
            }
        }
        return result;
    }

   //Finds submarine with most torpedo storage
    public Submarine findSubmarineWithMostTorpedoStorage() {
        Submarine result = null;
        int maxTorpedoStorage = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (sub.getMaxTorpedos() > maxTorpedoStorage) {
                    maxTorpedoStorage = sub.getMaxTorpedos();
                    result = sub;
                }
            }
        }
        return result;
    }

   //Arraylist return of all water Nuclear pwoer
    public ArrayList<WaterVehicle> findAllWaterNuclearPowered() {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getIsNuclearPowered() == true) {
                result.add(vehicle);
            }
        }
        return result;
    }

   //Gets all empty submarines
    public ArrayList<Submarine> getEmptySubmarines() {
        ArrayList<Submarine> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (sub.getNumberOfTorpedos() == 0) {
                    result.add(sub);
                }
            }
        }
        return result;
    }

   //Gets all ship of a certain type
    public ArrayList<Ship> getAllShipOfType(String type) {
        ArrayList<Ship> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getType().equals(type)) {
                    result.add(ship);
                }
            }
        }
        return result;
    }

   //Finds all watervehicles at a specific location
    public ArrayList<WaterVehicle> findAtLocation(String location) {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getLocation().equals(location)) {
                result.add(vehicle);
            }
        }
        return result;
    }

   //Finds the fastest water vehicle
    public WaterVehicle findFastestWater()
    {
        WaterVehicle temp = null;
        for (int i = 0; i < waterStorage.size(); i++)
        {
            if (temp == null)
            {
                temp = waterStorage.get(i);
            }
            else
            {
                temp = temp.compareSpeed(waterStorage.get(i));
            }
        }
        return temp;
    }

   //Finds the fastest ship
    public Ship findFastestShip() {
        Ship result = null;
        int maxSpeed = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getSpeed() > maxSpeed) {
                    maxSpeed = ship.getSpeed();
                    result = ship;
                }
            }
        }
        return result;
    }

   //Finds the fastest submarine
    public Submarine findFastestSubmarine() {
        Submarine result = null;
        int maxSpeed = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (sub.getSpeed() > maxSpeed) {
                    maxSpeed = sub.getSpeed();
                    result = sub;
                }
            }
        }
        return result;
    }

   //Finds the ship with the most fuel
    public Ship findMostFuelShip() {
        Ship result = null;
        double maxFuel = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getFuelCapacity() > maxFuel) {
                    maxFuel = ship.getFuelCapacity();
                    result = ship;
                }
            }
        }
        return result;
    }

   //Finds the submarine with the most fuel
    public Submarine findMostFuelSubmarine() {
        Submarine result = null;
        double maxFuel = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (sub.getFuelCapacity() > maxFuel) {
                    maxFuel = sub.getFuelCapacity();
                    result = sub;
                }
            }
        }
        return result;
    }

   //Finds the most expensive submarine
    public Submarine findMostExpensiveSubmarine() {
        Submarine result = null;
        int maxCost = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (sub.getCost() > maxCost) {
                    maxCost = sub.getCost();
                    result = sub;
                }
            }
        }
        return result;
    }

     //finst the most expensive ship
    public Ship findMostExpensiveShip() {
        Ship result = null;
        int maxCost = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getCost() > maxCost) {
                    maxCost = ship.getCost();
                    result = ship;
                }
            }
        }
        return result;
    }

   //finds the most expensive water vehicle
    public WaterVehicle findMostExpensiveWaterVehicle() {
        WaterVehicle waterVehicle = null;
        for (int i = 0; i < waterStorage.size(); i++)
        {
            if (waterVehicle == null)
            {
                waterVehicle = waterStorage.get(i);
            }
            else
            {
                if (waterVehicle.compareCost(waterStorage.get(i)) < 0) {
                    waterVehicle = waterStorage.get(i);
                }
            }
        }
        return waterVehicle;
    }
      
      //gets the most tank Storage ship

    public Ship findMostTankStorageShip() {
        Ship result = null;
        int maxTankStorage = 0;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getMaxTankStorage() > maxTankStorage) {
                    maxTankStorage = ship.getMaxTankStorage();
                    result = ship;
                }
            }
        }
        return result;
    }

      //gets the most jet Storage ship

    public Ship findMostJetStorageShip() {
        Ship maxJetStorageShip = null;
        int maxJetStorage = 0;

        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getMaxJetStorage() > maxJetStorage) {
                    maxJetStorage = ship.getMaxJetStorage();
                    maxJetStorageShip = ship;
                }
            }
        }

        return maxJetStorageShip;
    }

      //gets the most Aircraft Storage ship

    public Ship findMostAircraftStorageShip() {
        Ship maxAircraftStorageShip = null;
        int maxAircraftStorage = 0;

        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getMaxAircraftStorage() > maxAircraftStorage) {
                    maxAircraftStorage = ship.getMaxAircraftStorage();
                    maxAircraftStorageShip = ship;
                }
            }
        }

        return maxAircraftStorageShip;
    }

      //gets the most rocket Storage ship

    public Ship findMostRocketStorageShip() {
        Ship maxRocketStorageShip = null;
        int maxRocketStorage = 0;

        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getMaxRocketStorage() > maxRocketStorage) {
                    maxRocketStorage = ship.getMaxRocketStorage();
                    maxRocketStorageShip = ship;
                }
            }
        }

        return maxRocketStorageShip;
    }

      //gets the most tank Submarine ship

    public Ship findMostSubmarineStorageShip() {
        Ship maxSubmarineStorageShip = null;
        int maxSubmarineStorage = 0;

        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Ship) {
                Ship ship = (Ship) vehicle;
                if (ship.getMaxSubmarineStorage() > maxSubmarineStorage) {
                    maxSubmarineStorage = ship.getMaxSubmarineStorage();
                    maxSubmarineStorageShip = ship;
                }
            }
        }

        return maxSubmarineStorageShip;
    }
    
      //Indicates what ship a specified submarine is carried in 
    
    public Ship isCarriedSubmarine(String serial) {
        Submarine submarine = (Submarine)searchVehicleSerial(serial);

        if (submarine instanceof Submarine) {
            for (WaterVehicle vehicle : waterStorage) {
                if (vehicle instanceof Ship) {
                    Ship ship = (Ship) vehicle;
                    if (submarine.getContainedVehicle()==ship) {
                        return ship;
                    }
                }
            }
        }

        return null;
    }

}
