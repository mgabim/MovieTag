package otoni.omena.santos.machado.movietag.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import otoni.omena.santos.machado.movietag.R;

public class CadastroActivity extends AppCompatActivity {
    private ImageView imgFotoPerfil;
    private FloatingActionButton fbAddFotoPerfil;
    private FloatingActionButton fbVoltarLogin;
    private EditText etUsuario, etEmail, etSenha, etConfirmaSenha;
    private Button btnLogar;
    private TextView tvJaPossuiLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Inicializar componentes
        imgFotoPerfil = findViewById(R.id.imgFotoPerfil);
        fbAddFotoPerfil = findViewById(R.id.fbAddFotoPerfil);
        fbVoltarLogin = findViewById(R.id.fbVoltarLogin);
        etUsuario = findViewById(R.id.etUsuario);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etConfirmaSenha = findViewById(R.id.etConfirmaSenha);
        btnLogar = findViewById(R.id.btnLogar);
        tvJaPossuiLogin = findViewById(R.id.tvJaPossuiLogin);


    }
}