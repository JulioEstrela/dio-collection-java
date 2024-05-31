package map.operacoesBasicas.agendaDeContatos;

import java.util.HashMap;
import java.util.Map;

/**
 * Seria melhor criar um DTO para trabalhar com contatos,
 * assim como nos outros exemplos (list e set), criar-se-ia um objeto Contato, com diversos atributos.
 * O map não tem sua melhor aplicação nesse exemplo.
 * <p>
 * Com isso, seria um pouco mais plausível, ainda que inadequado,
 * criar um {@code Map<id, Contato>}, no qual cada instância de Contato é separado por id;
 * mesmo assim, o id deveria ser um atributo de Contato e não se usaria o Map.
 */
class AgendaContatos {
    /**
     * Como não serão realizados cálculos com número de telefone, ele será armazenado em String.
     *
     * @implNote {@code <String nome, String telefone>}
     * @see <a href="https://www.bbc.co.uk/bitesize/guides/zghbgk7/revision/4">BBC - Storing text</a>
     * @see <a href=https://github.com/google/libphonenumber/blob/master/FALSEHOODS.md#:~:text=Never%20try%20to%20store%20phone%20numbers%20as%20an%20int%20or%20any%20other%20kind%20of%20numeric%20data%20type>Google - Falsehoods Programmers Believe About Phone Numbers</a>
     *
     */
    private Map<String, String> contatos;

    AgendaContatos() {
        this.contatos = new HashMap<String, String>();
    }

    void adicionarContato(String nome, String telefone) {
        contatos.put(nome, telefone);
    }
    void removerContato(String nome) {
        contatos.remove(nome);
    }
    void exibirContatos() {
        System.out.println(contatos);
    }
    String pesquisarPorNome(String nome) {
        return contatos.get(nome);
    }
}
