package list.pesquisa.soma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    protected SomaNumeros() {
        this.numeros = new ArrayList<Integer>();
    }

    protected void adicionarNumero(int numero) {
        numeros.add(numero);
    }
    protected int calcularSoma() {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma;
    }

    protected int encontrarMaiorNumero() {
        //int maiorNumero = Integer.MIN_VALUE; returns MIN_VALUE if list is empty
        //int maiorNumero = numeros.get(0);
        //for (int numero : numeros) {
        //    if (numero > maiorNumero) {
        //        maiorNumero = numero;
        //    }
        //}
        //return maiorNumero;

        //throws NoSuchElementException if list is empty
        return Collections.max(numeros);
    }

    protected int encontrarMenorNumero() {
        //throws NoSuchElementException if list is empty
        return Collections.min(numeros);
    }

    protected void exibirNumeros() {
        numeros.forEach(System.out::println);
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(5);

        somaNumeros.exibirNumeros();
        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.encontrarMaiorNumero());
        System.out.println(somaNumeros.encontrarMenorNumero());
    }

}
