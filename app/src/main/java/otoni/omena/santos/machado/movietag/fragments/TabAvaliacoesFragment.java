package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.AvaliacoesUsuarioAdapter;
import otoni.omena.santos.machado.movietag.utils.Util;

public class TabAvaliacoesFragment extends Fragment {
    MainActivity mainActivity;



    public TabAvaliacoesFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public static TabAvaliacoesFragment newInstance(MainActivity mainActivity) {
        return new TabAvaliacoesFragment(mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_avaliacoes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvTabAvaliacoes = view.findViewById(R.id.rvTabAvaliacoes);
        AvaliacoesUsuarioAdapter avalUserAdapter = new AvaliacoesUsuarioAdapter(mainActivity);

        rvTabAvaliacoes.setAdapter(avalUserAdapter);
        float w = 100; // Alterar conforme os tamanhos
        int numberOfColumns = Util.calculateNoOfColumns(getContext(), w);
        rvTabAvaliacoes.setLayoutManager(new GridLayoutManager(getContext(),numberOfColumns));
    }
}