import java.util.Scanner;

public class MainRunner {

    public static void main(String[] args) {
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Vehicle Management System ---");
            System.out.println("1. Add Water Vehicle");
            System.out.println("2. Add Land Vehicle");
            System.out.println("3. Add Air Vehicle");
            System.out.println("4. Add Space Vehicle");
            System.out.println("5. Exchange Parts Between Vehicles");
            System.out.println("6. Find Most Expensive Vehicle");
            System.out.println("7. Find Fastest Vehicle");
            System.out.println("8. Export Database to File");
            System.out.println("9. Import Database from File");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addWaterVehicle(database, scanner);
                case 2 -> addLandVehicle(database, scanner);
                case 3 -> addAirVehicle(database, scanner);
                case 4 -> addSpaceVehicle(database, scanner);
                case 5 -> exchangeParts(database, scanner);
                case 6 -> findMostExpensiveVehicle(database);
                case 7 -> findFastestVehicle(database);
                case 8 -> exportDatabase(database, scanner);
                case 9 -> importDatabase(database, scanner);
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting Vehicle Management System. Goodbye!");
    }

    private static void addWaterVehicle(Database database, Scanner scanner) {
        System.out.print("Enter serial number: ");
        String serial = scanner.nextLine();
        System.out.print("Enter fuel capacity: ");
        double fuelCapacity = scanner.nextDouble();
        System.out.print("Enter speed: ");
        int speed = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Is it nuclear powered? (true/false): ");
        boolean isNuclearPowered = scanner.nextBoolean();
        System.out.print("Enter location: ");
        String location = scanner.next();
        System.out.print("Enter cost: ");
        int cost = scanner.nextInt();

        System.out.println("Adding a Water Vehicle...");
        boolean success = database.waterManager.addWaterVehicle(serial, fuelCapacity, speed, isNuclearPowered, location, cost);

        if (success) {
            System.out.println("Water Vehicle added successfully!");
        } else {
            System.out.println("Failed to add Water Vehicle.");
        }
    }

    private static void addLandVehicle(Database database, Scanner scanner) {
        System.out.print("Enter serial number: ");
        String serial = scanner.nextLine();
        System.out.print("Enter manufacture year: ");
        int year = scanner.nextInt();
        System.out.print("Enter cost: ");
        int cost = scanner.nextInt();
        System.out.print("Enter number of parts: ");
        int parts = scanner.nextInt();

        System.out.println("Adding a Land Vehicle...");
        boolean success = database.landManager.addJeep(year, cost, parts, serial, 200, "USA", 10, 4, 6, 2, 2.5);

        if (success) {
            System.out.println("Land Vehicle added successfully!");
        } else {
            System.out.println("Failed to add Land Vehicle.");
        }
    }

    private static void addAirVehicle(Database database, Scanner scanner) {
        System.out.print("Enter serial number: ");
        String serial = scanner.nextLine();
        System.out.print("Enter wing span: ");
        int wings = scanner.nextInt();
        System.out.print("Enter speed: ");
        int speed = scanner.nextInt();
        System.out.print("Enter manufacture year: ");
        int year = scanner.nextInt();

        System.out.println("Adding an Air Vehicle...");
        boolean success = database.airManager.addAircraft(year, 100, wings, speed, serial, 200, 2, 4, 300.5, 20.0, 50.0, 100, 4);

        if (success) {
            System.out.println("Air Vehicle added successfully!");
        } else {
            System.out.println("Failed to add Air Vehicle.");
        }
    }

    private static void addSpaceVehicle(Database database, Scanner scanner) {
        System.out.print("Enter serial number: ");
        String serial = scanner.nextLine();
        System.out.print("Enter engine power: ");
        int enginePower = scanner.nextInt();
        System.out.print("Enter altitude: ");
        int altitude = scanner.nextInt();
        System.out.print("Enter manufacture year: ");
        int year = scanner.nextInt();

        System.out.println("Adding a Space Vehicle...");
        boolean success = database.spaceManager.addRocket(enginePower, serial, altitude, "Moon", year, "NASA", 10, 2, 3, 5, 4, 2, 100);

        if (success) {
            System.out.println("Space Vehicle added successfully!");
        } else {
            System.out.println("Failed to add Space Vehicle.");
        }
    }

    private static void exchangeParts(Database database, Scanner scanner) {
        System.out.print("Enter the serial number of the source vehicle: ");
        String sourceSerial = scanner.nextLine();
        System.out.print("Enter the serial number of the target vehicle: ");
        String targetSerial = scanner.nextLine();

        boolean success = database.exchangeParts(sourceSerial, targetSerial);
        if (success) {
            System.out.println("Parts exchanged successfully!");
        } else {
            System.out.println("Failed to exchange parts.");
        }
    }

    private static void findMostExpensiveVehicle(Database database) {
        Vehicle mostExpensive = database.findMostExpensiveVehicle();
        if (mostExpensive != null) {
            System.out.println("Most Expensive Vehicle:");
            System.out.println(mostExpensive);
        } else {
            System.out.println("No vehicles found.");
        }
    }

    private static void findFastestVehicle(Database database) {
        Vehicle fastest = database.findFastestVehicle();
        if (fastest != null) {
            System.out.println("Fastest Vehicle:");
            System.out.println(fastest);
        } else {
            System.out.println("No vehicles found.");
        }
    }

    private static void exportDatabase(Database database, Scanner scanner) {
        System.out.print("Enter file name to export: ");
        String fileName = scanner.nextLine();

        boolean success = database.exportToFile(fileName);
        if (success) {
            System.out.println("Database exported successfully!");
        } else {
            System.out.println("Failed to export database.");
        }
    }

    private static void importDatabase(Database database, Scanner scanner) {
        System.out.print("Enter file name to import: ");
        String fileName = scanner.nextLine();

        boolean success = database.importFromFile(fileName);
        if (success) {
            System.out.println("Database imported successfully!");
        } else {
            System.out.println("Failed to import database.");
        }
    }
}
