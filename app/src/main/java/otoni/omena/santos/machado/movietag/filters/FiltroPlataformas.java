package otoni.omena.santos.machado.movietag.filters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;

import java.util.HashMap;

import otoni.omena.santos.machado.movietag.R;

public class FiltroPlataformas {

    View filtroPlataformas;

    LinearLayout liFiltroPlats;

    public FiltroPlataformas(FragmentActivity activity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        filtroPlataformas = inflater.inflate(R.layout.dlg_filtros_plataformas, null);

        liFiltroPlats = filtroPlataformas.findViewById(R.id.liFiltroPlats);

        LinearLayout container = filtroPlataformas.findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (liFiltroPlats.getVisibility() == View.GONE) {
                    liFiltroPlats.setVisibility(View.VISIBLE);
                } else {
                    liFiltroPlats.setVisibility(View.GONE);
                }
            }
        });
    }

    public View getView(){
        return filtroPlataformas;
    }

    public HashMap<String, Boolean> getPlataformas() {
        int qtd = liFiltroPlats.getChildCount();
        HashMap<String, Boolean> checkBoxes = new HashMap<>();
        for(int i = 0; i < qtd; i++){
            View child = liFiltroPlats.getChildAt(i);
            CheckBox checkBox = (CheckBox) child;
            checkBoxes.put(checkBox.getText().toString(), checkBox.isChecked());
        }
        return checkBoxes;
    }
}
