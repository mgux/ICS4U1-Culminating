//WaterVehicle Class with abstract methods methods and fields
class WaterVehicle{
private double fuelCapacity;
private boolean isNuclearPowered;
private String serialNum;
private int speed;
private String location;
private int cost;
private int partSwapWorth;
private boolean isInWater;

//Constructor
  public WaterVehicle(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost){
    this.fuelCapacity = fuelCapacity;
    this.isNuclearPowered = isNuclearPowered;
    this.manufactureYear = manufactureYear;
    this.serialNum = serialNum;
    this.speed = speed;
    this.location = location;
    this.cost = cost;
    isInwater = false;
  }

  public compareWater(WaterVehicle){
    
  }

  public generateSerialNum(){
  }

  public String toString(){
  }

  public boolean launch(){
    
  }
}
