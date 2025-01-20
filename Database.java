import java.util.ArrayList;

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

        Object fastestWater = waterManager.findFastestWater();
        if (fastestWater instanceof WaterVehicle && ((WaterVehicle) fastestWater).getSpeed() > highestSpeed) {
            highestSpeed = ((WaterVehicle) fastestWater).getSpeed();
            fastest = fastestWater;
        }

        Object fastestLand = landManager.findFastestLand();
        if (fastestLand instanceof LandVehicle && ((LandVehicle) fastestLand).getSpeed() > highestSpeed) {
            highestSpeed = ((LandVehicle) fastestLand).getSpeed();
            fastest = fastestLand;
        }

        Object fastestAir = airManager.findFastestAircraft();
        if (fastestAir instanceof AirVehicle && ((AirVehicle) fastestAir).getSpeed() > highestSpeed) {
            highestSpeed = ((AirVehicle) fastestAir).getSpeed();
            fastest = fastestAir;
        }

        Object fastestSpace = spaceManager.findFastestSpace();
        if (fastestSpace instanceof SpaceVehicle && ((SpaceVehicle) fastestSpace).getSpeed() > highestSpeed) {
            highestSpeed = ((SpaceVehicle) fastestSpace).getSpeed();
            fastest = fastestSpace;
        }
                System.out.println("Fastest vehicle: " + fastest.getSerialNum());
    }

    public boolean exportToFile(String filePath) {
        boolean success = true;

        success &= waterManager.outWaterVehicle(filePath);
        success &= landManager.outLandVehicles(filePath);
        success &= airManager.outAirVehicle(filePath);
        success &= spaceManager.outSpaceVehicle(filePath);

        return success;
    }

    public boolean importFromFile(String filePath) {
        boolean success = true;

        success &= waterManager.readWaterVehicle(filePath);
        success &= landManager.readLandVehicles(filePath);
        success &= airManager.readAirVehicle(filePath);
        success &= spaceManager.readSpaceVehicle(filePath);

        return success;
    }

    public boolean exchangeParts(String serial1, String serial2) {
        Object vehicle1 = null, vehicle2 = null;

        if (vehicle1 == null) vehicle1 = waterManager.searchSerial(serial1);
        if (vehicle1 == null) vehicle1 = landManager.searchSerial(serial1);
        if (vehicle1 == null) vehicle1 = airManager.searchVehicleSerial(serial1);
        if (vehicle1 == null) vehicle1 = spaceManager.searchSerial(serial1);

        if (vehicle2 == null) vehicle2 = waterManager.searchSerial(serial2);
        if (vehicle2 == null) vehicle2 = landManager.searchSerial(serial2);
        if (vehicle2 == null) vehicle2 = airManager.searchVehicleSerial(serial2);
        if (vehicle2 == null) vehicle2 = spaceManager.searchSerial(serial2);

        if (vehicle1 == null || vehicle2 == null) {
            System.out.println("One or both vehicles not found.");
            return false;
        }

        if (vehicle1.getParts() > 0 && vehicle2.getParts() < vehicle2.getMaxParts()) {
            int transferableParts = Math.min(vehicle1.getParts(), vehicle2.getMaxParts() - vehicle2.getParts());
            vehicle1.setParts(vehicle1.getParts() - transferableParts);
            vehicle2.setParts(vehicle2.getParts() + transferableParts);
            return true;
        }

        return false;
    }
}
