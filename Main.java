// Java Program to Print Colored Text in Console

// Importing input output classes
import java.io.*;
import java.util.Scanner;

// Main class
public class Main {

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\u001B[36m";
    public static final String ANSI_BG = "\u001B[41m";

    // Main driver method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "▗▖  ▗▖▗▄▄▄▖▗▖ ▗▖▗▄▄▄▖ ▗▄▄▖▗▖   ▗▄▄▄▖    ▗▖  ▗▖ ▗▄▖ ▗▖  ▗▖ ▗▄▖  ▗▄▄▖▗▄▄▄▖▗▄▄▖ \n" +
                "▐▌  ▐▌▐▌   ▐▌ ▐▌  █  ▐▌   ▐▌   ▐▌       ▐▛▚▞▜▌▐▌ ▐▌▐▛▚▖▐▌▐▌ ▐▌▐▌   ▐▌   ▐▌ ▐▌\n" +
                "▐▌  ▐▌▐▛▀▀▘▐▛▀▜▌  █  ▐▌   ▐▌   ▐▛▀▀▘    ▐▌  ▐▌▐▛▀▜▌▐▌ ▝▜▌▐▛▀▜▌▐▌▝▜▌▐▛▀▀▘▐▛▀▚▖\n" +
                " ▝▚▞▘ ▐▙▄▄▖▐▌ ▐▌▗▄█▄▖▝▚▄▄▖▐▙▄▄▖▐▙▄▄▖    ▐▌  ▐▌▐▌ ▐▌▐▌  ▐▌▐▌ ▐▌▝▚▄▞▘▐▙▄▄▖▐▌ ▐▌\n" +
                "                                                                             \n" +
                "                                                                             " +
                "                                                                             ");
        System.out.println("MADE BY TIANYUE, LUKE, MICHAEL\n");


        int selection;

        System.out.println("[0] - Find Fastest Vehicle");
        System.out.println("[1] - Find Vehicles Over Certain Age");
        System.out.println("[2] - Find Certain Land Vehicle");
        System.out.println("[3] - Find Certain Air Vehicle");
        System.out.println("[2] - Find Certain Water Vehicle");
        System.out.println("[3] - Find Certain Space Vehicle");
        // Printing the text on console prior adding
        // the desired color
//        System.out.println(ANSI_YELLOW + "This text is cyan");
//        System.out.println("hello");
//        System.out.print(ANSI_RESET);
//        System.out.println("What the zaza");
//        System.out.println(ANSI_BG + "This text is red");
//        System.out.println("hi");
//        System.out.println("ZAZA");
//        System.out.println(ANSI_YELLOW);
//        System.out.println("HI");
    }
}
