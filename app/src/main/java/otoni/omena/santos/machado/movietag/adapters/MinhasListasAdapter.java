package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.fragments.ListaFragment;
import otoni.omena.santos.machado.movietag.fragments.ProducaoFragment;
import otoni.omena.santos.machado.movietag.models.ListaProducoes;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;
import otoni.omena.santos.machado.movietag.models.Producao;

public class MinhasListasAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;

    public MinhasListasAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_listas, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvTituloItemLista = holder.itemView.findViewById(R.id.tvTituloItemLista);
        tvTituloItemLista.setText(mainActivity.getVm().getListas().get(position).getNome());

        ListaProducoes listaProd = mainActivity.getVm().getListas().get(position);

        FloatingActionButton fbItemLista = holder.itemView.findViewById(R.id.fbItemLista);
        fbItemLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaFragment lstFrag = ListaFragment.newInstance(mainActivity, listaProd);
                mainActivity.setFragment(lstFrag);
            }
        });

        RecyclerView rvFilmes = holder.itemView.findViewById(R.id.rvItemLista);
        CarrosselFilmesAdapter filmesAdapter = new CarrosselFilmesAdapter(mainActivity, mainActivity.getVm().getListas().get(position).getProducoes());
        rvFilmes.setAdapter(filmesAdapter);
        rvFilmes.setLayoutManager(new LinearLayoutManager(rvFilmes.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public int getItemCount() {
        return mainActivity.getVm().getListas().size();
    }
}
