package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Date;

public class Producao {

    public Integer id;
    public Integer idApi;
    public Bitmap poster;
    public Bitmap backgroundPoster;
    public String titulo;
    public Date estreia;
    public Float nota;
    public String linkTrailer;
    public ArrayList<Integer> listaIdTags;
    public String sinopse;
    public ArrayList<Integer> listaIdIntegrantes;
    public ArrayList<Integer> listaIdPlataformas;

    public Producao getProducaoById(Integer id){
        if(id.equals(this.id)){
            return this;
        } else{
            return null;
        }
    }
}
