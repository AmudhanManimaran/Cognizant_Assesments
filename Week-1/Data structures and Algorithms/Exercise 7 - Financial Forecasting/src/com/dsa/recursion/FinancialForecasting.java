package com.dsa.recursion;

public class FinancialForecasting {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years==0) {
            return currentValue;
        }

        double nextYearValue=currentValue * (1 + growthRate);
        return predictFutureValue(nextYearValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        System.out.println("Starting Financial Forecasting Model...\n");

        double presentValue=10000.00;
        double pastAverageGrowthRate=0.05;
        int yearsToForecast=10;

        System.out.println("Present Value: $" + presentValue);
        System.out.println("Expected Growth Rate: " + (pastAverageGrowthRate * 100) + "% per year");
        System.out.println("Forecast Period: " + yearsToForecast + " years\n");

        double futureValue = predictFutureValue(presentValue, pastAverageGrowthRate, yearsToForecast);

        System.out.printf("Predicted Future Value: $%.2f\n", futureValue);
    }
}