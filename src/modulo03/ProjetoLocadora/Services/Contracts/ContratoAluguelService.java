package modulo03.ProjetoLocadora.Services.Contracts;

import modulo03.ProjetoLocadora.Entidades.Locadora.ContratoAluguel;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ContratoAluguelService {
    ContratoAluguel buscarAluguelPorIdentidade(String cpfCliente);
    BigDecimal calcularValorAlguelDeCarro(LocalDateTime dataLocacao, LocalDateTime dataDevolucao, String placa);

}
