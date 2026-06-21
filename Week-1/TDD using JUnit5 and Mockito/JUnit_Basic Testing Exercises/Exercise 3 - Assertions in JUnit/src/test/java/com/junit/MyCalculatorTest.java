package com.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyCalculatorTest {

    @Test
    void testAdd() {
        MyCalculator calculator = new MyCalculator();
        int result = calculator.add(10, 5);
        assertEquals(15, result);
    }

    @Test
    void testSubtract() {
        MyCalculator calculator = new MyCalculator();
        int result = calculator.subtract(10, 5);
        assertEquals(5, result);
    }

    @Test
    void testMultiply() {
        MyCalculator calculator = new MyCalculator();
        int result = calculator.multiply(4, 3);
        assertEquals(12, result);
    }

    @Test
    void testDivide() {
        MyCalculator calculator = new MyCalculator();
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result);
    }

    @Test
    void testDivideByZero() {
        MyCalculator calculator = new MyCalculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}