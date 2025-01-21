/*
ICS4U1-12
Luke
00/00/0000
A.Y Jackson SS

The submarine has a depth variable for the depth it is currently at.
It has a visibility underwater a torpedo storage and max amount.

*/
// Submarine Class with abstract methods and fields

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Submarine extends WaterVehicle{

    //class fields
    private int depth;
    private int numberOfTorpedos;
    private int underWaterVisibility;
    private int maxTorpedos;
    private boolean docked;
    private Ship containedVehicle;

    public Submarine(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost, int parts, int minParts, int maxParts, int depth, int nomberOfTorpedos, int underWaterVisibility, int maxTorpedos, boolean docked){
        super(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, maxParts, minParts);
        this.depth = depth;
        this.numberOfTorpedos = numberOfTorpedos;
        this.underWaterVisibility = underWaterVisibility;
        this.maxTorpedos = maxTorpedos;
        this.docked = true;
    }

    // Accessor (Getter) Methods
    public int getDepth() {
        return depth;
    }

    public int getNumberOfTorpedos() {
        return numberOfTorpedos;
    }

    public int getUnderWaterVisibility() {
        return underWaterVisibility;
    }

    public int getMaxTorpedos() {
        return maxTorpedos;
    }

    public boolean isDocked() {
        return docked;
    }

    public Ship getContainedVehicle()
    {
        return containedVehicle;
    }

    // Mutator (Setter) Methods
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setNumberOfTorpedos(int numberOfTorpedos) {
        this.numberOfTorpedos = numberOfTorpedos;
    }

    public void setUnderWaterVisibility(int underWaterVisibility) {
        this.underWaterVisibility = underWaterVisibility;
    }

    public void setMaxTorpedos(int maxTorpedos) {
        this.maxTorpedos = maxTorpedos;
    }

    public void setDocked(boolean docked) {
        this.docked = docked;
    }

    public void setContainedVehicle(Ship a)
    {
        containedVehicle = a;
    }

    //compare methods
    public double comparefuelCapacity(Submarine other){
        return (this.getFuelCapacity() - other.getFuelCapacity());
    }

    public double compareSpeed(Submarine other){
        return (this.getSpeed() - other.getSpeed());
    }

    public double compareCost(Submarine other){
        return (this.getCost() - other.getCost());
    }

    public double compareDepth(Submarine other){
        return (this.getDepth() - other.getDepth());
    }

    public double compareUnderWaterVisibilty(Submarine other){
        return (this.getUnderWaterVisibility() - other.getUnderWaterVisibility());
    }

    public double compareMaxTorpedos(Submarine other){
        return (this.getNumberOfTorpedos() - other.getNumberOfTorpedos());
    }

    //class methods
    public boolean shootTorpedo(int amount){
        if(amount > numberOfTorpedos){
            System.out.println("Not enough torpedos to shoot");
            return false;
        }else{
            this.numberOfTorpedos = numberOfTorpedos - amount;
            return true;
        }
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
        return super.toString() + depth + "\n" +
               numberOfTorpedos + "\n" +
              underWaterVisibility + "\n" +
             maxTorpedos + "\n" +
           docked + "\n";
    }


}
