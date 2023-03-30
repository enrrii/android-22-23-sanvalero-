package com.example.glovoandroid.verCarta;

import com.example.glovoandroid.entities.Plato;

import java.util.ArrayList;

public interface VerCartaContract {
    public interface View{
        void onSuccessCartaRestaurante(ArrayList<Plato> plato, int idRestaurante);
        void onFailureCartaRestaurante(String err);
    }
    public interface Presenter{
        //Visualiza la carta de un restaurante en especifico.
        void verCartaRestaurante(int idRestaurante);
    }
    public interface Model{
        interface onCartaRestauranteListener{
            void onSuccess(ArrayList<Plato> plato);
            void onFailure(String err);
        }
        void verCartaRestauranteWS(int idRestaurante, VerCartaContract.Model.onCartaRestauranteListener onCartaRestauranteListener);
    }
}
