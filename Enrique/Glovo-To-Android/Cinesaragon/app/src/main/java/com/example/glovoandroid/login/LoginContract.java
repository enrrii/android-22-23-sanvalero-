package com.example.glovoandroid.login;

import com.example.glovoandroid.entities.Usuario;

import java.util.ArrayList;

public interface LoginContract {


    public interface View{
        void onSuccessLogin(ArrayList<Usuario>  user);
        void onFailureLogin(String err);
    }
    public interface Presenter{
        //Login del usuario.
        void login(Usuario user);
    }
    public interface Model{
        interface onLoginListener{
            void onSuccess(ArrayList<Usuario> user);
            void onFailure(String err);
        }
        void loginWS(Usuario user, LoginContract.Model.onLoginListener onLoginListener);
    }
}
