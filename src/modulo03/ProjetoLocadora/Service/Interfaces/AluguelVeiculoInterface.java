package modulo03.ProjetoLocadora.Service.Interfaces;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface AluguelVeiculoInterface {
    void alugar(Veiculo veiculo, Pessoa cliente, LocalDateTime dataInicio, LocalDateTime dataFim);
    /*BigDecimal calcularPreco();
    void registrarDevolucao(LocalDateTime dataDevolucao);*/
}
