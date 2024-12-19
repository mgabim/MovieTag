package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.MinhasListasAdapter;
import otoni.omena.santos.machado.movietag.models.Producao;


public class MinhasListasFragment extends Fragment {

    MainActivity mainActivity;


    public MinhasListasFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

    }

    public static MinhasListasFragment newInstance(MainActivity mainActivity) {
        return new MinhasListasFragment(mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_minhas_listas, container, false);

        // Configure the Toolbar
        Toolbar toolbar = rootView.findViewById(R.id.tbMinhasListas);

        // setando como actiobar do fragment
        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);

            // colocando o titulo de acordo com nome de integrante
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle("Minhas Listas");
            }
        }

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fbCriarLista = view.findViewById(R.id.fbMinhasListas);
        fbCriarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Configurar dialog de Criar Lista
            }
        });

        RecyclerView rvMinhasListas = (RecyclerView)view.findViewById(R.id.rvMinhasListas);
        MinhasListasAdapter minhasListasAdapter = new MinhasListasAdapter(mainActivity);
        rvMinhasListas.setAdapter(minhasListasAdapter);
        rvMinhasListas.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        inflater.inflate(R.menu.menu_titulo, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}