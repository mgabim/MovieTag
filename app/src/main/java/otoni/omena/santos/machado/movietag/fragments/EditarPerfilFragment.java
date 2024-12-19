package otoni.omena.santos.machado.movietag.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.activities.CadastroActivity;
import otoni.omena.santos.machado.movietag.activities.MainActivity;
import otoni.omena.santos.machado.movietag.models.Usuario;
import otoni.omena.santos.machado.movietag.utils.Config;

public class EditarPerfilFragment extends Fragment {
    Usuario user;
    MainActivity mainActivity;

    public EditarPerfilFragment(MainActivity mainActivity, Usuario user) {
        this.mainActivity = mainActivity;
        this.user = user;
    }

    public static EditarPerfilFragment newInstance(MainActivity mainActivity, Usuario user) {
        return new EditarPerfilFragment(mainActivity, user);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_editar_perfil, container, false);

        // Configure the Toolbar
        Toolbar toolbar = rootView.findViewById(R.id.tbEditarPerfil);

        // setando como actiobar do fragment
        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);

            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle("Perfil");
            }
        }

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        inflater.inflate(R.menu.menu_titulo, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imvEditarPerfil = view.findViewById(R.id.imvPerfil);
        EditText etEditarUsuario = view.findViewById(R.id.etEditarUsuario);
        etEditarUsuario.setHint(user.getUsuario());
        EditText etEditarEmail = view.findViewById(R.id.etEditarEmail);
        etEditarEmail.setHint(user.getEmail());
        EditText etEditarSenha = view.findViewById(R.id.etEditarSenha);
        EditText etNovaSenha = view.findViewById(R.id.etNovaSenha);
        EditText etConfirmarSenha = view.findViewById(R.id.etConfirmarNovaSenha);

        Button btnAtualizar = view.findViewById(R.id.btnEditarPerfil);



        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEditarSenha.getText().toString().equals(Config.getPassword(getContext()))){
                    if(etNovaSenha.getText().toString().equals(etConfirmarSenha.getText().toString())){
                        user.setEmail(etEditarEmail.getText().toString());
                        user.setUsuario(etEditarUsuario.getText().toString());
                        Config.setPassword(getActivity(), etNovaSenha.getText().toString());
                        PerfilFragment perfilFrag = new PerfilFragment(mainActivity, user);
                        mainActivity.setFragment(perfilFrag);
                    } else{
                        Toast.makeText(getContext(), "As senhas devem coincidir", Toast.LENGTH_LONG).show();
                    }
                } else{
                    Toast.makeText(getContext(), "A senha está errada", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}