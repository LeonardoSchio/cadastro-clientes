package Main;

import java.util.List;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido(Long id, Cliente cliente, List<ItemPedido> itens) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        itens.add(itemPedido);
    }

    public double calcularTotalPedido() {
        double subtotal = 0;

        for (ItemPedido itemPedido : itens) {
            subtotal += itemPedido.getProduto().getPreco() * itemPedido.getQuantidadeComprada();
        }
        return subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n Cliente: " + cliente + "\nItens: " + itens;
    }
}