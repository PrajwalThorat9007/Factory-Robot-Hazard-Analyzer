// UC6: Introduce Custom Exception – RobotSafetyException
// Author: Prajwal

import java.util.Scanner;

// Custom Exception Class
class RobotSafetyException extends Exception {

    // Constructor that passes message to parent Exception class
    public RobotSafetyException(String message) {
        super(message);
    }
}

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            // Input Collection
            System.out.print("Enter Arm Precision (0.1 - 1.0): ");
            double armPrecision = scanner.nextDouble();

            System.out.print("Enter Worker Density (1 - 100): ");
            int workerDensity = scanner.nextInt();

            scanner.nextLine(); // Clear buffer

            System.out.print("Enter Machinery State (Active/Idle/Maintenance): ");
            String machineryState = scanner.nextLine();

            // Method call that may throw exception
            double hazardRisk = calculateHazardRisk(
                    armPrecision, workerDensity, machineryState);

            System.out.println("\nHazard Risk Score: " + hazardRisk);

        } catch (RobotSafetyException e) {

            // Exception message displayed by exception itself
            System.out.println("Safety Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }

    // Method with validation + calculation
    // Declaring that it may throw RobotSafetyException
    public static double calculateHazardRisk(double armPrecision,
                                             int workerDensity,
                                             String machineryState)
            throws RobotSafetyException {

        // Validation Logic

        if (armPrecision <= 0 || armPrecision > 1) {
            throw new RobotSafetyException(
                    "Arm Precision must be between 0.1 and 1.0");
        }

        if (workerDensity <= 0 || workerDensity > 100) {
            throw new RobotSafetyException(
                    "Worker Density must be between 1 and 100");
        }

        if (!(machineryState.equalsIgnoreCase("Active") ||
                machineryState.equalsIgnoreCase("Idle") ||
                machineryState.equalsIgnoreCase("Maintenance"))) {

            throw new RobotSafetyException(
                    "Machinery State must be Active, Idle, or Maintenance");
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
