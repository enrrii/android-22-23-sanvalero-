package com.example.glovoandroid.carro_compra.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Plato;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VerCarroAdapter extends RecyclerView.Adapter<VerCarroAdapter.ViewHolder> {
    private ArrayList<Plato> carroCompra;
    private Context mContext;
    private TextView tvTotal;

    public VerCarroAdapter(Context mContext, ArrayList<Plato> carroCompra,TextView tvTotal){
        this.carroCompra = carroCompra;
        this.tvTotal = tvTotal;
        this.mContext = mContext;
    }

    public void calcularTotal(int cantItems){
        double total = 0;
        if(carroCompra != null){
            for(int i = 0 ; i < carroCompra.size() ; i++) {
                total = total + Double.parseDouble(""+carroCompra.get(i).getPrecio() * cantItems);
            }

            tvTotal.setText(""+total);
        }else{
            tvTotal.setText("¡Vaya, parece que aún no has metido nada a tu carro!");
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_objetos_carro,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int cant = carroCompra.get(holder.getAdapterPosition()).getCantidad();
        calcularTotal(cant);
        //holder.idRestaurante.setText(String.valueOf(r.getID_RESTAURANTE()));
        holder.nombrePlato.setText(carroCompra.get(position).getNombre());
        //holder.tvDescripcion.setText(carroCompra.get(position).getDescripcion());
        holder.tvPrecio.setText(""+carroCompra.get(holder.getAdapterPosition()).getPrecio() + "€");
        Picasso.get().load(carroCompra.get(position).getImagen()).into(holder.imagenRestaurante);

        holder.edtCantidad.setText(Integer.toString(cant));

        holder.btnEliminarPCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carroCompra.remove(holder.getAdapterPosition());
                calcularTotal(cant);
                notifyDataSetChanged();

            }
        });
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carroCompra.get(holder.getAdapterPosition()).addOne();
                calcularTotal(carroCompra.get(holder.getAdapterPosition()).getCantidad());
                notifyDataSetChanged();
            }
        });
        holder.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carroCompra.get(holder.getAdapterPosition()).removeOne();
                calcularTotal(carroCompra.get(holder.getAdapterPosition()).getCantidad());
                notifyDataSetChanged();
            }
        });




    }

    @Override
    public int getItemCount() {
        if(carroCompra != null){
            return carroCompra.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPrecio,nombrePlato,edtCantidad;
        private  ImageView btnEliminarPCarrito,btnDecrease,btnAdd,imagenRestaurante;

        public ViewHolder(View itemView) {
            super(itemView);
            btnEliminarPCarrito = itemView.findViewById(R.id.btnEliminarPCarrito);
            nombrePlato = itemView.findViewById(R.id.tvNomProducto);
            //tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            imagenRestaurante = (ImageView) itemView.findViewById(R.id.IMAGEN);
            edtCantidad = itemView.findViewById(R.id.edtCantidad);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }
    }
}
