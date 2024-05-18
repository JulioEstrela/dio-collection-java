package set.pesquisa.agendaDeContatos;

import java.util.Objects;

class Contato {
    private String nome;
    private String numeroTelefone;

    protected Contato(String nome, String numeroTelefone) {

        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    protected String getNome() {
        return nome;
    }

    protected String getNumeroTelefone() {
        return numeroTelefone;
    }

    protected void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return Objects.equals(getNome().toLowerCase(), contato.getNome().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome().toLowerCase());
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                '}';
    }
}
