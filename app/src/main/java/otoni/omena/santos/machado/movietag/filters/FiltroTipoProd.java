package otoni.omena.santos.machado.movietag.filters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import otoni.omena.santos.machado.movietag.R;

public class FiltroTipoProd {

    View filtroTipoProd;

    LinearLayout liFiltroTipoProd;

    public FiltroTipoProd(FragmentActivity activity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        filtroTipoProd = inflater.inflate(R.layout.dlg_filtros_tipo_producao, null);

        liFiltroTipoProd = filtroTipoProd.findViewById(R.id.liFiltroTipoProd);

        LinearLayout container = filtroTipoProd.findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (liFiltroTipoProd.getVisibility() == View.GONE) {
                    liFiltroTipoProd.setVisibility(View.VISIBLE);
                } else {
                    liFiltroTipoProd.setVisibility(View.GONE);
                }
            }
        });
    }

    public View getView(){
        return filtroTipoProd;
    }

    public HashMap<String, Boolean> getCheckBoxes() {
        int qtd = liFiltroTipoProd.getChildCount();
        HashMap<String, Boolean> checkBoxes = new HashMap<>();
        for(int i = 0; i < qtd; i++){
            View child = liFiltroTipoProd.getChildAt(i);
            CheckBox checkBox = (CheckBox) child;
            checkBoxes.put(checkBox.getText().toString(), checkBox.isChecked());
        }
        return checkBoxes;
    }
}
