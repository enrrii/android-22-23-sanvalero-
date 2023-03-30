package com.example.glovoandroid.ver_ficha.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.carro_compra.view.CarroCompraActivity;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.fltr_usuario.view.FiltrUsuActivity;
import com.example.glovoandroid.verCarta.view.verCartaActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class VerFichaAdapter extends RecyclerView.Adapter<VerFichaAdapter.ViewHolder> {
    private ArrayList<Restaurante> dataset;
    private Context mContext;
    private ImageView btnVolver;
    private ArrayList<Plato> carroCompra;
    private Button btnVerCarro;
    private  TextView tvCantProductos;
    private int idRestaurante;

    public VerFichaAdapter(Context mContext, ArrayList<Restaurante> lstRestaurantes, ImageView btnvolver, ArrayList<Plato> carroCompra,Button btnVerCarro,TextView tvCantProductos,int idRestaurante){
        this.dataset = lstRestaurantes;
        this.mContext = mContext;
        this.btnVolver = btnvolver;
        this.carroCompra = carroCompra;
        this.btnVerCarro = btnVerCarro;
        this.tvCantProductos = tvCantProductos;
        this.idRestaurante = idRestaurante;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_visualizar_ficha,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurante r = dataset.get(position);
        holder.nombreRestaurante.setText(r.getNOMBRE());
        holder.tipoRestaurante.setText(r.getTIPO());
        holder.btnVerCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, verCartaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("idRestaurante", r.getID_RESTAURANTE());
                intent.putExtra("CarroCompras", (Serializable) carroCompra);
                String tvCantProductosS = (String) tvCantProductos.getText();
                intent.putExtra("tvCantProductos", tvCantProductosS);
                mContext.startActivity(intent);
            }
        });
        Picasso.get().load(r.getIMAGEN()).into(holder.imagenRestaurante);
        holder.ratingBar.setRating(r.getPUNTUACION());
        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(mContext, "He cambiado a: " + v, Toast.LENGTH_LONG).show();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(mContext, FiltrUsuActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.putExtra("CarroCompras", (Serializable) carroCompra);
                String tvCantProductosS = (String) tvCantProductos.getText();
                intent2.putExtra("tvCantProductos", tvCantProductosS);
                mContext.startActivity(intent2);
            }
        });

        btnVerCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CarroCompraActivity.class);
                intent.putExtra("CarroCompras",(Serializable) carroCompra);
                intent.putExtra("idRestaurante",idRestaurante);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombreRestaurante;
        private TextView tipoRestaurante;
        private ImageView imagenRestaurante;
        private Button btnVerCarta;
        private RatingBar ratingBar;



        public ViewHolder(View itemView) {
            super(itemView);
            nombreRestaurante = itemView.findViewById(R.id.NOMBRE2);
            tipoRestaurante = itemView.findViewById(R.id.TIPO2);
            imagenRestaurante = (ImageView) itemView.findViewById(R.id.IMAGEN);
            btnVerCarta = (Button) itemView.findViewById(R.id.btnVerCarta);
            ratingBar = (RatingBar) itemView.findViewById(R.id.PUNTUACION2);
        }
    }


}
