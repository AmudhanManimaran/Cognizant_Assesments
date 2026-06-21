package com.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyCalculatorAAATestJUnit5 {

    private MyCalculator calculator;

    @BeforeEach
    void setUp() {
        // Runs before every test method
        calculator = new MyCalculator();
        System.out.println("Setup: MyCalculator instance created.");
    }

    @AfterEach
    void tearDown() {
        // Runs after every test method
        calculator = null;
        System.out.println("Teardown: MyCalculator instance destroyed.");
    }

    @Test
    void testAdd() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void testSubtract() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(7, result);
    }

    @Test
    void testMultiply() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(20, result);
    }

    @Test
    void testDivide() {
        // Arrange
        int a = 10;
        int b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(5.0, result);
    }

    @Test
    void testDivideByZero() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act and Assert
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }
}