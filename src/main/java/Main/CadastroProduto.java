package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CadastroProduto {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public boolean atualizarProdutos(Long id, String nome, double preco, Integer unidadesDisponiveis) {
        Optional<Produto> produtoA = buscarPorId(id);

        if (produtoA.isPresent()) {
            Produto produto = produtoA.get();

            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setUnidadesDisponiveis(unidadesDisponiveis);
            return true;
        }
        return false;
    }

    public boolean removerPorId(Long id) {
        Optional<Produto> produto = buscarPorId(id);

        if (produto.isPresent()) {
            produtos.remove(produto.get());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return produtos.toString();
    }
}