package otoni.omena.santos.machado.movietag.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import otoni.omena.santos.machado.movietag.R;

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

                // Verificações no Banco

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });}}
