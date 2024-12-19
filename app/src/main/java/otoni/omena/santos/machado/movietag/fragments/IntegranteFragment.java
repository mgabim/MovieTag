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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.CarrosselFilmesAdapter;
import otoni.omena.santos.machado.movietag.models.Integrante;
import otoni.omena.santos.machado.movietag.models.Producao;

public class IntegranteFragment extends Fragment {
    MainActivity mainActivity;
    Integrante integrante;
    List<Producao> listasProducoesAssociadas;
    CarrosselFilmesAdapter integranteAdapter;


    public IntegranteFragment(Integrante integrante, MainActivity mainActivity) {
        // Required empty public constructor
        this.integrante = integrante;
        this.mainActivity = mainActivity;
    }

    public static IntegranteFragment newInstance(Integrante integrante, MainActivity mainActivity) {

        return new IntegranteFragment(integrante, mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imvPoster = view.findViewById(R.id.imvIntegrante);
        imvPoster.setImageResource(integrante.getFoto());

        listasProducoesAssociadas = new ArrayList<>();
        List<Producao> listaProducoes = mainActivity.getVm().getProducoes();
        for (Producao producao : listaProducoes) {
            if (producao.getListaIntegrantes().contains(integrante)) {
                listasProducoesAssociadas.add(producao);
            }
        }
        integranteAdapter = new CarrosselFilmesAdapter(mainActivity, listasProducoesAssociadas);
        RecyclerView rvProdAssociadas = view.findViewById(R.id.rvProdAssociadas);

        TextView tvConhPor = view.findViewById(R.id.tvConhPor);
        tvConhPor.setText(integrante.getAtuacaoPrincipal());

        //Verificar saída da data
        TextView tvDataNasc = view.findViewById(R.id.tvDataNasc);
        tvDataNasc.setText(integrante.getDataNascimento().toString());

        TextView tvGenero = view.findViewById(R.id.tvGenero);
        tvGenero.setText(integrante.getGenero());

        TextView tvBiografia = view.findViewById(R.id.tvBiografia);
        tvBiografia.setText(integrante.getBiografia());

        rvProdAssociadas.setAdapter(integranteAdapter);
        rvProdAssociadas.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_integrante, container, false);

        // Configure the Toolbar
        Toolbar toolbar = rootView.findViewById(R.id.tbIntegrante);

        // setando como actiobar do fragment
        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);

            // colocando o titulo de acordo com nome de integrante
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle(integrante.getNome());
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