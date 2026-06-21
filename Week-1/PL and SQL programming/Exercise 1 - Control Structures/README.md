# Exercise 1: PL/SQL Control Structures

## Objective
To utilize PL/SQL control structures (loops, conditional `IF` statements, and cursors) to automate banking operations such as updating interest rates, modifying customer statuses, and generating targeted notifications.

## Scenario
A banking system requires automated batch processes to manage its customer and loan portfolios. Instead of manually updating records, the database needs scheduled PL/SQL blocks that apply business rules automatically: discounting loans for senior citizens, upgrading high-balance accounts to VIP status, and sending out 30-day loan repayment reminders.

## Technologies Used
* **Oracle PL/SQL**
* **Oracle Database**

## Folder Structure
```text
Exercise 1 - Control Structures/
├── Exercise1_ControlStructures.sql
└── README.md

```

## Code Explanation

* **Schema Setup:** Creates the `Customers` and `Loans` tables with a Primary/Foreign key relationship and inserts dummy data to test the logic.
* **Scenario 1 (Senior Citizen Discount):** Uses a `FOR` loop to iterate over a cursor joining customers and their loans. Calculates the age using `MONTHS_BETWEEN` and `SYSDATE`. An `IF` condition triggers an `UPDATE` to decrease the `InterestRate` by 1 for users over 60.
* **Scenario 2 (VIP Promotion):** Iterates through all customers. Checks `IF Balance > 10000`, and if true, executes an `UPDATE` statement setting the `IsVIP` flag to `'TRUE'`.
* **Scenario 3 (Due Date Reminders):** Joins `Customers` and `Loans` to find records where the `EndDate` falls `BETWEEN SYSDATE AND SYSDATE + 30`. Iterates through the results and uses `DBMS_OUTPUT.PUT_LINE` to print a formatted reminder message to the console.

## Execution Output

```text
Table CUSTOMERS created.
Table LOANS created.

Scenario 1 Completed

Scenario 2 Completed

Reminder: Dear Virat Kohli, your loan 101 is due on 06-JUL-2026
Reminder: Dear Messi, your loan 103 is due on 11-JUL-2026

PL/SQL procedure successfully completed.

```

## Learning Outcome

Successfully demonstrated how to write anonymous PL/SQL blocks using cursor `FOR` loops to process multiple records, apply conditional business logic using `IF/THEN` statements, and execute Data Manipulation Language (DML) operations seamlessly within the database layer.
