package list.pesquisa.catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogoLivros {
    private List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<Livro>();
    }

    protected void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    protected List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }

    protected List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                livrosPorIntervaloAnos.add(livro);
            }
        }
        return livrosPorIntervaloAnos;
    }

    // Retorna o primeiro livro encontrado com o título
    protected Livro pesquisarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        //TODO ver como a camila do DIO fez isso
        //jogar uma excecao se o livro nao for encontrado

        // poderia ter um Optional vazio, mas teria que retornar um Optional<Livro>;
        // como receber esse Optional? O que fazer com ele?
        return null;
    }

    protected void exibirLivros() {
        livros.forEach(System.out::println);
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Dom Casmurro", "Machado de Assis", 1899);
        catalogoLivros.adicionarLivro("Quincas Borba", "Machado de Assis", 1891);
        catalogoLivros.adicionarLivro("Memórias Póstumas", "Machado de Assis", 1881);
        catalogoLivros.adicionarLivro("O cortiço", "Aluísio Azevedo", 1890);

        catalogoLivros.exibirLivros();

        System.out.println(catalogoLivros.pesquisarPorAutor("machado de Assis"));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Assassin's Renaissance"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(1890, 1900));
    }
}
