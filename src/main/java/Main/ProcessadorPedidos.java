package Main;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorPedidos {
    public void processarCompra(Long idPedido, Cliente cliente, Produto produto, Integer quantidade) {
        boolean compraAprovada = produto.reducaoEstoque(quantidade);

        if (!compraAprovada) {
            System.out.println("Compra recusada: estoque insuficiente ou quantidade inválida.");
            return;
        }

        ItemPedido itemPedido = new ItemPedido(produto, quantidade);

        List<ItemPedido> itens = new ArrayList<>();

        itens.add(itemPedido);

        Pedido pedido = new Pedido(idPedido, cliente, itens);

        System.out.println(pedido);
        System.out.println("Total do pedido: " + pedido.calcularTotalPedido());
    }
}
