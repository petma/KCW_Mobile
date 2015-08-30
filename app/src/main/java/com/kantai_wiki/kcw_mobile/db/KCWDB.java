package com.kantai_wiki.kcw_mobile.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kantai_wiki.kcw_mobile.model.EquipmentEnemy;
import com.kantai_wiki.kcw_mobile.model.EquipmentKMS;
import com.kantai_wiki.kcw_mobile.model.EquipmentUpgrade;
import com.kantai_wiki.kcw_mobile.model.Expedition;
import com.kantai_wiki.kcw_mobile.model.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wafer on 2015/8/29.
 *
 */
public class KCWDB {

    public static final String DB_NAME = "kcw";

    public static final int VERSION = 1;

    private static KCWDB kcwdb;

    private SQLiteDatabase db;

    //Make the Ctor private

    private KCWDB(Context context) {
        KCWOpenHelper kcwOpenHelper = new KCWOpenHelper(context, DB_NAME, null, VERSION);
        db = kcwOpenHelper.getWritableDatabase();
    }

    //Get the instance
    public synchronized static KCWDB getInstance(Context context) {
        if (kcwdb == null) {
            kcwdb = new KCWDB(context);
        }
        return kcwdb;
    }

    //Check if table is empty
    private boolean isTableEmpty(String TABLE_NAME) {

        boolean flag;
        String quString = "SELETE COUNT(*) FROM TABLE " + TABLE_NAME;
        Cursor cursor = db.rawQuery(quString, null);
        cursor.moveToFirst();
        flag = cursor.getInt(0) == 0;

        cursor.close();

        return flag;
    }

    /**
     * The Quest Table Utils
     */

    //getQuestValue
    private ContentValues getQuestValues(Quest quest) {
        ContentValues values = new ContentValues();
        values.put("category", quest.getCategory());
        values.put("type", quest.getType());
        values.put("prequest_id", quest.getPrequest_id());
        values.put("name", quest.getName());
        values.put("reward_fuel", quest.getReward_fuel());
        values.put("reward_bullet", quest.getReward_bullet());
        values.put("reward_steel", quest.getReward_steel());
        values.put("reward_alum", quest.getReward_alum());
        values.put("reward_other", quest.getReward_other());
        values.put("condition", quest.getCondition());
        values.put("notice", quest.getNotice());
        return values;
    }

    //insert quest
    private void insertQuest(Quest quest) {
        if (quest != null) {
            db.insert(DBContract.TABLE_QUEST, null, getQuestValues(quest));
        }
    }

