package otoni.omena.santos.machado.movietag.models;
import java.util.List;

public class Tag {
    private Integer id;
    private String nome;
    private List<Producao> listaProducoes;

    public Tag(Integer id, String nome, List<Producao> listaProducoes) {
        this.id = id;
        this.nome = nome;
        this.listaProducoes = listaProducoes;
    }

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


