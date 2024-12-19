package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.fragments.ProducaoFragment;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;
import otoni.omena.santos.machado.movietag.models.Producao;

public class FilmesListaAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;
    List<Producao> producoes;
    public FilmesListaAdapter(MainActivity mainActivity, List<Producao> producoes) {
        this.mainActivity = mainActivity;
        this.producoes = producoes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_lista_producao, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvProducao = holder.itemView.findViewById(R.id.tvTituloProducaoLista);
        tvProducao.setText(producoes.get(position).getTitulo());

        ImageView imvProducao = holder.itemView.findViewById(R.id.imvPosterLista);
        imvProducao.setImageResource(producoes.get(position).getPoster());

        TextView tvSinopse = holder.itemView.findViewById(R.id.tvSinopseProducaoLista);
        tvSinopse.setText(producoes.get(position).getSinopse());

        Producao producaoAtual = producoes.get(position);

        imvProducao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProducaoFragment prodFrag = ProducaoFragment.newInstance(mainActivity, producaoAtual);
                mainActivity.setFragment(prodFrag);
            }
        });



    }

    @Override
    public int getItemCount() {
        return producoes.size();
    }
}
