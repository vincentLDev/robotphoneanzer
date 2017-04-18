package com.anzer.robotphone.login.presenterimpl;

import android.os.Handler;

import com.anzer.robotphone.login.module.IRobot;
import com.anzer.robotphone.login.module.RobotImpl;
import com.anzer.robotphone.login.presenter.ILoginPresenter;
import com.anzer.robotphone.login.view.ILoginView;

/**
 * Created by Lenovo on 17/4/10.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView mLoginView;
    private IRobot mIRobot;
    private Handler mHandler;

    public LoginPresenterImpl(ILoginView loginView) {
        this.mLoginView = loginView;
        mIRobot = new RobotImpl("ws://192.168.16.153:5560", "robotanzer", "123456");

        mHandler = new Handler();
    }

    @Override
    public void login(final String ip, String name, String passwd) {

        Boolean isLoginSuccess = true;

        final int code = mIRobot.checkUserValidity(ip, name, passwd);

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
