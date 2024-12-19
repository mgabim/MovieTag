package otoni.omena.santos.machado.movietag.models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import otoni.omena.santos.machado.movietag.R;

public class MainActivityViewModel extends ViewModel {
    int navigationOpSelected = R.id.inicioViewOp; // Opção escolhida pelo usuário no btNav
    List<Producao> producoes;
    List<ListaProducoes> listas;
    List<ListaProducoes> listasPadrao;
    List<Avaliacao> avaliacoes;
    List<Tag> tagsCriadas;

    Usuario usuario;

    public MainActivityViewModel(){
        this.producoes = new ArrayList<>();
        this.listas = new ArrayList<>();
        this.listasPadrao = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        this.tagsCriadas = new ArrayList<>();
    }
    public int getNavigationOpSelected() {
        return navigationOpSelected;
    }

    public void setNavigationOpSelected(int navigationOpSelected) {
        this.navigationOpSelected = navigationOpSelected;
    }

    public List<Producao> getProducoes(){
        // Código preenchendo manual o producoes
        return this.producoes;
    }

    public List<ListaProducoes> getListas(){
        return this.listas;
    }

    public Usuario getUsuario() {
        usuario = new Usuario(1, "guihocosta", "guiihocosta@gmail.com", R.drawable.fotoperfil);
        return this.usuario;
    }

    public List<ListaProducoes> getListasPadrao() {
        return this.listasPadrao;
    }

    public List<Avaliacao>  getAvaliacoesUsuario(){
        return avaliacoes;
    }

    public List<Tag> getTagsCriadas() {
        return tagsCriadas;
    }
}
