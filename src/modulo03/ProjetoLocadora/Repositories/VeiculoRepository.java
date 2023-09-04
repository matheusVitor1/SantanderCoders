package modulo03.ProjetoLocadora.Repositories;

import modulo03.ProjetoLocadora.Entidades.Veiculos.Carro;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Moto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VeiculoRepository {
    private List<Carro> carroRepository;
    private List<Moto> motoRepository;
    public VeiculoRepository() {
        this.carroRepository = new ArrayList<>();
        this.motoRepository = new ArrayList<>();
    }

    public void cadastrarCarro(Carro carro) {
        this.carroRepository.add(carro);
    }

    public void removerCarro(Carro carro) {
        Iterator<Carro> iterator = carroRepository.iterator();
        while (iterator.hasNext()) {
            Carro atual = iterator.next();
            if (atual.getNome().equalsIgnoreCase(carro.getNome())) {
                iterator.remove();
                return;
            }
        }
    }

    public List<Carro> listarCarros() {
        return Collections.unmodifiableList(carroRepository);
    }

    public Carro buscarCarroPorNome(String nome) {
        for (Carro carro : carroRepository) {
            if (carro.getNome().equalsIgnoreCase(nome)) {
                return carro;
            }
        }
        return null;
    }
    public Carro buscarCarroPorPlaca(String placa) {
        for (Carro carro : carroRepository) {
            if (carro.getPlaca().equalsIgnoreCase(placa)) {
                return carro;
            }
        }
        return null;
    }


    public void cadastrarMoto(Moto moto) {
        this.motoRepository.add(moto);
    }

    public void removerMoto(Moto moto) {
        Iterator<Moto> iterator = motoRepository.iterator();
        while (iterator.hasNext()) {
            Moto atual = iterator.next();
            if (atual.getNome().equalsIgnoreCase(moto.getNome())) {
                iterator.remove();
                return;
            }
        }
    }

    public List<Moto> listarMotos() {
        return Collections.unmodifiableList(motoRepository);
    }

    public Moto buscarMotosPorNome(String nome) {
        for (Moto moto : motoRepository) {
            if (moto.getNome().equalsIgnoreCase(nome)) {
                return moto;
            }
        }
        return null;
    }

    public Moto buscarMotosPorPlaca(String placa) {
        for (Moto moto : motoRepository) {
            if (moto.getPlaca().equalsIgnoreCase(placa)) {
                return moto;
            }
        }
        return null;
    }
}
