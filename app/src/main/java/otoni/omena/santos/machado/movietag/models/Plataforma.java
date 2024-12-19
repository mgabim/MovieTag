package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;

import java.util.List;

public class Plataforma {
    private String nome;
    private Integer foto;
    private String url;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Plataforma(String nome, Integer foto, String url) {
        this.nome = nome;
        this.foto = foto;
        this.url = url;
    }
}
