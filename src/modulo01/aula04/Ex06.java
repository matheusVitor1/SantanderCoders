package aula04;

public class Ex06 {
    public static void main(String[] args) {
        double[][] inputs = {
                {2.5, 3.2, 4.5, 5, 6},
                {2.5, 2.5, 4.5, 6, 6},
                {1, 2, 4, 5, 6, 7, 7, 8, 8, 2, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 13, 14, 15},
                {1, 2, 3, 4, 9, 10, 11, 21, 20, 1, 31},
                {1},
                {1.55, 1.56, 1.57, 1.58, 1.59, 1.58},
                {1.55, 1.56, 1.57, 1.58, 1.59, 1.589},
                {1.5555, 1.565, 1.57, 1.58, 1.59, 1.5895},
        };

        boolean[] expectedOutputs = {
                false,
                true,
                true,
                false,
                true,
                false,
                true,
                false,
                false,
        };

        for (int i = 0; i < inputs.length; i++) {
            boolean result = elementosRepetidos(inputs[i]);
            boolean expected = expectedOutputs[i];

            System.out.println("Resultado: " + result);
            System.out.println("Esperado: " + expected);
            System.out.println(result == expected);
            System.out.println();
        }
    }

    public static boolean elementosRepetidos(double[] input) {
        int i = 0;
        while (i < input.length) {
            int j = i + 1;
            while (j < input.length) {
                if (input[i] == input[j]) {
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

}