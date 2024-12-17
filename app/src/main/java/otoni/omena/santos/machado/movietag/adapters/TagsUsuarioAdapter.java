package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;

public class TagsUsuarioAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;

    public TagsUsuarioAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_usuario_tag, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Button btnUsuarioTag = holder.itemView.findViewById(R.id.btnUsuarioTag);
        btnUsuarioTag.setText(mainActivity.getVm().getTagsCriadas().get(position).getNome());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar frag de Tag
                mainActivity.setFragment();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mainActivity.getVm().getTagsCriadas().size();
    }
}
