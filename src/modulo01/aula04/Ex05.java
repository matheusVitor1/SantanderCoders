package aula04;
public class Ex05 {

    public static void main(String[] args) {
        String[] inputs = {
                "amor",
                "cocada",
                "mora",
                "ovo",
                "cachorro",
                "kaka",
                "saudades",
                "palalelepipedo",
                "fofocalizando",
                "papagaio",
                "ateiaateiab"
        };

        int[] expectedOutputs = {
                0,
                1,
                0,
                1,
                1,
                -1,
                2,
                9,
                4,
                4,
                10
        };

        for (int i = 0; i < inputs.length; i++) {
            double result = primeiroCaractereUnico(inputs[i]);
            double expected = expectedOutputs[i];

            System.out.println("Resultado: " + result);
            System.out.println("Esperado: " + expected);
            System.out.println(result == expected);
            System.out.println();
        }
    }

    public static int primeiroCaractereUnico(String input) {
        int[] frequenciaCaracteres = new int[256];

        for (char c : input.toCharArray()) {
            frequenciaCaracteres[c]++;
        }


        for (int i = 0; i < input.length(); i++) {
            if (frequenciaCaracteres[input.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
