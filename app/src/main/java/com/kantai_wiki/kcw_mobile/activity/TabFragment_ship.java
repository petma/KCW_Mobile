package com.kantai_wiki.kcw_mobile.activity;

/**
 * Created by airfr on 2015/8/25.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kantai_wiki.kcw_mobile.R;


/**
 * Created by airfr on 2015/8/24.
 */

public  class TabFragment_ship extends Fragment{
    private RecyclerView shipRecyclerView;
    //private LinearLayoutManager layoutManager;
    private String[] shipClass1 = {"驱逐舰","轻巡/雷巡","重巡/航巡","战舰","正规空母","潜水舰","其它舰艇"};
    private String[] shipClass2 ={"返回上一级","次级分类","次级分类","次级分类","次级分类"};
    private String[] shipClass3 ={"返回上一级","三级分类","三级分类","三级分类","三级分类"};
    private int classKey = 1;
    private ShipAdapter shipAdapter;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container,Bundle saveInstanceBundle){
        View v = layoutInflater.inflate(R.layout.tab_fragment_ship, container, false);
        shipAdapter = new ShipAdapter(getActivity());
        shipAdapter.iniData(shipClass1);
        shipRecyclerView = (RecyclerView) v.findViewById(R.id.ship_map_list);
        shipRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        shipRecyclerView.setAdapter(shipAdapter);
        //Click
        shipAdapter.setOnItemClickListener(new ShipAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                itemViewChoose(position);
            }
        });
        return v;
    }

    public void itemViewChoose(int position) {
        if (position == 0) {
            if (classKey == 1) {
                shipAdapter.removeAllItem(shipClass1);
                shipAdapter.addAllItem(shipClass2);
                Log.d("position = 0", "classKey = " + classKey);
                classKey++;
            } else if(classKey == 2){
                shipAdapter.removeAllItem(shipClass2);
                shipAdapter.addAllItem(shipClass1);
                Log.d("position = 0", "classKey = " + classKey);
                classKey--;
            } else if(classKey == 3){
                shipAdapter.removeAllItem(shipClass3);
                shipAdapter.addAllItem(shipClass2);
                Log.d("position = 0", "classKey = " + classKey);
                classKey--;
            }
        }
        else
        {
            if(classKey == 1) {
                shipAdapter.removeAllItem(shipClass1);
                shipAdapter.addAllItem(shipClass2);
                Log.d("classKey", "classKey = " + classKey);
                classKey++;
            }else if(classKey == 2){
                shipAdapter.removeAllItem(shipClass2);
                shipAdapter.addAllItem(shipClass3);
                Log.d("classKey", "classKey = " + classKey);
                classKey++;
            }else if(classKey == 3){
                Log.d("classKey","classKey = " + classKey);
                Intent intent = new Intent(getActivity(), ShipInformationActivity.class);
                intent.putExtra("position",position);//use position to judge load which ship
                startActivity(intent);
            }
        }
    }
}
