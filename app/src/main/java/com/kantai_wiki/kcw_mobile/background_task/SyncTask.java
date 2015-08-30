package com.kantai_wiki.kcw_mobile.background_task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

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
public class SyncTask extends AsyncTask<String, Void, Boolean>{

    final int taskType;
    public TaskResponse taskResponse = null;
    Context context;

    /**
     * The SyncTask extends AsyncTask
     * Use it to sync data from server
     * You must implement the TaskResponse interface to get the resultStatus
     * @param context The context that you current running
     * @param taskType Please indicate the syncType,
     *                 The Type is contained at TaskTypeContract Class
     */

    public SyncTask(Context context, int taskType) {
        super();
        this.context = context;
        this.taskType = taskType;
    }

    @Override
    protected Boolean doInBackground(String... urls) {
        KCWDB kcwdb = KCWDB.getInstance(context);
        try {
            String response = HTTPUtils.download(urls[0]);
            switch (taskType) {
                case TaskTypeContract.TASK_TYPE_QUEST:
                    List<Quest> questList;
                    questList = Parser.praseQuest(response);
                    kcwdb.syncQuest(questList);
                    break;

                case TaskTypeContract.TASK_TYPE_EXPEDITION:
                    List<Expedition> expeditionList;
                    expeditionList = Parser.praseExpedition(response);
                    kcwdb.syncExpedition(expeditionList);
                    break;

                case TaskTypeContract.TASK_TYPE_EQUIPMENT_KMS:
                    List<EquipmentKMS> equipmentKMSList;
                    equipmentKMSList = Parser.parseEquipmentKMS(response);
                    kcwdb.EquipmentKMS(equipmentKMSList);
                    break;

                case TaskTypeContract.TASK_TYPE_EQUIPMENT_ENEMY:
                    List<EquipmentEnemy> equipmentEnemyList;
                    equipmentEnemyList = Parser.parseEquipmentEnemy(response);
                    kcwdb.syncEquipmentEnemy(equipmentEnemyList);
                    break;

                case TaskTypeContract.TASK_TYPE_EQUIPMENT_UPGRADE:
                    List<EquipmentUpgrade> equipmentUpgradeList;
                    equipmentUpgradeList = Parser.parseEquipmentUpgrade(response);
                    kcwdb.syncEquipmentUpgrade(equipmentUpgradeList);
                    break;

                default:
                    throw new IllegalArgumentException();
            }
        }
        catch (IOException e) {
            taskResponse.processFinish(false, "Connection fail! Please check your connection");
            return false;
        } catch (IllegalArgumentException e) {
            taskResponse.processFinish(false, "The task type is illegal");
            Log.d("IllegalArgument", "The task type is illegal");
            return false;
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (!aBoolean) {
            return;
        }
        taskResponse.processFinish(true, "SUCCESS");
    }
}
