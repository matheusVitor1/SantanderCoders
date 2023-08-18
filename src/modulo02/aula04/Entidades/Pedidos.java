package modulo02.aula04.Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedidos {

    private static Integer ultimoPedido = 0;
    private Integer numeroPedido;
    private Cliente cliente;
    private Restaurante restaurante;
    private List<Pratos> pratos;

    public Pedidos(Cliente cliente, Restaurante restaurante) {
        this.numeroPedido = ++ultimoPedido;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.pratos = new ArrayList<>();
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Pratos> getPratos() {
        return pratos;
    }

    public void setPratos(List<Pratos> pratos) {
        this.pratos = pratos;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedidos ped = (Pedidos) obj;
        return numeroPedido.equals(ped.numeroPedido);
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "Numero Peido ='" + numeroPedido + '\'' +
                ", Cliente ='" + cliente + '\'' +
                ", restaurante ='" + restaurante + '\'' +
                ", pratos = '" + pratos + '\'';
    }
}
