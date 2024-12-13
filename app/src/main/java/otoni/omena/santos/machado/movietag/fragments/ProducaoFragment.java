package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import otoni.omena.santos.machado.movietag.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProducaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProducaoFragment extends Fragment {

    public ProducaoFragment() {
        // Required empty public constructor
    }

    public static ProducaoFragment newInstance() {
        return new ProducaoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producao, container, false);
    }
}