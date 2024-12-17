package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.fragments.ProducaoFragment;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;

public class AvaliacoesUsuarioAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;

    public AvaliacoesUsuarioAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_usuario_avaliacao, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView imvPoster = holder.itemView.findViewById(R.id.imvPosterAvaliacao);
        imvPoster.setImageResource(mainActivity.getVm().getAvaliacoesUsuario().get(position).getProducao().getPoster());

        TextView tvTitulo = holder.itemView.findViewById(R.id.tvTituloAvaliacao);
        tvTitulo.setText(mainActivity.getVm().getAvaliacoesUsuario().get(position).getProducao().getTitulo());

        RatingBar rbAvaliacao = holder.itemView.findViewById(R.id.rbAvaliacao);
        rbAvaliacao.setNumStars(mainActivity.getVm().getAvaliacoesUsuario().get(position).getAvaliacao());

        int positionSelected = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProducaoFragment prodFrag = new ProducaoFragment(mainActivity, mainActivity.getVm().getAvaliacoesUsuario().get(positionSelected).getProducao());
                mainActivity.setFragment(prodFrag);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainActivity.getVm().getAvaliacoesUsuario().size();
    }
}
