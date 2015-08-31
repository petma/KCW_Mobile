package com.kantai_wiki.kcw_mobile.background_task;

/**
 * Created by Wafer on 2015/8/31.
 *
 */


public interface TaskResponse {

    /**
     * The method processFinish aims at get the result of SyncTask
     * @param result This param is boolean, true or false means the
     *               Result of the SyncTask is success or fail
     *
     * @param message The String which contains ERROR message, if the
     *                result is false
     */
    void processFinish(boolean result, String message);
}