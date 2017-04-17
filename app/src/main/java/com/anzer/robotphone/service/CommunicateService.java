package com.anzer.robotphone.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
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

    public WebSocketClient webSocketClient = null;


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

    public void showTips() {

        Toast.makeText(getApplicationContext(), "wo wo wo", Toast.LENGTH_SHORT).show();
    }

    public void createWebSocket() {
        Log.e(TAG, "ws is connecting... ");

        new Thread(new Runnable() {

            WebSocketClient onWebSocketListener;

            @Override
            public void run() {
                String reqUri = "www.baidu.com";

                try {
                    URI uri = new URI(reqUri);
                    webSocketClient = new WebSocketClient(uri) {

                        @Override
                        public void onOpen(ServerHandshake handshakedata) {
                            onWebSocketListener.onOpen(handshakedata);
                        }

                        @Override
                        public void onMessage(String message) {
                            Log.e(TAG, "onMessage: " + message);
                            onWebSocketListener.onMessage(message);
                        }

                        @Override
                        public void onClose(final int code, final String reason, final boolean remote) {

                            Log.e(TAG, "onClose  code" + code + "  reason:" + reason + "  remote:" + remote);
                            onWebSocketListener.onClose(code, reason, remote);
                        }

                        @Override
                        public void onError(Exception e) {

                            Log.e(TAG, "onError: " + e.getMessage());
//                            onWebSocketListener.onError(e);
                        }
                    };

                    webSocketClient.connect();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }


}
