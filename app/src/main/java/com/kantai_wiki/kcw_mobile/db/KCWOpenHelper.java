package com.kantai_wiki.kcw_mobile.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wafer on 2015/8/29.
 *
 */
public class KCWOpenHelper extends SQLiteOpenHelper{

    public KCWOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBContract.SQL_CREATE_EQUIPMENTENEMY);
        db.execSQL(DBContract.SQL_CREATE_EQUIPMENTKMS);
        db.execSQL(DBContract.SQL_CREATE_EQUIPMENTUPGRADE);
        db.execSQL(DBContract.SQL_CREATE_EXPEDITION);
        db.execSQL(DBContract.SQL_CREATE_QUEST);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
