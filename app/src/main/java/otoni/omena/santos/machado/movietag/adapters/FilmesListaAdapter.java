package otoni.omena.santos.machado.movietag.adapters;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.models.Producao;

public class FilmesListaAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvProducao = holder.itemView.findViewById(R.id.tvProducao);
        tvProducao.setText(producaoList.get(position).getTitulo());

        ImageView imvProducao = holder.itemView.findViewById(R.id.imgProducao);
        imvProducao.setImageResource(producaoList.get(position).getPoster());

        Producao producaoAtual = producaoList.get(position);

        FloatingActionButton fbItemLista = holder.itemView.findViewById(R.id.fbItemLista);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
