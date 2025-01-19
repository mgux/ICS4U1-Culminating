import java.util.*;

public class SerialNumGeneration
{
   final static ArrayList<String> LAND_VEHICLE_SERIALS = new ArrayList<String>();
   final static ArrayList<String> WATER_VEHICLE_SERIALS = new ArrayList<String>();
   final static ArrayList<String> AIR_VEHICLE_SERIALS = new ArrayList<String>();
   final static ArrayList<String> SPACE_VEHICLE_SERIALS = new ArrayList<String>();
   final static int DIGITS = 10;
   final static int LAND_VEHICLE_SERIAL_SIZE = 6;
   final static int WATER_VEHICLE_SERIAL_SIZE = 7;
   final static int AIR_VEHICLE_SERIAL_SIZE = 0;
   final static int SPACE_VEHICLE_SERIAL_SIZE = 0;
   
   public static String landVehicleGeneration()
   {
      String s = generateLandVehicle("");
      while (!addLandVehicleSerial(s))
      {
         s = generateLandVehicle("");
      }
      return s;
   }
   
public static String waterVehicleGeneration() {
    String s = generateWaterVehicle("");
    while (!addWaterVehicleSerial(s)) {
        s = generateWaterVehicle("");
    }
    return s;
}

   public static String airVehicleGeneration()
   {
   
   }
   public static String spaceVehicleGeneration()
   {
   
   }

   public static String generateWaterVehicle(String s) {
    if (s.length() == WATER_VEHICLE_SERIAL_SIZE) {
        return "W" + s; 
    }
    return generateWaterVehicle(s + (int) (Math.random() * DIGITS));
   }
   
   public static boolean addWaterVehicleSerial(String s) {
    boolean isFound = false;
    int mid, l = 0, r = WATER_VEHICLE_SERIALS.size() - 1;
    while (l <= r && !isFound) {
        mid = (l + r) / 2;
        if (WATER_VEHICLE_SERIALS.get(mid).equals(s)) {
            isFound = true;
        }
        if (WATER_VEHICLE_SERIALS.get(mid).compareTo(s) > 0) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    if (!isFound) {
        WATER_VEHICLE_SERIALS.add(l, s);
    }
    return (!isFound);
   }

   
   public static String generateLandVehicle(String s)
   {
      if (s.length() == LAND_VEHICLE_SERIAL_SIZE)
      {
         return s;
      }
      return generateLandVehicle(s+(int)(Math.random()*DIGITS));
   }
   
   public static boolean addLandVehicleSerial(String s)
   {
      boolean isFound = false;
      int mid, l = 0, r = LAND_VEHICLE_SERIALS.size();
      while (l <= r && !isFound)
      {
         mid = (l+r)/2;
         if (LAND_VEHICLE_SERIALS.get(mid).equals(s))
         {
            isFound = true;
         }
         if (LAND_VEHICLE_SERIALS.get(mid).compareTo(s) > 0)
         {
            r = mid-1;
         }
         else
         {
            l = mid+1;
         }
      }
      if (!isFound)
      {
         LAND_VEHICLE_SERIALS.add(l, s);
      }
      return (!isFound);
   }
}
