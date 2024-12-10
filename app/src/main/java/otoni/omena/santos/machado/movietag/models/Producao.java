package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;
import java.util.Date;
import java.util.List;

public class Producao {

    private Integer id;
    private Integer idApi;
    private Bitmap poster;
    private Bitmap backgroundPoster;
    private String titulo;
    private Date estreia;
    private Float nota;
    private String linkTrailer;
    private List<Tag> listaTags;
    private String sinopse;
    private List<Integrante> listaIntegrantes;
    private List<Plataforma> listaPlataformas;
}