// WaterVehicle Class with abstract methods and fields
public abstract class WaterVehicle {
    private double fuelCapacity;
    private boolean isNuclearPowered;
    private int manufactureYear;
    private String serialNum;
    private int speed;
    private String location;
    private int cost;
    private int partSwapWorth;
    private boolean isInWater;

    // Constructor
    public WaterVehicle(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost) {
        this.fuelCapacity = fuelCapacity;
        this.isNuclearPowered = isNuclearPowered;
        this.manufactureYear = manufactureYear;
        this.serialNum = serialNum;
        this.speed = speed;
        this.location = location;
        this.cost = cost;
        this.isInWater = false;
    }

    // Accessor (Getter) Methods
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public boolean getIsNuclearPowered() {
        return isNuclearPowered;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public int getSpeed() {
        return speed;
    }

    public String getLocation() {
        return location;
    }

    public int getCost() {
        return cost;
    }

    public int getPartSwapWorth() {
        return partSwapWorth;
    }

    public boolean getIsInWater() {
        return isInWater;
    }

    // Mutator (Setter) Methods
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setIsNuclearPowered(boolean isNuclearPowered) {
        this.isNuclearPowered = isNuclearPowered;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPartSwapWorth(int partSwapWorth) {
        this.partSwapWorth = partSwapWorth;
    }

    public void setIsInWater(boolean isInWater) {
        this.isInWater = isInWater;
    }

    //class methods
    public boolean launch(){
        if(isInWater){
            return true;
        }else{
            return false;
        }
    }

    //abstract methods
    public abstract String generateSerialNum();

}

import java.util.ArrayList;

public class Ship extends WaterVehicle {
    // Class fields
    private int buoyancy;
    private int numberOfGuns;
    private String type;
    private int maxTankStorage;
    private int maxJetStorage;
    private int maxSubmarineStorage;
    private int maxRocketStorage;
    private boolean docked;
    private ArrayList<Tank> tankInShip; 
    private ArrayList<Jet> jetInShip; 
    private ArrayList<Submarine> submarineInShip; 
    private ArrayList<Rocket> rocketInShip; 

    // Constructor
    public Ship(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost,
                int buoyancy, int numberOfGuns, String type, int maxTankStorage, int maxJetStorage, int maxSubmarineStorage, int maxRocketStorage) {
        super(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost);
        this.buoyancy = buoyancy;
        this.numberOfGuns = numberOfGuns;
        this.type = type;
        this.maxTankStorage = maxTankStorage;
        this.maxJetStorage = maxTankStorage;
        this.maxSubmarineStorage = maxTankStorage;
        this.maxRocketStorage = maxTankStorage;
        this.tankInShip = new ArrayList<>(); 
        this.jetInShip = new ArrayList<>(); 
        this.submarineInShip = new ArrayList<>(); 
        this.rocketInShip = new ArrayList<>(); 
        this.docked = true; 
    }

    //add vehicles into the Ship
    public boolean addTank(Tank tank) {
        String serialNumOfTank = tank.getSerialNum();
        if (!LandManager.isCarried(serialNumOfTank)) {
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
    

        public boolean addJet(Jet jet) {
        String serialNumOfJet = jet.getSerialNum();
        if (!AirManager.isCarried(serialNumOfJet)) {
            if (jetInShip.size() < jetTankStorage) {
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
        if (!WaterManager.isCarried(serialNumOfSubmarine)) {
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
    

        public boolean addTank(Rocket rocket) {
        String serialNumOfRocket = rocket.getSerialNum();
        if (!SpaceManager.isCarried(serialNumOfRocket)) {
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
}


public class Submarine extends WaterVehicle{
    private int depth;
    private int numberIfTorpedos;
    private int underWaterVisibility;
}
