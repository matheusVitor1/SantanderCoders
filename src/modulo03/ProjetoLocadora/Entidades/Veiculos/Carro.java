package modulo03.ProjetoLocadora.Entidades.Veiculos;

import java.math.BigDecimal;

public class Carro extends Veiculo {

    private String porte;
    public Carro(String nome, String modelo,String placa, BigDecimal precoAluguel, String Porte, boolean isAlugado) {
        super(nome, modelo, placa, precoAluguel, isAlugado);
        this.porte = porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + getNome() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", precoAluguel=" + getPrecoAluguel() +
                ", alugado=" + isAlugado() +
                '}';
    }
}

