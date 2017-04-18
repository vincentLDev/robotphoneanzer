package com.anzer.robotphone.login.presenterimpl;

import android.os.Handler;

import com.anzer.robotphone.bean.RobotBean;
import com.anzer.robotphone.login.presenter.ILoginPresenter;
import com.anzer.robotphone.login.view.ILoginView;

/**
 * Created by Lenovo on 17/4/10.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView mLoginView;
    private RobotBean robotBean ;
    private Handler mHandler;

    public LoginPresenterImpl(ILoginView loginView) {
        this.mLoginView = loginView;
        robotBean = new RobotBean();

        mHandler = new Handler();
    }

    @Override
    public void login(final String ip, String name, String passwd) {





    }
}
