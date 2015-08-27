package com.kantai_wiki.kcw_mobile.activity;

/**
 * Created by airfr on 2015/8/25.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kantai_wiki.kcw_mobile.R;


/**
 * Created by airfr on 2015/8/24.
 */
public class TabFragment_mission extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        return inflater.inflate(R.layout.tab_fragment_mission,container,false);
    }
}
