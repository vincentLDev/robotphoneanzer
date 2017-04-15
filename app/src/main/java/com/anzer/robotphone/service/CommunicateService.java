package com.anzer.robotphone.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Lenovo on 17/4/15.
 */

public class CommunicateService extends Service {

    private static final String TAG = "CommunicateService";

    private static volatile CommunicateService mCommunicateService = null;

    public static synchronized CommunicateService getInstance() {
        return mCommunicateService;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");

        mCommunicateService = this;
    }

    public void showTips() {

        Toast.makeText(getApplicationContext(), "wo wo wo", Toast.LENGTH_SHORT).show();
    }
}
