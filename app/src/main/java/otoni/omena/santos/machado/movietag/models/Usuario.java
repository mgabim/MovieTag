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
}
