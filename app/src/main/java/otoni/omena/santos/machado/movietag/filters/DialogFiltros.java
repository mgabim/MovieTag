package otoni.omena.santos.machado.movietag.filters;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import otoni.omena.santos.machado.movietag.R;

public class DialogFiltros extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater.
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dlgView = inflater.inflate(R.layout.dlg_filtros, null);

        LinearLayout container = dlgView.findViewById(R.id.container);

        //criando o filtro tipo da producao
        FiltroTipoProd filtroTipoProd = new FiltroTipoProd(requireActivity());
        container.addView(filtroTipoProd.getView());

        //criando o filtro tags
        FiltroTags filtroTags =  new FiltroTags(requireActivity());
        container.addView(filtroTags.getView());

        // Inflate and set the layout for the dialog.
        // Pass null as the parent view because it's going in the dialog layout.
        builder.setView(dlgView)
                // Add action buttons
                .setPositiveButton("Pesquisar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // realizar a busca avancada
                        // mas por agora, apenas fechar o dialog
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //fechar o dialog
                    }
                });
        return builder.create();
    }
}