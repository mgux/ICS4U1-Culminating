/*
SpaceManager.java
Tianyue Zhao
ICS4U1
Jan 20th, 2025
Description: SpaceManager class, which has a variety of methods about searching and sorting all SpaceVehicles within it
*/

import java.util.*;
import java.io.*;

public class SpaceManager
{
    final static int CUR_YEAR = 2025;
    private ArrayList<SpaceVehicle> spaceStorage;

    public SpaceManager() //Constructor
    {
        spaceStorage = new ArrayList<SpaceVehicle>();
    }
    //Accessors and Mutators
    public int getCurSize()
    {
        return spaceStorage.size();
    }
    public boolean outSpaceVehicles(String s) //Outputs all SpaceVehicles in the Manager to a file
    {
        boolean isOut = true;
        BufferedWriter out;
        try
        {
            out = new BufferedWriter(new FileWriter(s, true));
            for (int i = 0; i < spaceStorage.size(); i++)
            {
                if (spaceStorage.get(i) instanceof Satellite)
                {
                    out.write("Satellite\n");
                }
                else
                {
                    out.write("Rocket\n");
                }
                out.write((spaceStorage.get(i)).toString());
                out.newLine();
            }
            out.close();
        }
        catch (IOException io)
        {
            isOut = false;
        }
        return isOut;
    }
    public boolean addSatellite(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7, double d1, double d2) //Adds a Satellite to the ArrayList
    {
        spaceStorage.add(new Satellite(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7, d1, d2));
        return true;
    }
    public boolean addRocket(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) //Adds a Rocket to the ArrayList
    {
        spaceStorage.add(new Rocket(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7, n8, n9, n10));
        return true;
    }
    public SpaceVehicle searchSerial(String s) //Searches for a serial and returns the SpaceVehicle, or null otherwise
    {
        SpaceVehicle sv = null;
        for (int i = 0; i < spaceStorage.size() && sv == null; i++)
        {
            if (s.equals((spaceStorage.get(i)).getSerialNum()))
            {
                sv = spaceStorage.get(i);
            }
        }
        return sv;
    }
    public boolean removeSpaceVehicle(String s) //Removes a SpaceVehicle by the serial, or null if it does not exist
    {
        SpaceVehicle temp = searchSerial(s);
        if (temp != null)
        {
            spaceStorage.remove(temp);
            return true;
        }
        return false;
    }
    public boolean updateParts(String s, int n //Updates parts of the SpaceVehicle
    {
        SpaceVehicle temp = searchSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.removeParts(n);
    }
    public boolean repair(String s) //Adds a repair to the SpaceVehile given serialNum
    {
        SpaceVehicle temp = searchSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.addRepair();
    }
    public Repairs getLastRepair(String s) //Returns the last Repair of a SpaceVehile
    {
        SpaceVehicle sv = searchSerial(s);
        if (sv == null)
        {
            return null;
        }
        return sv.getMostRecentRepairs();
    }
    public SpaceVehicle[] searchManufactureLocation(int n, String s) //Returns an array of SpaceVehicles that have the same age and are at the same location
    {
        SpaceVehicle temp;
        int num = 0;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            temp = spaceStorage.get(i);
            if (temp.getManufactureYear() == n && temp.getLocation().equals(s))
            {
                num++;
            }
        }
        SpaceVehicle[] arr = new SpaceVehicle[num];
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            temp = spaceStorage.get(i);
            if (temp.getManufactureYear() == n && temp.getLocation().equals(s))
            {
                arr[num-1] = temp;
            }
        }
        return arr;
    }
    public boolean sortSerial() //Sorts the SerialNumbers using Selection Sort
    {
        SpaceVehicle temp;
        int index;
        for (int i = 0; i < spaceStorage.size()-1; i++)
        {
            temp = spaceStorage.get(i);
            index = i;
            for (int j = i+1; j < spaceStorage.size(); j++)
            {
                if ((temp.getSerialNum()).compareTo((spaceStorage.get(j)).getSerialNum()) > 0)
                {
                    temp = spaceStorage.get(j);
                    index = j;
                }
            }
            spaceStorage.set(index, spaceStorage.get(i));
            spaceStorage.set(i, temp);
        }
        return true;
    }
    public boolean sortmanufactureLocation () //Sorts by descending orde of Manufacturing year, with ties broken by lexicographical order of loation using bubble sort
    {
        SpaceVehicle temp;
        int index;
        for (int i = spaceStorage.size()-1; i >= 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (spaceStorage.get(j).getManufactureYear() > spaceStorage.get(j+1).getManufactureYear())
                {
                    temp = spaceStorage.get(j);
                    spaceStorage.set(j, spaceStorage.get(j+1));
                    spaceStorage.set(j+1, temp);
                }
                else if (spaceStorage.get(j).getManufactureYear()==spaceStorage.get(j+1).getManufactureYear() && spaceStorage.get(j).getLocation().compareTo(spaceStorage.get(j+1).getLocation()) > 0)
                {
                    temp = spaceStorage.get(j);
                    spaceStorage.set(j, spaceStorage.get(j+1));
                    spaceStorage.set(j+1, temp);
                }
            }
        }
        return true;
    }
    public SpaceVehicle findFastestSpace() //Returns the SpaceVehicle with the highest speed
    {
        SpaceVehicle temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null)
            {
                temp = spaceStorage.get(i);
            }
            else
            {
                temp = temp.compareSpeed(spaceStorage.get(i));
            }
        }
        return temp;
    }
    public SpaceVehicle findMostExpensiveSpace() //Returns the SpaceVehicle with the highest cost
    {
        SpaceVehicle temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null)
            {
                temp = spaceStorage.get(i);
            }
            else
            {
                temp = temp.compareCost(spaceStorage.get(i));
            }
        }
        return temp;
    }
    public SpaceVehicle findHighestSpace() //Returns the SpaceVehicle with the highest altitude
    {
        SpaceVehicle temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null)
            {
                temp = spaceStorage.get(i);
            }
            else
            {
                temp = temp.compareAltitude(spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Satellite findHighestSatellite() //Returns the Satellite with the highest altitude, or null otherwise
    {
        Satellite temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Satellite)
            {
                temp = (Satellite)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Satellite)
            {
                assert temp != null;
                temp = (Satellite) temp.compareAltitude((Satellite)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Satellite findMostExpensiveSatellite() //Returns the Satellite with the highest cost, or null otherwise
    {
        Satellite temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Satellite)
            {
                temp = (Satellite)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Satellite)
            {
                temp = temp.compareCost((Satellite)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Satellite findFastestSatellite() //Returns the Satellite with the highest speed, or null otherwise
    {
        Satellite temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Satellite)
            {
                temp = (Satellite)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Satellite)
            {
                temp = temp.compareSpeed((Satellite)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Satellite findMostPowerCostSatellite() //Returns the Satellite with the highest powerCost, 
    {
        Satellite temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Satellite)
            {
                temp = (Satellite)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Satellite)
            {
                temp = temp.comparePowerCost((Satellite)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Satellite findMaxSolarPanelSizeSatellite() //Returns the Satellite with the highest solarPanelSize, or null otherwise
    {
        Satellite temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Satellite)
            {
                temp = (Satellite)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Satellite)
            {
                temp = temp.compareSolarPanelSize((Satellite)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Rocket findMostExpensiveRocket() //Returns the Rocket with the highest cost, or null otherwise
    {
        Rocket temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Rocket)
            {
                temp = (Rocket)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Rocket)
            {
                temp = temp.compareCost((Rocket)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Rocket findFastestRocket() //Returns the Rocket with the highest speed, or null otherwise
    {
        Rocket temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Rocket)
            {
                temp = (Rocket)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Rocket)
            {
                temp = temp.compareSpeed((Rocket)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Rocket findHighestAltitudeRocket() //Returns the Rocket with the highest altitude, or null otherwise
    {
        Rocket temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Rocket)
            {
                temp = (Rocket)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Rocket)
            {
                assert temp != null;
                temp = (Rocket) temp.compareAltitude((Rocket)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Rocket findMostEngineRocket() //Returns the Rocket with most engines
    {
        Rocket temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Rocket)
            {
                temp = (Rocket)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Rocket)
            {
                temp = temp.compareEngineNumber((Rocket)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public Rocket findMaxEnginePowerRocket() //Returns the Rocket with the highest EnginePower
    {
        Rocket temp = null;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (temp == null && spaceStorage.get(i) instanceof Rocket)
            {
                temp = (Rocket)spaceStorage.get(i);
            }
            else if (spaceStorage.get(i) instanceof Rocket)
            {
                temp = temp.compareEnginePower((Rocket)spaceStorage.get(i));
            }
        }
        return temp;
    }
    public SpaceVehicle[] findOverAge(int n) //Returns an array of SpaceVehicles with age over a certain number
    {
        int num = 0;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (CUR_YEAR-spaceStorage.get(i).getManufactureYear() >= n)
            {
                num++;
            }
        }
        SpaceVehicle[] s = new SpaceVehicle[num];
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (CUR_YEAR-spaceStorage.get(i).getManufactureYear() >= n)
            {
                s[num-1] = spaceStorage.get(i);
                num--;
            }
        }
        return s;
    }
    public SpaceVehicle[] findAllAtLocation(String s) //Returns all SpaceVehicles at a certain location
    {
        int num = 0;
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (s.equals(spaceStorage.get(i).getLocation()))
            {
                num++;
            }
        }
        SpaceVehicle[] sv = new SpaceVehicle[num];
        for (int i = 0; i < spaceStorage.size(); i++)
        {
            if (s.equals(spaceStorage.get(i).getLocation()))
            {
                sv[num-1] = spaceStorage.get(i);
                num--;
            }
        }
        return sv;
    }
    public Rocket isCarriedSatellite(String s) //Returns the Rocket that is carrying the Satellite, or null otherwise
    {
        SpaceVehicle sv = searchSerial(s);
        Satellite st;
        if (sv != null && sv instanceof Satellite)
        {
            st = (Satellite)sv;
            return st.containedWithinVehicle();
        }
        return null;
    }
    public Ship isCarriedRocket(String s) //Returns the Ship that is carrying the Rocket, or null otherwise
    {
        SpaceVehicle sv = searchSerial(s);
        Rocket r;
        if (sv != null && sv instanceof Satellite)
        {
            r = (Rocket)sv;
            return r.containedWithinVehicle();
        }
        return null;
    }
    public ArrayList<Satellite> carryingSatellites(String s) //Returns the Satellites that the Rocket is carrying
    {
        SpaceVehicle sv = searchSerial(s);
        Rocket r;
        if (sv != null && sv instanceof Rocket)
        {
            r = (Rocket)sv;
            return r.containedVehicles();
        }
        return null;
    }
}
