package com.kantai_wiki.kcw_mobile.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.kantai_wiki.kcw_mobile.background_task.TaskTypeContract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Wafer on 2015/8/30.
 *
 */
public class HTTPUtils {

    //checkConnection
    public static boolean checkConnection() {

        boolean flag;

        ConnectivityManager connMgr = (ConnectivityManager)
                KCW_Mobile.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        flag = networkInfo != null && networkInfo.isConnected();

        return flag;
    }

    //getURL
    public static String getURL(int syncType) {

        String URL_BASE = "https://kirito.me/kancolle/";
        String SUFFIX = ".json";

        switch (syncType) {
            case TaskTypeContract.TASK_TYPE_QUEST :
                return URL_BASE + "quest" + SUFFIX;
            case TaskTypeContract.TASK_TYPE_EXPEDITION:
                return URL_BASE + "expedition" + SUFFIX;
            case TaskTypeContract.TASK_TYPE_EQUIPMENT_KMS:
                return URL_BASE + "equipment_kms" + SUFFIX;
            case TaskTypeContract.TASK_TYPE_EQUIPMENT_ENEMY:
                return URL_BASE + "equipment_enemy" + SUFFIX;
            case TaskTypeContract.TASK_TYPE_EQUIPMENT_UPGRADE:
                return URL_BASE + "equipment_upgrade" + SUFFIX;
            default:
                break;
        }
        return null;
    }

    //download
    public static String download(String address) throws IOException {
        InputStream inputStream = null;

        int READ_TIME_OUT_LIMIT = 10000;
        int CONNECT_TIME_OUT_LIMIT = 15000;

        HttpURLConnection connection = null;
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();

            //set read and connect time out
            connection.setReadTimeout(READ_TIME_OUT_LIMIT);
            connection.setConnectTimeout(CONNECT_TIME_OUT_LIMIT);
            connection.setRequestMethod("GET");

            //start query
            connection.connect();

            //get input stream
            inputStream = connection.getInputStream();
            return readInputStream(inputStream);
        } finally {

            //close inputStream
            if (inputStream != null) {
                inputStream.close();
            }

            //close connection
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    //read inputStream
    private static String readInputStream(InputStream in) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        StringBuilder stringBuilder = new StringBuilder();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }

}
