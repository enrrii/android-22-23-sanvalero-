package com.example.glovoandroid.lst_restaurantes.view;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LstRestaurantAdapter extends RecyclerView.Adapter<LstRestaurantAdapter.ViewHolder> {
    private ArrayList<Restaurante> dataset;
    private Context mContext;

    public LstRestaurantAdapter(Context mContext, ArrayList<Restaurante> lstRestaurantes){
        this.dataset = lstRestaurantes;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_lista_restaurantes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurante r = dataset.get(position);
        //holder.idRestaurante.setText(String.valueOf(r.getID_RESTAURANTE()));
        holder.nombreRestaurante.setText(r.getNOMBRE());
        holder.tipoRestaurante.setText(r.getTIPO());
        holder.ventasRestaurante.setText(String.valueOf(r.getVENTAS()));
        holder.puntuacionRestaurante.setText(String.valueOf(r.getPUNTUACION()));
        Picasso.get().load(r.getIMAGEN()).into(holder.imagenRestaurante);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idRestaurante;
        private TextView nombreRestaurante;
        private TextView tipoRestaurante;
        private TextView ventasRestaurante;
        private TextView puntuacionRestaurante;
        private ImageView imagenRestaurante;



        public ViewHolder(View itemView) {
            super(itemView);


            //idRestaurante = itemView.findViewById(R.id.ID_RESTAURANTE);
            nombreRestaurante = itemView.findViewById(R.id.NOMBRE2);
            tipoRestaurante = itemView.findViewById(R.id.TIPO2);
            ventasRestaurante = itemView.findViewById(R.id.VENTAS2);
            puntuacionRestaurante = itemView.findViewById(R.id.PUNTUACION2);
            imagenRestaurante = (ImageView) itemView.findViewById(R.id.IMAGEN);
        }
    }

}
