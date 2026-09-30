package Main;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private Integer unidadesDisponiveis;

    public Produto(Long id, String nome, double preco, Integer unidadesDisponiveis) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.unidadesDisponiveis = unidadesDisponiveis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getUnidadesDisponiveis() {
        return unidadesDisponiveis;
    }

    public void setUnidadesDisponiveis(Integer unidadesDisponiveis) {
        this.unidadesDisponiveis = unidadesDisponiveis;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nPreço: " + preco + "\nUnidades disponíveis: " + unidadesDisponiveis;
    }
}