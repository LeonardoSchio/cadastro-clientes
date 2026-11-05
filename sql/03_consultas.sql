USE loja;
-- Identificar produtos com estoque baixo
SELECT
    produtos.nome AS NomeDoProduto,
    produtos.preco AS PrecoDoProduto,
    produtos.unidadesDisponiveis AS QuantidadeNoEstoque
FROM produtos
WHERE produtos.unidadesDisponiveis <= 10
ORDER BY produtos.unidadesDisponiveis ASC;

-- Consultar os produtos mais vendidos
SELECT
    produtos.nome AS NomeDoProduto,
    SUM(itens_pedido.quantidade) AS QuantidadeVendida
FROM produtos
JOIN itens_pedido
    ON produtos.id = itens_pedido.produto_id
GROUP BY produtos.id, produtos.nome
ORDER BY QuantidadeVendida DESC;

-- Consultar quanto cada cliente já gastou
SELECT
    clientes.nome AS NomeDoCliente,
    SUM(itens_pedido.preco_unitario * itens_pedido.quantidade) AS TotalGasto
FROM clientes
JOIN pedidos
    ON clientes.id = pedidos.cliente_id
JOIN itens_pedido
    ON pedidos.id = itens_pedido.pedido_id
GROUP BY clientes.id, clientes.nome;

-- Criar consultas reutilizáveis
CREATE OR REPLACE VIEW historico_compras AS
SELECT
    clientes.nome AS NomeDoCliente,
    pedidos.id AS IdDoPedido,
    produtos.nome AS NomeDoProduto,
    itens_pedido.quantidade AS QuantidadeComprada,
    itens_pedido.preco_unitario AS PrecoUnitario
FROM clientes
JOIN pedidos
    ON clientes.id = pedidos.cliente_id
JOIN itens_pedido
    ON pedidos.id = itens_pedido.pedido_id
JOIN produtos
    ON produtos.id = itens_pedido.produto_id;

-- Depois, para consultar essa VIEW, basta executar
SELECT * FROM historico_compras;