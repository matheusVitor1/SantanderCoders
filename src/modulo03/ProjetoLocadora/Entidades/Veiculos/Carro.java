package modulo03.ProjetoLocadora.Entidades.Veiculos;

import java.math.BigDecimal;

public class Carro extends Veiculo {

    private String porte;
    public Carro(String nome, String modelo,String placa, BigDecimal precoAluguelPorDia, String Porte, boolean isAlugado) {
        super(nome, modelo, placa, precoAluguelPorDia, isAlugado);
        this.porte = porte;
    }

    public String getPorte() {
        return porte;
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
                ", porte='" + getPorte() + '\'' +
                ", alugado=" + isAlugado() +
                '}';
    }
}

