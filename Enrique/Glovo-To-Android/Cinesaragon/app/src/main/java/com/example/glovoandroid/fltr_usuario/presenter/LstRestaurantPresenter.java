package com.example.glovoandroid.fltr_usuario.presenter;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.fltr_usuario.FiltroNecUsuarioContract;


import com.example.glovoandroid.fltr_usuario.model.FiltroNecUsuarioModel;


import java.util.ArrayList;

public class LstRestaurantPresenter implements FiltroNecUsuarioContract.Presenter {
    private FiltroNecUsuarioModel filtrUsuarioModel;
    private FiltroNecUsuarioContract.View view;

    public LstRestaurantPresenter(FiltroNecUsuarioContract.View view){
        this.view = view;
        this.filtrUsuarioModel = new FiltroNecUsuarioModel();
    }

    @Override
    public void lstRestaurant(String filtro) {
        filtrUsuarioModel.lstRestaurantWS(filtro, new FiltroNecUsuarioContract.Model.onLstRestaurantListener() {
                @Override
                public void onSuccess(ArrayList<Restaurante> lstRestaurante) {

                    if(lstRestaurante!=null && lstRestaurante.size()>0){
                        view.onSuccessLstRestaurant(lstRestaurante);
                    }
                }

                @Override
                public void onFailure(String err) {
                    view.onFailureLstRestaurant(err);
                }
            });
    }
}
