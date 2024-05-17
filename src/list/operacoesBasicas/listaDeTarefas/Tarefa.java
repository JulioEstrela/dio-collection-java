package list.operacoesBasicas.listaDeTarefas;

class Tarefa {
    private String descricao;

    protected Tarefa(String descricao) {
        this.descricao = descricao;
    }

    protected String getDescricao() {
        return descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
