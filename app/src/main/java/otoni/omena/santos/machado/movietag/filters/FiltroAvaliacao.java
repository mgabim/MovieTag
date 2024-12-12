package otoni.omena.santos.machado.movietag.filters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;

import java.util.HashMap;

import otoni.omena.santos.machado.movietag.R;

public class FiltroAvaliacao {

    View filtroAvaliacao;

    LinearLayout liFiltroAval;

    public FiltroAvaliacao(FragmentActivity activity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        filtroAvaliacao = inflater.inflate(R.layout.dlg_filtros_avaliacao, null);

        liFiltroAval = filtroAvaliacao.findViewById(R.id.liFiltroAval);

        LinearLayout container = filtroAvaliacao.findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (liFiltroAval.getVisibility() == View.GONE) {
                    liFiltroAval.setVisibility(View.VISIBLE);
                } else {
                    liFiltroAval.setVisibility(View.GONE);
                }
            }
        });
    }

    public View getView(){
        return filtroAvaliacao;
    }

    public HashMap<String, Boolean> getCheckBoxes() {
        int qtd = liFiltroAval.getChildCount();
        HashMap<String, Boolean> checkBoxes = new HashMap<>();
        for(int i = 0; i < qtd; i++){
            View child = liFiltroAval.getChildAt(i);
            CheckBox checkBox = (CheckBox) child;
            checkBoxes.put(checkBox.getText().toString(), checkBox.isChecked());
        }
        return checkBoxes;
    }
}
