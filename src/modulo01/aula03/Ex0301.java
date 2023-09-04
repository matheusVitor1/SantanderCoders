package aula03;

public class Ex0301 {


        public static double custoCompra(double input) {
            double valorUnitario;

            if (input >= 10) {
                valorUnitario = 1.25;
            } else {
                valorUnitario = 1.45;
            }
            double valorTotal = valorUnitario * input;
            valorTotal = Math.round(valorTotal * 100.0) / 100.0;

            return valorTotal;
        }


    public static void main(String[] args) {

        System.out.println(custoCompra(12));

    }
}
