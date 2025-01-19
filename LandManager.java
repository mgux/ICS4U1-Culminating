import java.util.*;
import java.io.*;

public class LandManager
{
   private int numLand;
   final static CUR_YEAR = 2025;
   private ArrayList<LandVehicle> landStorage;
   
   public LandManager()
   {
      numLand = 0;
      landstorage = new ArrayList<LandVehicle>;
   }
   public int getNumLand()
   {
      return numLand;
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
         for (int i = 0; i < numLand; i++)
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
      }
      catch (IOException io)
      {
         isOut = false;
      }
      return isOut;
   }
   public boolean addJeep(int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d)
   {
      landStorage.add(Jeep(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8, n9, d));
      numLand++;
      return true;
   }
   public boolean addTank(int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d)
   {
      landStorage.add(Tank(int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d));
      numLand++;
      return true;
   }
   public LandVehicle searchSerial(String s)
   {
      LandVehicle l = null;
      for (int i = 0; i < landStorage.size() && LandVehicle == null; i++)
      {
         if (s.equals((landStorage.get(i)).getSerialNum())
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
   public Repair getLastRepair(String s)
   {
      LandVehicle l = searchSerial(s);
      if (l == null)
      {
         return false;
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
         if (temp.getManufactureYear() == n && temp.getLocation.equals(s))
         {
            num++;
         }
      }
      LandVehicle[] arr = new LandVehicle[num];
      for (int i = 0; i < landStorage.size(); i++)
      {
         temp = landStorage.get(i);
         if (temp.getManufactureYear() == n && temp.getLocation.equals(s))
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
}