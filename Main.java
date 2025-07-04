import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Programmer: Michael Gu
* Last Updated: 2025-1-20
* This is the runner
* */

// Main class
public class Main {

    static LandManager landManager = new LandManager();
    static WaterManager waterManager = new WaterManager();
    static AirManager airManager = new AirManager();
    static SpaceManager spaceManager = new SpaceManager();
    static Database database = new Database(landManager, waterManager, airManager, spaceManager);

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\033[0;92m";
    public static final String ANSI_BG = "\u001B[41m";

    // Main driver method
    public static void main(String[] args) {
        printMenu();
        System.out.println("Goodbye!");
    }

    //method to print the main menu of vehicle manager
    public static void printMenu() {
        System.out.print(ANSI_YELLOW);
        System.out.println("\n" +
                "▗▖  ▗▖▗▄▄▄▖▗▖ ▗▖▗▄▄▄▖ ▗▄▄▖▗▖   ▗▄▄▄▖    ▗▖  ▗▖ ▗▄▖ ▗▖  ▗▖ ▗▄▖  ▗▄▄▖▗▄▄▄▖▗▄▄▖ \n" +
                "▐▌  ▐▌▐▌   ▐▌ ▐▌  █  ▐▌   ▐▌   ▐▌       ▐▛▚▞▜▌▐▌ ▐▌▐▛▚▖▐▌▐▌ ▐▌▐▌   ▐▌   ▐▌ ▐▌\n" +
                "▐▌  ▐▌▐▛▀▀▘▐▛▀▜▌  █  ▐▌   ▐▌   ▐▛▀▀▘    ▐▌  ▐▌▐▛▀▜▌▐▌ ▝▜▌▐▛▀▜▌▐▌▝▜▌▐▛▀▀▘▐▛▀▚▖\n" +
                " ▝▚▞▘ ▐▙▄▄▖▐▌ ▐▌▗▄█▄▖▝▚▄▄▖▐▙▄▄▖▐▙▄▄▖    ▐▌  ▐▌▐▌ ▐▌▐▌  ▐▌▐▌ ▐▌▝▚▄▞▘▐▙▄▄▖▐▌ ▐▌\n" +
                "                                                                             \n" +
                "                                                                             " +
                "                                                                             ");
        System.out.print(ANSI_RESET);
        System.out.println("MADE BY TIANYUE, LUKE, MICHAEL\n");
        
        Scanner sc = new Scanner(System.in);
        int selection = -1;
        String fileName;
        boolean validInput = false;
        boolean validInputAge = false;
        int age = 0;
        String location = "";
        String serial = "";
        int manufactureYear = 0;

        //Prompts user for option
        System.out.println("[0] - Find Fastest Vehicle");
        System.out.println("[1] - Find Certain Land Vehicle");
        System.out.println("[2] - Find Vehicles Over Certain Age");
        System.out.println("[3] - Search manufacture year and location");
        System.out.println("[5] - EXPORT CURRENT VEHICLE DATA");
        System.out.println("[6] - Search vehicle by serial");
        System.out.println("[7] - IMPORT EXISTING VEHICLE DATA");
        System.out.println("[8] - SORT VEHICLES BY MANUFACTURE YEAR AND LOCATION");
        System.out.println("[9] - ADD REPAIR TO A VEHICLE");
        System.out.println("[10] - GET RECENT REPAIR FOR A VEHICLE");
        System.out.println("[11] - ADD VEHICLE TO DATABASE");
        System.out.println("[12] - REMOVE VEHICLE FROM DATABASE");
        System.out.println("[13] - SORT SERIALS LEXICOGRAPHICALLY");
        System.out.println("[0000] - QUIT");
        System.out.println();

        //Keeps looping as long as user does not enter 0000
        while (!validInput) {
            System.out.println("Enter selection: ");
            try {

                selection = sc.nextInt();
                if (selection == 0000) {
                    return;
                }
                validInput = true;

            }
            catch (InputMismatchException e) {

                System.out.println("Enter a valid option!");
                sc.nextLine();
            }
        }

        //Switchcase to see what option the user has picked.
        switch(selection) {
                //find fastest vehicle in all vehicle
            case 0:
                database.findFastestVehicle();
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;

            case 1:
                //finds the most expensive vehicle in all vehicles
                database.findMostExpensiveVehicle();
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;

            case 2:
                //finds all the vehicles over specified age
                while (!validInputAge) {
                    System.out.println("Enter age: ");
                    try {
                        age = sc.nextInt();
                        validInputAge = true;

                    } catch (InputMismatchException e) {
                        System.out.println("Enter a valid option!");
                        sc.nextLine();
                    }
                }
                database.findVehiclesOverAge(age);
                break;
            case 3:
                // search manufacture year and location
                while (!validInputAge) {
                    System.out.println("Enter year: ");
                    try {
                        manufactureYear = sc.nextInt();
                        validInputAge = true;

                    } catch (InputMismatchException e) {
                        System.out.println("Enter a valid year!");
                        sc.nextLine();
                    }
                }
                sc.nextLine();

                System.out.println("Enter location: ");
                location = sc.nextLine();

                database.searchManufactureLocation(manufactureYear,location);

                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;
            case 5:
                // saves file
                System.out.println("Enter save file name: ");
                sc.nextLine();
                String save = sc.nextLine();
                database.exportToFile(save);
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;
            case 6:
                sc.nextLine();
                // search vehicle by serial 
                System.out.println("Enter the serial to search for: ");
                serial = sc.nextLine();
                database.searchSerial(serial);
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;
            case 7:
                database.readInput("Data.txt");
                printMenu();
                break;

            case 8:
                //sorts by manufacture and location
                sc.nextLine();
                database.sortManufactureLocation();
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;
            case 9:
                sc.nextLine();
                // add repairs repairs to a vehicle
                System.out.println("Enter the serial to add repairs to: ");
                serial = sc.nextLine();
                database.addRepairVehicleSerial(serial);
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;
            case 10:
                sc.nextLine();
                // sees all repairs of a certain vehicle.
                System.out.println("Enter the serial to see repairs: ");
                serial = sc.nextLine();
                database.searchSerialRepairs(serial);
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;
            case 11:
                // adds vehicles
                database.addVehicle();
                sc.nextLine();
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;
            case 12:
                //Uses serial to remove a certain vehicle from the database
                sc.nextLine();
                System.out.println("Enter the serial of the vehicle being removed: ");
                serial = sc.nextLine();
                database.removeVehicle(serial);
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;

            case 13:
                sc.nextLine();
                // sorts all vehicles in all managers using serial
                database.sortSerial();
                System.out.println("\n Press [Enter] to continue.");
                sc.nextLine();
                printMenu();
                break;
        }

    }
}
