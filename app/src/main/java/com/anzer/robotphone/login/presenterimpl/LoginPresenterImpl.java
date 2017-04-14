package com.anzer.robotphone.login.presenterimpl;

import android.os.Handler;

import com.anzer.robotphone.login.module.User;
import com.anzer.robotphone.login.module.UserImpl;
import com.anzer.robotphone.login.presenter.LoginPresenter;
import com.anzer.robotphone.login.view.LoginView;

/**
 * Created by Lenovo on 17/4/10.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private User user;
    private Handler handler;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        user = new UserImpl("WS://192.168.16.153:5560", "robotanzer", "123456");

        handler = new Handler();
    }

    @Override
    public void login(final String ip, String name, String passwd) {

        Boolean isLoginSuccess = true;

        final int code = user.checkUserValidity(ip, name, passwd);

        if (code != 0)
            isLoginSuccess = false;

        final Boolean result = isLoginSuccess;

        handler.post(new Runnable() {
            @Override
            public void run() {

                loginView.onLoginResult(result, code);
            }
        });


    }
}
