package list.operacoesBasicas.carrinhoDeCompras;

class Item {
    private String nome;
    private Double preco;
    private Integer quantidade;

    protected Item(String nome, Double preco, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    protected String getNome() {
        return nome;
    }

    protected Double getPreco() {
        return preco;
    }

    protected Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}
