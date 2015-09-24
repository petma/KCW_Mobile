package com.kantai_wiki.kcw_mobile.db;

import android.provider.BaseColumns;


/**
 * Created by Wafer on 2015/8/28.
 *
 */
public final class DBContract {

    //Prevent the instantiating
    public DBContract() { }

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


    //Equipment_kms
    private static abstract class EquipmentKMS implements BaseColumns {

        //Design of the table
        public static final String TABLE_NAME = "EquipmentKMS";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_RARE_RATE = "rare_rate";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_VALUE_FIREPOWER = "value_firepower";
        public static final String COLUMN_VALUE_TORPEDO = "value_torpedo";
        public static final String COLUMN_VALUE_EXPLOSION = "value_explosion";
        public static final String COLUMN_VALUE_ANTIAIRCRAFT = "value_antiaircraft";
        public static final String COLUMN_VALUE_ANTISUBMARINE = "value_antisubmarine";
        public static final String COLUMN_VALUE_TRACKING = "value_tracking";
        public static final String COLUMN_VALUE_ACCURACY = "value_accuracy";
        public static final String COLUMN_VALUE_EVASION = "value_evasion";
        public static final String COLUMN_RANGE = "range";
        public static final String COLUMN_EQUIPPABLE = "equippable";
        public static final String COLUMN_NOTICE = "notice";
    }


    //Equipment_enemy
    private static abstract class EquipmentEnemy implements BaseColumns {

        //Design of the table
        public static final String TABLE_NAME = "EquipmentEnemy";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_RANGE = "range";
        public static final String COLUMN_VALUE_FIREPOWER = "value_firepower";
        public static final String COLUMN_VALUE_TORPEDO = "value_torpedo";
        public static final String COLUMN_VALUE_ANTIAIRCRAFT = "value_antiaircraft";
        public static final String COLUMN_VALUE_ACCURACY = "value_accuracy";
        public static final String COLUMN_VALUE_TRACKING = "value_tracking";
        public static final String COLUMN_VALUE_EXPLOSION = "value_explosion";
        public static final String COLUMN_VALUE_ANTISUBMARINE = "value_antisubmarine";
        public static final String COLUMN_VALUE_EVASION = "value_evasion";
        public static final String COLUMN_VALUE_ARMOR = "value_armor";
    }

    //Equipment_upgrade
    private static abstract class EquipmentUpgrade implements BaseColumns {

        //Design of the table
        public static final String TABLE_NAME = "EquipmentUpgrade";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_POSITION = "position";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_STAR = "star";
        public static final String COLUMN_CONSUME_FUEL = "consume_fuel";
        public static final String COLUMN_CONSUME_BULLET = "consume_bullet";
        public static final String COLUMN_CONSUME_STEEL = "consume_steel";
        public static final String COLUMN_CONSUME_ALUM = "consume_alum";
        public static final String COLUMN_CONSUME_MATERIAL = "consume_material";
        public static final String COLUMN_CONSUME_SCREW = "consume_screw";
        public static final String COLUMN_CONSUME_EQUIPMENT = "consume_equipment";
        public static final String COLUMN_UPGRADEABLE_DAY = "upgradeable_day";
        public static final String COLUMN_ASSISTANT_SHIP = "assistant_ship";
        public static final String COLUMN_UPGRADE_RESULT = "upgrade_result";
        public static final String COLUMN_UPGRADE_RESULT_INVENTABLE = "upgrade_result_inventeable";
    }


    //TABLE NAME
    public static final String TABLE_EXPEDITION = Expedition.TABLE_NAME;
    public static final String TABLE_EQUIPMENTKMS = EquipmentKMS.TABLE_NAME;
    public static final String TABLE_EQUIPMENTENEMY = EquipmentEnemy.TABLE_NAME;
    public static final String TABLE_EQUIPMENTUPGRADE = EquipmentUpgrade.TABLE_NAME;
    public static final String TABLE_QUEST = Quest.TABLE_NAME;

    //SQL Command

    //Equipment_upgrade
    public static final String SQL_CREATE_EQUIPMENTUPGRADE = "create table " + EquipmentUpgrade.TABLE_NAME + " (" +
            EquipmentUpgrade._ID + " integer primary key autoincrement" + COMMA_SET +
            EquipmentUpgrade.COLUMN_CATEGORY + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_POSITION + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_NAME + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_STAR + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_CONSUME_FUEL + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_CONSUME_BULLET + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_CONSUME_STEEL + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_CONSUME_ALUM + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_CONSUME_MATERIAL + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_CONSUME_SCREW + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_CONSUME_EQUIPMENT + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_UPGRADEABLE_DAY + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_ASSISTANT_SHIP + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_UPGRADE_RESULT + TYPE_TEXT + COMMA_SET +
            EquipmentUpgrade.COLUMN_UPGRADE_RESULT_INVENTABLE + TYPE_TEXT +
            " )";

    public static final String SQL_DELETE_EQUIPMENTUPGRADE =
            "drop table if exists " + EquipmentUpgrade.TABLE_NAME;

    //Equipment_enemy
    public static final String SQL_CREATE_EQUIPMENTENEMY = "create table " + EquipmentEnemy.TABLE_NAME + " (" +
            EquipmentEnemy._ID + " integer primary key autoincrement" + COMMA_SET +
            EquipmentEnemy.COLUMN_NAME + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_CATEGORY + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_RANGE + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_FIREPOWER + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_TORPEDO + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_ANTIAIRCRAFT + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_ACCURACY + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_TRACKING + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_EXPLOSION + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_ANTISUBMARINE + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_EVASION + TYPE_TEXT + COMMA_SET +
            EquipmentEnemy.COLUMN_VALUE_ARMOR + TYPE_TEXT +
            " )";

    public static final String SQL_DELETE_EQUIPMENTENEMY =
            "drop table if exists " + EquipmentEnemy.TABLE_NAME;

    //EquipmentKMS
    public static final String SQL_CREATE_EQUIPMENTKMS = "create table " + EquipmentKMS.TABLE_NAME + " (" +
            EquipmentKMS._ID + " integer primary key autoincrement" + COMMA_SET +
            EquipmentKMS.COLUMN_ID + TYPE_INTEGER + COMMA_SET +
            EquipmentKMS.COLUMN_RARE_RATE + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_CATEGORY + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_VALUE_FIREPOWER + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_VALUE_TORPEDO + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_VALUE_EXPLOSION + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_VALUE_ANTIAIRCRAFT + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_VALUE_ANTISUBMARINE + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_VALUE_TRACKING + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_VALUE_ACCURACY + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_VALUE_EVASION + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_RANGE + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_EQUIPPABLE + TYPE_TEXT + COMMA_SET +
            EquipmentKMS.COLUMN_NOTICE + TYPE_TEXT +
            " )";

    public static final String SQL_DELETE_EQUIPMENTKMS =
            "drop table if exists " + EquipmentKMS.TABLE_NAME;

    //Quest
    public static final String SQL_CREATE_QUEST = "create table " + Quest.TABLE_NAME + " (" +
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
            Quest.COLUMN_NOTICE + TYPE_TEXT +
            " )";

    public static final String SQL_DELETE_QUEST =
            "drop table if exists " + Quest.TABLE_NAME;

    //Expedition
    public static final String SQL_CREATE_EXPEDITION = "create table " + Expedition.TABLE_NAME + " (" +
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
