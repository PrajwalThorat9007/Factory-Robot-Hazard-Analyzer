// UC4: Introduce Validation Using Conditional Logic
// Author: Prajwal

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Accept Inputs
        System.out.print("Enter Arm Precision (0.1 - 1.0): ");
        double armPrecision = scanner.nextDouble();

        System.out.print("Enter Worker Density (1 - 100): ");
        int workerDensity = scanner.nextInt();

        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Machinery State (Active/Idle/Maintenance): ");
        String machineryState = scanner.nextLine();

        // -----------------------------
        // Validation Using if-else
        // -----------------------------

        if (armPrecision <= 0 || armPrecision > 1) {
            System.out.println("Error: Arm Precision must be between 0.1 and 1.0");
        }
        else if (workerDensity <= 0 || workerDensity > 100) {
            System.out.println("Error: Worker Density must be between 1 and 100");
        }
        else if (!(machineryState.equalsIgnoreCase("Active") ||
                machineryState.equalsIgnoreCase("Idle") ||
                machineryState.equalsIgnoreCase("Maintenance"))) {

            System.out.println("Error: Machinery State must be Active, Idle, or Maintenance");
        }
        else {

            // If all inputs are valid → Calculate Risk

            double machineryFactor;

            if (machineryState.equalsIgnoreCase("Active")) {
                machineryFactor = 1.5;
            } else if (machineryState.equalsIgnoreCase("Idle")) {
                machineryFactor = 1.0;
            } else {
                machineryFactor = 0.5;
            }

            double hazardRisk = (workerDensity * machineryFactor) / armPrecision;

            System.out.println("\nHazard Risk Score: " + hazardRisk);
        }

        scanner.close();
    }
}
