package otoni.omena.santos.machado.movietag.filters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getAvaliacoes() {
        List<String> avaliacoes = new ArrayList<>();
        avaliacoes.add(filtroAvaliacao.findViewById(R.id.etAval1).toString());
        avaliacoes.add(filtroAvaliacao.findViewById(R.id.etAval2).toString());
        return avaliacoes;
    }
}
