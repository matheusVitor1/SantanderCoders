package aula04;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {

        double[][] inputs = {
                {1, 5.0, 2000.00},
                {11, 4.5, 2500.00},
                {5.1, 6.7, 4500.0},
                {1, 5.7, 4800.0},
                {10.1, 4.7, 4100.0},
                {15, 5.3, 6100.0},
                {2, 8.3, 9500.0},
                {20, 9.3, 10500.0},
                {0.5, 11.3, 4800.0},
                {5, 12.5, 6800.0},
                {10, 9.1, 8200.0}
        };

        double[] expectedOutputs = {
                2120.00,
                2662.50,
                4869.00,
                5121.60,
                4374.70,
                6545.30,
                10383.50,
                11686.50,
                5342.4,
                7752.00,
                9110.20
        };

        for (int i = 0; i < inputs.length; i++) {
            double result = calculoSalario(inputs[i]);
            double expected = expectedOutputs[i];

            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
            System.out.println(result == expected);
            System.out.println();
        }
    }

    public static double calculoSalario(double[] input) {
        int yearsOfService = (int) input[0];
        double inflation = input[1];
        double salary = input[2];

        double reajuste = 1.0;

        if (yearsOfService >= 1 && yearsOfService < 5) {
            reajuste = 1.01;
        } else if (yearsOfService >= 5 && yearsOfService < 10) {
            reajuste = 1.015;
        } else if (yearsOfService >= 10) {
            reajuste = 1.02;
        }

        double newSalary = salary * reajuste + (salary * (inflation / 100.0));

        return arredondar(newSalary);
    }

    public static double arredondar(double number) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(decimalFormat.format(number));
    }
}
