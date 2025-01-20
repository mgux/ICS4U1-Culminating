import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private LandManager landManager = new LandManager();
    private WaterManager waterManager = new WaterManager();
    private AirManager airManager = new AirManager();
    private SpaceManager spaceManager = new SpaceManager();
    public void findMostExpensiveVehicle() {
        ArrayList<Integer> mostExpensives = new ArrayList<>();
        AirVehicle mostExpensiveAir;
        WaterVehicle mostExpensiveWater;
        LandVehicle mostExpensiveLand;
        SpaceVehicle mostExpensiveSpace;
        int mostExpensiveVehicle;
        int num = 0;


        mostExpensiveAir = airManager.findMostExpensiveAirVehicle();
        mostExpensiveWater = waterManager.findMostExpensiveWaterVehicle();
        mostExpensiveLand = landManager.findMostExpensiveLand();
        mostExpensiveSpace = spaceManager.findMostExpensiveSpace();
        int mostExpensiveAirValue = mostExpensiveAir.getCost();
        int mostExpensiveWaterValue = mostExpensiveWater.getCost();
        int mostExpensiveSpaceValue = mostExpensiveSpace.getCost();
        int mostExpensiveLandValue = mostExpensiveLand.getCost();

        mostExpensives.add(mostExpensiveAirValue);
        mostExpensives.add(mostExpensiveWaterValue);
        mostExpensives.add(mostExpensiveSpaceValue);
        mostExpensives.add(mostExpensiveLandValue);

        mostExpensiveVehicle = mostExpensives.getFirst();
        for (int i = 1; i < mostExpensives.size(); i++) {
            if (mostExpensives.get(i) > mostExpensiveVehicle) {
                mostExpensiveVehicle = mostExpensives.get(i);
                num = i;
            }
        }

        System.out.print("The most expensive vehicle costs $" + mostExpensiveVehicle + " and is a ");
        switch (num) {
            case 0:
                System.out.println(" air vehicle with serial " + mostExpensiveAir.getSerialNum());
            case 1:
                System.out.println(" water vehicle with serial " + mostExpensiveWater.getSerialNum());
            case 2:
                System.out.println(" space vehicle with serial " + mostExpensiveSpace.getSerialNum());
            case 3:
                System.out.println(" land vehicle with serial " + mostExpensiveLand.getSerialNum());
        }

    }

    public void findFastestVehicle() {
        Object fastest = null;
        int highestSpeed = Integer.MIN_VALUE;
        int choice = -1;
        Object fastestWater = waterManager.findFastestWater();
        if (fastestWater instanceof WaterVehicle && ((WaterVehicle) fastestWater).getSpeed() > highestSpeed) {
            highestSpeed = ((WaterVehicle) fastestWater).getSpeed();
            fastest = fastestWater;
            choice = 0;
        }

        Object fastestLand = landManager.findFastestLand();
        if (fastestLand instanceof LandVehicle && ((LandVehicle) fastestLand).getSpeed() > highestSpeed) {
            highestSpeed = ((LandVehicle) fastestLand).getSpeed();
            fastest = fastestLand;
            choice = 1;
        }

        Object fastestAir = airManager.findFastestAircraft();
        if (fastestAir instanceof AirVehicle && ((AirVehicle) fastestAir).getSpeed() > highestSpeed) {
            highestSpeed = ((AirVehicle) fastestAir).getSpeed();
            fastest = fastestAir;
            choice = 2;
        }

        Object fastestSpace = spaceManager.findFastestSpace();
        if (fastestSpace instanceof SpaceVehicle && ((SpaceVehicle) fastestSpace).getSpeed() > highestSpeed) {
            highestSpeed = ((SpaceVehicle) fastestSpace).getSpeed();
            fastest = fastestSpace;
            choice = 3;
        }
        switch(choice){
            case 1:
                System.out.println("Fastest vehicle: " + ((WaterVehicle)fastest).getSerialNum());
                break;
            case 2:
                System.out.println("Fastest vehicle: " + ((LandVehicle)fastest).getSerialNum());
                break;

            case 3:
                System.out.println("Fastest vehicle: " + ((AirVehicle)fastest).getSerialNum());
                break;
            case 4:
                System.out.println("Fastest vehicle: " + ((SpaceVehicle)fastest).getSerialNum());
                break;
        }
    }

   public boolean exchangeParts(String sourceSerial, String targetSerial) {
       Scanner scanner = new Scanner(System.in);
   
       Object sourceVehicle = findVehicleBySerial(sourceSerial);
       Object targetVehicle = findVehicleBySerial(targetSerial);

       if (sourceVehicle == null || targetVehicle == null) {
           System.out.println("One or both vehicles could not be found.");
           return false;
       }

       System.out.print("Enter the number of parts to exchange: ");
       int partsToExchange = scanner.nextInt();
   
       if (sourceVehicle instanceof WaterVehicle && targetVehicle instanceof WaterVehicle) {
           return exchangeParts((WaterVehicle) sourceVehicle, (WaterVehicle) targetVehicle, partsToExchange);
       } else if (sourceVehicle instanceof LandVehicle && targetVehicle instanceof LandVehicle) {
           return exchangeParts((LandVehicle) sourceVehicle, (LandVehicle) targetVehicle, partsToExchange);
       } else if (sourceVehicle instanceof AirVehicle && targetVehicle instanceof AirVehicle) {
           return exchangeParts((AirVehicle) sourceVehicle, (AirVehicle) targetVehicle, partsToExchange);
       } else if (sourceVehicle instanceof SpaceVehicle && targetVehicle instanceof SpaceVehicle) {
           return exchangeParts((SpaceVehicle) sourceVehicle, (SpaceVehicle) targetVehicle, partsToExchange);
       } else {
           System.out.println("Vehicles must be of the same type to exchange parts.");
           return false;
       }
   }
   
   private Object findVehicleBySerial(String serial) {
       Object foundVehicle = null;
   
       if (waterManager.searchVehicleSerial(serial) != null) {
           foundVehicle = waterManager.searchVehicleSerial(serial);
       } else if (landManager.searchSerial(serial) != null) {
           foundVehicle = landManager.searchSerial(serial);
       } else if (airManager.searchVehicleSerial(serial) != null) {
           foundVehicle = airManager.searchVehicleSerial(serial);
       } else if (spaceManager.searchSerial(serial) != null) {
           foundVehicle = spaceManager.searchSerial(serial);
       }
   
       return foundVehicle;
   }
   
   private boolean exchangeParts(Vehicle source, Vehicle target, int partsToExchange) {
       int sourcePartsRequired = partsToExchange * source.PART_SWAP_WORTH;
   
       if (source.getParts() < sourcePartsRequired) {
           System.out.println("Source vehicle does not have enough parts for this exchange.");
           return false;
       }
   
       source.setParts(source.getParts() - sourcePartsRequired);
       int targetPartsAdded = partsToExchange * target.PART_SWAP_WORTH;
       target.setParts(target.getParts() + targetPartsAdded);
   
       System.out.println("Exchange completed successfully!");
       return true;
   }
   
}
