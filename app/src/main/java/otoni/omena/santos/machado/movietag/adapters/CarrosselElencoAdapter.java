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
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.fragments.IntegranteFragment;
import otoni.omena.santos.machado.movietag.models.Integrante;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;

public class CarrosselElencoAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;
    List<Integrante> listaIntegrantes;
    public CarrosselElencoAdapter(MainActivity mainActivity, List<Integrante> listaIntegrantes) {
        this.mainActivity = mainActivity;
        this.listaIntegrantes = listaIntegrantes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflador serve para ler arquivo xml do item e criar os elementos de interface
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_integrante, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView imvIntegrante = holder.itemView.findViewById(R.id.imvIntegrante);
        imvIntegrante.setImageResource(listaIntegrantes.get(position).getFoto());

        TextView tvNome = holder.itemView.findViewById(R.id.tvNomeIntegrante);
        tvNome.setText(listaIntegrantes.get(position).getNome()); // Perguntar pro Daniel como criar o relacionamento entre Integrande e Produção

        TextView tvFuncao = holder.itemView.findViewById(R.id.tvNomePersonagem);
        tvFuncao.setText(""); // Implementar

        Integrante integrante = listaIntegrantes.get(position);

        imvIntegrante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntegranteFragment integranteFrag = new IntegranteFragment(integrante, mainActivity);
                mainActivity.setFragment(integranteFrag);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaIntegrantes.size();
    }

}
