package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.ListasHomeAdapter;
import otoni.omena.santos.machado.movietag.adapters.ResultadosBuscaAdapter;
import otoni.omena.santos.machado.movietag.models.Producao;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultadoBuscaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultadoBuscaFragment extends Fragment {
    MainActivity mainActivity;
    ResultadosBuscaAdapter resultadosBuscaAdapter;
    List<Producao> listaResultado;

    public ResultadoBuscaFragment(MainActivity mainActivity, ResultadosBuscaAdapter resultadosBuscaAdapter, List<Producao> listaResultado) {
        // Required empty public constructor
        this.mainActivity = mainActivity;
        this.resultadosBuscaAdapter = resultadosBuscaAdapter;
        this.listaResultado = listaResultado;

    }


    public static ResultadoBuscaFragment newInstance(MainActivity mainActivity, ResultadosBuscaAdapter resultadosBuscaAdapter, List<Producao> listaResultado) {
        return new ResultadoBuscaFragment(mainActivity, resultadosBuscaAdapter, listaResultado);
    }

    public ResultadoBuscaFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public static ResultadoBuscaFragment newInstance(MainActivity mainActivity) {
        return new ResultadoBuscaFragment(mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_resultado_busca, container, false);

        // Initialize the Toolbar
        Toolbar toolbar = rootView.findViewById(R.id.tbResultados);

        // Set the Toolbar as the ActionBar (in the Fragment)
        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);

            // Set toolbar title or other properties
            activity.getSupportActionBar().setTitle("MovieTag");
        }

        // Enable the menu for this fragment
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvResultados = (RecyclerView)view.findViewById(R.id.rvResultados);

        resultadosBuscaAdapter = new ResultadosBuscaAdapter(mainActivity, mainActivity.getVm().getProducoes());
    }
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        inflater.inflate(R.menu.menu_pesquisa, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}