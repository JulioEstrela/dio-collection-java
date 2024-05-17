package list.operacoesBasicas.listaDeTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefaList;

    protected ListaTarefas() {
        this.tarefaList = new ArrayList<Tarefa>();
    }

    protected void adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        tarefaList.add(tarefa);
    }

    // Remove todas as tarefas com a mesma descrição
    protected void removerTarefa(String descricao) {
        List<Tarefa> tarefasRemover = new ArrayList<>();
        for (Tarefa t : tarefaList) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasRemover.add(t);
            }
        }
        tarefaList.removeAll(tarefasRemover);
    }

    protected Integer obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    protected List<String> obterDescricoesTarefas() {
        List<String> descricoesList = new ArrayList<>();
        for (Tarefa t : tarefaList) {
            descricoesList.add(t.getDescricao());
        }
        return descricoesList;
    }
}
