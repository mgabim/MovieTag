package otoni.omena.santos.machado.movietag.filters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import otoni.omena.santos.machado.movietag.R;

public class TipoProdFilter {

    View filtroTipoProd;

    List<CheckBox> checkBoxes = new ArrayList<>();

    public TipoProdFilter(FragmentActivity activity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        filtroTipoProd = inflater.inflate(R.layout.dlg_filtros_tipo_producao, null);

        LinearLayout liFiltroTipoProd = filtroTipoProd.findViewById(R.id.liFiltroTipoProd);

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

    public List<CheckBox> getCheckBoxes() {
        return checkBoxes;
    }
}
