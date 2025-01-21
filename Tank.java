public class Tank extends LandVehicle
{
    private int ammunition;
    private double range;
    private Ship containedVehicle;
    public Tank (int n1, int n2, int n3, String s1, int n4, String s2, int n5, int n6, int n7, int n8, int n9, double d)
    {
        super(n1, n2, n3, s1, n4, s2, n5, n6, n7, n8);
        ammunition = n9;
        range = d;
        containedVehicle = null;
    }
    public int getAmmunition()
    {
        return ammunition;
    }
    public double getRange()
    {
        return range;
    }
    public Ship getContainedVehicle()
    {
        return containedVehicle;
    }
    public void setAmmunition(int n)
    {
        ammunition = n;
    }
    public void setRange(double d)
    {
        range = d;
    }
    public void setContainedVehicle(Ship s)
    {
        containedVehicle = s;
    }
    public Tank compareSpeed(Tank other)
    {
        return this.getSpeed()>other.getSpeed()?this:other;
    }
    public Tank compareRange(Tank other)
    {
        return this.range>other.range?this:other;
    }
    public Tank compareCost(Tank other)
    {
        return this.getCost()>other.getCost()?this:other;
    }
    public Tank compareAmmo(Tank other)
    {
        return this.ammunition>other.ammunition?this:other;
    }
    public Ship containedWithinVehicle()
    {
        return getContainedVehicle();
    }
    public boolean isBroken()
    {
        return this.getParts() < this.getMinParts() && ammunition == 0;
    }
    public String toString()
    {
        return super.toString() + range+"\n"+ammunition+"\n";
    }
}
