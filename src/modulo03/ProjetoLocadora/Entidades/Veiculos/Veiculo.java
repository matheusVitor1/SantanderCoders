package modulo03.ProjetoLocadora.Entidades.Veiculos;

import java.math.BigDecimal;

public abstract class Veiculo {
    private String nome;
    private String modelo;
    private String placa;
    private BigDecimal precoAluguel;
    private boolean isAlugado;

    public Veiculo (String nome, String modelo, String placa, BigDecimal precoAluguel, boolean isAlugado){
        this.nome = nome;
        this.modelo = modelo;
        this.placa = placa;
        this.precoAluguel = precoAluguel;
        this.isAlugado = isAlugado;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BigDecimal getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(BigDecimal precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public boolean isAlugado() {
        return isAlugado;
    }

    public void setAlugado(boolean alugado) {
        isAlugado = alugado;
    }

    public void alugar() {

    }

    public void devolver() {

    }
}
