package br.com.metting.www.likemeet.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.metting.www.likemeet.Class.Amigo;
import br.com.metting.www.likemeet.R;

/**
 * Created by wisti on 04/12/2016.
 */
public class AmigosHorizontalAdapter extends RecyclerView.Adapter<AmigosHorizontalAdapter.MyViewHolder> {

    ArrayList<Amigo> list;
    private LayoutInflater mLayoutInflater;

    public AmigosHorizontalAdapter(Context c) {
        Amigo control = new Amigo();
        list = control.getLista();
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public AmigosHorizontalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.card_view_amigos_selecionados, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(AmigosHorizontalAdapter.MyViewHolder holder, int position) {
        holder.textViewNome.setText(list.get(position).getNome());

    }

    public void adicionar(Amigo amigo) {
        list.add(amigo);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNome;

        public MyViewHolder(View itemView) {

            super(itemView);
            textViewNome = (TextView) itemView.findViewById(R.id.textViewNome);

        }
    }
}
