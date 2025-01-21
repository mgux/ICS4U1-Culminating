/*
SpaceVehicle.java
Tianyue Zhao
ICS4U1
Jan 20th, 2025
Description: The SpaceVehicle class has all the methods needed to compare SpaceVehicles
*/


import java.util.*;

public abstract class SpaceVehicle
{
    private int altitude;
    private String camera;
    private int manufactureYear;
    private String serialNum;
    private int speed;
    private String location;
    private int cost;
    private int parts;
    private int maxParts;
    private int minParts;
    final static int PART_SWAP_WORTH = 2;
    private ArrayList<Repairs> repairHistory = new ArrayList<Repairs>();

    public SpaceVehicle(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7) //Constructor
    {
        altitude = n1;
        camera = s1;
        manufactureYear = n2;
        serialNum = s2;
        speed = n3;
        location = s3;
        cost = n4;
        parts = n5;
        maxParts = n6;
        minParts = n7;
    }

    //Accessors and Mutators
    public int getAltitude()
    {
        return altitude;
    }
    public String getCamera()
    {
        return camera;
    }
    public int getManufactureYear()
    {
        return manufactureYear;
    }
    public String getSerialNum()
    {
        return serialNum;
    }
    public int getSpeed()
    {
        return speed;
    }
    public String getLocation()
    {
        return location;
    }
    public int getCost()
    {
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
    public void setAltitude(int n)
    {
        altitude = n;
    }
    public void setCamera(String s)
    {
        camera = s;
    }
    public void setManufactureYear(int n)
    {
        manufactureYear = n;
    }
    public void setSerialNum(String s)
    {
        serialNum = s;
    }
    public void setSpeed(int n)
    {
        speed = n;
    }
    public void setLocation(String s)
    {
        location = s;
    }
    public void setCost(int n)
    {
        cost = n;
    }
    public void setParts(int n)
    {
        parts = n;
    }
    public void setMaxParts(int n)
    {
        maxParts = n;
    }
    public void setMinParts(int n)
    {
        minParts = n;
    }
    public SpaceVehicle compareCost(SpaceVehicle other) //Returns other if the cost of other is larger than this
    {
        return ((this.getCost()>other.getCost())?this:other);
    }
    public SpaceVehicle compareSpeed(SpaceVehicle other) //Returns other if the speed of other is larger than this
    {
        return ((this.getSpeed()>other.getSpeed())?this:other);
    }
    public SpaceVehicle compareAltitude(SpaceVehicle other) //Returns other if the altitude of other is larger than this
    {
        return ((this.getAltitude()>other.getAltitude())?this:other);
    }
    public abstract boolean isBroken(); //Abstrct isBroken to determine if a Vehicle is broken, returning true if it is and false otherwise
    public boolean removeParts(int n) //Tries to remove an amount of parts from the Vehicle, returning true if successful and false otherwise
    {
        if (parts-n < minParts)
        {
            return false;
        }
        parts-=n;
        return true;
    }
    public boolean addRepair() //Add a repair 
    {
        Repairs r = new Repairs(this);
        repairHistory.add(r);
        return true;
    }
    public Repairs getMostRecentRepairs() //Searches the repairHistory to get the most recent one
    {
        Repairs r = repairHistory.get(0);
        for (int i = 1; i < repairHistory.size(); i++)
        {
            r = r.compareRepairTime(repairHistory.get(i));
        }
        return r;
    }
    public String toString() //toString
    {
        return altitude+"\n"+camera+"\n"+manufactureYear+"\n"+serialNum+"\n"+speed+"\n"+location+"\n"+cost+"\n"+parts+"\n"+maxParts+"\n"+minParts+"\n";
    }
}
