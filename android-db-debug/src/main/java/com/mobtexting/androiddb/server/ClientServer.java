package com.mobtexting.androiddb.server;

/**
 * Created by azijul on 9/2/18.
 */


import android.content.Context;
import android.util.Log;
import android.util.Pair;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

public class ClientServer implements Runnable {

    private static final String TAG = "ClientServer";

    private final int mPort;

    private boolean mIsRunning;

    private ServerSocket mServerSocket;

    private final RequestHandler mRequestHandler;

    public ClientServer(Context context, int port) {
        mRequestHandler = new RequestHandler(context);
        mPort = port;
    }

    public void start() {
        mIsRunning = true;
        new Thread(this).start();
    }

    public void stop() {
        try {
            mIsRunning = false;
            if (null != mServerSocket) {
                mServerSocket.close();
                mServerSocket = null;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error closing the server socket.", e);
        }
    }

    @Override
    public void run() {
        try {
            mServerSocket = new ServerSocket(mPort);
            while (mIsRunning) {
                Socket socket = mServerSocket.accept();
                mRequestHandler.handle(socket);
                socket.close();
            }
        } catch (SocketException e) {
            // The server was stopped; ignore.
        } catch (IOException e) {
            Log.e(TAG, "Web server error.", e);
        } catch (Exception ignore) {
            Log.e(TAG, "Exception.", ignore);
        }
    }

    public void setCustomDatabaseFiles(HashMap<String, Pair<File, String>> customDatabaseFiles) {
        mRequestHandler.setCustomDatabaseFiles(customDatabaseFiles);
    }

    public boolean isRunning() {
        return mIsRunning;
    }
}
