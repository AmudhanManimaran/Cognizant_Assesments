# Exercise 3: Assertions in JUnit

## Objective
To utilize and understand various JUnit assertion methods for validating expected outcomes, boolean conditions, and object states in unit tests.

## Scenario
Unit testing goes beyond simple equality checks. A robust test suite must verify that certain conditions are strictly true or false, and ensure that objects are instantiated correctly (or remain null when expected). This exercise demonstrates how to use JUnit's built-in assertion library to validate these different types of logic states.

## Technologies Used
* **Java 17**
* **Maven** * **JUnit 5 (Jupiter)** ## Folder Structure
```text
Exercise 3 - Assertions in JUnit/
├── pom.xml
├── src/
│   ├── main/java/com/junit/
│   │   └── MyCalculator.java
│   └── test/java/com/junit/
│       ├── AssertionsTest.java
│       └── MyCalculatorTest.java
└── README.md

```

## Code Explanation

* **`AssertionsTest.java`:** A dedicated test class demonstrating five distinct assertion methods:
* `assertEquals(expected, actual)`: Verifies that two values are mathematically or structurally identical.
* `assertTrue(condition)`: Validates that a specific boolean expression resolves to `true`.
* `assertFalse(condition)`: Validates that a specific boolean expression resolves to `false`.
* `assertNull(object)`: Confirms that an object reference points to exactly `null`.
* `assertNotNull(object)`: Confirms that an object has been properly instantiated and is not `null`.



## Execution Output

```text
Test Results:
✓ testAssertions()
✓ testAdd()
✓ testDivide()
✓ testDivideByZero()
✓ testMultiply()
✓ testSubtract()

Tests passed: 6 of 6 tests
Process finished with exit code 0

```

## Learning Outcome

Successfully demonstrated the application of diverse JUnit assertions to validate multiple data types and logic conditions. By integrating this new test class into the existing test suite, the project successfully executed a comprehensive, multi-class test run.
