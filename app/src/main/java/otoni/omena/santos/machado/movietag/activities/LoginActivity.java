package otoni.omena.santos.machado.movietag.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import otoni.omena.santos.machado.movietag.R;

public class LoginActivity extends AppCompatActivity {
    EditText etUsuarioCadastro, etEmailCadastro, etConfirmarSenha, etSenhaCadastro;
    TextView tvIrParaCadastro;
    Button btnLogar;
    String usuarioEmail, senha;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Lógica para criar imagem ou adicionar imagem da Galeria

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etEmailCadastro = findViewById(R.id.etEmailCadastro);
                email = etEmailCadastro.getText().toString();

                etUsuarioCadastro = findViewById(R.id.etUsuarioCadastro);
                usuario = etUsuarioCadastro.getText().toString();

                etSenhaCadastro = findViewById(R.id.etSenhaCadastro);
                senha = etSenhaCadastro.getText().toString();

                etConfirmarSenha = findViewById(R.id.etConfirmarSenhaCadastro);
                confirmaSenha = etConfirmarSenha.getText().toString();

                // Verificações

                Intent i = new Intent(CadastroActivity.this, MainActivity.class);
                startActivity(i);
    }
}