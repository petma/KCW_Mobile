package com.kantai_wiki.kcw_mobile.background_task;

/**
 * Created by Wafer on 2015/8/31.
 *
 */
public abstract class TaskTypeContract {

    public static final int TASK_TYPE_QUEST = 0;
    public static final int TASK_TYPE_EXPEDITION = 1;
    public static final int TASK_TYPE_EQUIPMENT_KMS = 2;
    public static final int TASK_TYPE_EQUIPMENT_ENEMY = 3;
    public static final int TASK_TYPE_EQUIPMENT_UPGRADE = 4;

    public static final int TASK_TYPE_SYNC = 0;
    public static final int TASK_TYPE_LOAD = 1;

    public TaskTypeContract() {
    }

}
