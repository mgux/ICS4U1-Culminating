/*
ICS4U1-12
Luke
00/00/0000
A.Y Jackson SS

The ship can carry rockets, tanks and aircrafts. 
The ship has a buoyancy and a separate storage for all vehicles it can carry. 
The Ship cannot be carried by anything.

*/
// Ship Class with methods and fields

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Ship extends WaterVehicle {
    
    // Class fields
    private int buoyancy;
    private int numberOfGuns;
    private String type;
    private int maxTankStorage;
    private int maxJetStorage;
    private int maxSubmarineStorage;
    private int maxRocketStorage;
    private int maxAircraftStorage;
    private boolean docked;
    private ArrayList<Tank> tankInShip; 
    private ArrayList<Jet> jetInShip; 
    private ArrayList<Submarine> submarineInShip; 
    private ArrayList<Rocket> rocketInShip; 
    private ArrayList<Aircraft> aircraftInShip; 

    // Constructor
    public Ship(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost, int parts, int maxParts, int minParts, int buoyancy, int numberOfGuns, String type, int maxTankStorage, int maxJetStorage, int maxSubmarineStorage, int maxRocketStorage, int maxAircraftStorage, boolean docked) {
        super(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, maxParts, minParts);
        this.buoyancy = buoyancy;
        this.numberOfGuns = numberOfGuns;
        this.type = type;
        this.maxTankStorage = maxTankStorage;
        this.maxJetStorage = maxTankStorage;
        this.maxAircraftStorage = maxAircraftStorage;
        this.maxSubmarineStorage = maxTankStorage;
        this.maxRocketStorage = maxTankStorage;
        this.tankInShip = new ArrayList<>(); 
        this.jetInShip = new ArrayList<>(); 
        this.submarineInShip = new ArrayList<>(); 
        this.rocketInShip = new ArrayList<>(); 
        this.aircraftInShip = new ArrayList<>(); 
        this.docked = true; 
    }
   // Getters and Setters for Ship class
   public int getBuoyancy() {
       return buoyancy;
   }
   
   public void setBuoyancy(int buoyancy) {
       this.buoyancy = buoyancy;
   }
   
   public int getNumberOfGuns() {
       return numberOfGuns;
   }
   
   public void setNumberOfGuns(int numberOfGuns) {
       this.numberOfGuns = numberOfGuns;
   }
   
   public String getType() {
       return type;
   }
   
   public void setType(String type) {
       this.type = type;
   }
   
   public int getMaxTankStorage() {
       return maxTankStorage;
   }
   
   public void setMaxTankStorage(int maxTankStorage) {
       this.maxTankStorage = maxTankStorage;
   }
   
   public int getMaxJetStorage() {
       return maxJetStorage;
   }
   
   public void setMaxJetStorage(int maxJetStorage) {
       this.maxJetStorage = maxJetStorage;
   }
   
   public int getMaxSubmarineStorage() {
       return maxSubmarineStorage;
   }
   
   public void setMaxSubmarineStorage(int maxSubmarineStorage) {
       this.maxSubmarineStorage = maxSubmarineStorage;
   }
   
   public int getMaxRocketStorage() {
       return maxRocketStorage;
   }
   
   public void setMaxRocketStorage(int maxRocketStorage) {
       this.maxRocketStorage = maxRocketStorage;
   }
   
   public int getMaxAircraftStorage() {
       return maxAircraftStorage;
   }
   
   public void setMaxAircraftStorage(int maxAircraftStorage) {
       this.maxAircraftStorage = maxAircraftStorage;
   }
   
   public boolean isDocked() {
       return docked;
   }
   
   public void setDocked(boolean docked) {
       this.docked = docked;
   }

    //add methods
    public boolean addTank(Tank tank) {
        String serialNumOfTank = tank.getSerialNum();
        if (!LandManager.isCarriedTank(serialNumOfTank)) {
            if (tankInShip.size() < maxTankStorage) {
                tankInShip.add(tank);
                tank.setContainedVehicle(this);
                return true;
            } else {
                System.out.println("Cannot add Tank. Maximum tank storage reached!");
                return false;
            }
        } else {
            System.out.println("Tank with serial number " + serialNumOfTank + " is already on the ship.");
            return false;
        }
    }
    
    
    public boolean addAricraft(Aircraft aircraft) {
        String serialNumOfAircraft = aircraft.getSerialNum();
        if (!AirManager.isCarriedAircraft(serialNumOfAircraft)) {
            if (aircraftInShip.size() < maxAircraftStorage) {
                aircraftInShip.add(aircraft);
                aircraft.setContainedVehicle(this);
                return true;
            } else {
                System.out.println("Cannot add Aircraft. Maximum Aircraft storage reached!");
                return false;
            }
        } else {
            System.out.println("Aircraft with serial number " + serialNumOfAircraft + " is already on the ship.");
            return false;
        }
    }
    
    
    public boolean addJet(Jet jet) {
        String serialNumOfJet = jet.getSerialNum();
        if (!AirManager.isCarriedJet(serialNumOfJet)) {
            if (jetInShip.size() < maxJetStorage) {
                jetInShip.add(jet);
                jet.setContainedVehicle(this);
                return true;
            } else {
                System.out.println("Cannot add Jet. Maximum jet storage reached!");
                return false;
            }
        } else {
            System.out.println("Jet with serial number " + serialNumOfJet + " is already on the ship.");
            return false;
        }
    }
    

    public boolean addSubmarine(Submarine submarine) {
        String serialNumOfSubmarine = submarine.getSerialNum();
        if (!WaterManager.isCarriedSubmarine(serialNumOfSubmarine)) {
            if (submarineInShip.size() < maxSubmarineStorage) {
                submarineInShip.add(submarine);
                submarine.setContainedVehicle(this);
                return true;
            } else {
                System.out.println("Cannot add Submarine. Maximum submarine storage reached!");
                return false;
            }
        } else {
            System.out.println("Submarine with serial number " + serialNumOfSubmarine + " is already on the ship.");
            return false;
        }
    }
    

    public boolean addRocket(Rocket rocket) {
        String serialNumOfRocket = rocket.getSerialNum();
        if (!SpaceManager.isCarriedRocket(serialNumOfRocket)) {
            if (rocketInShip.size() < maxRocketStorage) {
                rocketInShip.add(rocket);
                submarine.setContainedVehicle(this);
                return true;
            } else {
                System.out.println("Cannot add Rocket. Maximum rocket storage reached!");
                return false;
            }
        } else {
            System.out.println("Rocket with serial number " + serialNumOfRocket + " is already on the ship.");
            return false;
        }
    }
    
    
    //remove methods
    public boolean removeTank(String serial) {
         for(Tank i : tankInShip){
            if(i.getSerialNum() == serial){
               tankInShip.remove(i);
               i.setContainedVehicle(null);
               return true;
            }
        }
      return false;
    }
    
    public boolean removeJet(String serial) {
         for(Jet i : jetInShip){
            if(i.getSerialNum() == serial){
               jetInShip.remove(i);
               i.setContainedVehicle(null);
               return true;
            }
        }
      return false;
    }
    
    public boolean removeAircraft(String serial) {
         for(Aircraft i : aircraftInShip){
            if(i.getSerialNum() == serial){
               aircraftInShip.remove(i);
               i.setContainedVehicle(null);
               return true;
            }
        }
      return false;
    }
    
    public boolean removeRocket(String serial) {
         for(Rocket i : rocketInShip){
            if(i.getSerialNum() == serial){
               rocketInShip.remove(i);
               i.setContainedVehicle(null);
               return true;
            }
        }
      return false;
    }
    
   public boolean removeSubmarine(String serial) {
         for(Submarine i : submarineInShip){
            if(i.getSerialNum() == serial){
               submarineInShip.remove(i);
               i.setContainedVehicle(null);
               return true;
            }
        }
      return false;
    }
    
    //compare methods
    public double comparefuelCapacity(Ship other){
        return (this.getFuelCapacity() - other.getFuelCapacity());
    }

    public double compareSpeed(Ship other){
        return (this.getSpeed() - other.getSpeed());
    }

    public double compareCost(Ship other){
        return (this.getCost() - other.getCost());
    }
    
   public double compareBuoyancy(Ship other){
        return (this.getBuoyancy() - other.getBuoyancy());
    }

    public double compareNumberOfGuns(Ship other){
        return (this.getNumberOfGuns() - other.getNumberOfGuns());
    }

    public double TankCapacity(Ship other){
        return (this.getMaxTankStorage() - other.getMaxTankStorage());
    }
    
   public double AircraftCapacity(Ship other){
        return (this.getMaxAircraftStorage() - other.getMaxAircraftStorage());
    }

    public double SubmarineCapacity(Ship other){
        return (this.getMaxSubmarineStorage() - other.getMaxSubmarineStorage());
    }

    public double JetCapacity(Ship other){
        return (this.getMaxJetStorage() - other.getMaxJetStorage());
    }
    
    public double RocketCapacity(Ship other){
        return (this.getMaxRocketStorage() - other.getMaxRocketStorage());
    }
    
    public ArrayList<Tank> getAllTanks() {
        return tanksInShip;
    }

    public ArrayList<Aircraft> getAllAircraft() {
        return aircraftInShip;
    }

    public ArrayList<Rocket> getAllRockets() {
        return rocketsInShip;
    }

    public ArrayList<Jet> getAllJets() {
        return jetsInShip;
    }
        
   //Check if broken
   public boolean isBroken()
   {
      if (this.getParts() < this.getMinParts())
      {
         return true;
      }
      return false;
   }
   
   //toString
public String toString() {
    return super.toString() +
           "Buoyancy: " + buoyancy + "\n" +
           "Number of Guns: " + numberOfGuns + "\n" +
           "Type: " + type + "\n" +
           "Max Tank Storage: " + maxTankStorage + "\n" +
           "Max Aircraft Storage: " + maxAircraftStorage + "\n" +
           "Max Submarine Storage: " + maxSubmarineStorage + "\n" +
           "Max Rocket Storage: " + maxRocketStorage + "\n" +
           "Max Jet Storage: " + maxJetStorage + "\n" +
           "Docked: " + docked + "\n";
}


}
