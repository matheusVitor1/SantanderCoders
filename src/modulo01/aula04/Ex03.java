package Aula4;

public class Ex03 {
    public static void main(String[] args) {
        double[][] inputs = {
                {8.0, 7.0, 8.0, 8.0},
                {5.0, 4.3, 8.0, 7.0},
                {2.0, 5.0, 8.0, 6.0},
                {4.0, 1.0, 9.0, 7.0},
                {2.0, 2.0, 10.0, 1.0},
                {2.9, 2.5, 10.0, 7.1},
                {4.4, 4.1, 8.5, 9.5},
                {5.0, 7.0, 9.0, 8.0},
                {8.0, 7.0, 8.0, 9.0},
                {8.0, 8.0, 10.0, 9.0},
                {2.0, 2.0, 5.0, 1.0}
        };

        String[] expectedOutputs = {
                "B",
                "C",
                "C",
                "D",
                "D",
                "C",
                "C",
                "B",
                "B",
                "A",
                "D"
        };

        for (int i = 0; i < inputs.length; i++) {
            String result = mediaAproveitamento(inputs[i]);
            String expected = expectedOutputs[i];

            System.out.println("Resultado: " + result);
            System.out.println("Esperado: " + expected);
            System.out.println(result.equals(expected));
            System.out.println();
        }
    }

    public static String mediaAproveitamento(double[] notas) {

        double mediaAproveitamento = (notas[0] * 1.0 + notas[1] * 2.0 + notas[2] * 3.0 + notas[3] * 1.0) / 7.0;

        if (mediaAproveitamento < 6.0) {
            return "D";
        } else if (mediaAproveitamento < 7.5) {
            return "C";
        } else if (mediaAproveitamento < 9.0) {
            return "B";
        } else {
            return "A";
        }
    }
}