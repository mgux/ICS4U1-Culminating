import java.util.*;
import java.io.*;

public class LandManager
{
    final static int CUR_YEAR = 2025;
    private ArrayList<LandVehicle> landStorage; //ArrayList of LandVehicles

    public LandManager() //Constructor
    {
        landStorage = new ArrayList<LandVehicle>();
    }
    //Accessors and Mutators
    public int getCurSize()
    {
        return landStorage.size();
    }
    public boolean outLandVehicles(String s) //Outputs all LandVehicles to a file
    {
        boolean isOut = true;
        BufferedWriter out;
        try
        {
            out = new BufferedWriter(new FileWriter(s, true));
            for (int i = 0; i < landStorage.size(); i++)
            {
                if (landStorage.get(i) instanceof Jeep)
                {
                    out.write("Jeep\n");
                }
                else
                {
                    out.write("Tank\n");
                }
                out.write((landStorage.get(i)).toString());
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
    public boolean addJeep(int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d) //adds a new Jeep to the ArrayList
    {
        landStorage.add(new Jeep(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8, n9, d));
        return true;
    }
    public boolean addTank(int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d) //adds a new Tank to the ArrayList
    {
        landStorage.add(new Tank(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8, n9, d));
        return true;
    }
    public LandVehicle searchSerial(String s) //Search if a LandVehicle with the given serialNum exists
    {
        LandVehicle l = null;
        for (int i = 0; i < landStorage.size() && l == null; i++)
        {
            if (s.equals((landStorage.get(i)).getSerialNum()))
            {
                l = landStorage.get(i);
            }
        }
        return l;
    }
    public boolean removeLandVehicle(String s) //Removes a LandVehicle by the serialNum
    {
        LandVehicle temp = searchSerial(s);
        if (temp != null)
        {
            landStorage.remove(temp);
            return true;
        }
        return false;
    }
    public boolean updateParts(String s, int n) //Updates the parts of a LandVehicle through the serialNum
    {
        LandVehicle temp = searchSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.removeParts(n);
    }
    public boolean repair(String s) //Adds a repair to a LandVehicle given the serialNum
    {
        LandVehicle temp = searchSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.addRepair();
    }
    public Repairs getLastRepair(String s) //Returns the last Repair of the LandVehicle identified by the serialNum
    {
        LandVehicle l = searchSerial(s);
        if (l == null)
        {
            return null;
        }
        return l.getMostRecentRepair();
    }
    public LandVehicle[] searchManufactureLocation(int n, String s) //Returns an array of LandVehicles that have the same manufactureYear and are at the same location
    {
        LandVehicle temp;
        int num = 0;
        for (int i = 0; i < landStorage.size(); i++)
        {
            temp = landStorage.get(i);
            if (temp.getManufactureYear() == n && temp.getLocation().equals(s))
            {
                num++;
            }
        }
        LandVehicle[] arr = new LandVehicle[num];
        for (int i = 0; i < landStorage.size(); i++)
        {
            temp = landStorage.get(i);
            if (temp.getManufactureYear() == n && temp.getLocation().equals(s))
            {
                arr[num-1] = temp;
            }
        }
        return arr;
    }
    public boolean sortSerial() //Sorts ArrayList by serialNum using Selection Sort
    {
        LandVehicle temp;
        int index;
        for (int i = 0; i < landStorage.size()-1; i++)
        {
            temp = landStorage.get(i);
            index = i;
            for (int j = i+1; j < landStorage.size(); j++)
            {
                if ((temp.getSerialNum()).compareTo((landStorage.get(j)).getSerialNum()) > 0)
                {
                    temp = landStorage.get(j);
                    index = j;
                }
            }
            landStorage.set(index, landStorage.get(i));
            landStorage.set(i, temp);
        }
        return true;
    }
    public boolean sortmanufactureLocation () //Sorts the array by the manufacture Year in descending order, with ties broken by the lexicographical order of the location using Bubble Sort
    {
        LandVehicle temp;
        int index;
        for (int i = landStorage.size()-1; i >= 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (landStorage.get(j).getManufactureYear() > landStorage.get(j+1).getManufactureYear())
                {
                    temp = landStorage.get(j);
                    landStorage.set(j, landStorage.get(j+1));
                    landStorage.set(j+1, temp);
                }
                else if (landStorage.get(j).getManufactureYear()==landStorage.get(j+1).getManufactureYear() && landStorage.get(j).getLocation().compareTo(landStorage.get(j+1).getLocation()) > 0)
                {
                    temp = landStorage.get(j);
                    landStorage.set(j, landStorage.get(j+1));
                    landStorage.set(j+1, temp);
                }
            }
        }
        return true;
    }
    public LandVehicle findFastestLand() //Returns the LandVehicle with the highest speed
    {
        LandVehicle temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null)
            {
                temp = landStorage.get(i);
            }
            else
            {
                temp = temp.compareSpeed(landStorage.get(i));
            }
        }
        return temp;
    }
    public LandVehicle findMostExpensiveLand() //Returns the LandVehicle with the highest cost
    {
        LandVehicle temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null)
            {
                temp = landStorage.get(i);
            }
            else
            {
                temp = temp.compareCost(landStorage.get(i));
            }
        }
        return temp;
    }
    public LandVehicle findMostSeatsLand() //Returns the LandVehicle with the most amount of seats
    {
        LandVehicle temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null)
            {
                temp = landStorage.get(i);
            }
            else
            {
                temp = temp.compareSeats(landStorage.get(i));
            }
        }
        return temp;
    }
    public Jeep findMostExpensiveJeep() //Returns the Jeep with the highest cost
    {
        Jeep temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null && landStorage.get(i) instanceof Jeep)
            {
                temp = (Jeep)landStorage.get(i);
            }
            else if (landStorage.get(i) instanceof Jeep)
            {
                temp = temp.compareCost((Jeep)landStorage.get(i));
            }
        }
        return temp;
    }
    public Jeep findFastestJeep() //Returns the Jeep with the highest Speed
    {
        Jeep temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null && landStorage.get(i) instanceof Jeep)
            {
                temp = (Jeep)landStorage.get(i);
            }
            else if (landStorage.get(i) instanceof Jeep)
            {
                temp = temp.compareSpeed((Jeep)landStorage.get(i));
            }
        }
        return temp;
    }
    public Jeep findHeaviestJeep() //Returns the Jeep with highest cargoWeight
    {
        Jeep temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null && landStorage.get(i) instanceof Jeep)
            {
                temp = (Jeep)landStorage.get(i);
            }
            else if (landStorage.get(i) instanceof Jeep)
            {
                temp = temp.compareWeight((Jeep)landStorage.get(i));
            }
        }
        return temp;
    }
    public Jeep findLargestStorageSpaceJeep() //Returns the Jeep with the most storageSpace
    {
        Jeep temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null && landStorage.get(i) instanceof Jeep)
            {
                temp = (Jeep)landStorage.get(i);
            }
            else if (landStorage.get(i) instanceof Jeep)
            {
                temp = temp.compareStorageSpace((Jeep)landStorage.get(i));
            }
        }
        return temp;
    }
    public Tank findMostExpensiveTank() //Returns  the Tank with the highest cost
    {
        Tank temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null && landStorage.get(i) instanceof Tank)
            {
                temp = (Tank)landStorage.get(i);
            }
            else if (landStorage.get(i) instanceof Tank)
            {
                temp = temp.compareCost((Tank)landStorage.get(i));
            }
        }
        return temp;
    }
    public Tank findFastestTank() //Returns the Tank with the fastest speed
    {
        Tank temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null && landStorage.get(i) instanceof Tank)
            {
                temp = (Tank)landStorage.get(i);
            }
            else if (landStorage.get(i) instanceof Tank)
            {
                temp = temp.compareSpeed((Tank)landStorage.get(i));
            }
        }
        return temp;
    }
    public Tank findLongestTank() //Returns the tank with the longest range
    {
        Tank temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null && landStorage.get(i) instanceof Tank)
            {
                temp = (Tank)landStorage.get(i);
            }
            else if (landStorage.get(i) instanceof Tank)
            {
                temp = temp.compareRange((Tank)landStorage.get(i));
            }
        }
        return temp;
    }
    public Tank findMostAmmoank() //Returns the Tank with the most Ammo
    {
        Tank temp = null;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (temp == null && landStorage.get(i) instanceof Tank)
            {
                temp = (Tank)landStorage.get(i);
            }
            else if (landStorage.get(i) instanceof Tank)
            {
                temp = temp.compareAmmo((Tank)landStorage.get(i));
            }
        }
        return temp;
    }
    public LandVehicle[] findOverAge(int n) //Returns an array of LandVehicles that are over a certain age
    {
        int num = 0;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (CUR_YEAR-landStorage.get(i).getManufactureYear() >= n)
            {
                num++;
            }
        }
        LandVehicle[] l = new LandVehicle[num];
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (CUR_YEAR-landStorage.get(i).getManufactureYear() >= n)
            {
                l[num-1] = landStorage.get(i);
                num--;
            }
        }
        return l;
    }
    public LandVehicle[] findAllAtLocation(String s) //Returns an array of LandVehicles that are at a certain location
    {
        int num = 0;
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (s.equals(landStorage.get(i).getLocation()))
            {
                num++;
            }
        }
        LandVehicle[] l = new LandVehicle[num];
        for (int i = 0; i < landStorage.size(); i++)
        {
            if (s.equals(landStorage.get(i).getLocation()))
            {
                l[num-1] = landStorage.get(i);
                num--;
            }
        }

        return l;
    }
    public Aircraft isCarriedJeep(String s) //Returns the Aircraft that is carrying the Jeep that is found by serialNumber. If it is not being carried, returns null
    {
        LandVehicle l = searchSerial(s);
        Jeep j;
        if (l != null && l instanceof Jeep)
        {
            j = (Jeep)l;
            return j.containedWithinVehicle();
        }
        return null;
    }
    public Ship isCarriedTank(String s) //Returns the Ship that is carrying the Jeep that is found by serialNumber. If it is not being carried, returns null
    {
        LandVehicle l = searchSerial(s);
        Tank t;
        if (l != null && l instanceof Jeep)
        {
            t = (Tank)l;
            return t.containedWithinVehicle();
        }
        return null;
    }
}
