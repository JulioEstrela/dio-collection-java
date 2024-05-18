package set.operacoesBasicas.conjuntoDePalavras;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    protected ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<String>();
    }

    protected void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }
    protected void removerPalavra(String palavra) {
        palavrasUnicas.remove(palavra);
    }
    protected boolean temAPalavra(String palavra) {
        return palavrasUnicas.contains(palavra);
    }

    protected void exibirPalavras() {
        palavrasUnicas.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Palavra");
        conjuntoPalavrasUnicas.exibirPalavras();
        conjuntoPalavrasUnicas.removerPalavra("Palavra");
        System.out.println(conjuntoPalavrasUnicas.temAPalavra("Palavra"));
    }
}
