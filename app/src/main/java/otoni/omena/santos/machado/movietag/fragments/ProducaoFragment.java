package otoni.omena.santos.machado.movietag.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.CarrosselElencoAdapter;
import otoni.omena.santos.machado.movietag.adapters.ListaTemporadasAdapter;
import otoni.omena.santos.machado.movietag.models.Avaliacao;
import otoni.omena.santos.machado.movietag.models.Producao;
import otoni.omena.santos.machado.movietag.models.Tag;

public class ProducaoFragment extends Fragment {
    MainActivity mainActivity;
    Producao producao;
    MinhasListasFragment minhalista;

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

            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle(producao.getTitulo());

            }
        }

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imvPoster = view.findViewById(R.id.imvPoster);
        imvPoster.setImageResource(producao.getPoster());

        ImageView imvBackground = view.findViewById(R.id.imgBackground);
        imvBackground.setImageResource(producao.getBackgroundPoster());

        TextView tvTitulo = view.findViewById(R.id.tvTitulo);
        tvTitulo.setText(producao.getTitulo());

        TextView tvDados = view.findViewById(R.id.tvInfoFilme);
        String dadosGerais = ""; // Implementar
        tvDados.setText(dadosGerais);

        TextView tvNota = view.findViewById(R.id.tvNota);
        tvNota.setText(producao.getNota().toString());

        ChipGroup chipGroup = view.findViewById(R.id.cgTagsProducao);
        for (Tag tag : producao.getListaTags()) {
            Chip chip = new Chip(chipGroup.getContext());
            chip.setText(tag.getNome());
            chip.setCheckable(false); // Define se o chip será clicável ou selecionável
            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TagFragment tagFragment = TagFragment.newInstance(mainActivity, tag);
                    mainActivity.setFragment(tagFragment);
                }
            });
            // chip.setChipBackgroundColorResource(R.color.chipBackground); // Customize as cores se necessário
            // chip.setTextColor(ContextCompat.getColor(chipGroup.getContext(), R.color.chipText)); // Personalize o texto
            chipGroup.addView(chip); // Adiciona o chip ao ChipGroup
        }

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

        TextView tvTemporadas = view.findViewById(R.id.tvTemporadas);
        RecyclerView rvTemporadas = view.findViewById(R.id.rvTemporadas);
        tvTemporadas.setVisibility(View.INVISIBLE);
        rvTemporadas.setVisibility(View.INVISIBLE);

        if(!producao.getTemporadas().isEmpty()){
            tvTemporadas.setVisibility(View.VISIBLE);
            rvTemporadas.setVisibility(View.VISIBLE);

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

        Button btnAddLista = view.findViewById(R.id.btnAdicionarListas);
        btnAddLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPopupLista();
            }

        });

        Button btnAddTag = view.findViewById(R.id.btnAdicionarTag);
        btnAddTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPopupAddTag();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater.
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dlgView = inflater.inflate(R.layout.dlg_avaliacao, null);

        // Inflate and set the layout for the dialog.
        // Pass null as the parent view because it's going in the dialog layout.
        builder.setView(dlgView)
                .setPositiveButton("Avaliar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Sign in the user.
                        RatingBar rbAvaliacao = dlgView.findViewById(R.id.rbAvaliacao);
                        int nota = rbAvaliacao.getNumStars();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        builder.create().show();
    }

    private void abrirPopupLista() {
        // Inicializa o Builder do diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Infla o layout do diálogo
        View dlgView = inflater.inflate(R.layout.dlg_add_prod_lista, null);

        ImageButton btnCriarNovaLista = dlgView.findViewById(R.id.btnCriarNovaLista);

        // Verifica se o botão foi encontrado
        if (btnCriarNovaLista == null) {
            Log.e("ProducaoFragment", "btnCriarNovaLista não encontrado no layout dlg_add_prod_lista.");
            return; // Retorna para evitar o crash
        }

        // Define o comportamento do clique no botão
        btnCriarNovaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPopupCriarLista();
            }
        });

        // Configura o diálogo
        builder.setView(dlgView)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o diálogo
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Implementa a lógica ao salvar a lista
                    }
                });

        // Exibe o diálogo
        builder.create().show();
    }


    private void abrirPopupAddTag() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater.
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dlgView = inflater.inflate(R.layout.dlg_adicionar_tag, null);

        // Inflate and set the layout for the dialog.
        // Pass null as the parent view because it's going in the dialog layout.
        builder.setView(dlgView)
                // Add action buttons
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Sign in the user.
                    }
                });
        builder.create().show();
    }

    public void abrirPopupCriarLista() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater.
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dlgView = inflater.inflate(R.layout.dlg_criar_lista, null);

        // Inflate and set the layout for the dialog.
        // Pass null as the parent view because it's going in the dialog layout.
        builder.setView(dlgView)
                .setPositiveButton("Criar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        builder.create().show();


    }


}