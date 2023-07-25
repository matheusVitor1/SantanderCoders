package aula06;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
public class Ex01 {

    public enum Estado{
        MG, SP, RJ
    }
    public static void main(String[] args) {

        System.out.println(valorProdutoFinal(250.10, Estado.MG) == 267.607);
        System.out.println(valorProdutoFinal(250.10, Estado.RJ) == 287.615);
        System.out.println(valorProdutoFinal(250.10, Estado.SP) == 280.112);
    }

    public static double valorProdutoFinal(double valorProduto, Estado estado) {
        double taxaImposto = 0.0;

        switch (estado) {
            case MG:
                taxaImposto = 0.07; // 7%
                break;
            case SP:
                taxaImposto = 0.12; // 12%
                break;
            case RJ:
                taxaImposto = 0.15; // 15%
                break;
            default:
                System.out.println("Estado inválido.");
                return 0.0;
        }

        double precoFinal = valorProduto * (1 + taxaImposto);
        return arredondar(precoFinal);
    }

    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.####", symbols);
        return Double.parseDouble(decimalFormat.format(numero));
    }
}
