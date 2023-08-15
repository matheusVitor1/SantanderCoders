package modulo02.aula04.Services;

import modulo02.aula04.Entidades.Cliente;
import modulo02.aula04.Repository.ClienteRepository;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(String cpf, String nome) {
        clienteRepository.criarConta(cpf, nome);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return clienteRepository.buscarCliente(cpf);
    }


}
