package br.com.metting.www.likemeet.Adapters;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.metting.www.likemeet.Class.Evento;
import br.com.metting.www.likemeet.Fragments.ProcurarEventosMeetFragment;
import br.com.metting.www.likemeet.Maps.MapsFragmentProcurarEventos;
import br.com.metting.www.likemeet.R;

/**
 * Created by wisti on 18/12/2016.
 */
public class EventosProcurarAdapter extends RecyclerView.Adapter<EventosProcurarAdapter.MyViewHolder> {
    ArrayList<Evento> list;
    private LayoutInflater mLayoutInflater;

    public EventosProcurarAdapter(Context c, ArrayList<Evento> list) {
        this.mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @Override
    public EventosProcurarAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.card_view_lista_eventos_procurar, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }

    }

    @Override
    public void onBindViewHolder(EventosProcurarAdapter.MyViewHolder holder, int position) {
        // acoes para os botoes
        holder.id = list.get(position).getId();
        holder.textViewDescricao.setText(list.get(position).getDescricao());
        holder.textViewNome.setText(list.get(position).getNome());

        holder.textViewRestricaoIdade.setText(String.valueOf(list.get(position).getIdadeMin()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormatHora = new SimpleDateFormat("HH:mm:ss");
        String data = dateFormat.format(list.get(position).getDataEvento());
        String hora = dateFormatHora.format(list.get(position).getDataEvento());
        holder.textViewData.setText(data);
        holder.textViewHorario.setText(hora);


        String taxaEntrada;
        if (list.get(position).getValorEntrada() != 0.0) {
            taxaEntrada = String.valueOf(list.get(position).getValorEntrada()) + " R$";

        } else {
            taxaEntrada = "Gratuita";
        }
        holder.textViewtaxa.setText(taxaEntrada);

        // alterando a foto
        if (list.get(position).getIdCategoria() == 1) {
            holder.ImageViewCategoria.setImageResource(R.drawable.festa);
        }
        if (list.get(position).getIdCategoria() == 2) {
            holder.ImageViewCategoria.setImageResource(R.drawable.bar);

        }
        if (list.get(position).getIdCategoria() == 3) {
            holder.ImageViewCategoria.setImageResource(R.drawable.jogos);
        }
        if (list.get(position).getIdCategoria() == 4) {
            holder.ImageViewCategoria.setImageResource(R.drawable.esporte);
        }
        if (list.get(position).getIdCategoria() == 5) {
            holder.ImageViewCategoria.setImageResource(R.drawable.casual);
        }
        if (list.get(position).getIdCategoria() == 6) {
            holder.ImageViewCategoria.setImageResource(R.drawable.amigos);
        }
        if (list.get(position).getIdCategoria() == 7) {
            holder.ImageViewCategoria.setImageResource(R.drawable.icon_livro);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public int id;
        public TextView textViewNome;
        public TextView textViewDescricao;
        public TextView textViewData;
        public CardView cardViewEvento;
        public TextView textViewRestricaoIdade;
        public TextView textViewtaxa;
        public TextView textViewHorario;
        public ImageView ImageViewCategoria;
        public CardView cardView;
        public MyViewHolder(final View itemView) {

            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view_evento);
            textViewHorario = (TextView) itemView.findViewById(R.id.textViewHorario);
            textViewNome = (TextView) itemView.findViewById(R.id.textViewNome);
            textViewDescricao = (TextView) itemView.findViewById(R.id.textViewDescricao);
            textViewData = (TextView) itemView.findViewById(R.id.textViewData);
            cardViewEvento = (CardView) itemView.findViewById(R.id.card_view_evento);
            textViewRestricaoIdade = (TextView) itemView.findViewById(R.id.textViewIdade);
            textViewtaxa = (TextView) itemView.findViewById(R.id.textViewTaxa);
            ImageViewCategoria = (ImageView) itemView.findViewById(R.id.imageViewCategoria);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });
        }

    }

}


