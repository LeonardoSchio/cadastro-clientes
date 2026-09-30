package Main;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CadastroClientes cadastroClientes = new CadastroClientes();
        cadastroClientes.adicionar(new Cliente(1L, "Leonardo Schio", "leos@gmail.com", 24, 250.50));
        cadastroClientes.adicionar(new Cliente(2L, "Gustavo João Tanscheit", "gutajt@gmail.com", 24, 800.33));
        cadastroClientes.adicionar(new Cliente(3L, "Elias Eduardo Leonardi", "eliasel@gmail.com", 24, 178.90));

        cadastroClientes.atualizarClientes(1L, "João Pedro", "jp@gmail.com", 26, 1000.60);

        System.out.println(cadastroClientes);

        System.out.println("=================================================");

        CadastroProduto cadastroProduto = new CadastroProduto();

        cadastroProduto.adicionarProduto(new Produto(1L, "Computador", 5500.00, 25));

        cadastroProduto.adicionarProduto(new Produto(2L, "Celular", 3400.00, 14));

        System.out.println(cadastroProduto);

        System.out.println("=================================================");

        Optional<Produto> produto = cadastroProduto.buscarProId(2L);
        System.out.println(produto);

        boolean produto1 = cadastroProduto.removerPorId(1L);
        System.out.println(produto1);

        System.out.println("=================================================");

        cadastroProduto.atualizarProdutos(2L, "Tablet", 2700.00, 2);

        Optional<Produto> produtoAtualizado = cadastroProduto.buscarProId(2L);
        System.out.println(produtoAtualizado);

        System.out.println("=================================================");

        System.out.println(cadastroProduto);
    }
}
