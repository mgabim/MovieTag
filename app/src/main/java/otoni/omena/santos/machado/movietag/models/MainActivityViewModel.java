package otoni.omena.santos.machado.movietag.models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
        // Criação de plataformas
        Plataforma netflix = new Plataforma("Netflix", 1, "https://www.netflix.com");
        Plataforma amazonPrime = new Plataforma("Amazon Prime", 2, "https://www.primevideo.com");

        // Criação de integrantes
        Integrante diretor = new Integrante(1, "Christopher Nolan", 1, "Diretor", new Date(), "Masculino", "Conhecido por filmes complexos e inovadores.");
        Integrante ator = new Integrante(2, "Leonardo DiCaprio", 2, "Ator", new Date(), "Masculino", "Famoso por suas atuações em filmes premiados.");

        // Criação de tags
        Tag suspense = new Tag(1, "Suspense", new ArrayList<>());
        Tag drama = new Tag(2, "Drama", new ArrayList<>());

        // Criação de produções
        Producao producao1 = new Producao(
                1, 101, 1, 2, "Inception", new Date(), 8.8f,
                "https://www.youtube.com/watch?v=8hP9D6kZseM",
                Arrays.asList(suspense, drama),
                "Um ladrão que rouba segredos corporativos...",
                Arrays.asList(diretor, ator),
                Arrays.asList(netflix),
                Arrays.asList(amazonPrime),
                Arrays.asList(),
                new ArrayList<>()
        );

        Producao producao2 = new Producao(
                2, 102, 3, 4, "Interstellar", new Date(), 8.6f,
                "https://www.youtube.com/watch?v=zSWdZVtXT7E",
                Arrays.asList(drama),
                "Um grupo de exploradores viaja através de um buraco negro...",
                Arrays.asList(diretor),
                Arrays.asList(amazonPrime),
                Arrays.asList(netflix),
                Arrays.asList(),
                new ArrayList<>()
        );

        // Vincular produções às tags
        suspense.getListaProducoes().add(producao1);
        drama.getListaProducoes().addAll(Arrays.asList(producao1, producao2));

        // Criar listas de produções
        ListaProducoes listaFavoritos = new ListaProducoes(Arrays.asList(producao1), "Favoritos");
        ListaProducoes listaRecentes = new ListaProducoes(Arrays.asList(producao1, producao2), "Recentes");

        // Adicionar listas à lista padrão
        listasPadrao.add(listaFavoritos);
        listasPadrao.add(listaRecentes);

        return listasPadrao;
    }

    public List<Avaliacao>  getAvaliacoesUsuario(){
        return avaliacoes;
    }

    public List<Tag> getTagsCriadas() {
        return tagsCriadas;
    }
}
