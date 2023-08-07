package modulo02.aula02;

import java.math.BigDecimal;

public class Conta {
    private Cliente cliente;
    private String numero;
    private BigDecimal saldo;

    public Conta (Cliente cliente, String numero){
        this.cliente = cliente;
        this.numero = numero;
        this.saldo = BigDecimal.ZERO;
    }

    public Cliente getCliente(){
        return cliente;
    }
    public String getNumero(){
        return numero;
    }
    public void depositar (BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public void sacar (BigDecimal valor){
        if (saldo.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Conta conta = (Conta) obj;
        return numero.equals(cliente.cpf);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", saldo='" + saldo + '\'' +
                '}';
    }


}
