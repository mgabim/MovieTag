package otoni.omena.santos.machado.movietag.components;

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

public class filtroApareceSome : AppCompatActivity() {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Nome do Título
        val arrowTitle = findViewById<ImageView>(R.id.arrowTitle)
                val inputTitle = findViewById<EditText>(R.id.inputTitle)

                arrowTitle.setOnClickListener {
            toggleVisibility(inputTitle)
        }

        // Tipo do Título
        val arrowType = findViewById<ImageView>(R.id.arrowType)
                val inputType = findViewById<Spinner>(R.id.inputType)

                arrowType.setOnClickListener {
            toggleVisibility(inputType)
        }
    }

    // Função para alternar visibilidade
    private fun toggleVisibility(view: View) {
        view.visibility = if (view.visibility == View.GONE) View.VISIBLE else View.GONE
    }
}
