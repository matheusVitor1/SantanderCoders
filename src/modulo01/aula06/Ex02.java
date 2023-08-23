package aula06;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
public class Ex02 {

    public enum Estado{
        MG(0.07), SP(0.12), RJ(0.15);
        private double taxa;
        Estado(double taxa){
            this.taxa = taxa;
        }
        public double getTaxa(){
            return taxa;
        }

    }
    public static void main(String[] args) throws EstadoInvalidoException {

        System.out.println(valorProdutoFinal(250.10, "MG") == 267.607);
        System.out.println(valorProdutoFinal(250.10, "RJ") == 287.615);
        System.out.println(valorProdutoFinal(250.10, "SP") == 280.112);

        try {
            valorProdutoFinal(250.10, "DF");
        } catch (EstadoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    public static double valorProdutoFinal(double valorProduto, String estadoDestino) throws EstadoInvalidoException {
        Estado estado = null;

        for (Estado e : Estado.values()) {
            if (e.name().equalsIgnoreCase(estadoDestino)) {
                estado = e;
                break;
            }
        }

        if (estado == null) {
            throw new EstadoInvalidoException("Estado inválido fornecido: " + estadoDestino);
        }

        return arredondar(valorProduto * (1.0 + estado.getTaxa()));
    }


    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.####", symbols);
        return Double.parseDouble(decimalFormat.format(numero));
    }


}
