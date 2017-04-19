package com.anzer.robotphone.bean;

import android.support.annotation.DrawableRes;

/**
 * Created by Lenovo on 17/4/14.
 */

public class RobotBean {

    private String ip;
    private String name;
    private String passwd;
    private int id;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName( String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setId(@DrawableRes int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public int getId() {
        return id;
    }


}
