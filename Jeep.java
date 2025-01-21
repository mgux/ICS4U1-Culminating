/*
Jeep.java
Tianyue Zhao
ICS4U1
Jan 20th, 2025
Description: Jeep class, with all methods needed to compare different Jeeps
*/

public class Jeep extends LandVehicle
{
    private int storageSpace;
    private double cargoWeight;
    private Aircraft containedVehicle;
    final static double MAX_CARGO_WEIGHT = 1000.0;
    public Jeep (int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d) //Constructor
    {
        super(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8);
        storageSpace = n9;
        cargoWeight = d;
        containedVehicle = null;
    }
    //Accessors and Mutators
    public int getStorageSpace()
    {
        return storageSpace;
    }
    public double getCargoWeight()
    {
        return cargoWeight;
    }
    public Aircraft getContainedVehicle()
    {
        return containedVehicle;
    }
    public void setStorageSpace(int n)
    {
        storageSpace = n;
    }
    public void setCargoWeight(double d)
    {
        cargoWeight = d;
    }
    public void setContainedVehicle(Aircraft a)
    {
        containedVehicle = a;
    }

    public Jeep compareSpeed(Jeep other) //Overload compareSpeed method from LandVehicle with same implementation
    {
        return this.getSpeed()>other.getSpeed()?this:other;
    }
    public Jeep compareWeight(Jeep other) //Returns this if the weight of this is larger or equal to the weight of other, and other otherwise
    {
        return this.cargoWeight>other.cargoWeight?this:other;
    }
    public Jeep compareCost(Jeep other) //Overload compareCost method from LandVehicle with same implementation
    {
        return this.getCost()>other.getCost()?this:other;
    }
    public Jeep compareStorageSpace(Jeep other) //Returns this if the storageSpace of this is larger or equal to the weight of other, and other otherwise
    {
        return this.storageSpace>other.storageSpace?this:other;
    }
    public Aircraft containedWithinVehicle() //Returns the airCraft that is carrying the Jeep, and null if it is not being carried
    {
        return getContainedVehicle();
    }
    public boolean isBroken() //Implementation of isBroken method from LandVehicle
    {
        if (this.getParts() < this.getMinParts() && cargoWeight == MAX_CARGO_WEIGHT)
        {
            return true;
        }
        return false;
    }
    public String toString() //toString method
    {
        return super.toString() + storageSpace+"\n"+cargoWeight+"\n";
    }
}
