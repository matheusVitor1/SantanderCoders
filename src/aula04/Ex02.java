package aula04;

import java.text.DecimalFormat;

public class Ex02 {

    public static void processSalaryData(double[] inputData) {
        double yearsOfService = inputData[0];
        double inflationRate = inputData[1];
        double currentSalary = inputData[2];

        double inflationPercentage = calculateInflationPercentage(yearsOfService);

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(calculateNewSalary(inflationRate, currentSalary, inflationPercentage)));
    }

    public static double calculateInflationPercentage(double yearsOfService) {
        double percentage;

        if (yearsOfService >= 1 && yearsOfService < 5) {
            percentage = 0.01;
        } else if (yearsOfService >= 5 && yearsOfService < 10) {
            percentage = 0.015;
        } else if (yearsOfService >= 10) {
            percentage = 0.02;
        } else {
            percentage = 0;
        }

        return percentage;
    }

    public static double calculateNewSalary(double inflationRate, double currentSalary, double inflationPercentage) {
        double adjustment = inflationPercentage + (inflationRate / 100);
        double newSalary = currentSalary * (1 + adjustment);

        newSalary = Math.round(newSalary * 100.0) / 100.0;

        return newSalary;
    }

    public static void main(String[] args) {
        double[] inputData = {11, 4.5, 2500.0};
        processSalaryData(inputData);
    }
}
