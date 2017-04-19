package com.anzer.robotphone;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.anzer.robotphone.service.CommunicateService;

/**
 * Created by Lenovo on 17/4/10.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        startService(new Intent(this, CommunicateService.class));   // StartService()和StopService()方法，都定义在Context中（所以在Activity中可以直接调用这两个方法）

    }

}
