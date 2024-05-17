package list.operacoesBasicas.carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

class CarrinhoDeCompras {
    private List<Item> itens;

    protected CarrinhoDeCompras() {
        this.itens = new ArrayList<Item>();
    }

    protected void adicionarItem(String nome, double preco, int quantidade) {
        itens.add(new Item(nome, preco, quantidade));
    }

    // Remove todos os itens com o mesmo nome
    protected void removerItem(String nome) {
        List<Item> itensRemover = new ArrayList<>();
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)){
                itensRemover.add(item);
            }
        }
        itens.removeAll(itensRemover);
    }

    protected double calcularValorTotal() {
        double valorTotal = 0d;
        for (Item item : itens) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }

    protected void exibirItens() {
        itens.forEach(System.out::println);
    }
}
