package com.example.glovoandroid.register;

import com.example.glovoandroid.entities.Usuario;

public interface RegisterContract {


    public interface View{
        void onSuccessRegister(Usuario user);
        void onFailureRegister(String err);
    }
    public interface Presenter{
        //Register del usuario
        void register(String nombre, String password);
    }
    public interface Model{
        interface onRegisterListener{
            void onSuccess(Usuario user);
            void onFailure(String err);
        }
        void registerWS(String nombre, String password, RegisterContract.Model.onRegisterListener onRegisterListener);
    }
}
