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
import otoni.omena.santos.machado.movietag.fragments.HomeFragment;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;
import otoni.omena.santos.machado.movietag.models.Producao;

public class CarrosselFilmesAdapter extends RecyclerView.Adapter {
    HomeFragment homeFragment;
    List<Producao> producaoList;
    public CarrosselFilmesAdapter(HomeFragment homeFragment, List<Producao> producaoList) {
        this.homeFragment = homeFragment;
        this.producaoList = producaoList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_producao, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvProducao = holder.itemView.findViewById(R.id.tvProducao);
        tvProducao.setText(producaoList.get(position).getTitulo());

        ImageView imvProducao = holder.itemView.findViewById(R.id.imgProducao);
        imvProducao.setImageBitmap(producaoList.get(position).getPoster());

        imvProducao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return producaoList.size();
    }
}
