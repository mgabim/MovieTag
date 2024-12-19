package otoni.omena.santos.machado.movietag.models;
import java.util.List;

public class Tag {
    private Integer id;
    private String nome;
    private List<Producao> listaProducoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Producao> getListaProducoes() {
        return listaProducoes;
    }

    public void setListaProducoes(List<Producao> listaProducoes) {
        this.listaProducoes = listaProducoes;
    }
}


