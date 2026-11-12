package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void listarProdutosDoBanco() throws SQLException {
        try (Connection connection = Conexao.conectar()) {
            if (connection == null) {
                System.out.println("Não foi possível conectar ao banco.");
                return;
            }

            String sql = "SELECT nome, preco, unidadesDisponiveis FROM produtos";

            try (PreparedStatement comand = connection.prepareStatement(sql);
                 ResultSet resultSet = comand.executeQuery()) {
                while (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    double preco = resultSet.getDouble("preco");
                    int unidadesDisponiveis = resultSet.getInt("unidadesDisponiveis");

                    System.out.println("Nome: " + nome + "\nPreço: " + preco + "\nUnidades disponíveis: " + unidadesDisponiveis);
                }
            }
        }
    }

    public void cadastrarProdutoNoBanco(Produto produto) throws SQLException {
        try (Connection connection = Conexao.conectar()) {
            if (connection == null) {
                System.out.println("Não foi possível conectar ao banco.");
                return;
            }

            String sql = "INSERT INTO produtos (nome, preco, unidadesDisponiveis) VALUES (?, ?, ?)";

            try (PreparedStatement comand = connection.prepareStatement(sql)) {
                comand.setString(1, produto.getNome());
                comand.setDouble(2, produto.getPreco());
                comand.setInt(3, produto.getUnidadesDisponiveis());

                int linhasAfetadas = comand.executeUpdate();
            }
        }
    }

    public void consultarProdutoPorId(Long id) throws SQLException {
        try (Connection connection = Conexao.conectar()) {
            if (connection == null) {
                System.out.println("Não foi possível conectar ao banco.");
                return;
            }

            String sql = "SELECT id, nome, preco, unidadesDisponiveis FROM produtos WHERE id = ?";

            try (PreparedStatement comand = connection.prepareStatement(sql)) {
                comand.setLong(1, id);

                try (ResultSet resultSet = comand.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println(resultSet.getLong("id"));
                        System.out.println(resultSet.getString("nome"));
                        System.out.println(resultSet.getDouble("preco"));
                        System.out.println(resultSet.getInt("unidadesDisponiveis"));
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
            }
        }
    }

    public void atualizarPrecoEEstoque(Long id, double novoPreco, int novoEstoque) throws SQLException {
        try (Connection connection = Conexao.conectar()) {
            if (connection == null) {
                System.out.println("Não foi possível conectar ao banco.");
                return;
            }

            String sql = "UPDATE produtos SET preco = ?, unidadesDisponiveis = ? WHERE id = ?";

            try (PreparedStatement comand = connection.prepareStatement(sql)) {
                comand.setDouble(1, novoPreco);
                comand.setInt(2, novoEstoque);
                comand.setLong(3, id);

                int linhasAfetadas = comand.executeUpdate();
            }
        }
    }

    @Override
    public String toString() {
        return produtos.toString();
    }
}