public abstract class AirVehicle {
   private int wingNum;
   private int manufactureYear;
   private String serialNum;
   private int speed;

   private String location;
   private int cost;
   private int altitude;
   private int partSwapWorth;



   private int parts;
   private int maxParts;
   private int minParts;

   public AirVehicle(int engineNum, int wingNum, int manufactureYear, int speed, String location, int cost, int altitude, int partSwapWorth, int parts, int maxParts,int minParts) {
      this.engineNum = engineNum;
      this.wingNum = wingNum;
      this.manufactureYear = manufactureYear;
      this.speed = speed;
      this.location = location;
      this.cost = cost;
      this.altitude = altitude;
      this.partSwapWorth = partSwapWorth;
      this.parts = parts;
      this.minParts = minParts;
      this.maxParts = maxParts;
   }

   public boolean launch() {
      return true;
   }

   private int engineNum;

   public int getEngineNum() {
      return engineNum;
   }

   public int getWingNum() {
      return wingNum;
   }

   public int getManufactureYear() {
      return manufactureYear;
   }

   public String getSerialNum() {
      return serialNum;
   }

   public int getSpeed() {
      return speed;
   }

   public String getLocation() {
      return location;
   }

   public int getCost() {
      return cost;
   }

   public int getAltitude() {
      return altitude;
   }

   public int getPartSwapWorth() {
      return partSwapWorth;
   }

   public void setWingNum(int wingNum) {
      this.wingNum = wingNum;
   }

   public void setManufactureYear(int manufactureYear) {
      this.manufactureYear = manufactureYear;
   }

   public void setSerialNum(String serialNum) {
      this.serialNum = serialNum;
   }

   public void setSpeed(int speed) {
      this.speed = speed;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public void setCost(int cost) {
      this.cost = cost;
   }

   public void setAltitude(int altitude) {
      this.altitude = altitude;
   }

   public void setPartSwapWorth(int partSwapWorth) {
      this.partSwapWorth = partSwapWorth;
   }

   public void setEngineNum(int engineNum) {
      this.engineNum = engineNum;
   }

   public int getParts() {
      return parts;
   }

   public int getMaxParts() {
      return maxParts;
   }

   public int getMinParts() {
      return minParts;
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

   public int compareAltitude(AirVehicle air) {
      return this.altitude - air.altitude;
   }

   public int compareEngineNum(AirVehicle air) {
      return this.engineNum - air.engineNum;
   }

   public int compareWingNum(AirVehicle air) {
      return this.wingNum - air.wingNum;
   }

   public int compareSpeed(AirVehicle air) {
      return this.speed - air.speed;
   }

   public boolean isBroken() {
      if (parts < minParts) {
         return true;
      }
   
      return false;
   }

   public String toString() {
      return "AirVehicle{" +
             "wingNum=" + wingNum +
             ", manufactureYear=" + manufactureYear +
             ", serialNum='" + serialNum + '\'' +
             ", speed=" + speed +
             ", location='" + location + '\'' +
             ", cost=" + cost +
             ", altitude=" + altitude +
             ", partSwapWorth=" + partSwapWorth +
             ", engineNum=" + engineNum +
             '}';
   }
}
