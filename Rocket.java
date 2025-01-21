/*
Rocket.java
Tianyue Zhao
ICS4U1
Jan 20th, 2025
Description: Rocket class, which contains methods that compares Rockets
*/

import java.util.*;

public class Rocket extends SpaceVehicle
{
    private int enginePower;
    private int numberOfEngine;
    private int maxSatellites;
    private ArrayList<Satellite> satelliteInRocket = new ArrayList<Satellite>(); //ArrayList of the Satellites it is carrying
    private Ship containedVehicle;
    public Rocket(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) //Constructor
    {
        super(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7);
        enginePower = n8;
        numberOfEngine = n9;
        maxSatellites = n10;
        containedVehicle = null;
    }

    //Accessors and Mutators
    public int getEnginePower()
    {
        return enginePower;
    }
    public int getNumberOfEngine()
    {
        return numberOfEngine;
    }
    public int getMaxSatellites()
    {
        return maxSatellites;
    }
    public Ship getContainedVehicle()
    {
        return containedVehicle;
    }
    public void setEnginePower(int n)
    {
        enginePower = n;
    }
    public void setNumberOfEngine(int n)
    {
        numberOfEngine = n;
    }
    public void setMaxSatellites(int n)
    {
        maxSatellites = n;
    }
    public void setContainedVehicle(Ship s)
    {
        containedVehicle = s;
    }

    public boolean addSatellite(Satellite s) //Adds a Satellite. If successful, return true. Else, return false
    {
        if (satelliteInRocket.size() == maxSatellites)
        {
            return false;
        }
        satelliteInRocket.add(s);
        return true;
    }

    public boolean removeSatellite(Satellite s) //Attempts to remove a satellite. If successful, return true. Else, return false
    {
        int index = -1;
        for (int i = 0; i < satelliteInRocket.size() && index == -1; i++)
        {
            if (satelliteInRocket.get(i) == s)
            {
                index = i;
            }
        }
        if (index == -1)
        {
            return false;
        }
        satelliteInRocket.remove(index);
        return true;
    }

    public Rocket compareSpeed(Rocket other) //OverLoads the compareSpeed method in SpaceVehicle, with same implemention
    {
        return this.getSpeed()>other.getSpeed()?this:other;
    }
    public Rocket compareEnginePower(Rocket other) //Returns other if other has a higher enginePower than this. Else, return this
    {
        return this.enginePower>other.enginePower?this:other;
    }
    public Rocket compareCost(Rocket other) //OverLoads the compareCost method in SpaceVehicle, with same implementation
    {
        return this.getCost()>other.getCost()?this:other;
    }
    public Rocket compareEngineNumber(Rocket other) //Returns other if other has a higher numberOfEngine. Else, return this
    {
        return this.numberOfEngine>other.numberOfEngine?this:other;
    }
    public Ship containedWithinVehicle() //Returns the Ship that it is being contained in, and null if it is not being contained
    {
        return getContainedVehicle();
    }
    public ArrayList<Satellite> containedVehicles() //Returns the Satellites it is carrying
    {
        return satelliteInRocket;
    }
    public boolean isBroken() //Implements the abstract isBroken method in SpaceVehicle
    {
        if (this.getParts() < this.getMinParts() && enginePower == 0)
        {
            return true;
        }
        return false;
    }
    public String toString() //toString
    {
        return super.toString() + enginePower+"\n"+numberOfEngine+"\n" + maxSatellites + "\n";
    }
}
