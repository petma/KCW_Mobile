package com.kcw_production.kcw_mobile;

/**
 * Created by airfr on 2015/8/25.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by airfr on 2015/8/24.
 */
public class TabFragment_expedition extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        return inflater.inflate(R.layout.tab_fragment_expedition,container,false);
    }
}