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

    public boolean addShip(double fuelCapacity, boolean isNuclearPowered, int engineNum, int manufactureYear, String location,
                           int cost, int speed, int tankStorage, int jetStorage, int aircraftStorage,
                           int rocketStorage, String shipType, int guns, int parts, int minParts, int maxParts, int altitude,
                           boolean docked) {
        Ship newShip = new Ship(fuelCapacity, isNuclearPowered, engineNum, manufactureYear, location, cost, speed,
                                tankStorage, jetStorage, aircraftStorage, rocketStorage, shipType, guns, parts, minParts, maxParts, altitude, docked);
        waterStorage.add(newShip);
        return true;
    }

    public boolean addSubmarine(double fuelCapacity, boolean isNuclearPowered, int engineNum, int manufactureYear, String location,
                                 int cost, int speed, int torpedoStorage, int visibility, int maxDepth,
                                 int tankStorage, int jetStorage, int parts, int minParts, int maxParts, boolean docked) {
        Submarine newSubmarine = new Submarine(fuelCapacity, isNuclearPowered, engineNum, manufactureYear, location, cost, speed,
                                               torpedoStorage, visibility, maxDepth, tankStorage, jetStorage, parts, minParts, maxParts, docked);
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
            out.newLine(); 
        }
        out.close();
    } catch (IOException io) {
        isOut = false;
    }
    return isOut;
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

    public Repair getLastRepair(String serial) {
        WaterVehicle vehicle = searchVehicleSerial(serial);
        if (vehicle == null) {
            return null;
        }
        return vehicle.getLastRepair();
    }

    public WaterVehicle searchVehicleSerial(String serial) {
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getSerialNum().equals(serial)) {
                return vehicle;
            }
        }
        return null;
    }

    public ArrayList<WaterVehicle> searchVehicleWingNumber(int wingNum) {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.getWingNum() == wingNum) {
                result.add(vehicle);
            }
        }
        return result;
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
        return sub != null && sub.isBeingCarried();
    }

    public boolean reloadAllPossibleSubmarine() {
        boolean reloaded = false;
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle instanceof Submarine) {
                Submarine sub = (Submarine) vehicle;
                if (sub.reload()) {
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
                if (ship.getGuns() > maxGuns) {
                    maxGuns = ship.getGuns();
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
                if (sub.getVisibility() > maxVisibility) {
                    maxVisibility = sub.getVisibility();
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
                if (sub.getMaxDepth() > maxDepth) {
                    maxDepth = sub.getMaxDepth();
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
                if (sub.getTorpedoStorage() > maxTorpedoStorage) {
                    maxTorpedoStorage = sub.getTorpedoStorage();
                    result = sub;
                }
            }
        }
        return result;
    }

    public ArrayList<WaterVehicle> findAllWaterNuclearPowered() {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.isNuclearPowered()) {
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
                if (sub.isEmpty()) {
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

    public ArrayList<WaterVehicle> getAllDocked() {
        ArrayList<WaterVehicle> result = new ArrayList<>();
        for (WaterVehicle vehicle : waterStorage) {
            if (vehicle.isDocked()) {
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
                if (ship.getTankStorage() > maxTankStorage) {
                    maxTankStorage = ship.getTankStorage();
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
               if (ship.getJetStorageCapacity() > maxJetStorage) {
                   maxJetStorage = ship.getJetStorageCapacity();
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
               if (ship.getAircraftStorageCapacity() > maxAircraftStorage) {
                   maxAircraftStorage = ship.getAircraftStorageCapacity();
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
               if (ship.getRocketStorageCapacity() > maxRocketStorage) {
                   maxRocketStorage = ship.getRocketStorageCapacity();
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
               if (ship.getSubmarineStorageCapacity() > maxSubmarineStorage) {
                   maxSubmarineStorage = ship.getSubmarineStorageCapacity();
                   maxSubmarineStorageShip = ship;
               }
           }
       }
   
       return maxSubmarineStorageShip;
   }
   
   public Ship isCarriedSubmarine(String serial) {
       WaterVehicle submarine = searchVehicleSerial(serial);
   
       if (submarine instanceof Submarine) {
           for (WaterVehicle vehicle : waterStorage) {
               if (vehicle instanceof Ship) {
                   Ship ship = (Ship) vehicle;
                   if (ship.isCarryingSubmarine((Submarine) submarine)) {
                       return ship;
                   }
               }
           }
       }
   
       return null;
   }
   
}
   
