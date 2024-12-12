package otoni.omena.santos.machado.movietag.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.fragments.HomeFragment;
import otoni.omena.santos.machado.movietag.models.MyViewHolder;

public class CarrosselFilmesAdapter extends RecyclerView.Adapter {
    HomeFragment homeFragment;
    public CarrosselFilmesAdapter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
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

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
