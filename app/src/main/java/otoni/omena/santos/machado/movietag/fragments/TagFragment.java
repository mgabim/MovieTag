package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import otoni.omena.santos.machado.movietag.R;

public class TagFragment extends Fragment {

    public TagFragment() {
        // Required empty public constructor
    }

    public static TagFragment newInstance() {
        return new TagFragment();
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
}