package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;
import java.util.Date;
import java.util.List;

public class Producao {

    public Integer id;
    public Integer idApi;
    public Bitmap poster;
    public Bitmap backgroundPoster;
    public String titulo;
    public Date estreia;
    public Float nota;
    public String linkTrailer;
    public List<Tag> listaTags;
    public String sinopse;
    public List<Integrante> listaIntegrantes;
    public List<Plataforma> listaPlataformas;
}