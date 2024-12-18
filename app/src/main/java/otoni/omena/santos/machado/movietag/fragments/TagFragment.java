package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.FilmesAssociadosTagAdapter;
import otoni.omena.santos.machado.movietag.models.Tag;

public class TagFragment extends Fragment {
    MainActivity mainActivity;
    Tag tag;

    public TagFragment(MainActivity mainActivity, Tag tag) {
        this.mainActivity = mainActivity;
        this.tag = tag;
    }

    public static TagFragment newInstance(MainActivity mainActivity, Tag tag) {
        return new TagFragment(mainActivity, tag);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Código para colocar tag na toolbar

        TextView tvNumAcessos = view.findViewById(R.id.tvNumAcessos);
        RecyclerView rvFilmesAssociadosTag = view.findViewById(R.id.rvFilmesAssociadosTag);

        FilmesAssociadosTagAdapter filmesAdapter = new FilmesAssociadosTagAdapter(mainActivity, tag);
        rvFilmesAssociadosTag.setAdapter(filmesAdapter);
        rvFilmesAssociadosTag.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}