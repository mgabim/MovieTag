package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.List;

public class Usuario {
    private Integer id;
    private String usuario;
    private String email;
    private int foto;

    public Usuario(Integer id, String usuario, String email,  int foto) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.foto = foto;
    }

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

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
