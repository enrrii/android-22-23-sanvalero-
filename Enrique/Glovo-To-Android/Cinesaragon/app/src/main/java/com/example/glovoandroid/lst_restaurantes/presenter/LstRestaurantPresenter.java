package com.example.glovoandroid.lst_restaurantes.presenter;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.lst_restaurantes.model.LstRestaurantModel;

import java.util.ArrayList;

public class LstRestaurantPresenter implements LstRestaurantContract.Presenter {
    private LstRestaurantModel lstRestaurantModel;
    private LstRestaurantContract.View view;

    public LstRestaurantPresenter(LstRestaurantContract.View view){
        this.view = view;
        this.lstRestaurantModel = new LstRestaurantModel();
    }

    @Override
    public void lstRestaurant(Restaurante restaurante) {
        lstRestaurantModel.lstRestaurantWS(null, new LstRestaurantContract.Model.onLstRestaurantListener() {
                @Override
                public void onSuccess(ArrayList<Restaurante> lstRestaurante) {

                    if(lstRestaurante!=null && lstRestaurante.size()>0){
                        view.onSuccessLstRestaurant(lstRestaurante);

                    }else{

                    }
                }

                @Override
                public void onFailure(String err) {
                    view.onFailureLstRestaurant(err);
                }
            });
    }
}
