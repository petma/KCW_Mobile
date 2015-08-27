package com.kantai_wiki.kcw_mobile.db;

import android.provider.BaseColumns;

/**
 * Created by Wafer on 2015/8/28.
 *
 */
public final class FeedReaderContract {

    //Prevent the instantiating
    public FeedReaderContract() { }

    //Default Strings
    private static final String TYPE_TEXT = " text";
    private static final String TYPE_INTEGER = " integer";
    private static final String COMMA_SET = ", ";


    //innerclass for tables

    //Expedition
    private static abstract class Expedition implements BaseColumns {

        //Design of the table
        public static final String TABLE_NAME = "Expedition";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_FLAGSHIP_LV = "flagship_lv";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_CONSUME_FUEL = "consume_fuel";
        public static final String COLUMN_CONSUME_BULLET = "consume_bullet";
        public static final String COLUMN_TEITOKU_EXP = "teitoku_exp";
        public static final String COLUMN_KANMUSU_EXP = "kanmusu_exp";
        public static final String COLUMN_REWARD_FUEL = "reward_fuel";
        public static final String COLUMN_REWARD_BULLET = "reward_bullet";
        public static final String COLUMN_REWARD_STEEL = "reward_steel";
        public static final String COLUMN_REWARD_ALUM = "reward_alum";
        public static final String COLUMN_REWARD_BUCKET = "reward_bucket";
        public static final String COLUMN_REWARD_LIGHTER = "reward_lighter";
        public static final String COLUMN_REWARD_MATERIAL = "reward_material";
        public static final String COLUMN_REWARD_FURNITURE_BOX = "reward_furniture_box";
        public static final String COLUMN_FLEET_CONDITION = "fleet_condition";
        public static final String COLUMN_NOTICE = "notice";


    }

    //Quest
    private static abstract class Quest implements BaseColumns {

        //Design of the table
        public static final String TABLE_NAME = "Quest";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_PREQUEST_ID = "prequest_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_REWARD_FUEL = "reward_fuel";
        public static final String COLUMN_REWARD_BULLET = "reward_bullet";
        public static final String COLUMN_REWARD_STEEL = "reward_steel";
        public static final String COLUMN_REWARD_ALUM = "reward_alum";
        public static final String COLUMN_REWARD_OTHER = "reward_other";
        public static final String COLUMN_CONDITION = "condition";
        public static final String COLUMN_NOTICE = "notice";
    }

    // TODO: 2015/8/28 Add Equipment_kms
    // TODO: 2015/8/28 Add Equipment_enemy
    // TODO: 2015/8/28 Add Equipment_upgrade

    //SQL Command

    //Quest
    public static final String SQL_CREAT_QUEST = "create table " + Quest.TABLE_NAME + " (" +
            Quest._ID + " integer primary key autoincrement" + COMMA_SET +
            Quest.COLUMN_CATEGORY + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_TYPE + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_ID + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_PREQUEST_ID + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_NAME + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_REWARD_FUEL + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_REWARD_BULLET + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_REWARD_STEEL + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_REWARD_ALUM + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_REWARD_OTHER + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_CONDITION + TYPE_TEXT + COMMA_SET +
            Quest.COLUMN_NOTICE + TYPE_TEXT + COMMA_SET +
            " )";

    public static final String SQL_DELETE_QUEST =
            "drop table if exists " + Quest.TABLE_NAME;

    //Expedition
    public static final String SQL_CREAT_EXPEDITION = "create table " + Expedition.TABLE_NAME + " (" +
            Expedition._ID + " integer primary key autoincrement" + COMMA_SET +
            Expedition.COLUMN_ID + TYPE_INTEGER + COMMA_SET +
            Expedition.COLUMN_NAME + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_FLAGSHIP_LV + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_TIME + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_CONSUME_FUEL + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_CONSUME_BULLET + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_TEITOKU_EXP + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_KANMUSU_EXP + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_REWARD_FUEL + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_REWARD_BULLET + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_REWARD_STEEL + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_REWARD_ALUM + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_REWARD_BUCKET + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_REWARD_LIGHTER + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_REWARD_MATERIAL + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_REWARD_FURNITURE_BOX + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_FLEET_CONDITION + TYPE_TEXT + COMMA_SET +
            Expedition.COLUMN_NOTICE + TYPE_TEXT +
            " )";

    public static final String SQL_DELETE_EXPEDITION =
            "drop table if exists " + Expedition.TABLE_NAME;

}
