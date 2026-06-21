# Exercise 4: Arrange-Act-Assert (AAA) Pattern & Test Fixtures

## Objective
To structure unit tests for maximum readability using the Arrange-Act-Assert (AAA) pattern and to ensure strict test isolation by utilizing Setup and Teardown lifecycle methods.

## Scenario
As test suites grow, managing object instantiation inside every single test leads to code duplication and potential state-sharing bugs. By utilizing test fixtures (Setup/Teardown methods), we can automatically provide a fresh, isolated environment for every test. 

To provide the strongest possible implementation, this project includes two variations:
1. **JUnit 4 Implementation:** Fulfills the exact legacy requirements of the exercise using `@Before` and `@After`.
2. **JUnit 5 Implementation:** Demonstrates the modern enterprise standard equivalent using `@BeforeEach` and `@AfterEach`.

## Technologies Used
* **Java 17**
* **Maven**
* **JUnit 4** (Legacy Lifecycle Hooks)
* **JUnit 5 Jupiter** (Modern Lifecycle Hooks)

## Folder Structure
```text
JUnitBasicTesting/
├── pom.xml
├── src/
│   ├── main/java/com/junit/
│   │   └── MyCalculator.java
│   └── test/java/com/junit/
│       ├── MyCalculatorTest.java
│       ├── AssertionsTest.java
│       ├── MyCalculatorAAATest.java          (JUnit 4 Version)
│       └── MyCalculatorAAAJUnit5Test.java    (JUnit 5 Version)
└── README.md

```

## Code Explanation

* **Test Fixtures (Setup & Teardown):** * The `setUp()` method initializes a fresh instance of `MyCalculator` before every individual test executes. This guarantees **Test Isolation** (no test inherits modified data from a previous test).
* The `tearDown()` method acts as the cleanup hook, nullifying the instance after the test completes.


* **Arrange-Act-Assert (AAA) Pattern:** Inside the test methods, the code is structurally divided into three distinct phases to maximize readability:
1. **Arrange:** Initialize input variables and set up expected conditions.
2. **Act:** Execute the specific method being tested.
3. **Assert:** Verify that the actual result matches the expected outcome.


* **Exception Testing Difference:** Demonstrates JUnit 4's `@Test(expected = ArithmeticException.class)` versus JUnit 5's cleaner `assertThrows()` lambda approach.

## Execution Output

```text
Setup: MyCalculator instance created.
Teardown: MyCalculator instance destroyed.
Setup: MyCalculator instance created.
Teardown: MyCalculator instance destroyed.
Setup: MyCalculator instance created.
Teardown: MyCalculator instance destroyed.
Setup: MyCalculator instance created.
Teardown: MyCalculator instance destroyed.
Setup: MyCalculator instance created.
Teardown: MyCalculator instance destroyed.

Tests passed: 5 of 5 tests
Process finished with exit code 0

```

## Result Analysis

The console output explicitly proves that the lifecycle hooks are functioning correctly. The setup and teardown print statements wrap around every individual test execution, completely isolating each operation. This ensures that the state of `MyCalculator` is entirely reset, preventing side effects and flaky tests.
