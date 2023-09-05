package modulo03.ProjetoLocadora.Entidades.Locadora;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;

import java.time.LocalDateTime;

public class AluguelVeiculo {

    private static Integer ultimoPedido = 0;

    private Integer numeroPedido;
    private Veiculo veiculo;
    private Pessoa cliente;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;

    public AluguelVeiculo(Veiculo veiculo, Pessoa cliente, LocalDateTime dataLocacao, LocalDateTime dataDevolucao){
        this.numeroPedido = ++ultimoPedido;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

    public static Integer getUltimoPedido() {
        return ultimoPedido;
    }

    public static void setUltimoPedido(Integer ultimoPedido) {
        AluguelVeiculo.ultimoPedido = ultimoPedido;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDateTime dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }


    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "AluguelVeiculo{" +
                "numeroPedido=" + numeroPedido +
                ", veiculo=" + veiculo +
                ", cliente=" + cliente +
                ", dataLocacao=" + dataLocacao +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}
