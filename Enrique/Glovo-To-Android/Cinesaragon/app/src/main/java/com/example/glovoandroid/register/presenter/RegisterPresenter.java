package com.example.glovoandroid.register.presenter;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.Usuario;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.lst_restaurantes.model.LstRestaurantModel;
import com.example.glovoandroid.register.RegisterContract;
import com.example.glovoandroid.register.model.RegisterModel;

import java.util.ArrayList;

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterModel registerModel;
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view){
        this.view = view;
        this.registerModel = new RegisterModel();
    }

    @Override
    public void register(String nombre, String password) {
        registerModel.registerWS(nombre,password, new RegisterContract.Model.onRegisterListener() {
            @Override
            public void onSuccess(Usuario user) {
                if(user != null){
                        view.onSuccessRegister(user);
                }
            }

            @Override
            public void onFailure(String err) {
                view.onFailureRegister(err);
            }
        });
    }
}
