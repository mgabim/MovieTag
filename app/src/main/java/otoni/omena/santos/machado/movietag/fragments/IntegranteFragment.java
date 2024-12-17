package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.CarrosselFilmesAdapter;
import otoni.omena.santos.machado.movietag.adapters.FilmesListaAdapter;
import otoni.omena.santos.machado.movietag.adapters.ListasHomeAdapter;
import otoni.omena.santos.machado.movietag.models.Integrante;
import otoni.omena.santos.machado.movietag.models.ListaProducoes;
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_integrante, container, false);
    }
}