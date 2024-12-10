package otoni.omena.santos.machado.movietag.models;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    List<Producao> producoes;
    List<Lista> listas;

    public List<Producao> getProducoes(){
        // Código preenchendo manual o producoes
        return this.producoes;
    }

    public List<Lista> getListas(){
        return this.listas;
    }
}
