USE loja;
-- Cadastrar novos pedidos com segurança - INSERT, transações
START TRANSACTION;

INSERT INTO pedidos (cliente_id)
VALUES (1);

SET @pedido_id = LAST_INSERT_ID();

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario)
VALUES
(@pedido_id, 1, 1, 5500.00),
(@pedido_id, 2, 2, 400.00);

-- Depois, basta commitar
COMMIT;

-- Atualizar o estoque após uma venda
UPDATE produtos
SET unidadesDisponiveis = unidadesDisponiveis - 1
WHERE id = 1;

-- Cancelar um pedido
DELETE FROM itens_pedido
WHERE pedido_id = 1;

DELETE FROM pedidos
WHERE id = 1;

-- Exemplo de transação desfeita utilizando ROLLBACK
START TRANSACTION;

UPDATE produtos
SET unidadesDisponiveis = unidadesDisponiveis - 1
WHERE id = 1;

ROLLBACK;