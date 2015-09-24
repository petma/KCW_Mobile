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
public class SyncTask extends AsyncTask<Void, Void, List<?>>{

    private int taskType;
    public TaskListener taskListener = null;
    Context context;

    /**
     * The SyncTask extends AsyncTask
     * Use it to sync data from server
     * You must implement the TaskListener interface to get the resultStatus
     * @param context The context that you current running
     * @param taskType Please indicate the syncType,
     *                 The Type is contained at TaskTypeContract Class
     * @param taskListener This is the taskListener. You must implement this
     *                         interface with your Activity to run this Task.
     */
    public SyncTask(Context context, int taskType, TaskListener taskListener) {
        super();
        this.context = context;
        this.taskType = taskType;
        this.taskListener = taskListener;
    }

    @Override
    protected List<?> doInBackground(Void... params) {
        KCWDB kcwdb = KCWDB.getInstance(context);
        try {
            //sync
            String response = HTTPUtils.download(HTTPUtils.getURL(taskType));
            switch (taskType) {
                case TaskTypeContract.TASK_TYPE_QUEST:
                    List<Quest> questList;
                    questList = Parser.praseQuest(response);
                    kcwdb.syncQuest(questList);
                    return questList;

                case TaskTypeContract.TASK_TYPE_EXPEDITION:
                    List<Expedition> expeditionList;
                    expeditionList = Parser.praseExpedition(response);
                    kcwdb.syncExpedition(expeditionList);
                    return expeditionList;

                case TaskTypeContract.TASK_TYPE_EQUIPMENT_KMS:
                    List<EquipmentKMS> equipmentKMSList;
                    equipmentKMSList = Parser.parseEquipmentKMS(response);
                    kcwdb.syncEquipmentKMS(equipmentKMSList);
                    return equipmentKMSList;

                case TaskTypeContract.TASK_TYPE_EQUIPMENT_ENEMY:
                    List<EquipmentEnemy> equipmentEnemyList;
                    equipmentEnemyList = Parser.parseEquipmentEnemy(response);
                    kcwdb.syncEquipmentEnemy(equipmentEnemyList);
                    return  equipmentEnemyList;

                case TaskTypeContract.TASK_TYPE_EQUIPMENT_UPGRADE:
                    List<EquipmentUpgrade> equipmentUpgradeList;
                    equipmentUpgradeList = Parser.parseEquipmentUpgrade(response);
                    kcwdb.syncEquipmentUpgrade(equipmentUpgradeList);
                    return equipmentUpgradeList;

                default:
                    throw new IllegalArgumentException();
            }
        }
        catch (IOException e) {
            Log.d("NETWORK","ERROR!!!!!");
            return null;
        }
        catch (IllegalArgumentException e) {
            Log.d("IllegalArgument", "The task type is illegal");
            return null;
        }
        catch (IllegalAccessException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<?> list) {
        taskListener.onResult(list);
    }
}
