import java.util.*;

public class Rocket extends SpaceVehicle
{
   private int enginePower;
   private int numberOfEngine;
   private int maxSatellites;
   private ArrayList<Satellite> satelliteInRocket;
   private Ship containedVehicle;
   public Rocket(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7, int n8, int n9, int n10)
   {
      super(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7);
      enginePower = n8;
      numberOfEngine = n9;
      maxSatellites = n10;
      satelliteInRocket = new ArrayList<Satellite>()
      containedVehicle = null;
   }
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
   
   public boolean addSatellite(Satellite s)
   {
      if (satelliteInRocket.size() == maxSatellites)
      {
         return false;
      }
      satelliteInRocket.add(s);
   }
   
   public boolean removeSatellite(Satellite s)
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
   
   public Rocket compareSpeed(Rocket other)
   {
      return this.getSpeed()>other.getSpeed()?this:other;
   }
   public Rocket compareEnginePower(Rocket other)
   {
      return this.enginePower>other.enginePower?this:other;
   }
   public Rocket compareCost(Rocket other)
   {
      return this.getCost()>other.getCost()?this:other;
   }
   public Rocket compareEngineNumber(Rocket other)
   {
      return this.numberOfEngine>other.numberOfEngine?this:other;
   }
   public Ship containedWithinVehicle()
   {
      return getContainedVehicle();
   }
   public ArrayList<Satellite> containedVehicles()
   {
      return satelliteInRocket;
   }
   public boolean isBroken()
   {
      if (this.getParts() < this.getMinParts() && enginePower == 0)
      {
         return true;
      }
      return false;
   }
   public String toString()
   {
      return "Rocket:\n"+"Engine Power: "+enginePower+"\nNumber of Engines: "+numberOfEngine+"\nNumber of Satellites carried: "+satelliteInRocket.size()+"\nCarried by: "+(containedVehicle==null?"None":containedVehicle.getSerialNum())+"\n"+super.toString();
   }
}
