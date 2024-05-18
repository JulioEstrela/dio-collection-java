package set.pesquisa.listaDeTarefas;

import java.util.HashSet;
import java.util.Set;

class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<Tarefa>();
    }

    protected void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }
    protected void removerTarefa(String descricao) {
        tarefaSet.remove(new Tarefa(descricao));
    }
    protected void exibirTarefas() {
        System.out.println(tarefaSet);
    }
    protected int obterQuantidadeTarefas() {
        return tarefaSet.size();
    }
    protected HashSet<Tarefa> obterTarefasConcluidas() {
        HashSet<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa tarefa : tarefaSet) {
            if (tarefa.isConcluida()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }
    protected HashSet<Tarefa> obterTarefasPendentes() {
        HashSet<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa tarefa : tarefaSet) {
            if (!tarefa.isConcluida()) {
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }
    protected void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : tarefaSet) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(true);
                return;
            }
        }
    }
    protected void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : tarefaSet) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(false);
                return;
            }
        }
    }
    protected void limparListaTarefas() {
        tarefaSet.clear();
    }
}
