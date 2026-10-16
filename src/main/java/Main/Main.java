package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CadastroClientes cadastroClientes = new CadastroClientes();
        cadastroClientes.adicionar(new Cliente(1L, "Leonardo Schio", "leos@gmail.com", 24, 250.50));
        Optional<Cliente> cliente = cadastroClientes.buscarPorId(1L);
        Cliente clienteEncontrado = cliente.get();

        CadastroProduto cadastroProduto = new CadastroProduto();
        cadastroProduto.adicionarProduto(new Produto(1L, "Computador", 5500.00, 25));
        cadastroProduto.adicionarProduto(new Produto(2L, "Mouse", 400, 4));
        Optional<Produto> produto = cadastroProduto.buscarPorId(1L);
        Produto produtoEncontrado = produto.get();

        ItemPedido itemPedido = new ItemPedido(produtoEncontrado, 2);
        //produtoEncontrado.reducaoEstoque(2);

        boolean result = produtoEncontrado.reducaoEstoque(78);

        System.out.println("Resultado: " + result);
        System.out.println("Estoque restante: " + produtoEncontrado.getUnidadesDisponiveis());

        System.out.println("Item pedido: " + itemPedido);

        List<ItemPedido> itemPedidos = new ArrayList<>();
        itemPedidos.add(itemPedido);

        Pedido pedido = new Pedido(1L, clienteEncontrado, itemPedidos);

        System.out.println(pedido);

        System.out.println("Total do pedido: " + pedido.calcularTotalPedido());

        ProcessadorPedidos processadorPedidos = new ProcessadorPedidos();
        processadorPedidos.processarCompra(1L, clienteEncontrado, produtoEncontrado, 3);
    }
}
