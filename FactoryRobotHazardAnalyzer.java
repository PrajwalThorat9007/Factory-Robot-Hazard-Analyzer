// UC2: Accept Robot Hazard Inputs
// Author: Prajwal

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // Program entry point
    public static void main(String[] args) {

        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Taking arm precision input (double)
        System.out.print("Enter Arm Precision: ");
        double armPrecision = scanner.nextDouble();

        // Taking worker density input (int)
        System.out.print("Enter Worker Density: ");
        int workerDensity = scanner.nextInt();

        // Clearing buffer before taking String input
        scanner.nextLine();

        // Taking machinery state input (String)
        System.out.print("Enter Machinery State: ");
        String machineryState = scanner.nextLine();

        // Echoing back the entered inputs
        System.out.println("\n--- Entered Hazard Parameters ---");
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        // Closing scanner
        scanner.close();
    }
}
