package com.kantai_wiki.kcw_mobile.util;

import android.content.Context;

import com.kantai_wiki.kcw_mobile.background_task.TaskWrapper;

import java.util.List;

/**
 * Created by Wafer on 2015/9/23.
 *
 */
public class TaskUtils{

    /**
     * This method is used to execute the asyncTask.
     * @param taskType SYNC or LOAD in the TaskTypeContract class
     * @param context The context
     * @param taskInnerType The InnerType such as QUEST, EXPEDITION
     * @return The Load/Sync Result, Please cast it to the List you want.
     */
    public static List<?> execute(int taskType,Context context,int taskInnerType) {
        TaskWrapper taskWrapper = new TaskWrapper();
        taskWrapper.execute(taskType, context,taskInnerType);
        return taskWrapper.getmList();
    }
}
