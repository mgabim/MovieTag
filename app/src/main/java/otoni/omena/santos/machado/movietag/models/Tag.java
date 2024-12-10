package otoni.omena.santos.machado.movietag.models;
import java.util.ArrayList;

public class Tag {
    private Integer id;
    private String nome;
    private Usuario usuario;
    private ArrayList<Producao> listaProducoes;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Producao> getListaProducoes() {
        return listaProducoes;
    }

    public void setListaProducoes(ArrayList<Producao> listaProducoes) {
        this.listaProducoes = listaProducoes;
    }
}


