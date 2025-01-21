/*
Satellite.java
Tianyue Zhao
ICS4U1
Jan 20th, 2025
Description: Satellite class, which contains methods that compare Satellites
*/

public class Satellite extends SpaceVehicle
{
    private double powerCost;
    private double solarPanelSize;
    private Rocket containedVehicle;
    public Satellite(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7, double d1, double d2) //Constructor
    {
        super(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7);
        powerCost = d1;
        solarPanelSize = d2;
        containedVehicle = null;
    }
    //Accessors and Mutators
    public double getPowerCost()
    {
        return powerCost;
    }
    public double getSolarPanelSize()
    {
        return solarPanelSize;
    }
    public Rocket getContainedVehicle()
    {
        return containedVehicle;
    }
    public void setPowerCost(double d)
    {
        powerCost = d;
    }
    public void setSolarPanelSize(double d)
    {
        solarPanelSize = d;
    }
    public void getContainedVehicle(Rocket r)
    {
        containedVehicle = r;
    }
    public Satellite compareSpeed(Satellite other) //Overloads the method in SpaceVehicle with same implementation
    {
        return this.getSpeed()>other.getSpeed()?this:other;
    }
    public Satellite comparePowerCost(Satellite other) //Return other if other has a higher powerCost, and this otherwise
    {
        return this.powerCost>other.powerCost?this:other;
    }
    public Satellite compareCost(Satellite other) //OverLoads the method in SpaceVehicle with same implementation
    {
        return this.getCost()>other.getCost()?this:other;
    }
    public Satellite compareSolarPanelSize(Satellite other) //Returns other if other has a higher powerCost, and this otherwise
    {
        return this.solarPanelSize>other.solarPanelSize?this:other;
    }
    public Rocket containedWithinVehicle() //Returns the Rocket that is containing the Satellite, or null if it is not being contained
    {
        return getContainedVehicle();
    }
    public boolean isBroken() //Implements the isBroken Method from SpaceVehicle
    {
        if (this.getParts() < this.getMinParts() && powerCost == 0)
        {
            return true;
        }
        return false;
    }
    public String toString() //toString
    {
        return super.toString() + powerCost+"\n"+solarPanelSize+"\n";
    }
}
