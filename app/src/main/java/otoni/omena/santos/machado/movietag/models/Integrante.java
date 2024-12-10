package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Date;

public class Integrante {
    public Integer id;
    public String nome;
    public Bitmap foto;
    public String atuacaoPrincipal;
    public Date dataNascimento;
    public String genero;
    public String biografia;
    public ArrayList<Producao> listaProducoes;
}

