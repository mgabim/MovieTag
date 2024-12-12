package otoni.omena.santos.machado.movietag.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import otoni.omena.santos.machado.movietag.R;

public class CadastroActivity extends AppCompatActivity {
    EditText etUsuarioCadastro, etEmailCadastro, etConfirmarSenha, etSenhaCadastro;
    TextView tvPossuiLogin;
    Button btnCadastrar;
    String email, usuario, senha, confirmaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        // Lógica para criar imagem ou adicionar imagem da Galeria

        tvPossuiLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity();
            }
        });

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
        });




    }
}