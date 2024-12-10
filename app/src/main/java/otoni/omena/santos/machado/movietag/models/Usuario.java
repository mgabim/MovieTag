package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;

import java.util.List;

public class Usuario {
    private Integer id;
    private String usuario;
    private String email;
    private String senha;
    private Bitmap foto;
    private List<Avaliacao> avaliacoes;
    private List<Tag> tagsCriadas;
    private List<Lista> listas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Tag> getTagsCriadas() {
        return tagsCriadas;
    }

    public void setTagsCriadas(List<Tag> tagsCriadas) {
        this.tagsCriadas = tagsCriadas;
    }

    public List<Lista> getListas() {
        return listas;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }
}
