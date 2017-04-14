package com.anzer.robotphone.login.presenter;

import com.anzer.robotphone.base.BasePresenter;

/**
 * Created by Lenovo on 17/4/10.
 */

public interface LoginPresenter extends BasePresenter {

    void login(String ip, String name, String passwd);
}
