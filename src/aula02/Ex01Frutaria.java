package aula02;

import java.util.Scanner;
public class Ex01Frutaria {

    /* Maria tem uma frutaria e está com ma promoção para quem comprar mais de 1- frutas do mesmo item. a tabela de preços das frutas com preços especiais são:

    Pera, laranja, maçã, tomate, caqui

    comprando qualquer fruta da promoção e levando acima de 10 unidades da mesma fruta o preço da unidade fica em 1.25, caso a pessoa leve uma quantidade inferior  o preço individual fica em 1.45

    faça uma função que recebe a quantidade de frutas e calcule o valor a ser pago, arredondado 2 casas decimais

    */
    public static double calcularValorFrutas(String fruta, int quantidade) {
        String[] frutasPromocao = {"Pera", "laranja", "maçã", "tomate", "caqui"};
        double valorUnitario;

        if (containsIgnoreCase(frutasPromocao, fruta)) {
            if (quantidade >= 10) {
                valorUnitario = 1.25;
            } else {
                valorUnitario = 1.45;
            }
        } else {
            valorUnitario = 1.45;
        }

        double valorTotal = valorUnitario * quantidade;
        valorTotal = Math.round(valorTotal * 100.0) / 100.0;

        return valorTotal;
    }

    public static boolean containsIgnoreCase(String[] array, String str) {
        for (String element : array) {
            if (element.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a fruta desejada: ");
        String fruta = scanner.nextLine();

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();

        double valorPago = calcularValorFrutas(fruta, quantidade);
        System.out.println("O valor a ser pago é: R$ " + valorPago);

        scanner.close();
    }
}
