package modulo03.ProjetoLocadora.Services.impl;

import modulo03.ProjetoLocadora.Entidades.Locadora.ContratoAluguel;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;
import modulo03.ProjetoLocadora.Repositories.ContratoAluguelRepository;
import modulo03.ProjetoLocadora.Repositories.PessoaRepository;
import modulo03.ProjetoLocadora.Repositories.VeiculoRepository;
import modulo03.ProjetoLocadora.Services.Contracts.ContratoAluguelService;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class ContratoAluguelServiceImpl implements ContratoAluguelService {

    private ContratoAluguelRepository contratoAluguelRepository;
    private VeiculoRepository veiculoRepository;

    public long calculaDiarias(LocalDateTime dataLocacao, LocalDateTime dataDevolucao){

        Duration duracaoAluguel = Duration.between(dataLocacao, dataDevolucao);

        long horasArredondadas = (long) Math.ceil((double) duracaoAluguel.toMinutes() / 60);

        if (dataDevolucao.isAfter(dataLocacao)) {
            horasArredondadas++;
        }
        long diarias = horasArredondadas / 24;

        return diarias;
    }
    @Override
    public ContratoAluguel buscarAluguelPorIdentidade(String cpfCliente) {
        return null;
    }

    @Override
    public BigDecimal calcularValorAlguelDeCarro(LocalDateTime dataLocacao, LocalDateTime dataDevolucao, String placa) {
        return null;
    }
}
