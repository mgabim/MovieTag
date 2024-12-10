package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;

public class Plataforma {
    private String nome;
    private Bitmap foto;

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
}
