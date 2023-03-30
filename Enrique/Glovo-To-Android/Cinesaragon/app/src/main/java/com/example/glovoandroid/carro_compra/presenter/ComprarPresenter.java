package com.example.glovoandroid.carro_compra.presenter;

import com.example.glovoandroid.carro_compra.ComprarContract;
import com.example.glovoandroid.carro_compra.model.ComprarModel;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.verCarta.VerCartaContract;
import com.example.glovoandroid.verCarta.model.VerCartaModel;

import java.util.ArrayList;

public class ComprarPresenter implements ComprarContract.Presenter {
    private ComprarModel comprarModel;
    private ComprarContract.View view;

    public ComprarPresenter(ComprarContract.View view){
        this.view = view;
        this.comprarModel = new ComprarModel();
    }

    @Override
    public void comprarCarro(ArrayList<Plato> lstCompra) {
        comprarModel.ComprarWS(lstCompra, new ComprarContract.Model.onComprarListener() {
            @Override
            public void onSuccess(String respuesta) {
                view.onSuccessComprar(respuesta);
            }

            @Override
            public void onFailure(String err) {
                view.onFailureComprar(err);
            }
        });
    }
}
