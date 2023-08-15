package modulo02.aula04.Services;

import modulo02.aula04.Entidades.Pratos;
import modulo02.aula04.Entidades.Restaurante;
import modulo02.aula04.Repository.RestauranteRepository;

import java.util.List;
import java.util.ArrayList;
public class RestauranteService {
    private RestauranteRepository restauranteRepository;


    public RestauranteService() {
        restauranteRepository = new RestauranteRepository();

    }

    public void cadastrarRestaurante(String cnpj, String nome, String endereco) {
        restauranteRepository.criarRestaurante(cnpj, nome, endereco);
    }

    public void cadastrarPrato(String cnpj, String idPrato, String nomePrato, double valor) {
        Restaurante restaurante = restauranteRepository.buscarRestaurante(cnpj);
        if (restaurante != null) {
            Pratos prato = new Pratos(idPrato, nomePrato, valor);
            restaurante.adicionarPrato(prato);
        } else {
            throw new IllegalArgumentException("Restaurante não encontrado.");
        }
    }

    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.listarRestaurantes();
    }

    public Restaurante buscarRestaurantePorCnpj(String cnpj) {
        return restauranteRepository.buscarRestaurante(cnpj);
    }
    public List<Pratos> buscarPratosPorId(String cnpj, String idPrato) {
        Restaurante restaurante = restauranteRepository.buscarRestaurante(cnpj);
        List<Pratos> pratosEncontrados = new ArrayList<>();

        if (restaurante != null) {
            for (Pratos prato : restaurante.getPratos()) {
                if (prato.getId().equals(idPrato)) {
                    pratosEncontrados.add(prato);
                }
            }
        } else {
            throw new IllegalArgumentException("Restaurante não encontrado.");
        }

        return pratosEncontrados;
    }


}
