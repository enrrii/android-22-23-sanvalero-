package com.example.glovoandroid.fltr_usuario;

import com.example.glovoandroid.entities.Restaurante;

import java.util.ArrayList;

public interface FiltroNecUsuarioContract {
    public interface View{
        void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant);
        void onFailureLstRestaurant(String err);
    }
   public interface Presenter{
        //Listado de los restaurantes por las necesidades del cliente.
        void lstRestaurant(String filtro);
   }
   public interface Model{
        interface onLstRestaurantListener{
            void onSuccess(ArrayList<Restaurante> lstRestaurante);
            void onFailure(String err);
        }
    void lstRestaurantWS(String filtro, onLstRestaurantListener onLstRestaurantListener);
   }
}
