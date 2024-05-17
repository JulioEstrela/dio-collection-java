package list.ordenacao.ordenacaoDeNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> integerList;

    protected OrdenacaoNumeros() {
        this.integerList = new ArrayList<Integer>();
    }

    protected void adicionarNumero(int numero) {
        integerList.add(numero);
    }

    protected void ordenarAscendente() {
        Collections.sort(integerList);
    }

    protected void ordenarDescendente() {
        integerList.sort(Collections.reverseOrder());
    }

    protected void exibirNumeros() {
        System.out.println(integerList);
    }
}
