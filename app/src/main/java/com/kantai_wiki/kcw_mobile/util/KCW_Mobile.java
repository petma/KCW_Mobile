package com.kantai_wiki.kcw_mobile.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Wafer on 2015/8/30.
 *
 */
public class KCW_Mobile extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
