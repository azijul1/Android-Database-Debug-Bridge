package com.mobtexting.androiddb.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Created by azijul on 9/2/18.
 */

public final class NetworkUtils {

    private NetworkUtils() {
        // This class in not publicly instantiable
    }

    public static String getAddressLog(Context context, int port) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
        @SuppressLint("DefaultLocale")
        final String formattedIpAddress = String.format("%d.%d.%d.%d",
                (ipAddress & 0xff),
                (ipAddress >> 8 & 0xff),
                (ipAddress >> 16 & 0xff),
                (ipAddress >> 24 & 0xff));
        return "Open http://" + formattedIpAddress + ":" + port + " in your browser";
    }

}
