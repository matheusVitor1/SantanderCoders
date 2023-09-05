package modulo03.ProjetoLocadora.Service.impl;

import modulo03.ProjetoLocadora.Entidades.Locadora.AluguelVeiculo;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;
import modulo03.ProjetoLocadora.Service.Interfaces.AluguelVeiculoInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AluguelVeiculoService implements AluguelVeiculoInterface {
    private List<AluguelVeiculo> aluguelVeiculosRepository;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;

    public AluguelVeiculoService(LocalDateTime dataLocacao, LocalDateTime dataDevolucao){
        this.aluguelVeiculosRepository = new ArrayList<>();
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

    void alugar(Veiculo veiculo, Pessoa cliente, LocalDateTime dataInicio, LocalDateTime dataFim){
        
    }


}
