package modulo02.aula02;
import java.math.BigDecimal;
import java.util.Scanner;

public class TesteBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        while (true) {
            System.out.println("##### Menu #####");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Extrato");
            System.out.println("5. Encerrar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.print("Digite o email do cliente: ");
                    String enderecoCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente);

                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();
                    banco.criarConta(cliente, numeroConta);
                    System.out.println("Conta criada com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextLine();
                    System.out.print("Digite o valor a ser depositado: ");
                    BigDecimal valorDeposito = scanner.nextBigDecimal();
                    banco.depositar(numeroConta, valorDeposito);
                    break;

                case 3:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextLine();
                    System.out.print("Digite o valor a ser sacado: ");
                    BigDecimal valorSaque = scanner.nextBigDecimal();
                    banco.sacar(numeroConta, valorSaque);
                    break;

                case 4:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextLine();
                    banco.consultar(numeroConta);
                    break;

                case 5:
                    System.out.println("Encerrando o programa.");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
