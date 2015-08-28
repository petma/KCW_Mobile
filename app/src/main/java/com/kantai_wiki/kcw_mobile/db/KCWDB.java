package com.kantai_wiki.kcw_mobile.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kantai_wiki.kcw_mobile.model.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wafer on 2015/8/29.
 */
public class KCWDB {

    public static final String DB_NAME = "kcw";

    public static final int VERSION = 1;

    private static KCWDB kcwdb;

    private SQLiteDatabase db;

    //Make the Ctor private

    private KCWDB(Context context) {
        KCWOpenHelper kcwOpenHelper = new KCWOpenHelper(context,DB_NAME,null,VERSION);
        db = kcwOpenHelper.getWritableDatabase();
    }

    //Get the instance
    public synchronized static KCWDB getInstance(Context context) {
        if(kcwdb == null) {
            kcwdb = new KCWDB(context);
        }
        return kcwdb;
    }

    /**
     * The Quest Table Utils
     *
     */

    //insert quest
    public void insertQuest(Quest quest) {
        if(quest != null) {
            ContentValues values = new ContentValues();
            values.put("category",quest.getCategory());
            values.put("type",quest.getType());
            values.put("prequest_id",quest.getPrequest_id());
            values.put("name",quest.getName());
            values.put("reward_fuel",quest.getReward_fuel());
            values.put("reward_bullet",quest.getReward_bullet());
            values.put("reward_steel",quest.getReward_steel());
            values.put("reward_alum",quest.getReward_alum());
            values.put("reward_other",quest.getReward_other());
            values.put("condition",quest.getCondition());
            values.put("notice",quest.getNotice());
            db.insert("Quest",null,values);
        }
    }

    //loadQuest
    public List<Quest> loadQuest() {
        List<Quest> list = new ArrayList<>();
        Cursor cursor = db.query("Quest",null,null,null,null,null,null);

        //query all
        if(cursor.moveToFirst()) {
            do {
                Quest quest = new Quest();
                quest.setCategory(cursor.getString(cursor.getColumnIndex("category")));
                quest.setType(cursor.getString(cursor.getColumnIndex("type")));
                quest.setId(cursor.getString(cursor.getColumnIndex("id")));
                quest.setPrequest_id(cursor.getString(cursor.getColumnIndex("prequest_id")));
                quest.setReward_fuel(cursor.getString(cursor.getColumnIndex("reward_fuel")));
                quest.setReward_bullet(cursor.getString(cursor.getColumnIndex("reward_bullet")));
                quest.setReward_steel(cursor.getString(cursor.getColumnIndex("reward_steel")));
                quest.setReward_alum(cursor.getString(cursor.getColumnIndex("reward_alum")));
                quest.setReward_other(cursor.getString(cursor.getColumnIndex("reward_other")));
                quest.setCondition(cursor.getString(cursor.getColumnIndex("condition")));
                quest.setNotice(cursor.getString(cursor.getColumnIndex("notice")));
                list.add(quest);
            } while (cursor.moveToNext());
        }
        return list;
    }
    
    //// TODO: 2015/8/29 Add Sync method 
}
