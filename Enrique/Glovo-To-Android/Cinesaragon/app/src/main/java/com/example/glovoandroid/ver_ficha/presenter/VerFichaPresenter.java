package com.example.glovoandroid.ver_ficha.presenter;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.lst_restaurantes.model.LstRestaurantModel;
import com.example.glovoandroid.ver_ficha.VerFichaContract;
import com.example.glovoandroid.ver_ficha.model.VerFichaModel;

import java.util.ArrayList;

public class VerFichaPresenter implements VerFichaContract.Presenter {
    private VerFichaModel verFichaModel;
    private VerFichaContract.View view;

    public VerFichaPresenter(VerFichaContract.View view){
        this.view = view;
        this.verFichaModel = new VerFichaModel();
    }


    @Override
    public void verFichaRestaurante(int idRestaurante) {
            verFichaModel.verFichaRestauranteWS(idRestaurante, new VerFichaContract.Model.onRestauranteListener() {
                @Override
                public void onSuccess(ArrayList<Restaurante> restaurante) {

                        view.onSuccessRestaurante(restaurante,idRestaurante);

                }

                @Override
                public void onFailure(String err) {
                    view.onFailureRestaurante(err);
                }
            });
    }
}
