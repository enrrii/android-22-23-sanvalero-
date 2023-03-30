package com.example.glovoandroid.register.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Usuario;

import com.example.glovoandroid.login.view.LoginActivity;
import com.example.glovoandroid.register.RegisterContract;
import com.example.glovoandroid.register.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private RegisterPresenter registerPresenter;
    private TextView nombre;
    private TextView email;
    private TextView password;

    private Button signupbtn;
    private TextView goToLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponents();
        initPresenter();
        //initData();
    }
    public void initComponents(){
        nombre = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signupbtn = findViewById(R.id.signupbtn);
        goToLogIn = findViewById(R.id.login);
        goToLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Usuario user = new Usuario();
                user.setNombre(String.valueOf(nombre.getText()));
                user.setEmail(String.valueOf(email.getText()));
                user.setPassword(String.valueOf(password.getText()));*/

                initData(String.valueOf(nombre.getText()),String.valueOf(password.getText()));
            }
        });




    }
    public void initPresenter()
    {
        registerPresenter = new RegisterPresenter(this);
    }
    public void initData(String nombre, String password){
        registerPresenter.register(nombre,password);
    }

    @Override
    public void onSuccessRegister(Usuario user) {
        //Llamaríamos al Adapter
        Toast.makeText(this,"BIENVENIDO:" + user.getNombre() , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailureRegister(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}