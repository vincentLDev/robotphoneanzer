package com.anzer.robotphone.login.module;

/**
 * Created by Lenovo on 17/4/14.
 */

public class RobotImpl implements IRobot {

    private String ip;
    private String name;
    private String passwd;

    public RobotImpl(String ip, String name, String passwd) {
        this.ip = ip;
        this.name = name;
        this.passwd = passwd;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }



    @Override
    public int checkUserValidity(String ip, String name, String password) {

        if (ip == null || name == null || passwd == null ||
                !ip.equals(getIp()) || !name.equals(getName()) || !password.equals(getPasswd())) {

            return -1;
        }

        return 0;
    }

}
