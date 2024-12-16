package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.ListasHomeAdapter;
import otoni.omena.santos.machado.movietag.adapters.ResultadosBuscaAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultadoBuscaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultadoBuscaFragment extends Fragment {
    MainActivity mainActivity;
    ResultadosBuscaAdapter resultadosBuscaAdapter;

    public ResultadoBuscaFragment() {
        // Required empty public constructor
    }


    public static ResultadoBuscaFragment newInstance() {
        return new ResultadoBuscaFragment();
    }

    public ResultadoBuscaFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public static ResultadoBuscaFragment newInstance(MainActivity mainActivity) {
        return new ResultadoBuscaFragment(mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado_busca, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvResultados = (RecyclerView)view.findViewById(R.id.rvResultados);

        resultadosBuscaAdapter = new ListasHomeAdapter(mainActivity, listasProducoesHome);

        Toolbar toolbar = view.findViewById(R.id.tbImIc);
        if (requireActivity() instanceof MainActivity){
            MainActivity activity =  (MainActivity) requireActivity();
            activity.setSupportActionBar(toolbar);
        }
    }
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        inflater.inflate(R.menu.menu_pesquisa, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.action_search:
                //fazer a ação
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}