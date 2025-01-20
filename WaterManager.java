/*
ICS4U1-12
Luke
00/00/0000
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

    public WaterManager() {
         waterStorage = new ArrayList<WaterVehicle>();
    }

    public boolean addShip(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost, int parts, int maxParts, int minParts, int buoyancy, int numberOfGuns, String type, int maxTankStorage, int maxJetStorage, int maxSubmarineStorage, int maxRocketStorage, int maxAircraftStorage, boolean docked) {
        Ship newShip = new Ship(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, maxParts, minParts, buoyancy, numberOfGuns, type, maxTankStorage, maxJetStorage, maxSubmarineStorage, maxRocketStorage, maxAircraftStorage, docked);
        waterStorage.add(newShip);
        return true;
    }

    public boolean addSubmarine(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost, int parts, int minParts, int maxParts, int depth, int nomberOfTorpedos, int underWaterVisibility, int maxTorpedos, boolean docked){
        Submarine newSubmarine = new Submarine(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, minParts, maxParts, depth, nomberOfTorpedos, underWaterVisibility, maxTorpedos, docked);
        waterStorage.add(newSubmarine);
        return true;
    }
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

public boolean readSubmarine(String fileName) {
    boolean isRead = true;
    BufferedReader in;
    try {
        in = new BufferedReader(new FileReader(fileName));
        try {
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
        } catch (NumberFormatException | NullPointerException ex) {
            isRead = false;
        }
        in.close();
    } catch (IOException io) {
        isRead = false;
    }
    return isRead;
}

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
        }
        out.close();
    } catch (IOException io) {
        isOut = false;
    }
    return isOut;
}

    
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

    public boolean repairWaterVehicle(String serial) {
        WaterVehicle vehicle = searchVehicleSerial(serial);
        if (vehicle == null || vehicle.getParts() == vehicle.getMaxParts()) {
            return false;
        }
        vehicle.setParts(vehicle.getMaxParts());
        return true;
    }

    public Repairs getLastRepair(String serial) {
        WaterVehicle vehicle = searchVehicleSerial(serial);
        if (vehicle == null) {
            return null;
        }
        return vehicle.getMostRecentRepair();
    }

    public WaterVehicle searchVehicleSerial(String serial) {
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getSerialNum().equals(serial)) {
                return vehicle;
            }
        }
        return null;
    }


    public ArrayList<WaterVehicle> searchVehicleManufactureLocation(int year, String location) {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getManufactureYear() == year && vehicle.getLocation().equals(location)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public void sortSerial() {
        waterStorage.sort((v1, v2) -> v1.getSerialNum().compareTo(v2.getSerialNum()));
    }

    public void sortManufactureLocation() {
        waterStorage.sort((v1, v2) -> v1.getLocation().compareTo(v2.getLocation()));
    }

    public boolean isBeingCarried(String serial) {
        Submarine sub = (Submarine) searchVehicleSerial(serial);
        return sub != null && sub.getContainedVehicle() != null;
    }

    public boolean reloadAllPossibleSubmarine() {
        boolean reloaded = false;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (isBeingCarried(sub.getSerialNum()) == false) {
                  sub.setNumberOfTorpedos(sub.getMaxTorpedos());
                    reloaded = true;
                }
            }
        }
        return reloaded;
    }

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

    public ArrayList<WaterVehicle> findAllWaterNuclearPowered() {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getIsNuclearPowered() == true) {
                result.add(vehicle);
            }
        }
        return result;
    }

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

    public ArrayList<WaterVehicle> findAtLocation(String location) {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getLocation().equals(location)) {
                result.add(vehicle);
            }
        }
        return result;
    }

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
   
