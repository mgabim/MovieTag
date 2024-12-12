package otoni.omena.santos.machado.movietag.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.utils.Config;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuarioEmail, etSenha;
    TextView tvIrParaCadastro;
    Button btnLogar;
    String usuarioEmail, senha;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvIrParaCadastro = findViewById(R.id.tvIrParaCadastro);
        tvIrParaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(i);
            }
        });

        btnLogar = findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsuarioEmail = findViewById(R.id.etUsuario);
                usuarioEmail = etUsuarioEmail.getText().toString();

                etSenha = findViewById(R.id.etSenha);
                senha = etSenha.getText().toString();

                if(usuarioEmail.isEmpty() || senha.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Todos os campos devem ser preenchidos", Toast.LENGTH_LONG).show();
                    return;
                }

                Config.setLogin(LoginActivity.this, usuarioEmail);
                Config.setPassword(LoginActivity.this, senha);

                // Verificações no Banco

                finish();
            }
        });}}
