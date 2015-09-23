package com.kantai_wiki.kcw_mobile.background_task;

import java.util.List;

/**
 * Created by Wafer on 2015/8/31.
 *
 */


public interface TaskListener {

    /**
     * This method is a callback method,
     * you should implement this method if you want to get the result.
     * @param list This is the List you sync/load for,
     *             please cast it to which you want,
     *             care for the risk of force cast.
     */
    void onResult(List<?> list);
}
