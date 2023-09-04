package modulo02.ProjetoRestaurante.Repository;

import modulo02.ProjetoRestaurante.Entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private List<Cliente> clientRepository;

    public ClienteRepository() {
        this.clientRepository = new ArrayList<>();
    }

    public boolean validarCliente(String cpf) {
        for (Cliente cliente : this.clientRepository) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public void criarConta(String cpf, String nome) {
        if (!validarCliente(cpf)) {
            Cliente novoCliente = new Cliente(cpf, nome);
            this.clientRepository.add(novoCliente);
        } else {
            System.out.println("CPF já cadastrado!");
        }
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : this.clientRepository) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

}
