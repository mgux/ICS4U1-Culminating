/*
* Programmer: Michael Gu
* Last Updated: 2025-01-20
* This is the jet class
* */

public class Jet extends AirVehicle{
    private String missileType;
    private int agility;
    private int storageTaken;
    private Ship containedObject;

    public Jet(int engineNum, int wingNum, int manufactureYear, String serialNum, int speed, String location, int cost, int altitude, String missileType, int agility, int storageTaken, int parts, int minParts, int maxParts) {
        super(engineNum, wingNum, manufactureYear, serialNum, speed, location, cost, altitude,parts,minParts,maxParts);
        this.agility = agility;
        this.missileType = missileType;
        this.storageTaken = storageTaken;
        containedObject = null;
    }

    public int compareAgility(Jet jet) {
        return this.agility - jet.agility;
    }

    public int compareSpeed(Jet jet) {
        return this.getSpeed() - jet.getSpeed();
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

    public Ship getContainedObject() {
        return containedObject;
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

    public void setContainedObject(Ship ship) {
        containedObject = ship;
    }


    public String toString() {
        return "Jet{" +
                "missileType='" + missileType + '\'' +
                ", agility=" + agility +
                ", storageTaken=" + storageTaken +
                '}';
    }
}
