package com.kcw_production.kcw_mobile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
/**
 * Created by airfr on 2015/8/25.
 */


public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment_1 tab1 = new TabFragment_1();
                return tab1;
            case 1:
                TabFragment_2 tab2 = new TabFragment_2();
                return tab2;
            case 2:
                TabFragment_3 tab3 = new TabFragment_3();
                return tab3;
            case 3:
                TabFragment_4 tab4 = new TabFragment_4();
                return tab4;
            case 4:
                TabFragment_5 tab5 = new TabFragment_5();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
