import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private LandManager LandManager = new LandManager();
    private WaterManager WaterManager = new WaterManager();
    private AirManager AirManager = new AirManager();
    private SpaceManager SpaceManager = new SpaceManager();
    public void findMostExpensiveVehicle() {
        ArrayList<Integer> mostExpensives = new ArrayList<>();
        AirVehicle mostExpensiveAir;
        WaterVehicle mostExpensiveWater;
        LandVehicle mostExpensiveLand;
        SpaceVehicle mostExpensiveSpace;
        int mostExpensiveVehicle;
        int num = 0;


        mostExpensiveAir = AirManager.findMostExpensiveAirVehicle();
        mostExpensiveWater = WaterManager.findMostExpensiveWaterVehicle();
        mostExpensiveLand = LandManager.findMostExpensiveLand();
        mostExpensiveSpace = SpaceManager.findMostExpensiveSpace();
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
        Object fastestWater = WaterManager.findFastestWater();
        if (fastestWater instanceof WaterVehicle && ((WaterVehicle) fastestWater).getSpeed() > highestSpeed) {
            highestSpeed = ((WaterVehicle) fastestWater).getSpeed();
            fastest = fastestWater;
            choice = 0;
        }

        Object fastestLand = LandManager.findFastestLand();
        if (fastestLand instanceof LandVehicle && ((LandVehicle) fastestLand).getSpeed() > highestSpeed) {
            highestSpeed = ((LandVehicle) fastestLand).getSpeed();
            fastest = fastestLand;
            choice = 1;
        }

        Object fastestAir = AirManager.findFastestAircraft();
        if (fastestAir instanceof AirVehicle && ((AirVehicle) fastestAir).getSpeed() > highestSpeed) {
            highestSpeed = ((AirVehicle) fastestAir).getSpeed();
            fastest = fastestAir;
            choice = 2;
        }

        Object fastestSpace = SpaceManager.findFastestSpace();
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
   
       Object sourceVehicle = null;
       Object targetVehicle = null;
   
       // Determine the type of the source vehicle
       if ((sourceVehicle = WaterManager.searchVehicleSerial(sourceSerial)) != null) {
           System.out.println("Source vehicle is a WaterVehicle.");
       } else if ((sourceVehicle = LandManager.searchSerial(sourceSerial)) != null) {
           System.out.println("Source vehicle is a LandVehicle.");
       } else if ((sourceVehicle = AirManager.searchVehicleSerial(sourceSerial)) != null) {
           System.out.println("Source vehicle is an AirVehicle.");
       } else if ((sourceVehicle = SpaceManager.searchSerial(sourceSerial)) != null) {
           System.out.println("Source vehicle is a SpaceVehicle.");
       } else {
           System.out.println("Source vehicle not found.");
           return false;
       }
   
       // Determine the type of the target vehicle
       if ((targetVehicle = WaterManager.searchVehicleSerial(targetSerial)) != null) {
           System.out.println("Target vehicle is a WaterVehicle.");
       } else if ((targetVehicle = LandManager.searchSerial(targetSerial)) != null) {
           System.out.println("Target vehicle is a LandVehicle.");
       } else if ((targetVehicle = AirManager.searchVehicleSerial(targetSerial)) != null) {
           System.out.println("Target vehicle is an AirVehicle.");
       } else if ((targetVehicle = SpaceManager.searchSerial(targetSerial)) != null) {
           System.out.println("Target vehicle is a SpaceVehicle.");
       } else {
           System.out.println("Target vehicle not found.");
           return false;
       }
   
       // Prompt for the number of parts to exchange
       System.out.print("Enter the number of parts to exchange: ");
       int partsToExchange = scanner.nextInt();
   
       // Handle exchange based on specific vehicle types
       if (sourceVehicle instanceof WaterVehicle && targetVehicle instanceof WaterVehicle) {
           return performExchange((WaterVehicle) sourceVehicle, (WaterVehicle) targetVehicle, partsToExchange);
       } else if (sourceVehicle instanceof LandVehicle && targetVehicle instanceof LandVehicle) {
           return performExchange((LandVehicle) sourceVehicle, (LandVehicle) targetVehicle, partsToExchange);
       } else if (sourceVehicle instanceof AirVehicle && targetVehicle instanceof AirVehicle) {
           return performExchange((AirVehicle) sourceVehicle, (AirVehicle) targetVehicle, partsToExchange);
       } else if (sourceVehicle instanceof SpaceVehicle && targetVehicle instanceof SpaceVehicle) {
           return performExchange((SpaceVehicle) sourceVehicle, (SpaceVehicle) targetVehicle, partsToExchange);
       } else {
           System.out.println("Incompatible vehicle types for part exchange.");
           return false;
       }
   }
   
   // Helper method to perform the exchange for specific types
   private boolean performExchange(WaterVehicle sourceVehicle, WaterVehicle targetVehicle, int partsToExchange) {
       int sourcePartsRequired = partsToExchange * sourceVehicle.PART_SWAP_WORTH;
   
       if (sourceVehicle.getParts() < sourcePartsRequired) {
           System.out.println("Source vehicle does not have enough parts for this exchange.");
           return false;
       }
   
       sourceVehicle.setParts(sourceVehicle.getParts() - sourcePartsRequired);
       int targetPartsAdded = partsToExchange * targetVehicle.PART_SWAP_WORTH;
       targetVehicle.setParts(targetVehicle.getParts() + targetPartsAdded);
   
       System.out.println("Exchange completed successfully!");
       return true;
   }
   
   // Overloaded performExchange methods for other vehicle types
   private boolean performExchange(LandVehicle sourceVehicle, LandVehicle targetVehicle, int partsToExchange) {
       // Similar logic for LandVehicle
       int sourcePartsRequired = partsToExchange * sourceVehicle.PART_SWAP_WORTH;
   
       if (sourceVehicle.getParts() < sourcePartsRequired) {
           System.out.println("Source vehicle does not have enough parts for this exchange.");
           return false;
       }
   
       sourceVehicle.setParts(sourceVehicle.getParts() - sourcePartsRequired);
       int targetPartsAdded = partsToExchange * targetVehicle.PART_SWAP_WORTH;
       targetVehicle.setParts(targetVehicle.getParts() + targetPartsAdded);
   
       System.out.println("Exchange completed successfully!");
       return true;
   }
   
   private boolean performExchange(AirVehicle sourceVehicle, AirVehicle targetVehicle, int partsToExchange) {
       // Similar logic for AirVehicle
       int sourcePartsRequired = partsToExchange * sourceVehicle.PART_SWAP_WORTH;
   
       if (sourceVehicle.getParts() < sourcePartsRequired) {
           System.out.println("Source vehicle does not have enough parts for this exchange.");
           return false;
       }
   
       sourceVehicle.setParts(sourceVehicle.getParts() - sourcePartsRequired);
       int targetPartsAdded = partsToExchange * targetVehicle.PART_SWAP_WORTH;
       targetVehicle.setParts(targetVehicle.getParts() + targetPartsAdded);
   
       System.out.println("Exchange completed successfully!");
       return true;
   }
   
   private boolean performExchange(SpaceVehicle sourceVehicle, SpaceVehicle targetVehicle, int partsToExchange) {
       // Similar logic for SpaceVehicle
       int sourcePartsRequired = partsToExchange * sourceVehicle.PART_SWAP_WORTH;
   
       if (sourceVehicle.getParts() < sourcePartsRequired) {
           System.out.println("Source vehicle does not have enough parts for this exchange.");
           return false;
       }
   
       sourceVehicle.setParts(sourceVehicle.getParts() - sourcePartsRequired);
       int targetPartsAdded = partsToExchange * targetVehicle.PART_SWAP_WORTH;
       targetVehicle.setParts(targetVehicle.getParts() + targetPartsAdded);
   
       System.out.println("Exchange completed successfully!");
       return true;
   }

   
}
