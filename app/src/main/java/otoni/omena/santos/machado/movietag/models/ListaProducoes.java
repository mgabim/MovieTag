package otoni.omena.santos.machado.movietag.models;

import java.util.List;

public class ListaProducoes {
    private List<Producao> producoes;
    private String nome;

    public List<Producao> getProducoes() {
        return producoes;
    }

    public void setProducoes(List<Producao> producoes) {
        this.producoes = producoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
