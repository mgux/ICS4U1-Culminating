import java.util.*;
import java.io.*;

public class LandManager
{
    final static int CUR_YEAR = 2025;
    private ArrayList<LandVehicle> landStorage;

    public LandManager()
    {
        landStorage = new ArrayList<LandVehicle>();
    }

    public int getCurSize()
    {
        return landStorage.size();
    }
    public boolean readJeepVehicle(String s)
    {
        boolean isRead = true;
        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader(s));
            try
            {
                addJeep(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()));
            }
            catch (NumberFormatException nfx)
            {
                isRead = false;
            }
            catch (NullPointerException npx)
            {
                isRead = false;
            }
            in.close();
            System.out.println("true");
        }
        catch (IOException io)
        {
            isRead = false;
        }
        return isRead;
    }
    public boolean readTankVehicle(String s)
    {
        boolean isRead = true;
        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader(s));
            try
            {
                addTank(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()));
            }
            catch (NumberFormatException nfx)
            {
                isRead = false;
            }
            catch (NullPointerException npx)
            {
                isRead = false;
            }
            in.close();
        }
        catch (IOException io)
        {
            isRead = false;
        }
        return isRead;
    }
    public boolean outLandVehicles(String s)
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
            }
            out.close();
        }
        catch (IOException io)
        {
            isOut = false;
        }
        return isOut;
    }
    public boolean addJeep(int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d)
    {
        landStorage.add(new Jeep(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8, n9, d));
        return true;
    }
    public boolean addTank(int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d)
    {
        landStorage.add(new Tank(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8, n9, d));
        return true;
    }
    public LandVehicle searchSerial(String s)
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
    public boolean removeLandVehicle(String s)
    {
        LandVehicle temp = searchSerial(s);
        if (temp != null)
        {
            landStorage.remove(temp);
            return true;
        }
        return false;
    }
    public boolean updateParts(String s, int n)
    {
        LandVehicle temp = searchSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.removeParts(n);
    }
    public boolean repair(String s)
    {
        LandVehicle temp = searchSerial(s);
        if (temp == null)
        {
            return false;
        }
        return temp.addRepair();
    }
    public Repairs getLastRepair(String s)
    {
        LandVehicle l = searchSerial(s);
        if (l == null)
        {
            return null;
        }
        return l.getMostRecentRepair();
    }
    public LandVehicle[] searchManufactureLocation(int n, String s)
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
    public boolean sortSerial()
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
    public boolean sortmanufactureLocation ()
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
    public LandVehicle findFastestLand()
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
    public LandVehicle findMostExpensiveLand()
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
    public LandVehicle findMostSeatsLand()
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
    public Jeep findMostExpensiveJeep()
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
    public Jeep findFastestJeep()
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
    public Jeep findHeaviestJeep()
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
    public Jeep findLargestStorageSpaceJeep()
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
    public Tank findMostExpensiveTank()
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
    public Tank findFastestTank()
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
    public Tank findLongestTank()
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
    public Tank findMostAmmoank()
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
    public LandVehicle[] findOverAge(int n)
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
    public LandVehicle[] findAllAtLocation(String s)
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
    public Aircraft isCarriedJeep(String s)
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
    public Ship isCarriedTank(String s)
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
