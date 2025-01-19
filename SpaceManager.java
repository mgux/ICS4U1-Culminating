import java.util.*;
import java.io.*;

public class SpaceManager
{
   final static int CUR_YEAR = 2025;
   private ArrayList<SpaceVehicle> spaceStorage;
   
   public SpaceManager()
   {
      spaceStorage = new ArrayList<SpaceVehicle>();
   }
   public int getCurSize()
   {
      return spaceStorage.size();
   }
   public boolean readSatelliteVehicle(String s)
   {                     
      boolean isRead = true;
      BufferedReader in;
      try
      {
         in = new BufferedReader(new FileReader(s));
         try
         {
            addSatellite(Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()));
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
   public boolean readRocketVehicle(String s)
   {                     
      boolean isRead = true;
      BufferedReader in;
      try
      {
         in = new BufferedReader(new FileReader(s));
         try
         {
            addRocket(Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()));
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
   public boolean outSpaceVehicles(String s)
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
         }
         out.close();
      }
      catch (IOException io)
      {
         isOut = false;
      }
      return isOut;
   }
   public boolean addSatellite(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7, double d1, double d2)
   {
      spaceStorage.add(new Satellite(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7, d1, d2));
      return true;
   }
   public boolean addRocket(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7, int n8, int n9, int n10)
   {
      spaceStorage.add(new Rocket(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7, n8, n9, n10));
      return true;
   }
   public SpaceVehicle searchSerial(String s)
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
   public boolean removeSpaceVehicle(String s)
   {
      SpaceVehicle temp = searchSerial(s);
      if (temp != null)
      {
         spaceStorage.remove(temp);
         return true;
      }
      return false;
   }
   public boolean updateParts(String s, int n)
   {
      SpaceVehicle temp = searchSerial(s);
      if (temp == null)
      {
         return false;
      }
      return temp.removeParts(n);
   }
   public boolean repair(String s)
   {
      SpaceVehicle temp = searchSerial(s);
      if (temp == null)
      {
         return false;
      }
      return temp.addRepair();
   }
   public Repairs getLastRepair(String s)
   {
      SpaceVehicle sv = searchSerial(s);
      if (sv == null)
      {
         return null;
      }
      return sv.getMostRecentRepairs();
   }
   public SpaceVehicle[] searchManufactureLocation(int n, String s)
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
   public boolean sortSerial()
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
   public boolean sortmanufactureLocation ()
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
   public SpaceVehicle findFastestSpace()
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
   public SpaceVehicle findMostExpensiveSpace()
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
   public SpaceVehicle findHighestSpace()
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
   public Satellite findHighestSatellite()
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
            temp = temp.compareAltitude((Satellite)spaceStorage.get(i));
         }
      }
      return temp;
   }
   public Satellite findMostExpensiveSatellite()
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
   public Satellite findFastestSatellite()
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
   public Satellite findMostPowerCostSatellite()
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
   public Satellite findMaxSolarPanelSizeSatellite()
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
   public Rocket findMostExpensiveRocket()
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
   public Rocket findFastestRocket()
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
   public Rocket findHighestAltitudeRocket()
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
            temp = temp.compareAltitude((Rocket)spaceStorage.get(i));
         }
      }
      return temp;
   }
   public Rocket findMostEngineRocket()
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
   public Rocket findMaxEnginePowerRocket()
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
   public SpaceVehicle[] findOverAge(int n)
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
   public SpaceVehicle[] findAllAtLocation(String s)
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
   public Rocket isCarriedSatellite(String s)
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
   public Ship isCarriedRocket(String s)
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
   public ArrayList<Satellite> carryingSatellites(String s)
   {
      SpaceVehicle sv = searchSerial(s);
      Rocket r;
      if (sv != null && sv instanceof Rocket)
      {
         r = (Rocket)sv;
         return r.getSatelliteInRocket();
      }
      return null;
   }
}