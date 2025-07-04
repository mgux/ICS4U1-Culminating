/*
SerialNumGeneration.java
Tianyue Zhao, Michael Gu, Luke Wei
ICS4U1
Jan 20th, 2025
Description: Generates Serial Numbers for the Vehicles
*/

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
    final static int AIR_VEHICLE_SERIAL_SIZE = 9;
    final static int SPACE_VEHICLE_SERIAL_SIZE = 8;

    //Wrapper Methods
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

    public static String airVehicleGeneration() {
        String s = generateAirVehicle("");
        while (!addAirVehicleSerial(s))
        {
            s = generateAirVehicle("");
        }
        return s;
    }
    public static String spaceVehicleGeneration()
    {
        String s = generateSpaceVehicle("");
        while (!addSpaceVehicleSerial(s))
        {
            s = generateSpaceVehicle("");
        }
        return s;
    }

    //Recursion to generate the SerialNumbers: Generate a random number and append it to the already generated String. When it reaches a certain length, it is returned with a letter added to the front (W for WaterVehicles, L for LandVehicles, etc)
    public static String generateWaterVehicle(String s) {
        if (s.length() == WATER_VEHICLE_SERIAL_SIZE) {
            return "W" + s;
        }
        return generateWaterVehicle(s + (int) (Math.random() * DIGITS));
    }

    public static String generateLandVehicle(String s)
    {
        if (s.length() == LAND_VEHICLE_SERIAL_SIZE)
        {
            return "L"+s;
        }
        return generateLandVehicle(s+(int)(Math.random()*DIGITS));
    }

    public static String generateAirVehicle(String s) {
        if (s.length() == AIR_VEHICLE_SERIAL_SIZE)
        {
            return "A"+s;
        }
        return generateAirVehicle(s+(int)(Math.random()*DIGITS));
    }

    public static String generateSpaceVehicle(String s)
    {
        if (s.length() == SPACE_VEHICLE_SERIAL_SIZE)
        {
            return "S"+s;
        }
        return generateLandVehicle(s+(int)(Math.random()*DIGITS));
    }

    //Uses binary Search to search whether the generated SerialNum exists. If it is found, then return false. Otherwise, insert the generated SerialNum into their respective serialNum ArrayLists at where they would be found if they were already in the list to maintain a sorted list
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
    public static boolean addAirVehicleSerial(String s) {
        boolean isFound = false;
        int mid, l = 0, r = AIR_VEHICLE_SERIALS.size();
        while (l <= r && !isFound)
        {
            mid = (l+r)/2;
            if (AIR_VEHICLE_SERIALS.get(mid).equals(s))
            {
                isFound = true;
            }
            if (AIR_VEHICLE_SERIALS.get(mid).compareTo(s) > 0)
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
            AIR_VEHICLE_SERIALS.add(l, s);
        }
        return (!isFound);
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
    public static boolean addSpaceVehicleSerial(String s)
    {
        boolean isFound = false;
        int mid, l = 0, r = SPACE_VEHICLE_SERIALS.size();
        while (l <= r && !isFound)
        {
            mid = (l+r)/2;
            if (SPACE_VEHICLE_SERIALS.get(mid).equals(s))
            {
                isFound = true;
            }
            if (SPACE_VEHICLE_SERIALS.get(mid).compareTo(s) > 0)
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
            SPACE_VEHICLE_SERIALS.add(l, s);
        }
        return (!isFound);
    }
}
