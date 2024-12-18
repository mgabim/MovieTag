package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.models.ListaProducoes;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;

public class ListasHomeAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;
    List<ListaProducoes> listasProducoesHome;
    public ListasHomeAdapter(MainActivity mainActivity, List<ListaProducoes> listasProducoesHome) {
        this.mainActivity = mainActivity;
        this.listasProducoesHome = listasProducoesHome;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflador serve para ler arquivo xml do item e criar os elementos de interface
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_home, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvTituloItemHome = holder.itemView.findViewById(R.id.tvTituloItemHome);
        tvTituloItemHome.setText(listasProducoesHome.get(position).getNome());

        RecyclerView rvListasHome = (RecyclerView)holder.itemView.findViewById(R.id.rvItemHome);

        CarrosselFilmesAdapter carrosselFilmesAdapter = new CarrosselFilmesAdapter(mainActivity, listasProducoesHome.get(position).getProducoes());
        rvListasHome.setAdapter(carrosselFilmesAdapter);
        rvListasHome.setLayoutManager(new LinearLayoutManager(rvListasHome.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public int getItemCount() {
        return listasProducoesHome.size();
    }
}
