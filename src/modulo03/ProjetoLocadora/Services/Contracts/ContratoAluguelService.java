package modulo03.ProjetoLocadora.Services.Contracts;

import modulo03.ProjetoLocadora.Entidades.Locadora.ContratoAluguel;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ContratoAluguelService {
    ContratoAluguel buscarAluguelPorCliente(String cpfCliente);
    BigDecimal calcularValorAluguel(LocalDateTime dataLocacao, LocalDateTime dataDevolucao, Veiculo veiculo);
    boolean validarContrato(ContratoAluguel contrato);
    boolean criarContratoAluguel(Veiculo veiculo, Pessoa cliente, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, String enderecoDevolucao);


}
