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

    //add methods
    public boolean addTank(Tank tank) {
        String serialNumOfTank = tank.getSerialNum();
        if (!LandManager.isCarriedTank(serialNumOfTank)) {
            if (tankInShip.size() < maxTankStorage) {
                tankInShip.add(tank);
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
                return true;
            } else {
                System.out.println("Cannot add Aircraft. Maximum Aircraft storage reached!");
                return false;
            }
        } else {
            System.out.println("Aircraft with serial number " + serialNumOfTank + " is already on the ship.");
            return false;
        }
    }
    
    
    public boolean addJet(Jet jet) {
        String serialNumOfJet = jet.getSerialNum();
        if (!AirManager.isCarriedJet(serialNumOfJet)) {
            if (jetInShip.size() < maxJetStorage) {
                jetInShip.add(jet);
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
            if(i.getSerialNum == serial){
               tankInShip.remove(i);
               return true;
            }
        }
      return false;
    }
    
    public boolean removeJet(String serial) {
         for(Jet i : jetInShip){
            if(i.getSerialNum == serial){
               jetInShip.remove(i);
               return true;
            }
        }
      return false;
    }
    
    public boolean removeAircraft(String serial) {
         for(Aircraft i : aircraftInShip){
            if(i.getSerialNum == serial){
               aircraftInShip.remove(i);
               return true;
            }
        }
      return false;
    }
    
    public boolean removeRocket(String serial) {
         for(Rocket i : rocketInShip){
            if(i.getSerialNum == serial){
               rocketInShip.remove(i);
               return true;
            }
        }
      return false;
    }
    
   public boolean removeSubmarine(String serial) {
         for(Submarine i : submarineInShip){
            if(i.getSerialNum == serial){
               submarineInShip.remove(i);
               return true;
            }
        }
      return false;
    }
    
    //compare methods
    public double comparefuelCapacity(Ship other){
        return (this.fuelCapacity - other.fuelCapacity);
    }

    public double compareSpeed(Ship other){
        return (this.speed - other.speed);
    }

    public double compareCost(Ship other){
        return (this.cost - other.cost);
    }
    
   public double compareBuoancy(Ship other){
        return (this.buoancy - other.buoancy);
    }

    public double compareNumberOfGuns(Ship other){
        return (this.numberOfGuns - other.numberOfGuns);
    }

    public double TankCapacity(Ship other){
        return (this.tankCapacity - other.tankCapacity);
    }
    
   public double AircraftCapacity(Ship other){
        return (this.aircraftCapacity - other.aircraftCapacity);
    }

    public double SubmarineCapacity(Ship other){
        return (this.submarineCapacity - other.submarineCapacity);
    }

    public double JetCapacity(Ship other){
        return (this.jetCapacity - other.jetCapacity);
    }
    
    public double RocketCapacity(Ship other){
        return (this.rocketCapacity - other.rocketCapacity);
    }
    
    //get contained vehicles
    public Tank[] getAllTank(){
      return tankInShip;
    }
    
   public Aricraft[] getAllAricraft(){
      return aircraftInShip;
    }
    
   public Rocket[] getAllRocket(){
      return rocketInShip;
    }
    
   public Jet[] getAllJet(){
      return jetInShip;
    }
    
   public Submarine[] getAllSubmarine(){
      return submarineInShip;
    }
    
   //toString
   public String toString(){
        return "";
    }
}
