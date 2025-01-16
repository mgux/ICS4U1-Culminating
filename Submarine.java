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

    public Submarine(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost, int parts, int minParts, int maxParts, int depth, int nomberOfTorpedos, int underWaterVisibility, int maxTorpedos, boolean docked){
        super(fuelCapacity, isNuclearPowered, manufactureYear, serialNum, speed, location, cost, parts, maxParts, minParts);
        this.depth = depth;
        this.numberOfTorpedos = numberOfTorpedos;
        this.underWaterVisibility = underWaterVisibility; 
        this.maxTorpedos = maxTorpedos; 
        this.docked = true;  
    }
}
