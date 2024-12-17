package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.models.MainActivityViewModel;
import otoni.omena.santos.machado.movietag.models.Usuario;

public class PerfilFragment extends Fragment {
    MainActivity mainActivity;
    Usuario usuario;

    public PerfilFragment(MainActivity mainActivity, Usuario usuario) {
        this.mainActivity = mainActivity;
        this.usuario = usuario;
    }

    public static PerfilFragment newInstance(MainActivity mainActivity, Usuario usuario) {
        return new PerfilFragment(mainActivity, usuario);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imvFotoPerfil = view.findViewById(R.id.imvFotoPerfilUsuario);
        TextView tvNome = view.findViewById(R.id.tvNomeUsuarioPerfil);
        TextView tvQtdAvaliacoes = view.findViewById(R.id.tvQtdAvaliacoes);
        TextView tvQtdTagsCriadas = view.findViewById(R.id.tvQtdTagsCriadas);
        TextView tvEmail = view.findViewById(R.id.tvEmailUsuarioPerfil);
        ImageButton imbEditarPerfil = view.findViewById(R.id.imBEditarPerfil);
        Button btnTags = view.findViewById(R.id.btnTagsFavoritas);
        Button btnAvaliacoes = view.findViewById(R.id.btnAvaliacoes);

        imvFotoPerfil.setImageResource(usuario.getFoto());
        tvNome.setText(usuario.getUsuario());
        tvQtdAvaliacoes.setText(mainActivity.getVm().getAvaliacoesUsuario().size());
        tvQtdTagsCriadas.setText(mainActivity.getVm().getTagsCriadas().size());
        tvEmail.setText(usuario.getEmail());


        TabTagsFragment tabTags = TabTagsFragment.newInstance();
        setFragment(tabTags);

        btnTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabTagsFragment tabTags = TabTagsFragment.newInstance();
                setFragment(tabTags);
            }
        });

        btnAvaliacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabAvaliacoesFragment tabAvaliacoes = TabAvaliacoesFragment.newInstance();
                setFragment(tabAvaliacoes);
            }
        });

        imbEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditarPerfilFragment editarPerfilFrag = EditarPerfilFragment.newInstance();
                mainActivity.setFragment(editarPerfilFrag);
            }
        });


    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fTabsUsuario, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}