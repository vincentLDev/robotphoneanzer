package com.anzer.robotphone.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * Created by Lenovo on 17/4/15.
 */

public class CommunicateService extends Service {

    private static final String TAG = "CommunicateService";

    private static volatile CommunicateService mCommunicateService = null;

    public static synchronized CommunicateService getInstance() {
        return mCommunicateService;
    }

    public WebSocketClient mWebSocketClient = null;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;    //  如果不想绑定，返回null
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mCommunicateService = this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        createWebSocket();

        return super.onStartCommand(intent, flags, startId);
    }

    public void showTips() {

        Toast.makeText(getApplicationContext(), "wo wo wo", Toast.LENGTH_SHORT).show();
    }

    public void sendJsonToWebSocket(String json) {      //  Send Json to WebSocket

        if (mWebSocketClient != null && !TextUtils.isEmpty(json)) {
            mWebSocketClient.send(json);
        }

    }

    private void createWebSocket() {
        Log.e(TAG, "ws is connecting... ");

        String reqUri = "ws://192.168.16.166:5560";

        try {
            URI uri = new URI(reqUri);

            mWebSocketClient = new WebSocketClient(uri) {

                @Override
                public void onOpen(ServerHandshake handshakedata) {

                    Log.e(TAG, "onOpen");
                }

                @Override
                public void onMessage(String message) {
                    Log.e(TAG, "onMessage: " + message);
                }

                @Override
                public void onClose(final int code, final String reason, final boolean remote) {

                    Log.e(TAG, "onClose  code" + code + "  reason:" + reason + "  remote:" + remote);
                }

                @Override
                public void onError(Exception e) {

                    Log.e(TAG, "onError: " + e.getMessage());
                }
            };

            mWebSocketClient.connect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}



