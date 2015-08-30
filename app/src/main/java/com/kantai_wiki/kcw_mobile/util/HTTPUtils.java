package com.kantai_wiki.kcw_mobile.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * Created by Wafer on 2015/8/30.
 *
 */
public class HTTPUtils {

    //checkConnection
    public static boolean checkConnection(){

        boolean flag;

        ConnectivityManager connMgr = (ConnectivityManager)
                KCW_Mobile.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        flag = networkInfo != null && networkInfo.isConnected();

        return flag;
    }


    //download
    // TODO: 2015/8/30 Complete the download method
//    public static String download(String address) throws IOException{
//        InputStream inputStream = null;
//
//        int READ_TIME_OUT_LIMIT = 10000;
//        int CONNECT_TIME_OUT_LIMIT = 15000;
//
//        try {
//            URL url = new URL(address);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            //set read and connect time out
//            connection.setReadTimeout(READ_TIME_OUT_LIMIT);
//            connection.setConnectTimeout(CONNECT_TIME_OUT_LIMIT);
//
//            //set request method
//            connection.setRequestMethod("GET");
//
//            //get input stream
//            inputStream = connection.getInputStream();
//        }
//    }

}
