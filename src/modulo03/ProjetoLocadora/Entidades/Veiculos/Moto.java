package modulo03.ProjetoLocadora.Entidades.Veiculos;

import java.math.BigDecimal;

public class Moto extends Veiculo {


    public Moto(String nome, String modelo, String placa, BigDecimal precoAluguelPorDia, boolean isAlugado) {
        super(nome, modelo, placa, precoAluguelPorDia, isAlugado);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "nome='" + getNome() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", precoAluguel=" + getPrecoAluguelPorDia() +
                ", alugado=" + isAlugado() +
                '}';
    }
}
