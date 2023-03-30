package com.example.glovoandroid.carro_compra;

import com.example.glovoandroid.entities.Plato;

import java.util.ArrayList;

public interface ComprarContract {
    public interface View{
        void onSuccessComprar(String respuesta);
        void onFailureComprar(String err);
    }
    public interface Presenter{
        //Introduce la compra en la bbdd.
        void comprarCarro(ArrayList<Plato> lstCompra);
    }
    public interface Model{
        interface onComprarListener{
            void onSuccess(String respuesta);
            void onFailure(String err);
        }
        void ComprarWS(ArrayList<Plato> lstCompra, ComprarContract.Model.onComprarListener onComprarListener);
    }
}
