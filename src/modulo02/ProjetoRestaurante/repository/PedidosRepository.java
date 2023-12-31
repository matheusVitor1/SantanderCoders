package modulo02.ProjetoRestaurante.Repository;

import modulo02.ProjetoRestaurante.Entidades.Pedidos;

import java.util.ArrayList;
import java.util.List;

public class PedidosRepository {
    private List<Pedidos> pedidosList;

    public PedidosRepository() {
        this.pedidosList = new ArrayList<>();
    }

    public void adicionarPedido(Pedidos pedido) {
        this.pedidosList.add(pedido);
    }

    public List<Pedidos> listarPedidos() {
        return new ArrayList<>(this.pedidosList);
    }


}
