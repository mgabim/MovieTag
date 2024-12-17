package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Date;

public class Integrante {
    private Integer id;
    private String nome;
    private Bitmap foto;
    private String atuacaoPrincipal;
    private Date dataNascimento;
    private String genero;
    private String biografia;
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

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public String getAtuacaoPrincipal() {
        return atuacaoPrincipal;
    }

    public void setAtuacaoPrincipal(String atuacaoPrincipal) {
        this.atuacaoPrincipal = atuacaoPrincipal;
    }

    public Date getDataNascimento() {

        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public ArrayList<Producao> getListaProducoes() {
        return listaProducoes;
    }

    public void setListaProducoes(ArrayList<Producao> listaProducoes) {
        this.listaProducoes = listaProducoes;
    }
}

