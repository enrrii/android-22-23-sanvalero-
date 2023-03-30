package com.example.glovoandroid.login.model;

import com.example.glovoandroid.entities.Usuario;
import com.example.glovoandroid.login.LoginContract;
import com.example.glovoandroid.register.RegisterContract;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginModel implements LoginContract.Model {

    @Override
    public void loginWS(Usuario user, onLoginListener onLoginListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call <ArrayList<Usuario>> call = apiService.checkLogin(user.getNombre(), user.getPassword());
        call.enqueue(new Callback <ArrayList<Usuario>>() {
            @Override
            public void onResponse(Call <ArrayList<Usuario>> call, Response <ArrayList<Usuario>> response) {
                ArrayList<Usuario> lstuser = response.body();
                onLoginListener.onSuccess(lstuser);
            }

            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                onLoginListener.onFailure(t.getMessage());
            }
        });
    }
}
