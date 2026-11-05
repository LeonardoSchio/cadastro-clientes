CREATE DATABASE loja;

USE loja;

-- Armazena os dados dos clientes
CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100),
    idade INT,
    saldoCompras DECIMAL(10,2)
);

-- Armazena os produtos e suas informações de estoque e preço
CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    preco DECIMAL(10,2),
    unidadesDisponiveis INT
);

-- Armazena os pedidos realizados pelos clientes
-- Cada pedido está associado a um cliente
CREATE TABLE pedidos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Armazena os produtos e as quantidades de cada pedido
-- Cada item está associado a um pedido e a um produto
CREATE TABLE itens_pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pedido_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);