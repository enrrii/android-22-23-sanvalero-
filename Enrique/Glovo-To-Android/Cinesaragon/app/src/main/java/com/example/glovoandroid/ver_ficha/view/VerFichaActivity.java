package com.example.glovoandroid.ver_ficha.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_restaurantes.presenter.LstRestaurantPresenter;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantAdapter;
import com.example.glovoandroid.ver_ficha.VerFichaContract;
import com.example.glovoandroid.ver_ficha.presenter.VerFichaPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VerFichaActivity extends AppCompatActivity implements VerFichaContract.View {

    private VerFichaPresenter verFichaPresenter;
    private RecyclerView recyclerView;
    private TextView idRestaurante;
    private TextView nombreRestaurante;
    private TextView tipoRestaurante;
    private TextView ventasRestaurante;
    private TextView puntuacionRestaurante;
    private ImageView imagenRestaurante;

    private ArrayList<Plato> carroCompras;
    private TextView tvCantProductos;
    private ImageView btnVolver;
    private Button btnVerCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ficha);
        Bundle extras = getIntent().getExtras();
        int idRestaurante = extras.getInt("idRestaurante");

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initComponents();
        initPresenter();
        initData(idRestaurante);
    }
    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerFicha);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        tvCantProductos = findViewById(R.id.cantProductos);
        if(getIntent().getSerializableExtra("CarroCompras") != null){
            carroCompras = (ArrayList<Plato>) getIntent().getSerializableExtra("CarroCompras");

            tvCantProductos.setText(getIntent().getExtras().getString("tvCantProductos"));

        }

        nombreRestaurante = findViewById(R.id.NOMBRE2);
        tipoRestaurante = findViewById(R.id.TIPO2);
        ventasRestaurante = findViewById(R.id.VENTAS2);
        puntuacionRestaurante = findViewById(R.id.PUNTUACION2);
        imagenRestaurante = (ImageView) findViewById(R.id.IMAGEN);
        btnVolver = findViewById(R.id.btnVolver);

        btnVerCarro = (Button) findViewById(R.id.btnVerCarro);


    }
    public void initPresenter()
    {
        verFichaPresenter = new VerFichaPresenter(this);
    }
    public void initData(int idRestaurante) {
        verFichaPresenter.verFichaRestaurante(idRestaurante); //SEL

    }

    @Override
    public void onSuccessRestaurante(ArrayList<Restaurante> restaurante, int idRestaurante) {
        VerFichaAdapter adapter = new VerFichaAdapter(getBaseContext(),restaurante, btnVolver,carroCompras,btnVerCarro,tvCantProductos,idRestaurante);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureRestaurante(String err) {
            Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}