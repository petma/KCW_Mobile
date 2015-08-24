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
                TabFragment_attact tab1 = new TabFragment_attact();
                return tab1;
            case 1:
                TabFragment_expedition tab2 = new TabFragment_expedition();
                return tab2;
            case 2:
                TabFragment_ship tab3 = new TabFragment_ship();
                return tab3;
            case 3:
                TabFragment_equipment tab4 = new TabFragment_equipment();
                return tab4;
            case 4:
                TabFragment_mission tab5 = new TabFragment_mission();
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
