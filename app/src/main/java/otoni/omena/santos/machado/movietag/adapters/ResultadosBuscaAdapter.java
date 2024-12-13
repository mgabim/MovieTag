package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.fragments.ResultadoBuscaFragment;
import otoni.omena.santos.machado.movietag.models.Lista;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;

public class ResultadosBuscaAdapter extends RecyclerView.Adapter {
    ResultadoBuscaFragment resultadoBuscaFragment;
    List<Lista> listaResultadoBusca;

    public ResultadosBuscaAdapter(ResultadoBuscaFragment resultadoBuscaFragment,List<Lista> listaResultadoBusca) {
        this.resultadoBuscaFragment = resultadoBuscaFragment;
        this.listaResultadoBusca = listaResultadoBusca;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflador serve para ler arquivo xml do item e criar os elementos de interface
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.fragment_resultado_busca, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerView rvResultados = (RecyclerView)holder.itemView.findViewById(R.id.rvResultados);
    }

    @Override
    public int getItemCount() {
        return listaResultadoBusca.size();
    }
}
