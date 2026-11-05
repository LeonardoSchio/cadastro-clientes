
# Sistema de Gestão de Clientes e Pedidos

## 📋 Sobre o projeto

Projeto desenvolvido em Java com o objetivo de criar um sistema para cadastro e gerenciamento de clientes, produtos e pedidos.

O projeto está sendo desenvolvido de forma incremental, aplicando na prática conceitos de Programação Orientada a Objetos, Collections, Generics, Exceptions, Stream API e SQL.

Atualmente, o sistema Java utiliza Collections para armazenar os dados em memória, enquanto a estrutura do banco de dados MySQL e suas operações SQL já foram desenvolvidas separadamente.

A integração entre Java e MySQL utilizando JDBC será implementada nas próximas etapas.

## 🚀 Funcionalidades

- Cadastro e gerenciamento de clientes
- Cadastro e gerenciamento de produtos
- Registro de pedidos
- Consulta de clientes e produtos
- Consultas de histórico de compras
- Cálculo do valor total dos pedidos
- Identificação dos produtos mais vendidos
- Consulta de produtos com estoque baixo
- Atualização de estoque
- Cancelamento de pedidos

## 🛠️ Tecnologias utilizadas

- Java
- SQL
- MySQL
- JDBC (próxima etapa)
- Maven
- IntelliJ IDEA
- Git e GitHub

## 📚 Conceitos praticados

### Java
- Programação Orientada a Objetos (POO)
- Encapsulamento
- Herança
- Polimorfismo
- Collections
- List e ArrayList
- Generics
- Stream API
- Lambda
- Optional
- Tratamento de exceções

### SQL
- Criação de bancos de dados e tabelas
- PRIMARY KEY e FOREIGN KEY
- INSERT, SELECT, UPDATE e DELETE
- WHERE e ORDER BY
- JOIN
- GROUP BY e SUM
- Views
- Transações
- COMMIT e ROLLBACK

## 📁 Estrutura do projeto

```text
cadastro-clientes/
├── .idea/
├── sql/
│   ├── 01_criar_tabelas.sql
│   ├── 02_inserir_dados.sql
│   ├── 03_consultas.sql
│   └── 04_operacoes.sql
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── Main/
│   │   │       ├── CadastroClientes.java
│   │   │       ├── CadastroProduto.java
│   │   │       ├── Cliente.java
│   │   │       ├── ItemPedido.java
│   │   │       ├── Main.java
│   │   │       ├── Pedido.java
│   │   │       ├── ProcessadorPedidos.java
│   │   │       └── Produto.java
│   │   └── resources/
│   └── test/
│       └── java/
├── .gitignore
├── pom.xml
└── README.md
```