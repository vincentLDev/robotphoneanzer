package com.anzer.robotphone.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
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

public class CommunicateService extends Service { // 继承onBind（），重写onCreate（）、onStartCommand（）、

    private static final String TAG = "CommunicateService";
    public final static String REQUEST_URI = "ws://192.168.16.166:5560";

    private static volatile CommunicateService mCommunicateService = null;

    public static synchronized CommunicateService getInstance() {
        return mCommunicateService;
    }

    public WebSocketClient mWebSocketClient = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {  // Return the communication channel to the service

        return null;    //  如果不想绑定，返回null,  return null if clients can not bind to the service.
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mCommunicateService = this;

//        Log.e(TAG, "onCreate: " + Process.myPid());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) { // 对于Service一启动就会执行的业务，一般都放在onStartCommand()里面

        createWebSocket();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void createWebSocket() {
        Log.e(TAG, "ws is connecting... ");

        try {
            URI uri = new URI(REQUEST_URI);

            mWebSocketClient = new WebSocketClient(uri) {

                @Override
                public void onOpen(ServerHandshake handshakedata) {

                    Log.e(TAG, "WebSocketClient onOpen:");
                }

                @Override
                public void onMessage(String message) {
                    Log.e(TAG, "WebSocketClient onMessage: " + message);
                }

                @Override
                public void onClose(final int code, final String reason, final boolean remote) {

                    Log.e(TAG, "WebSocketClient onClose:  code： " + code + "  reason： " + reason + "  remote： " + remote);
                }

                @Override
                public void onError(Exception e) {

                    Log.e(TAG, "WebSocketClient onError: " + e.getMessage());
                }
            };

            mWebSocketClient.connect(); // Starts a background thread that attempts and maintains a WebSocket connection to the URI

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendJsonToWebSocket(String json) {      //  Send Json to WebSocket

        if (mWebSocketClient != null && !TextUtils.isEmpty(json)) {

            mWebSocketClient.send(json);    //  Sends <var>json</var> to the connected WebSocket server
        }
    }

    public void showTips() {

        Toast.makeText(getApplicationContext(), "wo wo wo", Toast.LENGTH_SHORT).show();
    }


}



