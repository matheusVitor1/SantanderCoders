package aula03;

public class Ex0303 {

    public static double calculoSalario(double[] input) {
        double tempoServico = input[0];
        double inflacao = input[1];
        double salario = input[2];
        double percent;

        if (tempoServico >= 1 && tempoServico < 5) {
            percent = 0.01;
        } else if (tempoServico >= 5 && tempoServico < 10) {
            percent = 0.015;
        } else if (tempoServico >= 10) {
            percent = 0.02;
        } else {
            percent = 0;
        }

        double reajuste = percent + (inflacao / 100);
        double novoSalario = salario * (1 + reajuste);


        novoSalario = Math.round(novoSalario * 100.0) / 100.0;

        return novoSalario;
    }
    public static void main(String[] args) {
        double array[] = {  5.1,
                6.7,
                4500};

        double result = calculoSalario(array);

        System.out.println(result);

    }
}
