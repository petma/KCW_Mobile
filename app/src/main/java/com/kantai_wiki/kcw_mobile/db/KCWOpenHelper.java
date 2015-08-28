package com.kantai_wiki.kcw_mobile.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wafer on 2015/8/29.
 */
public class KCWOpenHelper extends SQLiteOpenHelper{

    public KCWOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(FeedReaderContract.SQL_CREAT_EQUIPMENTENEMY);
        db.execSQL(FeedReaderContract.SQL_CREAT_EQUIPMENTKMS);
        db.execSQL(FeedReaderContract.SQL_CREAT_EQUIPMENTUPGRADE);
        db.execSQL(FeedReaderContract.SQL_CREAT_EXPEDITION);
        db.execSQL(FeedReaderContract.SQL_CREAT_QUEST);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
