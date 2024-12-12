package otoni.omena.santos.machado.movietag.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import otoni.omena.santos.machado.movietag.R;
import otoni.omena.santos.machado.movietag.models.CadastroActivityViewModel;
import otoni.omena.santos.machado.movietag.models.Usuario;

public class CadastroActivity extends AppCompatActivity {
    static int PHOTO_PICKER_REQUEST = 1;
    EditText etUsuarioCadastro, etEmailCadastro, etConfirmarSenha, etSenhaCadastro;
    ImageView imgFoto;
    Uri foto;
    FloatingActionButton faAddFoto;
    TextView tvPossuiLogin;
    Button btnCadastrar;
    String email, usuario, senha, confirmaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        faAddFoto = findViewById(R.id.fbAddFotoPerfil);
        faAddFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

                // Selecionando somente as imagens
                photoPickerIntent.setType("image/*");

                // Intenção que espera um resultado (a foto)\
                startActivityForResult(photoPickerIntent, PHOTO_PICKER_REQUEST);
            }
        });

        // Lógica para criar imagem ou adicionar imagem da Galeria

        tvPossuiLogin = findViewById(R.id.tvPossuiLogin);
        tvPossuiLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etEmailCadastro = findViewById(R.id.etEmailCadastro);
                email = etEmailCadastro.getText().toString().trim();

                etUsuarioCadastro = findViewById(R.id.etUsuarioCadastro);
                usuario = etUsuarioCadastro.getText().toString().trim();

                etSenhaCadastro = findViewById(R.id.etSenhaCadastro);
                senha = etSenhaCadastro.getText().toString().trim();

                etConfirmarSenha = findViewById(R.id.etConfirmarSenhaCadastro);
                confirmaSenha = etConfirmarSenha.getText().toString().trim();

                // Verificações

                if(email.isEmpty() || usuario.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else if(!confirmaSenha.equals(senha)){
                    Toast.makeText(CadastroActivity.this, "As senhas devem coincidir", Toast.LENGTH_LONG).show();
                } // Talvez vire uma função para verificar tudo, inclusive no banco

                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Verifica a chamada do StartActivityForResult, se e a mesma referente a escolha de imagem
        if (requestCode == PHOTO_PICKER_REQUEST) {

            // Verifica se a Activity de destino retornou com sucesso ou nao
            if (resultCode == Activity.RESULT_OK){

                foto = data.getData();
                // Obtem o ImageView
                imgFoto = findViewById(R.id.imgFotoPerfil);

                // Seta a imagem no ImageView
                imgFoto.setImageURI(foto);

                // Salvar foto no Banco de Dados
    }
}}}

