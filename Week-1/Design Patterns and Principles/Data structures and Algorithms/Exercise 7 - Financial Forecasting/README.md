# Exercise 7: Financial Forecasting

## Objective
To predict future financial values based on historical growth rates using recursive algorithms, and to analyze the performance implications of the recursive approach.

## Scenario
In financial technology, projecting future values (like compound interest or revenue growth) is a common requirement. While these can be solved with simple loops or mathematical formulas, this exercise utilizes Recursion to demonstrate how a complex multi-year forecast can be broken down into smaller, self-contained single-year calculations.

## Technologies Used
* **Java 17**

## Folder Structure
```text
FinancialForecasting/
├── src/
│   └── com/
│       └── dsa/
│           └── recursion/
│               ├── FinancialForecasting.java
│               └── Analysis.txt
└── README.md

```

## Code Explanation

* **`FinancialForecasting.java`:** * **Recursive Method (`predictFutureValue`):** A method that calls itself.
* **Base Case:** `if (years == 0)` returns the current value, halting the recursion.
* **Recursive Step:** Calculates the value for one single year (`currentValue * (1 + growthRate)`), and then calls itself while decrementing the `years` parameter (`years - 1`).


* **`Analysis.txt`:** Contains the theoretical Big O complexity breakdown and strategies for preventing Stack Overflow errors in enterprise applications.

## Execution Output

```text
Starting Financial Forecasting Model...

Present Value: $10000.0
Expected Growth Rate: 5.0% per year
Forecast Period: 10 years

Predicted Future Value: $16288.95

Process finished with exit code 0

```

## Complexity Analysis & Optimization

Time Complexity: O(n) – The algorithm executes one operation for every year requested.
Space Complexity: O(n) – Because the method calls itself `n` times before resolving, it adds `n` frames to the system's Call Stack.
Optimization Strategy:** For massive values of `n`, this recursive approach risks a `StackOverflowError`. In a real-world enterprise system, this should be optimized by either:
1. Memoization: Caching previously calculated years so they don't need to be re-computed in complex overlapping recursive trees.
2. Iterative Conversion: Replacing the recursion with a standard `for` loop, which drastically drops the Space Complexity from O(n) to O(1).