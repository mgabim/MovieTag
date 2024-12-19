package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Integrante {
    private Integer id;
    private String nome;
    private Integer foto;
    private String atuacaoPrincipal;
    private Date dataNascimento;
    private String genero;
    private String biografia;
    private List<Producao> producoes;

    public Integrante(Integer id, String nome, int foto, String atuacaoPrincipal, Date dataNascimento, String genero, String biografias) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.atuacaoPrincipal = atuacaoPrincipal;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.biografia = biografia;
        this.producoes = new ArrayList<>();
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

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public List<Producao> getProducoes() {
        return producoes;
    }

    public void setProducoes(List<Producao> producoes) {
        this.producoes = producoes;
    }
}

