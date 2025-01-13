// WaterVehicle Class with abstract methods and fields
class WaterVehicle {
    private double fuelCapacity;
    private boolean isNuclearPowered;
    private int manufactureYear;
    private String serialNum;
    private int speed;
    private String location;
    private int cost;
    private int partSwapWorth;
    private boolean isInWater;

    // Constructor
    public WaterVehicle(double fuelCapacity, boolean isNuclearPowered, int manufactureYear, String serialNum, int speed, String location, int cost) {
        this.fuelCapacity = fuelCapacity;
        this.isNuclearPowered = isNuclearPowered;
        this.manufactureYear = manufactureYear;
        this.serialNum = serialNum;
        this.speed = speed;
        this.location = location;
        this.cost = cost;
        this.isInWater = false;
    }

    // Accessor (Getter) Methods
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public boolean getIsNuclearPowered() {
        return isNuclearPowered;
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

    public int getPartSwapWorth() {
        return partSwapWorth;
    }

    public boolean getIsInWater() {
        return isInWater;
    }

    // Mutator (Setter) Methods
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setIsNuclearPowered(boolean isNuclearPowered) {
        this.isNuclearPowered = isNuclearPowered;
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

    public void setPartSwapWorth(int partSwapWorth) {
        this.partSwapWorth = partSwapWorth;
    }

    public void setIsInWater(boolean isInWater) {
        this.isInWater = isInWater;
    }
}
