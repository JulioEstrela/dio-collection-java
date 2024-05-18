package set.operacoesBasicas.conjuntoDeConvidados;

import java.util.HashSet;
import java.util.Set;

class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    protected ConjuntoConvidados() {
        this.convidadoSet = new HashSet<Convidado>();
    }
    protected void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    protected void removerConvidadoPorCodigoConvite(int codigoConvite) {
//        for (Convidado convidado : convidadoSet) {
//            if (convidado.getCodigoConvite() == codigoConvite) {
//                convidadoSet.remove(convidado);
//                return;
//            }
//        }

        // O nome não faz diferença, já que o codigoConvite é único por convidado
        convidadoSet.remove(new Convidado(null, codigoConvite));
    }

    protected int obterQuantidadeConvidados() {
        return convidadoSet.size();
    }

    protected void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Julio", 111);
        conjuntoConvidados.adicionarConvidado("Pedro", 111); //códigoConvite é identificador hashcode
        conjuntoConvidados.adicionarConvidado("Joao", 123);

        conjuntoConvidados.exibirConvidados();
        conjuntoConvidados.removerConvidadoPorCodigoConvite(123);
        System.out.println("Após removido:");
        conjuntoConvidados.exibirConvidados();
    }

}
