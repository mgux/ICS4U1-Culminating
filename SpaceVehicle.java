public abstract class SpaceVehicle
{
   private int altitude;
   private String camera;
   private int manufactureYear;  
   private String serialNum;
   private int speed;
   private String location;
   private int cost;
   private int parts;
   private int maxParts;
   private int minParts;
   final static int PART_SWAP_WORTH = 2;
   
   public SpaceVehicle(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7)
   {
      altitude = n1;
      camera = s1;
      manufactureYear = n2;
      serialNum = s2;
      speed = n3;
      location = s3;
      cost = n4;
      parts = n5;
      maxParts = n6;
      minParts = n7;
   }
   
   public int getAltitude()
   {
      return altitude;
   }
   public String getCamera()
   {
      return camera;
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
   public void setAltitude(int n)
   {
      altitude = n;
   }
   public void setCamera(String s)
   {
      camera = s;
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
   public SpaceVehicle compareCost(SpaceVehicle other)
   {
      return ((this.getCost()>other.getCost())?this:other);
   }
   public SpaceVehicle compareSpeed(SpaceVehicle other)
   {
      return ((this.getSpeed()>other.getSpeed())?this:other);
   }
   public SpaceVehicle compareAltitude(SpaceVehicle other)
   {
      return ((this.getAltitude()>other.getAltitude())?this:other);
   }
   public abstract boolean isBroken();
   public boolean removeParts(int n)
   {
      if (parts-n < minParts)
      {
         return false;
      }
      parts-=n;
      return true;
   }
   public boolean addRepair()
   { //Come back when implement repairs
      return true;
   }
   public void getMostRecentRepairs()
   {
      //Come back when implement repairs
   }
   public String toString()
   {
      //Implement
      return "";
   }
}