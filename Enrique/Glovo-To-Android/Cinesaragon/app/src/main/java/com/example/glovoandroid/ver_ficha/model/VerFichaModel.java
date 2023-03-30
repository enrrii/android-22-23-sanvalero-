package com.example.glovoandroid.ver_ficha.model;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;
import com.example.glovoandroid.ver_ficha.VerFichaContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VerFichaModel implements VerFichaContract.Model {
    @Override
    public void verFichaRestauranteWS(int idRestaurante, onRestauranteListener onRestauranteListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Restaurante>>call = apiService.getFichaRestaurante(idRestaurante);
        call.enqueue(new Callback<ArrayList<Restaurante>>() {
            @Override
            public void onResponse(Call<ArrayList<Restaurante>> call, Response<ArrayList<Restaurante>> response) {
                ArrayList<Restaurante> listaRestaurante = response.body();
                onRestauranteListener.onSuccess(listaRestaurante);
            }

            @Override
            public void onFailure(Call<ArrayList<Restaurante>> call, Throwable t) {
                onRestauranteListener.onFailure(t.getMessage());
            }
        });


    }
}
