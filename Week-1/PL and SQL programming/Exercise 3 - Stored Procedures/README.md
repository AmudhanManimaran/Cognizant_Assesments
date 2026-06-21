# Exercise 3: PL/SQL Stored Procedures

## Objective
To encapsulate complex business logic—such as account transactions, interest calculations, and employee bonuses—into reusable, secure, and transaction-safe PL/SQL Stored Procedures.

## Scenario
In a banking system, database operations often require multiple steps that must be executed securely and consistently. This exercise demonstrates automating routine batch jobs (applying interest and bonuses) and handling highly sensitive operations (transferring money). The fund transfer specifically highlights the need for atomic transactions—meaning either all steps succeed together, or none do, ensuring no money is lost if an error occurs.

## Technologies Used
* **Oracle PL/SQL**
* **Oracle Database**

## Folder Structure
```text
Exercise 3 - Stored Procedures/
├── Exercise3_StoredProcedures.sql
└── README.md

```

## Code Explanation

* **Schema Setup:** Creates the `Accounts` and `Employees` tables and populates them with initial dummy data.
* **Batch Update Procedures:** * Safely applies a 1% monthly interest rate to all accounts marked as 'Savings'.
* Distributes a 10% bonus to the salaries of all employees within the 'IT' department.


* **`TransferFunds` Procedure:**
* **Input Parameters:** Accepts the sender's account ID, the receiver's account ID, and the transfer amount.
* **Row Locking:** Uses `SELECT ... FOR UPDATE` when checking the sender's balance. This places an exclusive lock on that specific row, preventing other concurrent transactions from modifying it until this transfer is complete.
* **Validation & Execution:** Checks if the sender has sufficient funds. If `TRUE`, it executes the `UPDATE` statements for both accounts.
* **Transaction Control (TCL):** Issues a `COMMIT` to permanently save the changes if everything succeeds. If funds are insufficient, it issues a `ROLLBACK` to safely undo any partial changes.



## Execution Output

```text
--- Running Tests ---
SUCCESS: 1% Monthly interest processed for all Savings accounts.
SUCCESS: 10% bonus applied to IT department.
SUCCESS: Transferred $5000 from Account 101 to Account 102
ERROR: Transfer failed. Insufficient funds in Account 103

PL/SQL procedure successfully completed.

```

## Learning Outcome

Successfully demonstrated how to enforce ACID (Atomicity, Consistency, Isolation, Durability) database properties. By utilizing Stored Procedures, row-level locking, and strict Exception Handling, the database automates routine financial batch jobs while remaining protected against race conditions and partial transaction failures.
