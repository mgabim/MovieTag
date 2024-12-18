package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import otoni.omena.santos.machado.movietag.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlataformasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlataformasFragment extends Fragment {

    public PlataformasFragment() {
        // Required empty public constructor
    }

    public static PlataformasFragment newInstance() {
        return new PlataformasFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plataformas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvStream = view.findViewById(R.id.rvStream);
        RecyclerView rvAlugar = view.findViewById(R.id.rvAlugar);
        RecyclerView rvComprar = view.findViewById(R.id.rvComprar);
    }
}