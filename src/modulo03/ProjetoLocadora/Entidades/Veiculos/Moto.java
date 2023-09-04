package modulo03.ProjetoLocadora.Entidades.Veiculos;

import java.math.BigDecimal;

public class Moto extends Veiculo {
    public Moto(String nome, String modelo, String placa, BigDecimal precoAluguel, boolean isAlugado) {
        super(nome, modelo, placa, precoAluguel, isAlugado);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "nome='" + getNome() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", precoAluguel=" + getPrecoAluguel() +
                ", alugado=" + isAlugado() +
                '}';
    }
}
