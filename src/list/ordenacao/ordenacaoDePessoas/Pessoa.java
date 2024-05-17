package list.ordenacao.ordenacaoDePessoas;

public class Pessoa implements Comparable<Pessoa>{
    private String nome;
    private int idade;
    private double altura;

    protected Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    protected String getNome() {
        return nome;
    }

    protected int getIdade() {
        return idade;
    }

    protected double getAltura() {
        return altura;
    }


    @Override
    public int compareTo(Pessoa pessoa) {
//        if (idade > pessoa.getIdade()) {
//            return 1;
//        } else if (idade < pessoa.getIdade()) {
//            return -1;
//        }
//        return 0;

        return Integer.compare(idade, pessoa.getIdade());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }
}
