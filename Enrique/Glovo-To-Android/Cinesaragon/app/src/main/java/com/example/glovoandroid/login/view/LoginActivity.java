package com.example.glovoandroid.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Usuario;
import com.example.glovoandroid.fltr_usuario.view.FiltrUsuActivity;
import com.example.glovoandroid.login.LoginContract;
import com.example.glovoandroid.login.presenter.LoginPresenter;
import com.example.glovoandroid.register.presenter.RegisterPresenter;
import com.example.glovoandroid.register.view.RegisterActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private TextView password;
    private TextView nombre;
    private Button loginbtn;
    private TextView btngoToregister;
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        initPresenter();
    }
    public void initComponents(){
        nombre = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        btngoToregister = findViewById(R.id.register);

        btngoToregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario user = new Usuario();
                user.setNombre(String.valueOf(nombre.getText()));
                user.setPassword(String.valueOf(password.getText()));
                initData(user);
            }
        });
    }

    public void initPresenter()
    {
        loginPresenter = new LoginPresenter(this);
    }
    public void initData(Usuario user){
        loginPresenter.login(user);
    }
    @Override
    public void onSuccessLogin(ArrayList<Usuario> user) {
        if(user != null){
            Intent intent = new Intent(getBaseContext(), FiltrUsuActivity.class);
            intent.putExtra("idUser", user.get(0).getIdUser());
            intent.putExtra("nombreUser", user.get(0).getNombre());
            startActivity(intent);
        }else{
            Toast.makeText(this,"USUARIO INCORRECTO", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailureLogin(String err) {

    }
}