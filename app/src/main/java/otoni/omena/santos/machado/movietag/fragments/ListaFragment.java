package otoni.omena.santos.machado.movietag.fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.FilmesListaAdapter;
import otoni.omena.santos.machado.movietag.models.ListaProducoes;
import otoni.omena.santos.machado.movietag.models.Producao;
import otoni.omena.santos.machado.movietag.utils.Config;


public class ListaFragment extends Fragment {
    MainActivity mainActivity;
    ListaProducoes lista;


    public ListaFragment(MainActivity mainActivity, ListaProducoes lista) {
        this.mainActivity = mainActivity;

        this.lista = lista;
    }

    public static ListaFragment newInstance(MainActivity mainActivity, ListaProducoes listaProd) {
        return new ListaFragment(mainActivity, listaProd);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvLista = (RecyclerView)view.findViewById(R.id.rvLista);

        FilmesListaAdapter filmesAdapter = new FilmesListaAdapter(mainActivity, lista.getProducoes());
        rvLista.setAdapter(filmesAdapter);
        rvLista.setLayoutManager(new LinearLayoutManager(getContext()));

        FloatingActionButton fbAddFilme = view.findViewById(R.id.fbFragmentLista);

        fbAddFilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Filme adicionado com sucesso!", Toast.LENGTH_LONG).show();
            }

        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_lista, container, false);

        // Configure the Toolbar
        Toolbar toolbar = rootView.findViewById(R.id.tbLista);

        // setando como actiobar do fragment
        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);

            // colocando o titulo de acordo com nome de integrante
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle(lista.getNome());
            }


        }

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        inflater.inflate(R.menu.menu_titulo, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


}