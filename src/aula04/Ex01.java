package aula04;
import java.text.DecimalFormat;

public class Ex01 {
    public static double[] custosCarro(double[] input) {

        double vFabrica = input[0];
        double vDistri = input[1];
        double vImp = input[2];

        double percentualDistribuidor = (vDistri / vFabrica) * 100;
        double percentualImpostos = (vImp / vFabrica) * 100;

        percentualDistribuidor = Math.round(percentualDistribuidor * 100.0) / 100.0;
        percentualImpostos = Math.round(percentualImpostos * 100.0) / 100.0;

        return new double[]{percentualDistribuidor, percentualImpostos};
    }


        public static void main(String[] args) {
            double[] valoresEntrada = {10000.00, 2000.00, 1500.00};
            double[] percentuais = custosCarro(valoresEntrada);
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(percentuais[0]));
            System.out.println(df.format(percentuais[1]));
        }

}
