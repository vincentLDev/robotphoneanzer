package com.anzer.robotphone.client;

import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * Created by Lenovo on 17/4/15.
 */

public class WebSocketClientRobot extends WebSocketClient{
    private static final String TAG = "WebSocketClientRobot";

    public WebSocketClientRobot(URI serverURI) {
        super(serverURI);

    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {

    }

    @Override
    public void onMessage(String message) {

    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }

    @Override
    public void onError(Exception ex) {
    }
}
