package com.example.glovoandroid.carro_compra.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.carro_compra.ComprarContract;
import com.example.glovoandroid.carro_compra.presenter.ComprarPresenter;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.verCarta.presenter.VerCartaPresenter;
import com.example.glovoandroid.verCarta.view.VerCartaAdapter;
import com.example.glovoandroid.verCarta.view.verCartaActivity;
import com.example.glovoandroid.ver_ficha.view.VerFichaActivity;

import java.util.ArrayList;

public class CarroCompraActivity extends AppCompatActivity implements ComprarContract.View {
    private ArrayList<Plato> carroCompras;
    private ComprarPresenter comprarPresenter;
    private VerCarroAdapter adapter;
    private RecyclerView rvListaCarro;
    private TextView tvTotal;
    private ImageView btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_compra);
        //getSupportActionBar().hide();
        Bundle extras = getIntent().getExtras();
        int idRestaurante = extras.getInt("idRestaurante");
        initComponents(idRestaurante);
        initPresenter();

    }
    public void initComponents(int idRestaurante){
        carroCompras = (ArrayList<Plato>) getIntent().getSerializableExtra("CarroCompras");
        rvListaCarro = findViewById(R.id.rvListaCarro);
        rvListaCarro.setLayoutManager(new GridLayoutManager(CarroCompraActivity.this, 1));
        tvTotal = findViewById(R.id.tvTotal);
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), verCartaActivity.class);
                intent.putExtra("idRestaurante",idRestaurante);
                startActivity(intent);
            }
        });
        VerCarroAdapter adapter = new VerCarroAdapter(getBaseContext(), carroCompras, tvTotal);
        rvListaCarro.setAdapter(adapter);
        //initData(carroCompras);
    }

    public void initPresenter(){
        comprarPresenter = new ComprarPresenter(this);
    }
    public void initData(ArrayList<Plato> carroCompras) {
        comprarPresenter.comprarCarro(carroCompras);

    }
    @Override
    public void onSuccessComprar(String respuesta) {

    }

    @Override
    public void onFailureComprar(String err) {

    }
}