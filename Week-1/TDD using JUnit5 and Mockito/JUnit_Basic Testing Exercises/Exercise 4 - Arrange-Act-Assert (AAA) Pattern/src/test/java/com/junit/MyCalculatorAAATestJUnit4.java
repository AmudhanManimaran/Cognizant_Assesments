package com.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyCalculatorAAATestJUnit4 {

    private MyCalculator calculator;

    @Before
    public void setUp() {
        // Runs before every test method
        calculator = new MyCalculator();
        System.out.println("Setup: MyCalculator instance created.");
    }

    @After
    public void tearDown() {
        // Runs after every test method
        calculator = null;
        System.out.println("Teardown: MyCalculator instance destroyed.");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(7, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(20, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 10;
        int b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(5.0, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act
        calculator.divide(a, b);

        // Assert — handled by @Test(expected = ArithmeticException.class)
    }
}