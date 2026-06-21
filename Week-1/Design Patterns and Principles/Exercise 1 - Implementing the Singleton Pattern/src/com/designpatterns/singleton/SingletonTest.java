package com.designpatterns.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        System.out.println("Starting Singleton Pattern Test...\n");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Application started...");
        logger2.log("Processing data...");

        System.out.println("\nVerification: ");
        System.out.println("Same instance: " + (logger1 == logger2));

        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 share the same memory reference.");
            System.out.println("Hashcode of logger1: " + logger1.hashCode());
            System.out.println("Hashcode of logger2: " + logger2.hashCode());
        } else {
            System.out.println("Failure: Multiple instances were created.");
        }
    }
}