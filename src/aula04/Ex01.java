package aula04;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        double[][] inputs = {
                {100000.00, 12000.00, 20000.00},
                {115500.00, 25000.00, 32500.00},
                {121000.0, 14350.0, 21450.0},
                {238500.0, 18350.0, 32450.0},
                {53000.0, 2350.0, 8450.0},
                {1250000.0, 124550.0, 225450.0},
                {145000.0, 12550.0, 22450.0},
                {173000.0, 12450.0, 22540.0},
                {111000.0, 12455.0, 22550.0},
                {123000.0, 8550.0, 25450.0},
                {92000.0, 5450.0, 16450.0}
        };

        double[][] expectedOutputs = {
                {12.00, 20.00},
                {21.65, 28.14},
                {11.86, 17.73},
                {7.69, 13.61},
                {4.43, 15.94},
                {9.96, 18.04},
                {8.66, 15.48},
                {7.20, 13.03},
                {11.22, 20.32},
                {6.95, 20.69},
                {5.92, 17.88}
        };

        for (int i = 0; i < inputs.length; i++) {
            double[] result = carCosts(inputs[i]);
            double[] expected = expectedOutputs[i];

            System.out.println("Result: " + Arrays.toString(result));
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println(Arrays.equals(result, expected));
            System.out.println();
        }
    }

    public static double[] carCosts(double[] input) {
        double distriPercentage = input[1] / input[0] * 10000;
        double tax = input[2] / input[0] * 10000;

        return new double[]{round(distriPercentage), round(tax)};
    }

    public static double round(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##");
        return Double.parseDouble(decimalFormat.format(number));
    }
}
