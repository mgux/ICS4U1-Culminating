import java.time.*;
import java.util.*;

public class Repairs
{
    final static double PART_COST = 99.99;
    private double totalRepairCost;
    private static LocalDate repairDate; //LocalDate to determine the date of the Repair
    //ArrayList of LandVehicle, WaterVehicle, AirVehicle, SpaceVehicle
    private static ArrayList<LandVehicle> landRepairList = new ArrayList<LandVehicle>();
    private static ArrayList<WaterVehicle> waterRepairList = new ArrayList<WaterVehicle>();
    private static ArrayList<AirVehicle> airRepairList = new ArrayList<AirVehicle>();
    private static ArrayList<SpaceVehicle> spaceRepairList = new ArrayList<SpaceVehicle>();

    //Constructors
    public Repairs(LandVehicle l)
    {
        totalRepairCost = calculateRepairs(l.getMaxParts()-l.getParts());
        repairDate = LocalDate.now();
        landRepairList.add(l);
        l.setParts(l.getMaxParts());
    }
    public Repairs(WaterVehicle w)
    {
        totalRepairCost = calculateRepairs(w.getMaxParts()-w.getParts());
        repairDate = LocalDate.now();
        waterRepairList.add(w);
        w.setParts(w.getMaxParts());
    }
    public Repairs(AirVehicle a)
    {
        totalRepairCost = calculateRepairs(a.getMaxParts()-a.getParts());
        repairDate = LocalDate.now();
        airRepairList.add(a);
        a.setParts(a.getMaxParts());
    }
    public Repairs(SpaceVehicle s)
    {
        totalRepairCost = calculateRepairs(s.getMaxParts()-s.getParts());
        repairDate = LocalDate.now();
        spaceRepairList.add(s);
        s.setParts(s.getMaxParts());
    }
    
    public double calculateRepairs(int n) //Calculates the cost of a Repair
    {
        return PART_COST*n;
    }

    public void displayLandRepairs() //Displays all the LandVehicles that have been repaired
    {
        for (int i = 0; i < landRepairList.size(); i++)
        {
            System.out.println(landRepairList.get(i));
        }
    }

    public void displayWaterRepairs() //Displays all the WaterVehicles that have been repaired
    {
        for (int i = 0; i < waterRepairList.size(); i++)
        {
            System.out.println(waterRepairList.get(i));
        }
    }

    public void displayAirRepairs() //Displays all the AirVehicles that have been repaired
    {
        for (int i = 0; i < airRepairList.size(); i++)
        {
            System.out.println(airRepairList.get(i));
        }
    }

    public void displaySpaceRepairs() //Displays all the SpaceVehicles that have been repaired
    {
        for (int i = 0; i < spaceRepairList.size(); i++)
        {
            System.out.println(spaceRepairList.get(i));
        }
    }

    public Repairs compareRepairTime(Repairs other) //Returns the Repair that has the earlier date. If the date is the same, return this
    {
        return (((this.repairDate).isBefore(other.repairDate))?this:other);
    }

    public String toString() //toString
    {
        return "Date: "+repairDate+"\nCost: "+totalRepairCost+"\n";
    }
}
