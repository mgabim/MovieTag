package otoni.omena.santos.machado.movietag.models;

import android.graphics.Bitmap;

import androidx.lifecycle.ViewModel;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;

public class MainActivityViewModel extends ViewModel {
    int navigationOpSelected = R.id.inicioViewOp; // Opção escolhida pelo usuário no btNav
    List<Producao> producoes;
    List<Lista> listas;
    List<Lista> listasPadrao;
    List<Avaliacao> avaliacoes;

    Usuario usuario;


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

    public List<Lista> getListas(){
        return this.listas;
    }

    public Usuario getUsuario() {
        usuario = new Usuario(1, "guihocosta", "guiihocosta@gmail.com", R.drawable.fotoperfil);
        return this.usuario;
    }

    public List<Lista> getListasPadrao() {
        return this.listasPadrao;
    }
}
