// UC5: Refactor Validation into a Separate Method
// Author: Prajwal

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Collect Inputs
        System.out.print("Enter Arm Precision (0.1 - 1.0): ");
        double armPrecision = scanner.nextDouble();

        System.out.print("Enter Worker Density (1 - 100): ");
        int workerDensity = scanner.nextInt();

        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Machinery State (Active/Idle/Maintenance): ");
        String machineryState = scanner.nextLine();

        // Call separate method for validation + calculation
        double hazardRisk = calculateHazardRisk(armPrecision, workerDensity, machineryState);

        // Print result (only if valid)
        if (hazardRisk != -1) {
            System.out.println("\nHazard Risk Score: " + hazardRisk);
        }

        scanner.close();
    }

    // Method that handles both validation and hazard calculation
    public static double calculateHazardRisk(double armPrecision,
                                             int workerDensity,
                                             String machineryState) {

        // Input Validation
        if (armPrecision <= 0 || armPrecision > 1) {
            System.out.println("Error: Arm Precision must be between 0.1 and 1.0");
            return -1;
        }

        if (workerDensity <= 0 || workerDensity > 100) {
            System.out.println("Error: Worker Density must be between 1 and 100");
            return -1;
        }

        if (!(machineryState.equalsIgnoreCase("Active") ||
                machineryState.equalsIgnoreCase("Idle") ||
                machineryState.equalsIgnoreCase("Maintenance"))) {

            System.out.println("Error: Machinery State must be Active, Idle, or Maintenance");
            return -1;
        }

        // Assign machinery factor
        double machineryFactor;

        if (machineryState.equalsIgnoreCase("Active")) {
            machineryFactor = 1.5;
        } else if (machineryState.equalsIgnoreCase("Idle")) {
            machineryFactor = 1.0;
        } else {
            machineryFactor = 0.5;
        }

        // Business Logic Formula
        return (workerDensity * machineryFactor) / armPrecision;
    }
}
