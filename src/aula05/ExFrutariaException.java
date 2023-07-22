package aula05;

import java.util.Scanner;

public class ExFrutariaException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a fruta desejada: ");
        String fruta = scanner.nextLine();

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();

        try {
            double valorPago = calcularValorFrutas(fruta, quantidade);
            System.out.println("O valor a ser pago é: R$ " + valorPago);
        } catch (QuantidadeFrutasInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }
    public static double calcularValorFrutas(String fruta, int quantidade) throws QuantidadeFrutasInvalidaException {

        double valorUnitario = verificaQuantidade(quantidade, fruta);

        double valorTotal = valorUnitario * quantidade;
        valorTotal = Math.round(valorTotal * 100.0) / 100.0;

        return valorTotal;
    }

    public static double verificaQuantidade (int quantidade, String fruta) throws QuantidadeFrutasInvalidaException{

        String[] frutasPromocao = {"Pera", "laranja", "maçã", "tomate", "caqui"};
        double valorUnitario;
        if (containsIgnoreCase(frutasPromocao, fruta)) {
            if (quantidade >= 10) {
                valorUnitario = 1.25;
            } else if (quantidade < 10 && quantidade > 0){
                valorUnitario = 1.45;
            } else if (quantidade == 0 ){
                throw new QuantidadeFrutasInvalidaException("A quantidade de frutas nao pode ser 0");
            } else {
                throw new QuantidadeFrutasInvalidaException("A quantidade não pode ser negativa");
            }
        } else {
            valorUnitario = 1.43;
        }
        return valorUnitario;
    }
    public static boolean containsIgnoreCase(String[] array, String str) {
        for (String element : array) {
            if (element.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }


}


