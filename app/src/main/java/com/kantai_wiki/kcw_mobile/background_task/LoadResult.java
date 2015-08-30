package com.kantai_wiki.kcw_mobile.background_task;

import java.util.List;

/**
 * Created by Wafer on 2015/8/31.
 *
 */
public interface LoadResult {

    /**
     * The method getLoadResult is used to get the loading result
     *
     * @param list The list contains data that you loading.
     *             Please cast to the List which you are determine
     *             to use
     */

    void getLoadResult(List<?> list);
}
