package set.ordenacao.cadastroDeProdutos;

import java.util.*;

class CadastroProdutos {
    private Set<Produto> produtoSet;

    protected CadastroProdutos() {
        this.produtoSet = new HashSet<Produto>();
    }

    protected void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(nome, cod, preco, quantidade));
    }
    protected Set<Produto> ordenarPorNome() {
          // in this case, I need to return List:
//        return produtoSet.stream().sorted().toList();

        // TreeSet organiza com o Comparable do Produto automaticamente
        return new TreeSet<>(produtoSet);
    }
    protected Set<Produto> ordenarPorPrecoCrescente() {
          // in this case, I need to return List:
//        List<Produto> produtosPorPrecoCrescente = new ArrayList<>(produtoSet);
//        produtosPorPrecoCrescente.sort(new Comparator<Produto>() {
//            @Override
//            public int compare(Produto p1, Produto p2) {
//                return Double.compare(p1.getPreco(), p2.getPreco());
//            }
//        });
//        return produtosPorPrecoCrescente;

        // O TreeSet é iniciado vazio, mas com a estrutura do Comparator
        // Estou utilizando Comparator package-private criado em Produto:
        Set<Produto> produtosPorPrecoCrescente = new TreeSet<>(new ComparatorPorPrecoCrescente());

        // Adicionar a coleção no TreeSet com Comparator vai ordenar automaticamente
        produtosPorPrecoCrescente.addAll(produtoSet);
        return produtosPorPrecoCrescente;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(114, "Feijao", 500.0, 1);
        cadastroProdutos.adicionarProduto(112, "Arroz", 1000.0, 2);
        cadastroProdutos.adicionarProduto(113, "Macarrao", 100.0, 1);

        System.out.println(cadastroProdutos.ordenarPorNome());
        System.out.println(cadastroProdutos.ordenarPorPrecoCrescente());
    }
}
