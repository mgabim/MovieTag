package otoni.omena.santos.machado.movietag.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.fragments.ProducaoFragment;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;
import otoni.omena.santos.machado.movietag.models.Producao;
import otoni.omena.santos.machado.movietag.models.Tag;

public class FilmesAssociadosTagAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;
    Tag tag;

    public FilmesAssociadosTagAdapter(MainActivity mainActivity, Tag tag) {
        this.mainActivity = mainActivity;
        this.tag = tag;
    }

    @NonNull
    @Override


    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_producoes_tag, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView imvPoster = holder.itemView.findViewById(R.id.imvPosterProdTag);
        TextView tvTitulo = holder.itemView.findViewById(R.id.tvTituloProducaoTag);

        Producao prod = tag.getListaProducoes().get(position);

        TextView tvSinopse = holder.itemView.findViewById(R.id.tvSinopseProducaoTag);

        imvPoster.setImageResource(prod.getPoster());
        tvTitulo.setText(prod.getTitulo());
        tvSinopse.setText(prod.getSinopse());

        ChipGroup chipGroup = holder.itemView.findViewById(R.id.cgTagsProducaoTag);
        for (Tag tag : prod.getListaTags()) {
            Chip chip = new Chip(chipGroup.getContext());
            chip.setText(tag.getNome());
            chip.setCheckable(false); // Define se o chip será clicável ou selecionável
            // chip.setChipBackgroundColorResource(R.color.chipBackground); // Customize as cores se necessário
            // chip.setTextColor(ContextCompat.getColor(chipGroup.getContext(), R.color.chipText)); // Personalize o texto
            chipGroup.addView(chip); // Adiciona o chip ao ChipGroup
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProducaoFragment prodFrag = ProducaoFragment.newInstance(mainActivity, prod);
                mainActivity.setFragment(prodFrag);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tag.getListaProducoes().size();
    }
}
