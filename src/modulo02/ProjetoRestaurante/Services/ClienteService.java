package modulo02.ProjetoRestaurante.Services;

import modulo02.ProjetoRestaurante.Entidades.Cliente;
import modulo02.ProjetoRestaurante.Repository.ClienteRepository;

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
