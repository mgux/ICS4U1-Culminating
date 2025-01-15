public class Jet extends AirVehicle{
    private String missileType;
    private int agility;
    private int storageTaken;

    public Jet(int engineNum, int wingNum, int manufactureYear, String serialNum, int speed, String location, int cost, int altitude, int partSwapWorth, String missileType, int agility, int storageTaken, int parts, int minParts, int maxParts) {
        super(engineNum, wingNum, manufactureYear, serialNum, speed, location, cost, altitude, partSwapWorth,parts,minParts,maxParts);
        this.agility = agility;
        this.missileType = missileType;
        this.storageTaken = storageTaken;
    }

    public int compareAgility(Jet jet) {
        return this.agility - jet.agility;
    }

    public String getMissileType() {
        return missileType;
    }

    public int getAgility() {
        return agility;
    }

    public int getStorageTaken() {
        return storageTaken;
    }

    public void setStorageTaken(int storageTaken) {
        this.storageTaken = storageTaken;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setMissileType(String missileType) {
        this.missileType = missileType;
    }


    public String toString() {
        return "Jet{" +
                "missileType='" + missileType + '\'' +
                ", agility=" + agility +
                ", storageTaken=" + storageTaken +
                '}';
    }
}
