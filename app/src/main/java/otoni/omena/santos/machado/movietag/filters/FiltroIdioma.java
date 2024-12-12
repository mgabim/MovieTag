package otoni.omena.santos.machado.movietag.filters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import otoni.omena.santos.machado.movietag.R;

public class FiltroIdioma {

    View filtroIdioma;

    List<String> idiomas = new ArrayList<>();

    public FiltroIdioma(FragmentActivity activity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        filtroIdioma = inflater.inflate(R.layout.dlg_filtros_idioma, null);

        AutoCompleteTextView etFiltroIdioma = filtroIdioma.findViewById(R.id.etFiltroIdioma);
        String[] idiomas = { "familia", "mar", "barcos", "aventuras" };

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item, idiomas);

        etFiltroIdioma.setThreshold(4);
        etFiltroIdioma.setAdapter(adapter);

        LinearLayout container = filtroIdioma.findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etFiltroIdioma.getVisibility() == View.GONE) {
                    etFiltroIdioma.setVisibility(View.VISIBLE);
                } else {
                    etFiltroIdioma.setVisibility(View.GONE);
                }
            }
        });
    }

    public View getView(){
        return filtroIdioma;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }
}
