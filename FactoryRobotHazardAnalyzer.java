// UC8: Fully Modular & OOPS-Compliant Hazard Analyzer
// Author: Prajwal

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try {

            // Input Collection
            System.out.print("Enter Arm Precision (0.1 - 1.0): ");
            double armPrecision = scanner.nextDouble();

            System.out.print("Enter Worker Density (1 - 100): ");
            int workerDensity = scanner.nextInt();

            scanner.nextLine(); // Clear buffer

            System.out.print("Enter Machinery State (WORN/FAULTY/CRITICAL): ");
            String stateInput = scanner.nextLine();

            // Convert String to Enum (Type-Safe)
            MachineryState state = MachineryState.valueOf(stateInput);

            // Business Logic Call
            double hazardRisk = auditor.calculateHazardRisk(
                    armPrecision, workerDensity, state);

            System.out.println("\nHazard Risk Score: " + hazardRisk);

        } catch (IllegalArgumentException e) {
            System.out.println("Unsupported Machinery State. Allowed: WORN, FAULTY, CRITICAL");

        } catch (RobotSafetyException e) {
            System.out.println("Safety Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}


/* ================================
   Business Logic Class
   ================================ */
class RobotHazardAuditor {

    public double calculateHazardRisk(double armPrecision,
                                      int workerDensity,
                                      MachineryState state)
            throws RobotSafetyException {

        validateInputs(armPrecision, workerDensity);

        return (workerDensity * state.getRiskFactor()) / armPrecision;
    }

    private void validateInputs(double armPrecision, int workerDensity)
            throws RobotSafetyException {

        if (armPrecision <= 0 || armPrecision > 1) {
            throw new RobotSafetyException(
                    "Arm Precision must be between 0.1 and 1.0");
        }

        if (workerDensity <= 0 || workerDensity > 100) {
            throw new RobotSafetyException(
                    "Worker Density must be between 1 and 100");
        }
    }
}


/* ================================
   Enum for Machinery State
   ================================ */
enum MachineryState {

    WORN(1.2),
    FAULTY(1.6),
    CRITICAL(2.0);

    private final double riskFactor;

    MachineryState(double riskFactor) {
        this.riskFactor = riskFactor;
    }

    public double getRiskFactor() {
        return riskFactor;
    }
}


/* ================================
   Custom Exception Class
   ================================ */
class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
    }
}
