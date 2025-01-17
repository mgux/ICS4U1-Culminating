import java.util.*;

public abstract class LandVehicle
{
   private int tires;
   private int seats;
   private int manufactureYear;
   private String serialNum;
   private int speed;
   private String location;
   private int cost;
   private int parts;
   private int maxParts;
   private int minParts;
   final static int PART_SWAP_WORTH = 4;
   private ArrayList<Repairs> repairHistory = new ArrayList<Repairs>();
  
   public LandVehicle(int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8)
   {
      tires = n1;
      seats = n2;
      manufactureYear = n3;
      serialNum = s1;
      speed = n4;
      location = s2;
      cost = n5;
      parts = n6;
      maxParts = n7;
      minParts = n8;
   }
  
   public int getTires()
   {
      return tires;
   }
   public int getSeats()
   {
      return seats;
   }
   public int getManufactureYear()
   {
      return manufactureYear;
   }
   public String getSerialNum()
   {
      return serialNum;
   }
   public int getSpeed()
   {
      return speed;
   }
   public String getLocation()
   {
      return location;
   }
   public int getCost()
   {
      return cost;
   }
   public int getParts()
   {
      return parts;
   }
   public int getMaxParts()
   {
      return maxParts;
   }
   public int getMinParts()
   {
      return minParts;
   }
   public void setTires(int n)
   {
      tires = n;
   }
   public void setSeats(int n)
   {
      seats = n;
   }
   public void setManufactureYear(int n)
   {
      manufactureYear = n;
   }
   public void setSerialNum(String s)
   {
      serialNum = s;
   }
   public void setSpeed(int n)
   {
      speed = n;
   }
   public void setLocation(String s)
   {
      location = s;
   }
   public void setCost(int n)
   {
      cost = n;
   }
   public void setParts(int n)
   {
      parts = n;
   }
   public void setMaxParts(int n)
   {
      maxParts = n;
   }
   public void setMinParts(int n)
   {
      minParts = n;
   }
  
   public LandVehicle compareSpeed(LandVehicle other)
   {
      return ((this.getSpeed()>other.getSpeed())?this:other);
   }
  
   public LandVehicle compareCost(LandVehicle other)
   {
      return ((this.getCost()>other.getCost())?this:other);
   }

   public LandVehicle compareSeats(LandVehicle other)
   {
      return ((this.getSeats()>other.getSeats())?this:other);
   }
   
   public abstract boolean isBroken();
   
   public boolean addRepair()
   {
      Repairs r = new Repairs(this);
      repairHistory.add(r);
      return true;
   }
   
   public Repairs getMostRecentRepair()
   {
      Repairs r = repairHistory.get(0);
      for (int i = 1; i < repairHistory.size(); i++)
      {
         r = r.compareRepairTime(repairHistory.get(i));
      }
      return r;
   }
   
   public boolean removeParts(int n)
   {
      if (parts-n < minParts)
      {
         return false;
      }
      setParts(parts-n);
      return true;
   }
   
   public String toString()
   {
       return "Serial Number: "+serialNum+"\nLocation: "+location+"\nManufacture Year: "+manufactureYear+"\nSpeed: "+speed+"\nTires: "+tires+"\nSeats: "+seats+"\nCost: "+cost+"\n";
   }
}
