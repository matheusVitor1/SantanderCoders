package modulo03.ProjetoLocadora.Services.impl;

import modulo03.ProjetoLocadora.Entidades.Veiculos.Carro;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Moto;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;
import modulo03.ProjetoLocadora.Repositories.VeiculoRepository;
import modulo03.ProjetoLocadora.Services.Contracts.VeiculoService;

import java.math.BigDecimal;
import java.util.List;

public class VeiculoServiceImpl implements VeiculoService {

    private VeiculoRepository veiculoRepository;
    public VeiculoServiceImpl (VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }
    @Override
    public Veiculo buscarVeiculoPorNome(String nome){
        return veiculoRepository.buscarVeiculoPorNome(nome);
    }
    @Override
    public Veiculo buscarVeiculoPorPlaca(String placa){
        return veiculoRepository.buscarVeiculoPorPlaca(placa);
    }

    @Override
    public boolean adicionarVeiculo(Veiculo veiculo) {
        String placa = veiculo.getPlaca();
        if (buscarVeiculoPorPlaca(placa) == null) {
            veiculoRepository.salvarVeiculo(veiculo);
            return true;
        }
        return false;
    }

    @Override
    public boolean removerVeiculo(String placa) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculoRepository.removerVeiculo(veiculo);
            return true;
        }
        return false;
    }
    @Override
    public boolean editarVeiculo(String nome, String modelo, String placa, BigDecimal precoAluguel, String porte){
        if (buscarVeiculoPorPlaca(placa) != null){
            return veiculoRepository.editarVeiculo(nome,modelo,placa,precoAluguel,porte);
        }
        return false;
    }

    @Override
    public List<Carro> listarCarrosEmOrdemAlfabetica(){
        return veiculoRepository.listarCarrosEmOrdemAlfabetica();
    }
    @Override
    public List<Moto> listarMotosEmOrdemAlfabetica(){
        return veiculoRepository.listarMotosEmOrdemAlfabetica();
    }
}
