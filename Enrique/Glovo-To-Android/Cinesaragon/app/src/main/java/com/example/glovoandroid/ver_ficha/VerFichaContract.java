package com.example.glovoandroid.ver_ficha;

import com.example.glovoandroid.entities.Restaurante;

import java.util.ArrayList;

public interface VerFichaContract {
    public interface View{
        void onSuccessRestaurante(ArrayList<Restaurante> restaurante, int idRestaurante);
        void onFailureRestaurante(String err);
    }
   public interface Presenter{
        //Visualiza la ficha de un restaurante en especifico.
        void verFichaRestaurante(int idRestaurante);
   }
   public interface Model{
        interface onRestauranteListener{
            void onSuccess(ArrayList<Restaurante> restaurante);
            void onFailure(String err);
        }
    void verFichaRestauranteWS(int idRestaurante, onRestauranteListener onRestauranteListener);
   }
}
