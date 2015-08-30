package com.kantai_wiki.kcw_mobile.background_task;

import android.content.Context;
import android.os.AsyncTask;

import com.kantai_wiki.kcw_mobile.db.KCWDB;

import java.util.List;

/**
 * Created by Wafer on 2015/8/31.
 *
 */
public class LoadTask extends AsyncTask<Integer, Void, List<?>> {

    public TaskResponse taskResponse;
    public LoadResult loadResult;
    private Context context;

    /**
     * The LoadTask extends AsyncTask
     * Use it to load data from DataBase
     * You must implement the TaskResponse and the LoadResult interface
     * To get the TaskResponse and the data of loading
     *
     * @param context The current context which you are running
     */

    public LoadTask(Context context) {
        this.context = context;
    }

    @Override
    protected List<?> doInBackground(Integer... taskTypes) {
        KCWDB kcwdb = KCWDB.getInstance(context);

        switch (taskTypes[0]) {

            case TaskTypeContract.TASK_TYPE_QUEST:
                return kcwdb.loadQuest();
            case TaskTypeContract.TASK_TYPE_EXPEDITION:
                return kcwdb.loadExpedition();
            case TaskTypeContract.TASK_TYPE_EQUIPMENT_KMS:
                return kcwdb.loadEquipmentKMS();
            case TaskTypeContract.TASK_TYPE_EQUIPMENT_ENEMY:
                return kcwdb.loadEquipmentEnemy();
            case TaskTypeContract.TASK_TYPE_EQUIPMENT_UPGRADE:
                return kcwdb.loadEquipmentUpgrade();
            default:
                taskResponse.processFinish(false, "The task type is illegal");
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<?> objects) {
        loadResult.getLoadResult(objects);
    }
}
