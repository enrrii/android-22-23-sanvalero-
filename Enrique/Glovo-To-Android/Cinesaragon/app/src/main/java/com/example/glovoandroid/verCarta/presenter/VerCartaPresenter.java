package com.example.glovoandroid.verCarta.presenter;

import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.verCarta.VerCartaContract;
import com.example.glovoandroid.verCarta.model.VerCartaModel;

import java.util.ArrayList;

public class VerCartaPresenter implements VerCartaContract.Presenter {
    private VerCartaModel verCartaModel;
    private VerCartaContract.View view;

    public VerCartaPresenter(VerCartaContract.View view){
        this.view = view;
        this.verCartaModel = new VerCartaModel();
    }

    @Override
    public void verCartaRestaurante(int idRestaurante) {
        verCartaModel.verCartaRestauranteWS(idRestaurante, new VerCartaContract.Model.onCartaRestauranteListener() {
            @Override
            public void onSuccess(ArrayList<Plato> plato) {
                view.onSuccessCartaRestaurante(plato, idRestaurante);
            }

            @Override
            public void onFailure(String err) {
                view.onFailureCartaRestaurante(err);
            }
        });
    }
}
