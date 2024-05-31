package map.pesquisa.contagemDePalavras;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class ContagemPalavras {
    private Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<String, Integer>();
    }

    void adicionarPalavra(String palavra, Integer contagem) {
        palavras.put(palavra, contagem);
    }
    void removerPalavra(String palavra) {
        palavras.remove(palavra);
    }
    void exibirContagemPalavras() {
        System.out.println(palavras);
    }
    String encontrarPalavraMaisFrequente() {
        Optional<String> palavraMaisFrequente = Optional.empty();
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry : palavras.entrySet()) {
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                palavraMaisFrequente = Optional.of(entry.getKey());
            }
        }
        return palavraMaisFrequente.orElseThrow(() -> new IllegalStateException("the map is empty"));
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("palavra1", 1);
        contagemPalavras.adicionarPalavra("palavra3", 100);
        contagemPalavras.adicionarPalavra("palavra2", 50);
        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());

        contagemPalavras.exibirContagemPalavras();
    }
}
