package map.ordenacao.livrariaOnline;

import java.util.Comparator;
import java.util.Map;

record Livro(String titulo, String autor, double preco) {
}

class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return Double.compare(livro1.getValue().preco(), livro2.getValue().preco());
    }
}