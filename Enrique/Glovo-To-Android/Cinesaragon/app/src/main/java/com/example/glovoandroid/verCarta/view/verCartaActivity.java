package com.example.glovoandroid.verCarta.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Plato;

import com.example.glovoandroid.verCarta.VerCartaContract;
import com.example.glovoandroid.verCarta.presenter.VerCartaPresenter;
import com.example.glovoandroid.ver_ficha.view.VerFichaActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class verCartaActivity extends AppCompatActivity implements VerCartaContract.View {
    private VerCartaPresenter verCartaPresenter;
    private RecyclerView recyclerView;

    private TextView tvCantProductos;
    private Button verCarro;
    private ImageView btnVolver;
    private ArrayList<Plato> carroCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_carta);
        Bundle extras = getIntent().getExtras();
        int idRestaurante = extras.getInt("idRestaurante");
        initComponents();
        initPresenter();
        initData(idRestaurante);
    }

    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerCarta);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        tvCantProductos = findViewById(R.id.cantProductos);
        verCarro = findViewById(R.id.btnVerCarro);
        btnVolver = findViewById(R.id.btnVolver);
        if(getIntent().getSerializableExtra("CarroCompras") != null){
            carroCompras = (ArrayList<Plato>) getIntent().getSerializableExtra("CarroCompras");

            tvCantProductos.setText(getIntent().getExtras().getString("tvCantProductos"));

        }

    }

    public void initPresenter(){
        verCartaPresenter = new VerCartaPresenter(this);
    }
    public void initData(int idRestaurante) {
        verCartaPresenter.verCartaRestaurante(idRestaurante); //SEL

    }
    @Override
    public void onSuccessCartaRestaurante(ArrayList<Plato> plato, int idRestaurante) {
        VerCartaAdapter adapter = new VerCartaAdapter(getBaseContext(), plato,tvCantProductos,verCarro,btnVolver,carroCompras,idRestaurante);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureCartaRestaurante(String err) {

    }
}