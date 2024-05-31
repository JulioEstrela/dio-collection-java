package map.operacoesBasicas.dicionario;

import java.util.HashMap;
import java.util.Map;

/**
 * Nesse caso, também poderíamos usar um objeto Palavra,
 * uma palavra pode ter vários atributos de interesse, como:
 * definições (mais de uma), sinônimos
 */
class Dicionario {
    private final Map<String, String> palavras;

    Dicionario() {
        this.palavras = new HashMap<String, String>();
    }
    void adicionarPalavra(String palavra, String definicao) {
        palavras.put(palavra, definicao);
    }
    void exibirPalavras() {
        System.out.println(palavras);
    }
    String pesquisarDefinicaoPorPalavra(String palavra) {
        return palavras.get(palavra);
    }
}
