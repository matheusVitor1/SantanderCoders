package modulo03.ProjetoLocadora.Repositories;

import modulo03.ProjetoLocadora.Entidades.Veiculos.Carro;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;

import java.math.BigDecimal;
import java.util.*;
import java.util.Collections;

public class VeiculoRepository {

    private List<Veiculo> veiculoRepository;
    private List<Carro> carroRepository;

    public VeiculoRepository() {
        this.veiculoRepository = new ArrayList<>();
        this.carroRepository = new ArrayList<>();
    }

    public void salvarVeiculo(Veiculo veiculo) {
        this.veiculoRepository.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.veiculoRepository.remove(veiculo);
    }

    public List<Carro> listarCarrosEmOrdemAlfabetica() {
        List<Carro> carros = new ArrayList<>(carroRepository);
        Collections.sort(carros, Comparator.comparing(Carro::getNome));
        return Collections.unmodifiableList(carros);
    }

    public Veiculo buscarVeiculoPorNome(String nome) {
        for (Veiculo veiculo : veiculoRepository) {
            if (veiculo.getNome().equalsIgnoreCase(nome)) {
                return veiculo;
            }
        }
        return null;
    }
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculoRepository) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public boolean editarVeiculo(String nome, String modelo, String placa, BigDecimal precoAluguel, String porte) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            veiculo.setNome(nome);
            veiculo.setModelo(modelo);
            veiculo.setPlaca(placa);
            veiculo.setPrecoAluguelPorDia(precoAluguel);
            if (veiculo instanceof Carro) {
                // Se for um carro, atualize o porte
                Carro carro = (Carro) veiculo;
                carro.setPorte(porte);
            }

            return true;
        }

        return false;
    }


    public boolean editarDisponibilidadeDoVeiculo(String placa, boolean isAlugado) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculo.setAlugado(isAlugado);
            return true;
        }
        return false;
    }



}
