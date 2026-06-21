-- =========================================================================
-- PL/SQL Programming - Exercise 1: Control Structures
-- =========================================================================

SET SERVEROUTPUT ON;

-- =========================================================================
-- PART 1: SCHEMA SETUP & DUMMY DATA (For testing purposes)
-- =========================================================================

CREATE TABLE Customers (
                           CustomerID NUMBER PRIMARY KEY,
                           Name VARCHAR2(100),
                           DOB DATE,
                           Balance NUMBER,
                           IsVIP VARCHAR2(5)
);

CREATE TABLE Loans (
                       LoanID NUMBER PRIMARY KEY,
                       CustomerID NUMBER,
                       InterestRate NUMBER,
                       StartDate DATE,
                       EndDate DATE,
                       CONSTRAINT fk_customer
                           FOREIGN KEY (CustomerID)
                               REFERENCES Customers(CustomerID)
);

INSERT INTO Customers VALUES (1, 'Virat Kohli', TO_DATE('15-05-1950','DD-MM-YYYY'), 15000, 'FALSE');
INSERT INTO Customers VALUES (2, 'Ronaldo', TO_DATE('20-07-1990','DD-MM-YYYY'), 5000, 'FALSE');
INSERT INTO Customers VALUES (3, 'Messi', TO_DATE('10-03-1958','DD-MM-YYYY'), 12000, 'FALSE');

INSERT INTO Loans VALUES (101, 1, 7.5, SYSDATE - 100, SYSDATE + 15);
INSERT INTO Loans VALUES (102, 2, 6.0, SYSDATE - 50, SYSDATE + 60);
INSERT INTO Loans VALUES (103, 3, 8.0, SYSDATE - 75, SYSDATE + 20);

COMMIT;


-- -------------------------------------------------------------------------
-- Scenario 1: Apply discount to loan interest rates for customers above 60
-- -------------------------------------------------------------------------
DECLARE
v_age NUMBER;
BEGIN
FOR cust IN (
        SELECT c.CustomerID,
               c.DOB,
               l.LoanID
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
    )
    LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust.DOB)/12);

        IF v_age > 60 THEN
UPDATE Loans
SET InterestRate = InterestRate - 1
WHERE LoanID = cust.LoanID;
END IF;
END LOOP;

COMMIT;
DBMS_OUTPUT.PUT_LINE('Scenario 1 Completed');
END;
/

-- -------------------------------------------------------------------------
-- Scenario 2: Promote customer to VIP status based on balance > $10,000
-- -------------------------------------------------------------------------
DECLARE
BEGIN
FOR cust IN (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP
        IF cust.Balance > 10000 THEN
UPDATE Customers
SET IsVIP = 'TRUE'
WHERE CustomerID = cust.CustomerID;
END IF;
END LOOP;

COMMIT;
DBMS_OUTPUT.PUT_LINE('Scenario 2 Completed');
END;
/

-- -------------------------------------------------------------------------
-- Scenario 3: Send reminders for loans due within the next 30 days
-- -------------------------------------------------------------------------
BEGIN
FOR loan_rec IN (
        SELECT c.Name,
               l.LoanID,
               l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear '
            || loan_rec.Name
            || ', your loan '
            || loan_rec.LoanID
            || ' is due on '
            || TO_CHAR(loan_rec.EndDate,'DD-MON-YYYY')
        );
END LOOP;
END;
/