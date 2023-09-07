package modulo03.ProjetoLocadora.Services.impl;

import modulo03.ProjetoLocadora.Entidades.Locadora.ContratoAluguel;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;
import modulo03.ProjetoLocadora.Repositories.ContratoAluguelRepository;
import modulo03.ProjetoLocadora.Services.Contracts.ContratoAluguelService;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class ContratoAluguelServiceImpl implements ContratoAluguelService {

    private ContratoAluguelRepository contratoAluguelRepository;

    public ContratoAluguelServiceImpl (ContratoAluguelRepository contratoAluguelRepository) {
        this.contratoAluguelRepository = contratoAluguelRepository;
    }

    private long calcularDiarias(LocalDateTime dataLocacao, LocalDateTime dataDevolucao){

        Duration duracaoAluguel = Duration.between(dataLocacao, dataDevolucao);

        long horasArredondadas = (long) Math.ceil((double) duracaoAluguel.toMinutes() / 60);

        if (dataDevolucao.isAfter(dataLocacao)) {
            horasArredondadas++;
        }
        long diarias = horasArredondadas / 24;

        return diarias;
    }
    @Override
    public ContratoAluguel buscarAluguelPorCliente(String identidade) {
        return null;
    }

    @Override
    public BigDecimal calcularValorAluguel(LocalDateTime dataLocacao, LocalDateTime dataDevolucao, Veiculo veiculo) {

        if (dataDevolucao.equals(ContratoAluguel.DATA_DEVOLUCAO_NAO_DEFINIDA)) {
            return BigDecimal.ZERO;
        }

        BigDecimal precoAluguelPorDia = veiculo.getPrecoAluguelPorDia();
        long diarias = calcularDiarias(dataLocacao, dataDevolucao);
        BigDecimal valorContrato = precoAluguelPorDia.multiply(BigDecimal.valueOf(diarias));

        return valorContrato;
    }


    @Override
    public boolean criarContratoAluguel(Veiculo veiculo, Pessoa cliente, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, String enderecoDevolucao) {
        if (dataDevolucao == null) {
            dataDevolucao = ContratoAluguel.DATA_DEVOLUCAO_NAO_DEFINIDA;
        }

        BigDecimal valorAPagar = calcularValorAluguel(dataLocacao,dataDevolucao, veiculo);

        ContratoAluguel contratoAluguel = new ContratoAluguel(veiculo, cliente, dataLocacao, dataDevolucao, enderecoDevolucao, valorAPagar);

        if (validarContrato(contratoAluguel)) {
            contratoAluguelRepository.salvarAluguel(contratoAluguel);
            contratoAluguel.getVeiculo().setAlugado(true);
            return true;
        }
        return false;
    }
    @Override
    public boolean validarContrato(ContratoAluguel contrato) {

        if (contrato.getDataLocacao().isAfter(contrato.getDataDevolucao())) {
            System.out.println("Data de devolução não pode ser anterior à data de locação.");
            return false;
        } else if (contrato.getVeiculo().isAlugado()) {
            System.out.println("Veículo já alugado!");
            return false;
        }
        return true;
    }
}







