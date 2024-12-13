package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.models.Producao;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProducaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProducaoFragment extends Fragment {
    MainActivity mainActivity;
    Producao producao;

    public ProducaoFragment() {
        // Required empty public constructor
    }

    public static ProducaoFragment newInstance() {
        return new ProducaoFragment();
    }

    public ProducaoFragment(MainActivity mainActivity, Producao producao) {
        this.mainActivity = mainActivity;
        this.producao = producao;

    }

    public static ProducaoFragment newInstance(MainActivity mainActivity, Producao producao) {
        return new ProducaoFragment(mainActivity, producao);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producao, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvTitulo = view.findViewById(R.id.tvProducao);
        tvTitulo.setText(producao.getTitulo());

        TextView tvDados = view.findViewById(R.id.tvDados);
        String dadosGerais = ""; // Implementar
        tvDados.setText(dadosGerais);
    }
}