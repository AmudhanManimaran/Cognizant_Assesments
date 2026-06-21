# Exercise 1: Setting Up JUnit

## Objective
To initialize a Java Maven project, configure modern testing dependencies, and establish a foundational test class to verify business logic.

## Scenario
Before Test-Driven Development (TDD) can begin, a robust testing environment must be configured. This exercise demonstrates how to set up a project to write and execute unit tests. 
*Note: While the original requirements suggested using legacy JUnit 4, this implementation proactively utilizes modern **JUnit 5 (Jupiter)** to align with current enterprise standards.*

## Technologies Used
* **Java 17**
* **Maven** (Build & Dependency Management)
* **JUnit 5 (Jupiter)** ## Folder Structure
```text
Exercise 1 - Setting Up JUnit/
├── pom.xml
├── src/
│   ├── main/java/com/junit/
│   │   └── MyCalculator.java
│   └── test/java/com/junit/
│       └── MyCalculatorTest.java
└── README.md

```

## Code Explanation

* **`pom.xml`:** Configured with `junit-jupiter-api` and `junit-jupiter-engine` (v5.10.0) alongside the `maven-surefire-plugin` to ensure tests compile and run during the build lifecycle.
* **`MyCalculator.java`:** The core application logic containing basic arithmetic operations, including boundary handling (throwing an `ArithmeticException` when dividing by zero).
* **`MyCalculatorTest.java`:** The test suite. It utilizes the `@Test` annotation to independently verify each mathematical operation using `assertEquals`, and employs `assertThrows` to cleanly verify the exception handling without failing the test suite.

## Execution Output

Based on the execution results:

```text
Test Results:
✓ testAdd()
✓ testDivide()
✓ testDivideByZero()
✓ testMultiply()
✓ testSubtract()

Tests passed: 5 of 5 tests
Process finished with exit code 0

```

## Learning Outcome

Successfully demonstrated the configuration of a Maven-based testing environment using JUnit 5. Validated the setup by writing and executing a comprehensive suite of passing unit tests, including proper assertion of expected exception throwing.
