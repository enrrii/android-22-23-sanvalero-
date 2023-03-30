package com.example.glovoandroid.lst_restaurantes;

import com.example.glovoandroid.entities.Restaurante;

import java.util.ArrayList;

public interface LstRestaurantContract {
    public interface View{
        void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant);
        void onFailureLstRestaurant(String err);
    }
   public interface Presenter{
        //Listado de los 10 restaurantes con más ventas.
        void lstRestaurant(Restaurante restaurante);
   }
   public interface Model{
        interface onLstRestaurantListener{
            void onSuccess(ArrayList<Restaurante> lstRestaurante);
            void onFailure(String err);
        }
    void lstRestaurantWS(Restaurante restaurante, onLstRestaurantListener onLstRestaurantListener);
   }
}
