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

    private LoginView mLoginView;
    private User mUser;
    private Handler mHandler;

    public LoginPresenterImpl(LoginView loginView) {
        this.mLoginView = loginView;
        mUser = new UserImpl("WS://192.168.16.153:5560", "robotanzer", "123456");

        mHandler = new Handler();
    }

    @Override
    public void login(final String ip, String name, String passwd) {

        Boolean isLoginSuccess = true;

        final int code = mUser.checkUserValidity(ip, name, passwd);

        if (code != 0)
            isLoginSuccess = false;

        final Boolean result = isLoginSuccess;

        mHandler.post(new Runnable() {
            @Override
            public void run() {

                mLoginView.onLoginResult(result, code);
            }
        });


    }
}
