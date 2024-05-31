package map.ordenacao.livrariaOnline;

import java.util.*;

/**
 * Novamente, seria não somente mais lógico como ainda mais fácil,
 * manter o {@code String link} como um atributo de {@code Livro},
 * ao invés de utilizá-lo separadamente num {@code Map}
 * <p>
 * Diversas vezes, no lugar de retornar um {@code Map<String link, Livro livro>},
 * poder-se-ia retornar um {@code Livro} apenas, no qual constaria o atributo {@code String link}.
 * Isso fica ainda mais ridículo à medida que pouco se usa o link do livro.
 */
class LivrariaOnline {
    private Map<String, Livro> livrosMap;

    LivrariaOnline() {
        this.livrosMap = new HashMap<String, Livro>();
    }

    void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrosMap.put(link, new Livro(titulo, autor, preco));
    }
    void removerLivro(String titulo) {
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().titulo().equals(titulo)) {
                livrosMap.remove(entry.getKey());
                return;
            }
        }
    }
    Map<String, Livro> obterLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrosMap.entrySet());
        livrosParaOrdenarPorPreco.sort(new ComparatorPorPreco());
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }
        return livrosOrdenadosPorPreco;
    }

    Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutorMap = new HashMap<>();
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().autor().equals(autor)) {
                livrosPorAutorMap.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosPorAutorMap;
    }

    // o nome da função faz pensar que será retornado um livro - e deveria -
    // mas como o link do livro está separado, precisa-se retornar um
    // Map com o link e o livro; péssimo.
    Map<String, Livro> obterLivroMaisCaro() {
        double maiorPreco = Double.MIN_VALUE;
        Map<String, Livro> livroMaisCaroMap = new HashMap<>();
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().preco() > maiorPreco) {
                maiorPreco = entry.getValue().preco();
                livroMaisCaroMap.clear();
                livroMaisCaroMap.put(entry.getKey(), entry.getValue());
            }
        }
        return livroMaisCaroMap;
    }
    Map<String, Livro> obterLivroMaisBarato() {
        double menorPreco = Double.MAX_VALUE;
        Map<String, Livro> livroMaisBaratoMap = new HashMap<>();
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().preco() < menorPreco) {
                menorPreco = entry.getValue().preco();
                livroMaisBaratoMap.clear();
                livroMaisBaratoMap.put(entry.getKey(), entry.getValue());
            }
        }
        return livroMaisBaratoMap;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("link1", "Dom Casmurro", "Machado de Assis", 27);
        livrariaOnline.adicionarLivro("link2", "Memórias Póstumas", "Machado de Assis", 25);
        livrariaOnline.adicionarLivro("link3", "O cortiço", "Aluísio Azevedo", 20);
        System.out.println(livrariaOnline.obterLivroMaisCaro());
        System.out.println(livrariaOnline.obterLivroMaisBarato());
        System.out.println(livrariaOnline.obterLivrosOrdenadosPorPreco());
        System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Machado de Assis"));
    }

}
