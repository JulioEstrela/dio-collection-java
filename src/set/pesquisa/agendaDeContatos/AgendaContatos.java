package set.pesquisa.agendaDeContatos;

import java.util.HashSet;
import java.util.Set;

class AgendaContatos {
    private Set<Contato> contatoSet;

    protected AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    protected void adicionarContato(String nome, String numeroTelefone) {
        contatoSet.add(new Contato(nome, numeroTelefone));
    }
    protected void exibirContatos() {
        System.out.println(contatoSet);
    }
    protected HashSet<Contato> pesquisarPorNome(String nome) {
        HashSet<Contato> contatosPorNome = new HashSet<>();
        for (Contato contato : contatoSet) {
            if (contato.getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                contatosPorNome.add(contato);
            }
        }
        return contatosPorNome;
    }
    protected void atualizarNumeroContato(String nome, String novoNumero) {
        for (Contato contato : contatoSet) {
            if(contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNumeroTelefone(novoNumero);
                return;
            }
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Julio Antunes", "1199195979");
        // não deve ser adicionado (nome igual)
        agendaContatos.adicionarContato("julio antunes", "1197445599");
        agendaContatos.adicionarContato("Julio Estrela", "1198794719");

        System.out.println(agendaContatos.pesquisarPorNome("julio"));
        agendaContatos.atualizarNumeroContato("julio antunes", "11955594449");
        agendaContatos.exibirContatos();
    }

}
