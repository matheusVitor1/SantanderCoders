package modulo02.aula04.Repository;

import modulo02.aula04.Entidades.Cliente;
import modulo02.aula04.Entidades.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RestauranteRepository {
    private List<Restaurante> restaurantRepository;

    public RestauranteRepository() {
        restaurantRepository = new ArrayList<>();
    }

    public boolean validarRestaurante(String cnpj) {
        for (Restaurante restaurante : restaurantRepository) {
            if (restaurante.getCnpj().equals(cnpj)) {
                return true;
            }
        }
        return false;
    }

    public void criarRestaurante(String cnpj, String nome, String endereco) {
        if (!validarRestaurante(cnpj)) {
            Restaurante novoRestaurante = new Restaurante(cnpj, nome, endereco);
            restaurantRepository.add(novoRestaurante);
            System.out.println("Restaurante cadastrado com sucesso!");
        } else {
            System.out.println("Restaurante já cadastrado!");
        }
    }

    public Restaurante buscarRestaurante(String cnpj) {
        for (Restaurante restaurante : restaurantRepository) {
            if (restaurante.getCnpj().equals(cnpj)) {
                return restaurante;
            }
        }
        return null;
    }

    public List<Restaurante> listarRestaurantes() {
        return new ArrayList<>(restaurantRepository);
    }




}
