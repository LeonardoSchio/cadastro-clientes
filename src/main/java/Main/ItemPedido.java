package Main;

public class ItemPedido {
    private Produto produto;
    private Integer quantidadeComprada;

    public ItemPedido(Produto produto, Integer quantidadeComprada) {
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(Integer quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    @Override
    public String toString() {
        return "Produto: " + produto + "\nQuantidade comprada: " + quantidadeComprada;
    }
}
