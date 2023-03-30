package com.example.glovoandroid.login.presenter;

import com.example.glovoandroid.entities.Usuario;
import com.example.glovoandroid.login.LoginContract;
import com.example.glovoandroid.login.model.LoginModel;
import com.example.glovoandroid.register.RegisterContract;
import com.example.glovoandroid.register.model.RegisterModel;

import java.util.ArrayList;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginModel loginModel;
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view){
        this.view = view;
        this.loginModel = new LoginModel();
    }


    @Override
    public void login(Usuario user) {
        loginModel.loginWS(user, new LoginContract.Model.onLoginListener() {
            @Override
            public void onSuccess(ArrayList<Usuario>  user) {

                    view.onSuccessLogin(user);

            }

            @Override
            public void onFailure(String err) {
                view.onFailureLogin(err);
            }
        });
    }
}
