package com.kantai_wiki.kcw_mobile.util;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kantai_wiki.kcw_mobile.model.EquipmentEnemy;
import com.kantai_wiki.kcw_mobile.model.EquipmentKMS;
import com.kantai_wiki.kcw_mobile.model.EquipmentUpgrade;
import com.kantai_wiki.kcw_mobile.model.Expedition;
import com.kantai_wiki.kcw_mobile.model.Quest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
    public static String download(String address) throws IOException{
        InputStream inputStream = null;

        int READ_TIME_OUT_LIMIT = 10000;
        int CONNECT_TIME_OUT_LIMIT = 15000;

        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //set read and connect time out
            connection.setReadTimeout(READ_TIME_OUT_LIMIT);
            connection.setConnectTimeout(CONNECT_TIME_OUT_LIMIT);

            //set request method
            connection.setRequestMethod("GET");

            //get input stream
            inputStream = connection.getInputStream();
            return readInputStream(inputStream);
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
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

    /**
     * The parser with GSON
     *
     */

    //Quest
    public List<Quest> praseQuest (String jsonString) {

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Quest>>(){}.getType();

        return gson.fromJson(jsonString, listType);
    }

    //Expedition
    public List<Expedition> praseExpedition (String jsonString) {
        Gson gson = new Gson();
        Type listType = new  TypeToken<List<Expedition>>(){}.getType();

        return gson.fromJson(jsonString,listType);
    }

    //EquipmentKMS
    public List<EquipmentKMS> parseEquipmentKMS (String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<EquipmentKMS>>() {}.getType();

        return gson.fromJson(jsonString,listType);
    }

    //EquipmentEnemy
    public List<EquipmentEnemy> parseEquipmentEnemy (String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<EquipmentEnemy>>() {}.getType();

        return gson.fromJson(jsonString,listType);
    }

    //EquipmentUpgrade
    public List<EquipmentUpgrade> parseEquipmentUpgrade (String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<EquipmentUpgrade>>() {}.getType();

        return gson.fromJson(jsonString,listType);
    }
}
