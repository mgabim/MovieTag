package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.models.Integrante;

public class IntegranteFragment extends Fragment {
    MainActivity mainActivity;
    Integrante integrante;


    public IntegranteFragment(Integrante integrante, MainActivity mainActivity) {
        // Required empty public constructor
        this.integrante = integrante;
        this.mainActivity = mainActivity;
    }

    public static IntegranteFragment newInstance(Integrante integrante, MainActivity mainActivity) {

        return new IntegranteFragment(integrante, mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_integrante, container, false);
    }
}