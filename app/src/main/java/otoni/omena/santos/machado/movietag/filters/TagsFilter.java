package otoni.omena.santos.machado.movietag.filters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import otoni.omena.santos.machado.movietag.R;

public class TagsFilter {
    View filterTags;

    List<String> tags = new ArrayList<>();

    public TagsFilter(FragmentActivity activity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        filterTags = inflater.inflate(R.layout.filter_tags, null);

        AutoCompleteTextView etFiltroTags = filterTags.findViewById(R.id.etFiltroTag);
        String[] tags = {"familia", "mar", "barcos", "aventuras" };

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item, tags);

        etFiltroTags.setThreshold(1);
        etFiltroTags.setAdapter(adapter);

        LinearLayout container = filterTags.findViewById(R.id.container);
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
        return filterTags;
    }

    public List<String> getTagString() {
        return tags;
    }

}
