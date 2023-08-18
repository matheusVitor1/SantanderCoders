package modulo02.aula04.Services;

import modulo02.aula04.Entidades.Cliente;
import modulo02.aula04.Entidades.Pedidos;
import modulo02.aula04.Entidades.Restaurante;
import modulo02.aula04.Entidades.Pratos;
import modulo02.aula04.Repository.PedidosRepository;

import java.util.List;
import java.util.ArrayList;
public class PedidosService {
    private PedidosRepository pedidosRepository;

    public PedidosService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    public void criarPedido(Cliente cliente, Restaurante restaurante, List<Pratos> pratos) {
        Pedidos pedido = new Pedidos(cliente, restaurante);
        pedido.setPratos(pratos);
        pedidosRepository.adicionarPedido(pedido);
    }

    public List<Pedidos> listarPedidosPorRestaurante(String cnpjRestaurante) {
        List<Pedidos> pedidosDoRestaurante = new ArrayList<>();
        for (Pedidos pedido : pedidosRepository.listarPedidos()) {
            if (pedido.getRestaurante().getCnpj().equals(cnpjRestaurante)) {
                pedidosDoRestaurante.add(pedido);
            }
        }
        return pedidosDoRestaurante;
    }


    public List<Pedidos> listarPedidosPorCliente(String cpf) {
        List<Pedidos> pedidosCliente = new ArrayList<>();
        for (Pedidos pedido : pedidosRepository.listarPedidos()) {
            if (pedido.getCliente().getCpf().equals(cpf)) {
                pedidosCliente.add(pedido);
            }
        }
        return pedidosCliente;
    }
}
