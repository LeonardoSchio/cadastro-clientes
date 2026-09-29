package Main;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private double saldoCompras;

    public Cliente(Long id, String nome, String email, Integer idade, double saldoCompras) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.saldoCompras = saldoCompras;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdade() {
        return idade;
    }

    public double getSaldoCompras() {
        return saldoCompras;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setSaldoCompras(double saldoCompras) {
        this.saldoCompras = saldoCompras;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nE-mail: " + email +
                "\nIdade: " + idade + "\nSaldo de compras: " + saldoCompras;
    }
}