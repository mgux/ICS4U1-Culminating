class SpaceVehicle{
  private int altitude;
  private boolean radio;
  private String camera;
  private int manufactureYear;
  private String serialNum;
  private int cost;
  private int partSwapWorth;
  private boolean isInSpace;

  public SpaceVehicle compareSpace(SpaceVehicle){
      
    return ;
  }
  public String generateSerialNum(String){
      
    return ;
  }
  public String toString(){
    return ;
  }
  public SpaceVehicle(int altitude, boolean radio, String camera, int manufactureYear, String serialNum, int cost){
      this.altitude = altitude;
      this.radio = radio;
      this.camera = camera;
      this.cost = cost;
      this.serialNum = serialNum
  }
  public launch(){
      if(SpaceManager.beingCarried(this.serialNum)==true){
        isInSpace = true;
        return true;
      }else{
        return false;
      }
  }
}
