package com.kantai_wiki.kcw_mobile.background_task;

import android.content.Context;
import android.os.AsyncTask;

import com.kantai_wiki.kcw_mobile.db.KCWDB;
import com.kantai_wiki.kcw_mobile.model.EquipmentEnemy;
import com.kantai_wiki.kcw_mobile.model.EquipmentKMS;
import com.kantai_wiki.kcw_mobile.model.EquipmentUpgrade;
import com.kantai_wiki.kcw_mobile.model.Expedition;
import com.kantai_wiki.kcw_mobile.model.Quest;
import com.kantai_wiki.kcw_mobile.util.HTTPUtils;
import com.kantai_wiki.kcw_mobile.util.Parser;

import java.io.IOException;
import java.util.List;

/**
 * Created by Wafer on 2015/8/31.
 *
 */
public class LoadTask extends AsyncTask<Void, Void, List<?>> {

    public TaskListener taskListener;
    private Context context;
    private int taskTypes;

    /**
     * The LoadTask extends AsyncTask
     * Use it to load data from DataBase
     * You must implement the TaskResponse and the LoadResult interface
     * To get the TaskResponse and the data of loading
     *
     * @param context The current context which you are running
     */

    public LoadTask(Context context,int taskType,TaskListener taskListener) {
        this.context = context;
        this.taskListener = taskListener;
        this.taskTypes = taskType;
    }

    @Override
    protected List<?> doInBackground(Void... param) {
        KCWDB kcwdb = KCWDB.getInstance(context);

        switch (taskTypes) {

            case TaskTypeContract.TASK_TYPE_QUEST:
                List<Quest> questList;
                questList = kcwdb.loadQuest();
                if (questList.isEmpty()) {

                    //sync
                    try {
                        String response;
                        response = HTTPUtils.download(HTTPUtils.getURL(taskTypes));
                        questList = Parser.praseQuest(response);
                        kcwdb.syncQuest(questList);
                    } catch (IOException e) {
                        return null;
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                }

                return questList;

            case TaskTypeContract.TASK_TYPE_EXPEDITION:
                List<Expedition> expeditionList;
                expeditionList = kcwdb.loadExpedition();
                if (expeditionList.isEmpty()) {

                    //sync
                    try {
                        String response;
                        response = HTTPUtils.download(HTTPUtils.getURL(taskTypes));
                        expeditionList = Parser.praseExpedition(response);
                        kcwdb.syncExpedition(expeditionList);
                    } catch (IOException e) {
                        return null;
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                }

                return expeditionList;

            case TaskTypeContract.TASK_TYPE_EQUIPMENT_KMS:
                List<EquipmentKMS> equipmentKMSList;
                equipmentKMSList = kcwdb.loadEquipmentKMS();
                if (equipmentKMSList.isEmpty()) {

                    //sync
                    try {
                        String response;
                        response = HTTPUtils.download(HTTPUtils.getURL(taskTypes));
                        equipmentKMSList = Parser.parseEquipmentKMS(response);
                        kcwdb.syncEquipmentKMS(equipmentKMSList);
                    } catch (IOException e) {
                        return null;
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                }

                return equipmentKMSList;

            case TaskTypeContract.TASK_TYPE_EQUIPMENT_ENEMY:
                List<EquipmentEnemy> equipmentEnemyList;
                equipmentEnemyList = kcwdb.loadEquipmentEnemy();
                if (equipmentEnemyList.isEmpty()) {

                    //sync
                    String response;
                    try {
                        response = HTTPUtils.download(HTTPUtils.getURL(taskTypes));
                        equipmentEnemyList = Parser.parseEquipmentEnemy(response);
                        kcwdb.syncEquipmentEnemy(equipmentEnemyList);
                    } catch (IOException e) {
                        return null;
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                }

                return equipmentEnemyList;
            case TaskTypeContract.TASK_TYPE_EQUIPMENT_UPGRADE:
                List<EquipmentUpgrade> equipmentUpgradeList;
                equipmentUpgradeList = kcwdb.loadEquipmentUpgrade();
                if (equipmentUpgradeList.isEmpty()) {

                    //sync
                    String response;
                    try {
                        response = HTTPUtils.download(HTTPUtils.getURL(taskTypes));
                        equipmentUpgradeList = Parser.parseEquipmentUpgrade(response);
                        kcwdb.syncEquipmentUpgrade(equipmentUpgradeList);
                    } catch (IOException e) {
                        return  null;
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                }
                return equipmentUpgradeList;

            default:
                break;
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<?> objects) {
        taskListener.onResult(objects);
    }
}
