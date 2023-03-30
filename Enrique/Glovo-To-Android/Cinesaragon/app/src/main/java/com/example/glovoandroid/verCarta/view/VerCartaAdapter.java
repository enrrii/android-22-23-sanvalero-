package com.example.glovoandroid.verCarta.view;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.glovoandroid.R;
import com.example.glovoandroid.carro_compra.view.CarroCompraActivity;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.ver_ficha.view.VerFichaActivity;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class VerCartaAdapter extends RecyclerView.Adapter<VerCartaAdapter.ViewHolder> {
    private ArrayList<Plato> dataset;
    private Context mContext;

    private TextView tvCantProductos;

    private ArrayList<Plato> carroCompra;

    private Button verCarro;
    private ImageView btnVolver;

    private int idRestaurante;
    public VerCartaAdapter(Context mContext, ArrayList<Plato> lstPlato, TextView tvCantProductos, Button verCarro, ImageView btnVolver, ArrayList<Plato> carroCompra, int idRestaurante){
        this.dataset = lstPlato;
        this.mContext = mContext;
        if(carroCompra != null){
            this.carroCompra = carroCompra;
        }else{
            this.carroCompra = new ArrayList<Plato>();
        }

        this.tvCantProductos = tvCantProductos;
        this.verCarro = verCarro;
        this.btnVolver = btnVolver;
        this.idRestaurante = idRestaurante;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_listar_platos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Plato c = dataset.get(position);

        holder.nombreProducto.setText(c.getNombre());

        holder.precio.setText(String.valueOf(c.getPrecio()) + "€");

        Picasso.get().load(c.getImagen()).into(holder.imagenCarta);
        holder.btnOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCantProductos.setText(""+(Integer.parseInt(tvCantProductos.getText().toString().trim()) + 1));
                //tvCantProductos.setText(""+(Integer.parseInt(tvCantProductos.getText().toString().trim()) - 1)); para eliminar

                carroCompra.add(c);

            }
        });
        verCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CarroCompraActivity.class);
                intent.putExtra("CarroCompras",(Serializable) carroCompra);
                intent.putExtra("idRestaurante",idRestaurante);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(mContext, VerFichaActivity.class);
                intent2.putExtra("CarroCompras",(Serializable) carroCompra);
                String tvCantProductosS = (String) tvCantProductos.getText();
                intent2.putExtra("tvCantProductos", tvCantProductosS);
                intent2.putExtra("idRestaurante",idRestaurante);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent2);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView nombreProducto;
        private Button btnOrdenar;
        private TextView precio;

        private ImageView imagenCarta;


        public ViewHolder(View itemView) {
            super(itemView);
            btnOrdenar = itemView.findViewById(R.id.btnOrdenar);
            nombreProducto = itemView.findViewById(R.id.nombreProducto);
            precio = itemView.findViewById(R.id.precio);
            imagenCarta = (ImageView) itemView.findViewById(R.id.IMAGEN);
        }


    }


}
