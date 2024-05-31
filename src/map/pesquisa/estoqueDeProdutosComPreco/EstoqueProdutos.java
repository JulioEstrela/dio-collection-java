package map.pesquisa.estoqueDeProdutosComPreco;

import java.util.*;

class EstoqueProdutos {
    private Map<Long, Produto> produtos;

    EstoqueProdutos() {
        this.produtos = new HashMap<Long, Produto>();
    }

    void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        produtos.put(cod, new Produto(nome, quantidade, preco));
    }

    void exibirProdutos() {
        System.out.println(produtos);
    }
    double calcularValorTotalEstoque() {
        double valorTotal = 0;
        for (Produto produto : produtos.values()) {
            valorTotal += produto.preco() * produto.quantidade();
        }
        return valorTotal;
    }
    Produto obterProdutoMaisCaro() {
        return produtos.values()
                .stream()
                .max(Comparator.comparingDouble(Produto::preco))
                .orElseThrow(() -> new IllegalStateException("the map is empty"));
    }

    Produto obterProdutoMaisBarato() {
        return produtos.values()
                .stream()
                .min(Comparator.comparingDouble(Produto::preco))
                .orElseThrow(() -> new IllegalStateException("the map is empty"));
    }

    Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        return produtos.values()
                .stream()
                .max(Comparator.comparingDouble(produto -> produto.preco() * produto.quantidade()))
                .orElseThrow(() -> new IllegalStateException("the map is empty"));
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(10, "Produto", 10, 10.0);
        estoqueProdutos.adicionarProduto(11, "Produto 2", 2, 25.0);
        System.out.println(estoqueProdutos.obterProdutoMaisCaro());
        System.out.println(estoqueProdutos.obterProdutoMaisBarato());
        System.out.println(estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
