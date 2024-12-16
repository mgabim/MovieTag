package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;
import otoni.omena.santos.machado.movietag.models.Producao;

public class ListaTemporadasAdapter extends RecyclerView.Adapter {
    List<Producao> listaTemporadas;

    public ListaTemporadasAdapter(List<Producao> listaTemporadas) {
        this.listaTemporadas = listaTemporadas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflador serve para ler arquivo xml do item e criar os elementos de interface
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_temporada, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvTituloTemporada = holder.itemView.findViewById(R.id.tvTemporada);
        tvTituloTemporada.setText(listaTemporadas.get(position).getTitulo());

        TextView tvAnoQtdEps = holder.itemView.findViewById(R.id.tvAnoQtdEp);
        tvAnoQtdEps.setText(""); // Implementar

        TextView tvDataExibicao = holder.itemView.findViewById(R.id.tvDataExibicao);
        tvDataExibicao.setText(""); // Implementar
    }

    @Override
    public int getItemCount() {
        return listaTemporadas.size();
    }
}
