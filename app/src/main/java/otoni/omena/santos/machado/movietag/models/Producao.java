package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;
import java.util.Date;
import java.util.List;

public class Producao {

    private Integer id;
    private Integer idApi;
    private Integer poster;
    private Integer backgroundPoster;
    private String titulo;
    private Date estreia;
    private Float nota;
    private String linkTrailer;
    private List<Tag> listaTags;
    private String sinopse;
    private List<Integrante> listaIntegrantes;
    private List<Plataforma> listaPlataformas;
    private List<Producao> temporadas;

    public List<Producao> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Producao> temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdApi() {
        return idApi;
    }

    public void setIdApi(Integer idApi) {
        this.idApi = idApi;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

    public Integer getBackgroundPoster() {
        return backgroundPoster;
    }

    public void setBackgroundPoster(Integer backgroundPoster) {
        this.backgroundPoster = backgroundPoster;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getEstreia() {
        return estreia;
    }

    public void setEstreia(Date estreia) {
        this.estreia = estreia;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public String getLinkTrailer() {
        return linkTrailer;
    }

    public void setLinkTrailer(String linkTrailer) {
        this.linkTrailer = linkTrailer;
    }

    public List<Tag> getListaTags() {
        return listaTags;
    }

    public void setListaTags(List<Tag> listaTags) {
        this.listaTags = listaTags;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public List<Integrante> getListaIntegrantes() {
        return listaIntegrantes;
    }

    public void setListaIntegrantes(List<Integrante> listaIntegrantes) {
        this.listaIntegrantes = listaIntegrantes;
    }

    public List<Plataforma> getListaPlataformas() {
        return listaPlataformas;
    }

    public void setListaPlataformas(List<Plataforma> listaPlataformas) {
        this.listaPlataformas = listaPlataformas;
    }
}