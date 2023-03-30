package com.example.glovoandroid.register.model;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.Usuario;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.register.RegisterContract;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterModel implements RegisterContract.Model {

    @Override
    public void registerWS(String nombre, String password, onRegisterListener onRegisterListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Usuario> call = apiService.sendRegisterData(nombre,password);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario user = response.body();
                onRegisterListener.onSuccess(user);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                onRegisterListener.onFailure(t.getMessage());
            }
        });
    }
}
