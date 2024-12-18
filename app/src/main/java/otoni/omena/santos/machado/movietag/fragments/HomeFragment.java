package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.adapters.ListasHomeAdapter;
import otoni.omena.santos.machado.movietag.models.ListaProducoes;
import otoni.omena.santos.machado.movietag.models.MainActivityViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    ListasHomeAdapter homeAdapter;
    List<ListaProducoes> listasProducoesHome;
    MainActivity mainActivity;
    private View view;
    private MainActivityViewModel vm;


    public HomeFragment() {
        // Required empty public constructor
    }

    public HomeFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public static HomeFragment newInstance(MainActivity mainActivity) {
        return new HomeFragment(mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize the Toolbar
        Toolbar toolbar = rootView.findViewById(R.id.tbHomeFragment);

        // Set the Toolbar as the ActionBar (in the Fragment)
        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);

            // Set toolbar title or other properties
            activity.getSupportActionBar().setTitle("MovieTag");
        }

        // Enable the menu for this fragment
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvListasHome = (RecyclerView)view.findViewById(R.id.rvListasHomeFragment);
        vm = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);

        List<ListaProducoes> listasProducoesHome = vm.getListasPadrao();
        homeAdapter = new ListasHomeAdapter(mainActivity, listasProducoesHome);

        rvListasHome.setAdapter(homeAdapter);
        rvListasHome.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        inflater.inflate(R.menu.menu_pesquisa, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    //configurar ação quando o botão de pesquisa for acionado
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            // Criar o Fragmento
            ResultadoBuscaFragment resultadosFrag = ResultadoBuscaFragment.newInstance();
            mainActivity.setFragment(resultadosFrag);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }















    public void navigateToEditarPerfilFragment(){
        EditarPerfilFragment editarPerfilFragment = new EditarPerfilFragment();

        if (getActivity() != null) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flPrincipal, editarPerfilFragment) // ID do container onde os fragmentos são exibidos
                    .addToBackStack(null) // Adiciona à pilha de navegação
                    .commit();
        }

    }
}