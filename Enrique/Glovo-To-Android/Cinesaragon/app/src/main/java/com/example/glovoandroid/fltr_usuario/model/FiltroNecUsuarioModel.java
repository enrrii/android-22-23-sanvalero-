package com.example.glovoandroid.fltr_usuario.model;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.fltr_usuario.FiltroNecUsuarioContract;

import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FiltroNecUsuarioModel implements FiltroNecUsuarioContract.Model {
    @Override
    public void lstRestaurantWS(String filtro, onLstRestaurantListener onLstRestaurantListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Restaurante>> call = apiService.getFiltroRestaurante(filtro);
        call.enqueue(new Callback<ArrayList<Restaurante>>() {
            @Override
            public void onResponse(Call<ArrayList<Restaurante>> call, Response<ArrayList<Restaurante>> response) {
                ArrayList<Restaurante> listaRestaurante = response.body();
                onLstRestaurantListener.onSuccess(listaRestaurante);
            }

            @Override
            public void onFailure(Call<ArrayList<Restaurante>> call, Throwable t) {
                    onLstRestaurantListener.onFailure(t.getMessage());
            }
        });

    }

}
