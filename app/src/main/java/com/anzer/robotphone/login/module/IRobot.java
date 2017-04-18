package com.anzer.robotphone.login.module;

/**
 * Created by Lenovo on 17/4/14.
 */

public interface IRobot {

    String getIp();

    String getName();

    String getPasswd();

    int checkUserValidity(String ip, String name, String password);
}
