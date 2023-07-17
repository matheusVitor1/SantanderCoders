package aula03;

public class Ex0304 {

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
    public static void main(String[] args) {

        System.out.println(primeiroCaractereUnico("aamor"));

    }
}