    //loadQuest
    public List<Quest> loadQuest() {
        List<Quest> list = new ArrayList<>();
        Cursor cursor = db.query("Quest", null, null, null, null, null, null);

        //query all
        if (cursor.moveToFirst()) {
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

        cursor.close();

        return list;
    }

    //sync Quest
    public void syncQuest(List<Quest> list) {
        if(isTableEmpty(DBContract.TABLE_QUEST)) {

            //if the table is empty insert data
            for (Quest quest : list) {
                insertQuest(quest);
            }
        } else {
            //if it's not empty, update all data

            db.beginTransaction();
            try {
                db.delete(DBContract.TABLE_QUEST,null,null);
                for (Quest quest :list) {
                    insertQuest(quest);
                }
                db.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                db.endTransaction();
            }
        }
    }


    /**
     * The Expedition Utils
     *
     */

    //getExpeditionValue
    private ContentValues getExpeditionValue(Expedition expedition) {

        ContentValues values = new ContentValues();
        values.put("id",expedition.getId());
        values.put("name",expedition.getName());
        values.put("flagship_lv",expedition.getFlagship_lv());
        values.put("time",expedition.getTime());
        values.put("consume_fuel",expedition.getConsume_fuel());
        values.put("consume_bullet",expedition.getConsume_bullet());
        values.put("teitoku_exp",expedition.getTeitoku_exp());
        values.put("kanmusu_exp",expedition.getKanmusu_exp());
        values.put("reward_fuel",expedition.getReward_fuel());
        values.put("reward_bullet",expedition.getReward_bullet());
        values.put("reward_steel",expedition.getReward_steel());
        values.put("reward_alum",expedition.getReward_alum());
        values.put("reward_bucket",expedition.getReward_bucket());
        values.put("reward_lighter",expedition.getReward_lighter());
        values.put("reward_material",expedition.getReward_material());
        values.put("reward_furniture_box",expedition.getReward_furniture_box());
        values.put("fleet_condition",expedition.getFleet_condition());
        values.put("notice",expedition.getNotice());

        return values;
    }

    //insert Expedition
    private void insertExpedition(Expedition expedition) {
        if(expedition != null) {
            db.insert(DBContract.TABLE_EXPEDITION,null,getExpeditionValue(expedition));
        }
    }

    //loadExpedition
    public List<Expedition> loadExpedition() {
        List<Expedition> list = new ArrayList<>();

        Cursor cursor = db.query(DBContract.TABLE_EXPEDITION,null,null,null,null,null,null);

        //query all
        if (cursor.moveToFirst()) {
            do {
                Expedition expedition = new Expedition();

                expedition.setId(cursor.getInt(cursor.getColumnIndex("id")));
                expedition.setName(cursor.getString(cursor.getColumnIndex("name")));
                expedition.setFlagship_lv(cursor.getString(cursor.getColumnIndex("flagship_lv")));
                expedition.setConsume_fuel(cursor.getString(cursor.getColumnIndex("consume_fuel")));
                expedition.setConsume_bullet(cursor.getString(cursor.getColumnIndex("consume_bullet")));
                expedition.setTeitoku_exp(cursor.getString(cursor.getColumnIndex("teitoku_exp")));
                expedition.setKanmusu_exp(cursor.getString(cursor.getColumnIndex("kanmusu_exp")));
                expedition.setReward_fuel(cursor.getString(cursor.getColumnIndex("reward_fuel")));
                expedition.setReward_bucket(cursor.getString(cursor.getColumnIndex("reward_bullet")));
                expedition.setReward_steel(cursor.getString(cursor.getColumnIndex("reward_steel")));
                expedition.setReward_alum(cursor.getString(cursor.getColumnIndex("reward_alum")));
                expedition.setReward_bucket(cursor.getString(cursor.getColumnIndex("reward_bucket")));
                expedition.setReward_lighter(cursor.getString(cursor.getColumnIndex("reward_lighter")));
                expedition.setReward_material(cursor.getString(cursor.getColumnIndex("reward_material")));
                expedition.setReward_furniture_box(cursor.getString(cursor.getColumnIndex("reward_furniture_box")));
                expedition.setNotice(cursor.getString(cursor.getColumnIndex("notice")));

                list.add(expedition);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    //sync Expedition
    public void syncExpedition(List<Expedition> list) {
        if (isTableEmpty(DBContract.TABLE_EXPEDITION)) {

            for (Expedition expedition : list) {
                insertExpedition(expedition);
            }
        } else {

            db.beginTransaction();
            try {
                db.delete(DBContract.TABLE_EXPEDITION,null,null);

                for (Expedition expedition : list) {
                    insertExpedition(expedition);
                }
                db.setTransactionSuccessful();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                db.endTransaction();
            }
        }
    }


    /**
     * EquipmentKMS Utils
     *
     */

    //getEquipmentKMSContentValue
    private ContentValues getEquipmentKMSValues(EquipmentKMS equipmentKMS) {
        ContentValues values = new ContentValues();

        //build the equippable String
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<equipmentKMS.getEquippable().size();i++) {
            stringBuilder.append(equipmentKMS.getEquippable().get(i));
            if (i == equipmentKMS.getEquippable().size() - 1) {
                break;
            }
            stringBuilder.append(",");
        }

        values.put("id", equipmentKMS.getId());
        values.put("rare_rate",equipmentKMS.getRare_rate());
        values.put("category", equipmentKMS.getCategory());
        values.put("value_firepower",equipmentKMS.getValue_firepower());
        values.put("value_torpedo",equipmentKMS.getValue_torpedo());
        values.put("value_explosion",equipmentKMS.getValue_explosion());
        values.put("value_antiaircraft",equipmentKMS.getValue_antiaircraft());
        values.put("value_antisubmarine",equipmentKMS.getValue_antisubmarine());
        values.put("value_tracking",equipmentKMS.getValue_tracking());
        values.put("value_accuracy",equipmentKMS.getValue_accuracy());
        values.put("value_evasion",equipmentKMS.getValue_evasion());
        values.put("range",equipmentKMS.getRange());
        values.put("equippable",stringBuilder.toString());
        values.put("notice",equipmentKMS.getNotice());

        return values;
    }


    //insert EquipmentKMS
    private void insertEquipmentKMS (EquipmentKMS equipmentkms) {

        if (equipmentkms != null) {
            db.insert(DBContract.TABLE_EQUIPMENTKMS,null,getEquipmentKMSValues(equipmentkms));
        }
    }

    //load
    public List<EquipmentKMS> loadEquipemntKMS () {

        List<EquipmentKMS> list = new ArrayList<>();
        Cursor cursor = db.query(DBContract.TABLE_EQUIPMENTKMS,null,null,null,null,null,null);

        //query all
        if (cursor.moveToFirst()) {
            do {
                EquipmentKMS equipmentKMS = new EquipmentKMS();

                equipmentKMS.setId(cursor.getInt(cursor.getColumnIndex("id")));
                equipmentKMS.setRare_rate(cursor.getString(cursor.getColumnIndex("rare_rate")));
                equipmentKMS.setName(cursor.getString(cursor.getColumnIndex("name")));
                equipmentKMS.setCategory(cursor.getString(cursor.getColumnIndex("category")));
                equipmentKMS.setValue_firepower(cursor.getString(cursor.getColumnIndex("value_firepower")));
                equipmentKMS.setValue_torpedo(cursor.getString(cursor.getColumnIndex("value_torpedo")));
                equipmentKMS.setValue_explosion(cursor.getString(cursor.getColumnIndex("value_explosion")));
                equipmentKMS.setValue_antiaircraft(cursor.getString(cursor.getColumnIndex("value_antiaircraft")));
                equipmentKMS.setValue_antisubmarine(cursor.getString(cursor.getColumnIndex("value_antisubmarine")));
                equipmentKMS.setValue_tracking(cursor.getString(cursor.getColumnIndex("value_tracking")));
                equipmentKMS.setValue_accuracy(cursor.getString(cursor.getColumnIndex("value_accuracy")));
                equipmentKMS.setValue_evasion(cursor.getString(cursor.getColumnIndex("value_evasion")));
                equipmentKMS.setRange(cursor.getString(cursor.getColumnIndex("range")));

                ArrayList<String> strings = new ArrayList<>();
                String s = cursor.getString(cursor.getColumnIndex("equippable"));

                int flag = 0;
                for (int i = 0;i<s.length();i++) {
                    if (Character.toString(s.charAt(i) ).equals(",")) {
                        strings.add(s.substring(flag,i));
                        flag = i;
                    }

                    //border check
                    if (i == s.length() - 1) {
                        strings.add(s.substring(flag + 1));
                    }
                }
                equipmentKMS.setEquippable(strings);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }


    //sync
    public void EquipmentKMS (List<EquipmentKMS> list) {
        if (isTableEmpty(DBContract.TABLE_EQUIPMENTKMS)) {
            for (EquipmentKMS equipmentkms : list) {
                insertEquipmentKMS(equipmentkms);
            }
        } else {

            db.beginTransaction();
            try {
                db.delete(DBContract.TABLE_EQUIPMENTKMS,null,null);

                for (EquipmentKMS equipmentkms : list) {
                    insertEquipmentKMS(equipmentkms);
                }
                db.setTransactionSuccessful();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                db.endTransaction();
            }
        }
    }



    /**
     * EquipmentEnemy
     *
     */

    //getContentValues
    private ContentValues getEquipmentEnemyValues(EquipmentEnemy equipmentEnemy) {
        ContentValues values = new ContentValues();

        values.put("name",equipmentEnemy.getName());
        values.put("category",equipmentEnemy.getCategory());
        values.put("range",equipmentEnemy.getRange());
        values.put("value_firepower",equipmentEnemy.getValue_firepower());
        values.put("value_torpedo",equipmentEnemy.getValue_torpedo());
        values.put("value_antiaircraft",equipmentEnemy.getValue_antiaircraft());
        values.put("value_accuracy",equipmentEnemy.getValue_accuracy());
        values.put("value_tracking",equipmentEnemy.getValue_tracking());
        values.put("value_explosion",equipmentEnemy.getValue_explosion());
        values.put("value_antisubmarine",equipmentEnemy.getValue_antisubmarine());
        values.put("value_evasion",equipmentEnemy.getValue_evasion());
        values.put("value_armor",equipmentEnemy.getValue_armor());

        return values;
    }

    //insert
    private void insertEquipmentEnemy(EquipmentEnemy equipmentEnemy) {

        if (equipmentEnemy != null) {
            db.insert(DBContract.TABLE_EQUIPMENTENEMY, null, getEquipmentEnemyValues(equipmentEnemy));
        }
    }

    //load
    public List<EquipmentEnemy> loadEquipmentEnemy() {

        List<EquipmentEnemy> list = new ArrayList<>();
        Cursor cursor = db.query(DBContract.TABLE_EQUIPMENTENEMY,null,null,null,null,null,null);

        //query all
        if (cursor.moveToFirst()) {

            do {
                EquipmentEnemy equipmentEnemy = new EquipmentEnemy();

                equipmentEnemy.setName(cursor.getString(cursor.getColumnIndex("name")));
                equipmentEnemy.setCategory(cursor.getString(cursor.getColumnIndex("category")));
                equipmentEnemy.setRange(cursor.getString(cursor.getColumnIndex("range")));
                equipmentEnemy.setValue_firepower(cursor.getString(cursor.getColumnIndex("value_firepower")));
                equipmentEnemy.setValue_torpedo(cursor.getString(cursor.getColumnIndex("value_torpedo")));
                equipmentEnemy.setValue_antiaircraft(cursor.getString(cursor.getColumnIndex("value_antiaircraft")));
                equipmentEnemy.setValue_accuracy(cursor.getString(cursor.getColumnIndex("value_accuracy")));
                equipmentEnemy.setValue_tracking(cursor.getString(cursor.getColumnIndex("value_tracking")));
                equipmentEnemy.setValue_explosion(cursor.getString(cursor.getColumnIndex("value_explosion")));
                equipmentEnemy.setValue_antisubmarine(cursor.getString(cursor.getColumnIndex("value_antisubmarine")));
                equipmentEnemy.setValue_evasion(cursor.getString(cursor.getColumnIndex("value_evasion")));
                equipmentEnemy.setValue_armor(cursor.getString(cursor.getColumnIndex("value_armor")));

                list.add(equipmentEnemy);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    //sync
    public void syncEquipmentEnemy(List<EquipmentEnemy> list) {
        if (isTableEmpty(DBContract.TABLE_EQUIPMENTENEMY)) {
            for (EquipmentEnemy equipmentEnemy : list) {
                insertEquipmentEnemy(equipmentEnemy);
            }
        } else {

            db.beginTransaction();
            try {
                db.delete(DBContract.TABLE_EQUIPMENTENEMY,null,null);

                for (EquipmentEnemy equipmentEnemy :list) {
                    insertEquipmentEnemy(equipmentEnemy);
                }

                db.setTransactionSuccessful();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                db.endTransaction();
            }
        }
    }


    /**
     * EquipmentUpgrade Utils
     *
     */

    //getEquipmentUpgradeContentValues
    private ContentValues getEquipmentUpgradeValues (EquipmentUpgrade equipmentUpgrade) {
        ContentValues values = new ContentValues();

        values.put("category",equipmentUpgrade.getCategory());
        values.put("position",equipmentUpgrade.getPosition());
        values.put("name",equipmentUpgrade.getName());
        values.put("star",equipmentUpgrade.getStar());
        values.put("consume_fuel",equipmentUpgrade.getConsume_fuel());
        values.put("consume_bullet",equipmentUpgrade.getConsume_bullet());
        values.put("consume_steel",equipmentUpgrade.getConsume_bullet());
        values.put("consume_alum",equipmentUpgrade.getConsume_alum());
        values.put("consume_material",equipmentUpgrade.getConsume_material());
        values.put("consume_screw",equipmentUpgrade.getConsume_screw());
        values.put("consume_equipment",equipmentUpgrade.getConsume_equipment());

        //upgradeable_day key
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0;i<equipmentUpgrade.getUpgradeable_day().size();i++) {
            stringBuilder.append(equipmentUpgrade.getUpgradeable_day().get(i));

            if (i == equipmentUpgrade.getUpgradeable_day().size() - 1) {
                break;
            }

            stringBuilder.append(",");
        }
        values.put("upgradeable_day",stringBuilder.toString());

        //assistant key
        StringBuilder builder = new StringBuilder();

        for(int i = 0;i<equipmentUpgrade.getAssistant_ship().size();i++) {
            builder.append(equipmentUpgrade.getAssistant_ship().get(i));

            if (i == equipmentUpgrade.getAssistant_ship().size() - 1) {
                break;
            }

            builder.append(",");
        }

        values.put("assistant_ship",builder.toString());

        values.put("upgrade_result",equipmentUpgrade.getUpgrade_result());
        values.put("upgrade_result_inventable",equipmentUpgrade.getUpgrade_result_inventable());

        return values;
    }

    //insert
    private void insertEquipmentUpgrade(EquipmentUpgrade equipmentUpgrade) {

        db.insert(DBContract.TABLE_EQUIPMENTUPGRADE, null, getEquipmentUpgradeValues(equipmentUpgrade));
    }

    //load
    public List<EquipmentUpgrade> loadEquipmentUpgrade () {
        List<EquipmentUpgrade> list = new ArrayList<>();
        Cursor cursor = db.query(DBContract.TABLE_EQUIPMENTUPGRADE,null,null,null,null,null,null);

        //query all
        if (cursor.moveToFirst()) {
            do {
                EquipmentUpgrade equipmentUpgrade = new EquipmentUpgrade();

                equipmentUpgrade.setCategory(cursor.getString(cursor.getColumnIndex("category")));
                equipmentUpgrade.setPosition(cursor.getString(cursor.getColumnIndex("position")));
                equipmentUpgrade.setName(cursor.getString(cursor.getColumnIndex("name")));
                equipmentUpgrade.setConsume_fuel(cursor.getString(cursor.getColumnIndex("consume_fuel")));
                equipmentUpgrade.setConsume_bullet(cursor.getString(cursor.getColumnIndex("consume_bullet")));
                equipmentUpgrade.setConsume_steel(cursor.getString(cursor.getColumnIndex("consume_steel")));
                equipmentUpgrade.setConsume_alum(cursor.getString(cursor.getColumnIndex("consume_alum")));
                equipmentUpgrade.setConsume_material(cursor.getString(cursor.getColumnIndex("consume_material")));
                equipmentUpgrade.setConsume_screw(cursor.getString(cursor.getColumnIndex("consume_screw")));
                equipmentUpgrade.setConsume_equipment(cursor.getString(cursor.getColumnIndex("consume_equipment")));

                //upgrade_day
                ArrayList<String> strings = new ArrayList<>();
                String s = cursor.getString(cursor.getColumnIndex("upgradeable_day"));

                int flag = 0;
                for (int i = 0;i<s.length();i++) {
                    if(Character.toString(s.charAt(i)).equals(",") ) {
                        strings.add(s.substring(flag,i));
                        flag = i;
                    }

                    //border check
                    if (i == s.length() - 1) {
                        strings.add(s.substring(flag + 1));
                    }
                }
                equipmentUpgrade.setUpgradeable_day(strings);

                //assistant
                ArrayList<String> stringArrayList = new ArrayList<>();
                String string = cursor.getString(cursor.getColumnIndex("assistant_ship"));

                flag = 0;
                for (int i = 0;i<string.length();i++) {
                    if (Character.toString(s.charAt(i)).equals(",") ) {
                        stringArrayList.add(string.substring(flag,i));
                        flag = i;
                    }

                    //border check
                    if (i == s.length() - 1) {
                        stringArrayList.add(string.substring(flag + 1));
                    }
                }
                equipmentUpgrade.setAssistant_ship(stringArrayList);

                equipmentUpgrade.setUpgrade_result(cursor.getString(cursor.getColumnIndex("upgrade_result")));
                equipmentUpgrade.setUpgrade_result_inventable(cursor.getString(cursor.getColumnIndex("upgrade_result_inventable")));

            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    //sync
    public void syncEquipmentUpgrade (List<EquipmentUpgrade> list) {
        if (isTableEmpty(DBContract.TABLE_EQUIPMENTUPGRADE)) {
            for (EquipmentUpgrade equipmentUpgrade :list) {
                insertEquipmentUpgrade(equipmentUpgrade);
            }
        } else {

            db.beginTransaction();
            try {
                db.delete(DBContract.TABLE_EQUIPMENTUPGRADE,null,null);
                for (EquipmentUpgrade equipmentUpgrade: list) {
                    insertEquipmentUpgrade(equipmentUpgrade);
                }
                db.setTransactionSuccessful();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                db.endTransaction();
            }
        }
    }
}