package br.com.metting.www.likemeet.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import br.com.metting.www.likemeet.R;


public class InfoEventoFragment extends Fragment {
    private CheckBox checkBoxtaxaEntrada;
    private CheckBox checkBoxRestricaoIdade;
    private CheckBox checkBoxFluxoPessoas;
    private EditText editTextTaxaEntrada;
    private EditText editTextRestricaoIdade;
    private EditText editTextFluxoPessoas;

    //variavel do menu swep
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info_evento, container, false);

        checkBoxtaxaEntrada = (CheckBox) view.findViewById(R.id.checkBoxTaxaEntrada);
        checkBoxRestricaoIdade = (CheckBox) view.findViewById(R.id.checkBoxRestricaoIdade);
        checkBoxFluxoPessoas = (CheckBox) view.findViewById(R.id.checkBoxFluxoPessoas);

        editTextTaxaEntrada = (EditText) view.findViewById(R.id.editTextTaxaEntrada);
        editTextRestricaoIdade = (EditText) view.findViewById(R.id.editTextRestricaoIdade);
        editTextFluxoPessoas = (EditText) view.findViewById(R.id.editTextFluxoPessoas);


        checkBoxFluxoPessoas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxFluxoPessoas.isChecked()) {
                    editTextFluxoPessoas.setVisibility(View.VISIBLE);
                } else {
                    editTextFluxoPessoas.setText("");
                    editTextFluxoPessoas.setVisibility(View.INVISIBLE);
                }
                ;
            }
        });

        checkBoxRestricaoIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxRestricaoIdade.isChecked()) {
                    editTextRestricaoIdade.setVisibility(View.VISIBLE);
                } else {
                    editTextRestricaoIdade.setText("");
                    editTextRestricaoIdade.setVisibility(View.INVISIBLE);
                }
                ;
            }
        });

        checkBoxtaxaEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxtaxaEntrada.isChecked()) {
                    editTextTaxaEntrada.setVisibility(View.VISIBLE);
                } else {
                    editTextTaxaEntrada.setText("");
                    editTextTaxaEntrada.setVisibility(View.INVISIBLE);
                }
                ;
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

}
