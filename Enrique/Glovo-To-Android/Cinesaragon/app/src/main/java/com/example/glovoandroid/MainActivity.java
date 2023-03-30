package com.example.glovoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.fltr_usuario.view.FiltrUsuActivity;
import com.example.glovoandroid.login.view.LoginActivity;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantActivity;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantAdapter;
import com.example.glovoandroid.register.view.RegisterActivity;
import com.example.glovoandroid.utils.ApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt1;
    private Button bt2;
    private Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //initComponents();
        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(intent);
    }
    public void initComponents(){
        //Intent intent = new Intent(getBaseContext(),LstRestaurantActivity.class);
        //Intent intent = new Intent(getBaseContext(), FiltrUsuActivity.class);
        /*bt1 = findViewById(R.id.button1);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);*/
        //Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
        //startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        /*Intent intent;
        switch (view.getId()) {
            case R.id.button1:
                //miIntent = new Intent(MainActivity.this, LstRestaurantActivity.class);
                intent = new  Intent(getBaseContext(), LstRestaurantActivity.class);
                startActivity(intent);
                break;

            case R.id.button2:
                intent=new Intent(getBaseContext(), FiltrUsuActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent=new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        startActivity(intent);*/
    }
}