package com.anzer.robotphone;

import android.app.Application;
import android.content.Intent;

import com.anzer.robotphone.service.CommunicateService;

/**
 * Created by Lenovo on 17/4/10.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        startService(new Intent(this, CommunicateService.class));




    }



}
