/*
ICS4U1-12
Luke
01/19/2025
A.Y Jackson SS

An abstract class that is also the parent class of Ship and Submarine.
It contains fields and abstract methods that all the waterVehicles should have, such as the fuel capacity and whether it is nuclear powered.
It also contains the parts' worth and all the comparison methods that are required for in waterManager.

*/
// WaterVehicle Class with abstract methods and fields

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public abstract class WaterVehicle {

    //class fields
    private double fuelCapacity;
    private boolean isNuclearPowered;
    private int manufactureYear;
    private String serialNum;
    private int speed;
    private String location;
    private int cost;
    private int parts;
    private int maxParts;
    private int minParts;
    public final int PART_SWAP_WORTH = 1;
    private ArrayList<Repairs> repairHistory = new ArrayList<>();

    // Constructor
    public WaterVehicle(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost, int parts, int maxParts, int minParts) {
        this.fuelCapacity = fuelCapacity;
        this.isNuclearPowered = isNuclearPowered;
        this.manufactureYear = manufactureYear;
        this.serialNum = serialNum;
        this.speed = speed;
        this.location = location;
        this.cost = cost;
        this.parts = parts;
        this.maxParts = maxParts;
        this.minParts = minParts;
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


    public int getParts()
    {
        return parts;
    }

    public int getMaxParts()
    {
        return maxParts;
    }

    public int getMinParts()
    {
        return minParts;
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

    public void setParts(int parts) {
        this.parts = parts;
    }

    public void setMaxParts(int maxParts) {
        this.maxParts = maxParts;
    }

    public void setMinParts(int minParts) {
        this.minParts = minParts;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    //compare methods
    //compares fuel capacity
    public double comparefuelCapacity(WaterVehicle other){
        return (this.fuelCapacity - other.fuelCapacity);
    }

    //compares speed
    public WaterVehicle compareSpeed(WaterVehicle other){
        if (this.speed > other.speed) {
            return this;
        }
        return other;
    }

    //compares cost
    public double compareCost(WaterVehicle other){
        return (this.cost - other.cost);
    }



    //class methods
    
    //adds a repair to the vehicles repairhistory
    public boolean addRepair(){
        Repairs r = new Repairs(this);
        repairHistory.add(r);
        return true;
    }

   //method to remove parts 
    public boolean removeParts(int remove){
        this.parts = parts - remove;
        return true;
    }

   //method to get most recent exist repair (dosnt have to be completed repair) returns the most recent repair
    public Repairs getMostRecentRepair(){
        Repairs mostRecentRepair = repairHistory.get(0);
        for (int i = 1; i < repairHistory.size(); i++){
            mostRecentRepair = mostRecentRepair.compareRepairTime(repairHistory.get(0));
        }
        return mostRecentRepair;
    }

    //abstract methods 
    public abstract boolean isBroken();

    //toString method
    public String toString() {
        return fuelCapacity +
                "\n" + isNuclearPowered +
                "\n" + manufactureYear +
                "\n" + serialNum +
                "\n" + speed +
                "\n" + location +
                "\n" + cost +
                "\n" + parts +
                "\n" + maxParts +
                "\n" + minParts +
                 "\n";
    }

}
