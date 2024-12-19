package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;
import otoni.omena.santos.machado.movietag.models.Plataforma;

public class ListaPlataformasAdapter extends RecyclerView.Adapter {
    List<Plataforma> listaPlat;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_plataforma, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView imvFoto = holder.itemView.findViewById(R.id.imvPlataforma);
        TextView tvNome = holder.itemView.findViewById(R.id.tvNomePlataforma);

        imvFoto.setImageResource(listaPlat.get(position).getFoto());
        tvNome.setText(listaPlat.get(position).getNome());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click para a página da plataforma
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPlat.size();
    }
}
