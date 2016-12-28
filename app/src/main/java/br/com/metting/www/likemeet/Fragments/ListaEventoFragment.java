package br.com.metting.www.likemeet.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.metting.www.likemeet.Adapters.EventosProcurarAdapter;
import br.com.metting.www.likemeet.Class.Evento;
import br.com.metting.www.likemeet.R;


public class ListaEventoFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Evento> list;

    public ListaEventoFragment() {
        list = Evento.getListaEventos();
    }

    public ListaEventoFragment(ArrayList<Evento> list) {
        this.list = list;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_evento, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerlistaEventos);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        EventosProcurarAdapter adapter = new EventosProcurarAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

        return view;

    }

}
