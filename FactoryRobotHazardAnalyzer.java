// UC2 & UC3: Factory Robot Hazard Analyzer
// Author: Prajwal

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // Program entry point
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // UC2: Accept Robot Hazard Inputs

        System.out.print("Enter Arm Precision: ");
        double armPrecision = scanner.nextDouble();

        System.out.print("Enter Worker Density: ");
        int workerDensity = scanner.nextInt();

        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Machinery State: ");
        String machineryState = scanner.nextLine();

        // UC3: Calculate Hazard Risk Score

        double hazardRiskScore = calculateHazardRisk(armPrecision, workerDensity, machineryState);

        // Displaying calculated hazard risk score
        System.out.println("\n--- Hazard Analysis Result ---");
        System.out.println("Hazard Risk Score: " + hazardRiskScore);

        scanner.close();
    }

    // Method to calculate hazard risk score
    public static double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) {

        // Assign machinery risk factor based on state
        double machineryFactor;

        if (machineryState.equalsIgnoreCase("Active")) {
            machineryFactor = 1.5;
        } else if (machineryState.equalsIgnoreCase("Idle")) {
            machineryFactor = 1.0;
        } else {
            machineryFactor = 0.5;  // Maintenance or other states
        }

        // Business Logic Formula (Assumed Valid Inputs)
        double hazardRisk = (workerDensity * machineryFactor) / armPrecision;

        return hazardRisk;
    }
}
