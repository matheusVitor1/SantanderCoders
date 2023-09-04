package aula04;

public class Ex04 {
    public static void main(String[] args) {
        int[][] inputs = {
                {5, 6, 12},
                {10, 8, 13},
                {21, 10, 25},
                {0, 10, 2},
                {102, 0, 10},
                {28, 11, 10},
                {55, 1, 15},
                {78, 8, 0},
                {0, 0, 15}
        };

        int[] expectedOutputs = {
                2017,
                3903,
                7990,
                302,
                37240,
                10560,
                20120,
                28710,
                15
        };

        for (int i = 0; i < inputs.length; i++) {
            int result = idadeEmDias(inputs[i]);
            int expected = expectedOutputs[i];

            System.out.println("Resultado: " + result);
            System.out.println("Esperado: " + expected);
            System.out.println(result == expected);
            System.out.println();
        }
    }

    public static int idadeEmDias(int[] input) {
        return input[0]*365 + input[1]*30 + input[2];
    }
}