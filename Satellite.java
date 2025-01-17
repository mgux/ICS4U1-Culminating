public class Satellite extends SpaceVehicle
{
   private double powerCost;
   private double solarPanelSize;
   private Rocket containedVehicle;
   public Satellite(int n1, String s1, int n2, String s2, int n3, String s3, int n4, int n5, int n6, int n7, double d1, double d2)
   {
      super(n1, s1, n2, s2, n3, s3, n4, n5, n6, n7);
      powerCost = d1;
      solarPanelSize = d2;
      containedVehicle = null;
   }
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
   public Satellite compareSpeed(Satellite other)
   {
      return this.getSpeed()>other.getSpeed()?this:other;
   }
   public Satellite comparePowerCost(Satellite other)
   {
      return this.powerCost>other.powerCost?this:other;
   }
   public Satellite compareCost(Satellite other)
   {
      return this.getCost()>other.getCost()?this:other;
   }
   public Satellite compareSolarPanelSize(Satellite other)
   {
      return this.solarPanelSize>other.solarPanelSize?this:other;
   }
   public Rocket containedWithinVehicle()
   {
      return getContainedVehicle();
   }
   public boolean isBroken()
   {
      if (this.getParts() < this.getMinParts() && powerCost == 0)
      {
         return true;
      }
      return false;
   }
   public String toString()
   {
      return "Satellite:\n"+"Power Cost: "+powerCost+"\nSolar Panel Size: "+solarPanelSize+"\nCarried by: "+(containedVehicle==null?"None":containedVehicle.getSerialNum())+"\n"+super.toString();
   }
}