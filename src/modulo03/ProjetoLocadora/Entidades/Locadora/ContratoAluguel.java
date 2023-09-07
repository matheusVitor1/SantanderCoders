package modulo03.ProjetoLocadora.Entidades.Locadora;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContratoAluguel {

    private static Integer ultimoPedido = 0;

    private Integer numeroPedido;

    public static final LocalDateTime DATA_DEVOLUCAO_NAO_DEFINIDA = LocalDateTime.MIN;

    public static final BigDecimal VALOR_NAO_DEFINIDO = BigDecimal.ZERO;
    private Veiculo veiculo;
    private Pessoa cliente;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;
    private String enderecoDevolucao;

    private BigDecimal valorAPagar;


    public ContratoAluguel(Veiculo veiculo, Pessoa cliente, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, String enderecoDevolucao, BigDecimal valorAPagar){
        this.numeroPedido = ++ultimoPedido;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = (dataDevolucao != null) ? dataDevolucao : DATA_DEVOLUCAO_NAO_DEFINIDA;
        this.enderecoDevolucao = enderecoDevolucao;
        this.valorAPagar = valorAPagar;
    }

    public static Integer getUltimoPedido() {
        return ultimoPedido;
    }

    public static void setUltimoPedido(Integer ultimoPedido) {
        ContratoAluguel.ultimoPedido = ultimoPedido;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public String getEnderecoDevolucao() {
        return enderecoDevolucao;
    }

    public void setEnderecoDevolucao(String enderecoDevolucao) {
        this.enderecoDevolucao = enderecoDevolucao;
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

    public BigDecimal getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
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
