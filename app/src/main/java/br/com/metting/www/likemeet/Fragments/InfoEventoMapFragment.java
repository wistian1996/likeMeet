package br.com.metting.www.likemeet.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.com.metting.www.likemeet.Class.Evento;
import br.com.metting.www.likemeet.Maps.MapsFragmentProcurarEventos;
import br.com.metting.www.likemeet.R;

public class InfoEventoMapFragment extends Fragment {
    private TextView nome;
    private TextView descricao;
    private TextView data;
    private TextView horario;
    private TextView entrada;
    private TextView idade;
    private TextView endereco;
    private TextView maxPessoas;
    private TextView categoria;
    private Button buttonParticipar;
    private Button buttonVoltar;
    private Evento evento;

    public InfoEventoMapFragment(Evento evento) {
        this.evento = evento;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_evento_map, container, false);
        nome = (TextView) view.findViewById(R.id.textViewNome);
        descricao = (TextView) view.findViewById(R.id.textViewDescricao);
        data = (TextView) view.findViewById(R.id.textViewData);
        horario = (TextView) view.findViewById(R.id.textViewHorario);
        entrada = (TextView) view.findViewById(R.id.textViewEntrada);
        idade = (TextView) view.findViewById(R.id.textViewIdade);
        endereco = (TextView) view.findViewById(R.id.textViewEndereco);
        maxPessoas = (TextView) view.findViewById(R.id.textViewMaxPessoas);
        categoria = (TextView) view.findViewById(R.id.textViewCategoria);
        buttonParticipar = (Button) view.findViewById(R.id.buttonParticipar);
        buttonVoltar = (Button) view.findViewById(R.id.buttonVoltar);

        nome.setText(evento.getNome());
        descricao.setText(evento.getDescricao());
        data.setText(evento.getDataString());
        horario.setText(evento.getHoraString());
        entrada.setText(String.valueOf(evento.getValorEntrada()));
        idade.setText(String.valueOf(evento.getIdadeMin()));
        endereco.setText(evento.getEndereco());
        maxPessoas.setText(String.valueOf(evento.getQtdMax()));
        categoria.setText(String.valueOf(evento.getIdCategoria()));


        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Fragment fragment = new ListaEventoFragment();
                android.support.v4.app.FragmentTransaction fragmentTrasaction =
                       getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTrasaction.replace(R.id.LayoutBaixoMap, fragment);
                fragmentTrasaction.commit();
            }
        });

        return view;
    }


}
