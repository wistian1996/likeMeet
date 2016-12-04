package br.com.metting.www.likemeet.Adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.metting.www.likemeet.Class.Amigo;
import br.com.metting.www.likemeet.R;

/**
 * Created by wisti on 03/12/2016.
 */
public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.MyViewHolder> {
    ArrayList<Amigo> list;
    private LayoutInflater mLayoutInflater;

    public AmigosAdapter(Context c) {
        Amigo control = new Amigo();
        list = control.getLista();
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public AmigosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.card_view_lista_amigos_add, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(AmigosAdapter.MyViewHolder holder, int position) {
        holder.textViewNome.setText(list.get(position).getNome());
        holder.textViewTel.setText(list.get(position).getTel());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNome;
        public TextView textViewTel;
        public CheckBox checkBox;

        public MyViewHolder(View itemView) {

            super(itemView);
            textViewNome = (TextView) itemView.findViewById(R.id.textViewNome);
            textViewTel = (TextView) itemView.findViewById(R.id.textViewTel);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);



        }
    }
}
