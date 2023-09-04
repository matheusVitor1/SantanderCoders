package aula03;

public class Ex0305 {
    public static boolean elementosRepetidos(double[] input) {

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {

                    return true;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        double array[] = { 5.1, 5.1,
                6.7,
                4500};

        boolean result = elementosRepetidos(array);

        System.out.println(result);
    }
}
