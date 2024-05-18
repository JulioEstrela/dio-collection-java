package set.ordenacao.listaDeAlunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    protected GerenciadorAlunos() {
        this.alunoSet = new HashSet<Aluno>();
    }

    protected void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    protected void removerAluno(long matricula) {
//        alunoSet.remove(new Aluno(null, matricula, 0));
        for (Aluno aluno : alunoSet) {
            if (aluno.getMatricula() == matricula) {
                alunoSet.remove(aluno);
                return;
            }
        }
    }

    protected Set<Aluno> ordenarPorNome() {
        return new TreeSet<>(alunoSet);
    }
    protected Set<Aluno> ordenarPorNotaCrescente() {
        Set<Aluno> alunosPorNotaCrescente = new TreeSet<>(new ComparatorPorNotaCrescente());
        alunosPorNotaCrescente.addAll(alunoSet);
        return alunosPorNotaCrescente;
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Júlio", 1234L, 10.0);
        gerenciadorAlunos.adicionarAluno("Alberto", 2222L, 8.0);
        gerenciadorAlunos.adicionarAluno("Zilberto", 3334L, 9.0);

        System.out.println(gerenciadorAlunos.ordenarPorNome());
        System.out.println(gerenciadorAlunos.ordenarPorNotaCrescente());

    }
 }
