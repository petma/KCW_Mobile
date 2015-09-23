package com.kantai_wiki.kcw_mobile.background_task;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wafer on 2015/9/23.
 *
 */
public class TaskWrapper {
    private List<?> mList;

    public TaskWrapper() {
        mList = new ArrayList<>();
    }

    public void execute(int taskType,Context context,int taskInnerType) {

        switch (taskType) {

            case TaskTypeContract.TASK_TYPE_SYNC:
                SyncTask syncTask = new SyncTask(context, taskInnerType, new TaskListener() {
                    @Override
                    public void onResult(List<?> list) {
                        setmList(list);
                    }
                });
                syncTask.execute();
                break;

            case TaskTypeContract.TASK_TYPE_LOAD:
                LoadTask loadTask = new LoadTask(context, taskInnerType, new TaskListener() {
                    @Override
                    public void onResult(List<?> list) {
                        setmList(list);
                    }
                });
                loadTask.execute();
                break;
        }
    }

    private void setmList(List<?> mList) {
        this.mList = mList;
    }

    public List<?> getmList() {
        return mList;
    }
}
