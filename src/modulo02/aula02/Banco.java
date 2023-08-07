package modulo02.aula02;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void criarConta(Cliente cliente, String numero) {
        Conta novaConta = new Conta(cliente, numero);
        contas.add(novaConta);
    }

    public Conta validarConta(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public boolean depositar(String numeroConta, BigDecimal valor) {
        Conta conta = validarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            return true;
        } else {
            System.out.println("Conta não encontrada.");
            return false;
        }
    }

    public void sacar(String numeroConta, BigDecimal valor) {
        Conta conta = validarConta(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void consultar(String numeroConta) {
        Conta conta = validarConta(numeroConta);
        if (conta != null) {
            System.out.println(conta.toString());
            Cliente cliente = conta.getCliente();
            if (cliente != null) {
                System.out.println(cliente.toString());
            } else {
                System.out.println("Cliente não encontrado para esta conta.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

}
