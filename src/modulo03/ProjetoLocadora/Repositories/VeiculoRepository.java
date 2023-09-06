package modulo03.ProjetoLocadora.Repositories;

import modulo03.ProjetoLocadora.Entidades.Veiculos.Carro;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Moto;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;

import java.math.BigDecimal;
import java.util.*;
import java.util.Collections;

public class VeiculoRepository {

    private List<Veiculo> veiculoRepository;
    private List<Carro> carroRepository;
    private List<Moto> motoRepository;
    public VeiculoRepository() {
        this.veiculoRepository = new ArrayList<>();
        this.carroRepository = new ArrayList<>();
        this.motoRepository = new ArrayList<>();
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

    public List<Moto> listarMotosEmOrdemAlfabetica() {
        List<Moto> motos = new ArrayList<>(motoRepository);
        Collections.sort(motos, Comparator.comparing(Moto::getNome));
        return Collections.unmodifiableList(motos);
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
        if (veiculo != null && veiculo instanceof Carro) {
            Carro carro = (Carro) veiculo;
            carro.setNome(nome);
            carro.setModelo(modelo);
            carro.setPlaca(placa);
            carro.setPrecoAluguelPorDia(precoAluguel);
            if (carro instanceof Carro) {
                ((Carro) carro).setPorte(porte);
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
