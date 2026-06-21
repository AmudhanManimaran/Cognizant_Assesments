-- =========================================================================
-- PL/SQL Programming - Exercise 3: Stored Procedures
-- =========================================================================

SET SERVEROUTPUT ON;

-- =========================================================================
-- PART 1: SCHEMA SETUP and DUMMY DATA
-- =========================================================================

CREATE TABLE Accounts (
                          AccountID NUMBER PRIMARY KEY,
                          OwnerName VARCHAR2(100),
                          AccountType VARCHAR2(50),
                          Balance NUMBER,
                          LastModified DATE
);

CREATE TABLE Employees (
                           EmployeeID NUMBER PRIMARY KEY,
                           Name VARCHAR2(100),
                           Department VARCHAR2(50),
                           Salary NUMBER
);

-- Insert Account Data
INSERT INTO Accounts VALUES (101, 'Tony Stark', 'Savings', 50000, SYSDATE);
INSERT INTO Accounts VALUES (102, 'Bruce Wayne', 'Checking', 15000, SYSDATE);
INSERT INTO Accounts VALUES (103, 'Peter Parker', 'Savings', 500, SYSDATE);

-- Insert Employee Data
INSERT INTO Employees VALUES (1, 'Steve Jobs', 'Sales', 80000);
INSERT INTO Employees VALUES (2, 'Bill Gates', 'IT', 95000);
INSERT INTO Employees VALUES (3, 'Elon Musk', 'IT', 90000);

COMMIT;



-- -------------------------------------------------------------------------
-- Scenario 1: Process monthly interest for all savings accounts (1%)
-- -------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
UPDATE Accounts
SET Balance = Balance + (Balance * 0.01),
    LastModified = SYSDATE
WHERE AccountType = 'Savings';

COMMIT;
DBMS_OUTPUT.PUT_LINE('SUCCESS: 1% Monthly interest processed for all Savings accounts.');
END ProcessMonthlyInterest;
/

-- -------------------------------------------------------------------------
-- Scenario 2: Update employee salary based on a department bonus
-- -------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_dept IN VARCHAR2,
    p_bonus_pct IN NUMBER
) IS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * (p_bonus_pct / 100))
WHERE Department = p_dept;

COMMIT;
DBMS_OUTPUT.PUT_LINE('SUCCESS: ' || p_bonus_pct || '% bonus applied to ' || p_dept || ' department.');
END UpdateEmployeeBonus;
/

-- -------------------------------------------------------------------------
-- Scenario 3: Transfer funds safely between accounts
-- -------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_acc IN NUMBER,
    p_to_acc IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    -- Check balance of the source account and lock the row to prevent errors
SELECT Balance INTO v_balance
FROM Accounts
WHERE AccountID = p_from_acc
    FOR UPDATE;

-- Validate if there is enough money
IF v_balance >= p_amount THEN
        -- Deduct from sender
UPDATE Accounts
SET Balance = Balance - p_amount,
    LastModified = SYSDATE
WHERE AccountID = p_from_acc;

-- Add to receiver
UPDATE Accounts
SET Balance = Balance + p_amount,
    LastModified = SYSDATE
WHERE AccountID = p_to_acc;

COMMIT;
DBMS_OUTPUT.PUT_LINE('SUCCESS: Transferred $' || p_amount || ' from Account ' || p_from_acc || ' to Account ' || p_to_acc);

ELSE
        -- If not enough money, rollback
        DBMS_OUTPUT.PUT_LINE('ERROR: Transfer failed. Insufficient funds in Account ' || p_from_acc);
ROLLBACK;
END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Invalid Account ID provided.');
ROLLBACK;
END TransferFunds;
/

-- =========================================================================
-- PART 3: TEST EXECUTION BLOCK
-- =========================================================================
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Running Tests ---');
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('IT', 10);
    TransferFunds(101, 102, 5000);
    TransferFunds(103, 102, 10000);
END;
/