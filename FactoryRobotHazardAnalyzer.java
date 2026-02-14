// UC7: Machinery State Risk Mapping
// Author: Prajwal

import java.util.Scanner;

// Custom Exception
class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
    }
}

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter Arm Precision (0.1 - 1.0): ");
            double armPrecision = scanner.nextDouble();

            System.out.print("Enter Worker Density (1 - 100): ");
            int workerDensity = scanner.nextInt();

            scanner.nextLine(); // Clear buffer

            System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
            String machineryState = scanner.nextLine();

            double hazardRisk = calculateHazardRisk(
                    armPrecision, workerDensity, machineryState);

            System.out.println("\nHazard Risk Score: " + hazardRisk);

        } catch (RobotSafetyException e) {

            System.out.println("Safety Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }

    // Hazard calculation method
    public static double calculateHazardRisk(double armPrecision,
                                             int workerDensity,
                                             String machineryState)
            throws RobotSafetyException {

        // Basic numeric validation
        if (armPrecision <= 0 || armPrecision > 1) {
            throw new RobotSafetyException(
                    "Arm Precision must be between 0.1 and 1.0");
        }

        if (workerDensity <= 0 || workerDensity > 100) {
            throw new RobotSafetyException(
                    "Worker Density must be between 1 and 100");
        }

        // Business rule encapsulation
        double machineryFactor = getMachineryRiskFactor(machineryState);

        return (workerDensity * machineryFactor) / armPrecision;
    }

    // Dedicated mapping method (structured logic)
    private static double getMachineryRiskFactor(String machineryState)
            throws RobotSafetyException {

        // Case-sensitive comparison (strict control)
        if (machineryState.equals("Worn")) {
            return 1.2;
        } else if (machineryState.equals("Faulty")) {
            return 1.6;
        } else if (machineryState.equals("Critical")) {
            return 2.0;
        } else {
            throw new RobotSafetyException(
                    "Unsupported Machinery State. Allowed: Worn, Faulty, Critical");
        }
    }
}
