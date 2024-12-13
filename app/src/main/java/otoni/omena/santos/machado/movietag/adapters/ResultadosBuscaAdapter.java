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
import otoni.omena.santos.machado.movietag.fragments.ResultadoBuscaFragment;
import otoni.omena.santos.machado.movietag.models.ListaProducoes;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;
import otoni.omena.santos.machado.movietag.models.Producao;

public class ResultadosBuscaAdapter extends RecyclerView.Adapter {
    ResultadoBuscaFragment resultadoBuscaFragment;
    List<Producao> listaResultadoBusca;

    public ResultadosBuscaAdapter(ResultadoBuscaFragment resultadoBuscaFragment,List<Producao> listaResultadoBusca) {
        this.resultadoBuscaFragment = resultadoBuscaFragment;
        this.listaResultadoBusca = listaResultadoBusca;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflador serve para ler arquivo xml do item e criar os elementos de interface
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_busca, parent, false);
        return new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvTituloProducaoLista = holder.itemView.findViewById(R.id.tvTituloProducaoLista);
        tvTituloProducaoLista.setText(listaResultadoBusca.get(position).getTitulo());

        TextView tvSinopseProducaoLista = holder.itemView.findViewById(R.id.tvSinopseProducaoLista);
        tvTituloProducaoLista.setText(listaResultadoBusca.get(position).getSinopse());

        ImageView imvProducao = holder.itemView.findViewById(R.id.imgPosterLista);
        imvProducao.setImageBitmap(listaResultadoBusca.get(position).getPoster());

        //Perguntar ao Daniel como preencher chip group com limite de espaço

    }

    @Override
    public int getItemCount() {
        return listaResultadoBusca.size();
    }
}
