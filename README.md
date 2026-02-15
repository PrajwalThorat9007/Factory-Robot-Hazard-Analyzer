# Factory Robot Hazard Analyzer

A modular, OOPS-compliant Java application that evaluates industrial robot hazard risk based on operational parameters.

This project demonstrates clean architecture principles including encapsulation, modularity, exception handling, and enum-based state management — all implemented in a single Java file.

---

## Project Objective

To design a structured and extensible hazard analysis system that:

- Accepts robot operational inputs
- Validates input ranges
- Maps machinery condition to risk factor
- Calculates hazard risk score
- Handles invalid scenarios using a custom exception

---

## Supported Machinery States

| State     | Risk Factor |
|-----------|------------|
| WORN      | 1.2        |
| FAULTY    | 1.6        |
| CRITICAL  | 2.0        |

Only the above states are supported.  
Any unsupported state throws a custom exception.

---

## Hazard Risk Formula

```
Hazard Risk Score = (Worker Density × Risk Factor) / Arm Precision
```

---

## Architecture Design (Single File – Modular)

```
FactoryRobotHazardAnalyzer.java
 ├── FactoryRobotHazardAnalyzer  → User Interaction
 ├── RobotHazardAuditor         → Business Logic
 ├── MachineryState (Enum)      → Risk Mapping
 └── RobotSafetyException       → Custom Exception
```

---

## OOPS Principles Demonstrated

### Encapsulation
- Risk factors stored inside enum
- Validation hidden inside auditor class

### Abstraction
- User interacts via:
  calculateHazardRisk(...)

### Single Responsibility Principle
Each class handles exactly one responsibility.

### Extensibility
To add a new machinery state:

```
MODERATE(1.4),
```

No modification required in calculation logic.

---

## Exception Handling

Custom exception used:

```
class RobotSafetyException extends Exception
```

- Thrown for invalid precision or density
- Thrown for unsupported machinery states
- Caught and handled cleanly in main()

---

## How to Compile and Run

### Step 1: Compile
```
javac FactoryRobotHazardAnalyzer.java
```

### Step 2: Run
```
java FactoryRobotHazardAnalyzer
```

---

## Sample Input

```
Enter Arm Precision (0.1 - 1.0): 0.8
Enter Worker Density (1 - 100): 20
Enter Machinery State (WORN/FAULTY/CRITICAL): FAULTY
```

## Sample Output

```
Hazard Risk Score: 40.0
```

---

## Technologies Used

- Java
- OOPS Principles
- Enum-based Design
- Custom Exception Handling

---

## Key Learning Outcomes

- Method abstraction
- Exception-based validation
- Enum for type safety
- Clean modular architecture
- Enterprise-style design thinking

---

## Git Commit Convention Used

```
[Prajwal]:UC8:Implemented modular OOPS hazard analyzer in single Java file
```

---


