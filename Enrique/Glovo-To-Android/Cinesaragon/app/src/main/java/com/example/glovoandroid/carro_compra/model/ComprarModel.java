package com.example.glovoandroid.carro_compra.model;

import com.example.glovoandroid.carro_compra.ComprarContract;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;
import com.example.glovoandroid.verCarta.VerCartaContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComprarModel implements ComprarContract.Model {
    @Override
    public void ComprarWS(ArrayList<Plato> lstCompra, onComprarListener onComprarListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<String> call = apiService.comprarLstCompra(lstCompra);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String respuesta = response.body();
                onComprarListener.onSuccess(respuesta);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                onComprarListener.onFailure(t.getMessage());
            }
        });
    }
}
