package aula04;

public class Ex03 {
    public static double calculaNotas (double[] input){
        double n1 = input[0];
        double n2 = input[1];
        double n3 = input[2];
        double mediaExercicios = input[3];

        double mediaAproveitamento = (n1 + (n2*2) + (n3*3) + mediaExercicios) / 7;

        return mediaAproveitamento;
    }

    public static void verificaConceito (double[] input){
        double mediaAproveitamento = calculaNotas(input);

        if(mediaAproveitamento >= 9){
            System.out.println("A");
        } else if (mediaAproveitamento >= 7.5 && mediaAproveitamento < 9){
            System.out.println("B");
        } else if (mediaAproveitamento >= 6 && mediaAproveitamento < 7.5){
            System.out.println("C");
        } else {
            System.out.println("D");
        }

    }

    public static void main(String[] args) {
        double[] inputData = {5.0, 4.3, 8.0, 7.0};
        verificaConceito(inputData);
    }
}
