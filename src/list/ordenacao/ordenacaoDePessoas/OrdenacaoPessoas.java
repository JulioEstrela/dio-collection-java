package list.ordenacao.ordenacaoDePessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoas;

    protected OrdenacaoPessoas() {
        this.pessoas = new ArrayList<Pessoa>();
    }

    protected void adicionarPessoa(String nome, int idade, double altura) {
        pessoas.add(new Pessoa(nome, idade, altura));
    }

    // ordena por idade crescente
    protected List<Pessoa> ordernarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoas);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    // ordena por altura crescente
    protected List<Pessoa> ordernarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoas);
        /*
        - É possível criar uma classe package-private que implementa Comparator,
        tanto no OrdenacaoPessoas quanto em Produto.
        - É possível criar uma classe que implementa Comparator em um arquivo próprio;
        - Já que Comparator é uma interface funcional,
        ou seja, possui apenas um método abstrato,
        é possível utilizar lambda com o método compare;
        - É possível criar uma classe anônima (como abaixo).
         */
        pessoasPorAltura.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
//                if (p1.getAltura() > p2.getAltura()) {
//                    return 1;
//                } else if (p1.getAltura() < p2.getAltura()) {
//                    return -1;
//                }
//                return 0;

                return Double.compare(p1.getAltura(), p2.getAltura());
            }
        });
        return pessoasPorAltura;
    }

    protected void exibirPessoas() {
        pessoas.forEach(System.out::println);
    }


    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();
        ordenacaoPessoas.adicionarPessoa("Julio", 17, 1.73);
        ordenacaoPessoas.adicionarPessoa("Pedro", 15, 1.82);

        ordenacaoPessoas.exibirPessoas();
        ordenacaoPessoas.ordernarPorIdade();
        ordenacaoPessoas.exibirPessoas();
        ordenacaoPessoas.ordernarPorAltura();
        ordenacaoPessoas.exibirPessoas();
    }
}
