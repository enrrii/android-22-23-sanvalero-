package com.example.glovoandroid.verCarta.model;

import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;
import com.example.glovoandroid.verCarta.VerCartaContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerCartaModel implements VerCartaContract.Model {

    @Override
    public void verCartaRestauranteWS(int idRestaurante, onCartaRestauranteListener onCartaRestauranteListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Plato>> call = apiService.getCartaRestaurante(idRestaurante);
        call.enqueue(new Callback<ArrayList<Plato>>() {
            @Override
            public void onResponse(Call<ArrayList<Plato>> call, Response<ArrayList<Plato>> response) {
                ArrayList<Plato> lstPlato = response.body();
                onCartaRestauranteListener.onSuccess(lstPlato);
            }

            @Override
            public void onFailure(Call<ArrayList<Plato>> call, Throwable t) {
                onCartaRestauranteListener.onFailure(t.getMessage());
            }
        });

    }
}
