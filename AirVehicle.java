public abstract class AirVehicle {
    private int wingNum;
    private int manufactureYear;
    private String serialNum;
    private int speed;

    private String location;
    private int cost;
    private int altitude;
    private int partSwapWorth;

    public AirVehicle(int engineNum, int wingNum, int manufactureYear, String serialNum, int speed, String location, int cost, int altitude, int partSwapWorth) {
        this.engineNum = engineNum;
        this.wingNum = wingNum;
        this.manufactureYear = manufactureYear;
        this.serialNum = serialNum;
        this.speed = speed;
        this.location = location;
        this.cost = cost;
        this.altitude = altitude;
        this.partSwapWorth = partSwapWorth;
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
