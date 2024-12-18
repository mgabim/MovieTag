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

public class FiltroTags {

    View filtroTags;

    List<String> tags = new ArrayList<>();

    public FiltroTags(FragmentActivity activity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        filtroTags = inflater.inflate(R.layout.dlg_filtros_tags, null);

        AutoCompleteTextView etFiltroTags = filtroTags.findViewById(R.id.etFiltroTag);
        String[] tags = { "familia", "mar", "barcos", "aventuras" };

        ArrayAdapter adapter = new ArrayAdapter(activity,android.R.layout.select_dialog_item, tags);



        etFiltroTags.setThreshold(1);
        etFiltroTags.setAdapter(adapter);

        LinearLayout container = filtroTags.findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etFiltroTags.getVisibility() == View.GONE) {
                    etFiltroTags.setVisibility(View.VISIBLE);
                } else {
                    etFiltroTags.setVisibility(View.GONE);
                }
            }
        });
    }

    public View getView(){
        return filtroTags;
    }

    public List<String> getTagString() {
        return tags;
    }

}
