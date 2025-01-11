public abstract class LandVehicle
{
   private String serialNum;
   private String location;
   private int manufactureYear;
   private int speed;
   private int tires;
   private int seats;
   private int cost;
   private int parts;
   private int maxParts;
   final static int PART_SWAP_WORTH = 4;
  
   public LandVehicle(String s1, String s2, int n1, int n2, int n3, int n4, int n5, int n6, int n7)
   {
      serialNum = s1;
      location = s2;
      manufactureYear = n1;
      speed = n2;
      tires = n3;
      seats = n4;
      cost = n5;
      parts = n6;
      maxParts = n7;
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
   public void getSerialNum(String s)
   {
      serialNum = s;
   }
   public void setSpeed(int n)
   {
      speed = n;
   }
   public void getLocation(String s)
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
  
   public LandVehicle compareSpeed(LandVehicle other)
   {
      return ((this.getSpeed()>other.getSpeed())?this:other);
   }
  
   public LandVehicle compareCost(LandVehicle other)
   {
      return ((this.getCost()>other.getCost())?this:other);
   }
   
   public abstract boolean isBroken();
   
   public boolean removeParts(int n)
   {
      if (parts < n)
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