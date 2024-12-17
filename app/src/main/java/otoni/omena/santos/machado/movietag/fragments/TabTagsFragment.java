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

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.TagsUsuarioAdapter;

public class TabTagsFragment extends Fragment {
    MainActivity mainActivity;

    public TabTagsFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public static TabTagsFragment newInstance(MainActivity mainActivity) {
        return new TabTagsFragment(mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_minhas_tags, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvTags = view.findViewById(R.id.rvTagsUsuario);

        TagsUsuarioAdapter tagsUsuarioAdapter = new TagsUsuarioAdapter(mainActivity);
        rvTags.setAdapter(tagsUsuarioAdapter);
        rvTags.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}