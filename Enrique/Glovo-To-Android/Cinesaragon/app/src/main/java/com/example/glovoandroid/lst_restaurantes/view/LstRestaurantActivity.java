package com.example.glovoandroid.lst_restaurantes.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.lst_restaurantes.presenter.LstRestaurantPresenter;
import com.example.glovoandroid.utils.ApiClient;

import java.util.ArrayList;

public class LstRestaurantActivity extends AppCompatActivity implements LstRestaurantContract.View {
    private LstRestaurantAdapter lstRestaurantAdapter;
    private LstRestaurantPresenter lstRestPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_restaurant);
        initComponents();
        initPresenter();
        initData();

    }
    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
    public void initPresenter()
    {
        lstRestPresenter = new LstRestaurantPresenter(this);
    }
    public void initData(){
        lstRestPresenter.lstRestaurant(null); //SELECT * FROM SIMPSON
    }

    @Override
    public void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant) {
        LstRestaurantAdapter adapter = new LstRestaurantAdapter(getBaseContext(),lstRestaurant);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstRestaurant(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}