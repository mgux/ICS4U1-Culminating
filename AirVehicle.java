import java.util.ArrayList;

public abstract class AirVehicle {
    final static int PART_SWAP_WORTH = 3;
    private int engineNum;
    private int wingNum;
    private int manufactureYear;
    private String serialNum;
    private int speed;

    private String location;
    private int cost;
    private int altitude;


    private int parts;
    private int maxParts;
    private int minParts;

    private ArrayList<Repairs> repairHistory = new ArrayList<>();

    public AirVehicle(int engineNum, int wingNum, int manufactureYear, String serialNum, int speed, String location, int cost, int altitude, int parts, int maxParts,int minParts) {
        this.engineNum = engineNum;
        this.wingNum = wingNum;
        this.manufactureYear = manufactureYear;
        this.serialNum = serialNum;
        this.speed = speed;
        this.location = location;
        this.cost = cost;
        this.altitude = altitude;
        this.parts = parts;
        this.minParts = minParts;
        this.maxParts = maxParts;
    }



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
        return PART_SWAP_WORTH;
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

    public void setEngineNum(int engineNum) {
        this.engineNum = engineNum;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }

    public void setMaxParts(int maxParts) {
        this.maxParts = maxParts;
    }

    public void setMinParts(int minParts) {
        this.minParts = minParts;
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

    public int compareAltitude(AirVehicle air) {
        return this.altitude - air.altitude;
    }

    public int compareEngineNum(AirVehicle air) {
        return this.engineNum - air.engineNum;
    }

    public int compareWingNum(AirVehicle air) {
        return this.wingNum - air.wingNum;
    }

    public AirVehicle compareSpeed(AirVehicle air) {
        if (this.speed > air.speed) {
            return this;
        }
        return air;
    }

    public int compareCost(AirVehicle air) {
        return this.cost - air.cost;
    }

    public boolean addRepair()
    {
        Repairs r = new Repairs(this);
        repairHistory.add(r);
        return true;
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

    public boolean isBroken() {
        if (parts < minParts) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Engine Number: " + engineNum + "\nWing Number: " + wingNum + "\nManufacture Year: " + manufactureYear + "\nSerial Number: " + serialNum + "\nSpeed: " + speed + "\nLocation: " + location + "\nCost: " + cost + "\nAltitude" + altitude + "\nParts: " + parts +"\nMinparts: " + minParts  + "\nMaxparts: " + maxParts + "\nPart Swap Worth: " + PART_SWAP_WORTH;
    }

}
