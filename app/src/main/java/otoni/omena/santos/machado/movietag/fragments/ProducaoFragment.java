package otoni.omena.santos.machado.movietag.fragments;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.CarrosselElencoAdapter;
import otoni.omena.santos.machado.movietag.adapters.ListaTemporadasAdapter;
import otoni.omena.santos.machado.movietag.models.Avaliacao;
import otoni.omena.santos.machado.movietag.models.Producao;

public class ProducaoFragment extends Fragment {
    MainActivity mainActivity;
    Producao producao;

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
        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_producao, container, false);

        // Configure the Toolbar
        Toolbar toolbar = rootView.findViewById(R.id.tbProducao);

        // setando como actiobar do fragment
        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);

            if (activity.getSupportActionBar() != null && producao != null) {
                activity.getSupportActionBar().setTitle(producao.getTitulo());
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                activity.getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_media_previous);
            }

            toolbar.setNavigationOnClickListener(v -> activity.onBackPressed());
        }

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvTitulo = view.findViewById(R.id.tvProducao);
        tvTitulo.setText(producao.getTitulo());

        TextView tvDados = view.findViewById(R.id.textView35);
        String dadosGerais = ""; // Implementar
        tvDados.setText(dadosGerais);

        ProgressBar pb = view.findViewById(R.id.progressBar);
        pb.setProgress(Math.round(producao.getNota()));

        Button btnTrailer = view.findViewById(R.id.btnTrailer);
        btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = producao.getLinkTrailer();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        // Implementar Click em Listas

        RecyclerView rvElenco = view.findViewById(R.id.rvElenco);
        CarrosselElencoAdapter elencoAdapter = new CarrosselElencoAdapter(mainActivity, producao.getListaIntegrantes());
        rvElenco.setAdapter(elencoAdapter);
        rvElenco.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        if(!producao.getTemporadas().isEmpty()){
            RecyclerView rvTemporadas = view.findViewById(R.id.rvTemporadas);
            ListaTemporadasAdapter lstTemporadasAdapter = new ListaTemporadasAdapter(producao.getTemporadas());

            rvTemporadas.setAdapter(lstTemporadasAdapter);
            rvTemporadas.setLayoutManager(new LinearLayoutManager(getContext()));
        }


        Button btnAvaliar = view.findViewById(R.id.btnAvaliarProducao);
        btnAvaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPopupAvaliacao();
            }
        });


    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        inflater.inflate(R.menu.menu_titulo, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    // Implementar dialog de Listas

    private void abrirPopupAvaliacao() {
        // Criar um diálogo
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dlg_avaliacao, null);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(requireContext());
        builder.setView(dialogView);

        // Configurar elementos do layout do diálogo
        RatingBar rbAvaliacao = dialogView.findViewById(R.id.rbAvaliacao);
        Button btnConfirmar = dialogView.findViewById(R.id.btnConfirmarAvaliacao);

        // Criar e exibir o diálogo
        androidx.appcompat.app.AlertDialog dialog = builder.create();
        dialog.show();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int avaliacaoInt = (int) rbAvaliacao.getRating();
                Avaliacao av = new Avaliacao(producao, avaliacaoInt);
                dialog.dismiss(); // Fechar o diálogo
            }
        });
    }


}