package aula03;

public class Ex0302 {

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
        double array[] = {  121000,
                14350,
                21450};

        double[] result = custosCarro(array);

        System.out.println("Percentual Distribuidor: " + result[0] + "%");
        System.out.println("Percentual Impostos: " + result[1] + "%");
    }
}
