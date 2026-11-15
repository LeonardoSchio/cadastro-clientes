package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorPedidos {
    public void processarCompra(Pedido pedido) {
        for (ItemPedido itemPedido : pedido.getItens()) {
            Produto produto = itemPedido.getProduto();
            Integer quantidade = itemPedido.getQuantidadeComprada();

            if (!produto.verificarEstoque(quantidade)) {
                System.out.println("Pedido recusado.");
                return;
            }
        }

        for (ItemPedido itemPedido : pedido.getItens()) {
            Produto produto = itemPedido.getProduto();
            Integer quantidade = itemPedido.getQuantidadeComprada();

            if (produto.reducaoEstoque(quantidade)) {
                System.out.println("Redução no estoque feita com sucesso.");
            }
        }
    }

    public void cadastrarPedidoNoBanco(Pedido pedido) throws SQLException {
        try (Connection connection = Conexao.conectar()) {
            if (connection == null) {
                System.out.println("Não foi possível conectar ao banco.");
                return;
            }

            String sql = "INSERT INTO pedidos (cliente_id) VALUES (?)";

            try (PreparedStatement comand = connection.prepareStatement(sql)) {
                comand.setLong(1, pedido.getCliente().getId());

                int linhasAfetadas = comand.executeUpdate();
            }
        }
    }
}