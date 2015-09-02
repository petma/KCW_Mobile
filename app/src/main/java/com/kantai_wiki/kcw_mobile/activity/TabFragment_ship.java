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

import java.util.List;


/**
 * Created by airfr on 2015/8/24.
 */

public  class TabFragment_ship extends Fragment {
    private RecyclerView shipRecyclerView;
    private static final int CLOSE = 0;
    private static final int OPEN = 1;
    //private LinearLayoutManager layoutManager;
    private String[] shipClass1 = {"驱逐舰", "轻巡/雷巡", "重巡/航巡", "战舰", "正规空母", "潜水舰", "其它舰艇"};
    private String[] shipClass2 = {"返回上一级", "次级分类", "次级分类", "次级分类", "次级分类"};
    private String[] shipClass3 = {"返回上一级", "三级分类", "三级分类", "三级分类", "三级分类"};
    private int[] classStatus = {0,0,0,0,0,0,0};
    private ShipAdapter shipAdapter;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle saveInstanceBundle) {
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
                Log.d("Click:", "it is " + position);
            }
        });
        return v;
    }

    public void itemViewChoose(int position) {
        switch(shipAdapter.getShipData().get(position)){
            case"驱逐舰": {
                if (classStatus[0] != OPEN) {
                    shipAdapter.addAllItem(shipClass2,position);
                    //shipAdapter.addAllItem(shipClass2, position);
                    classStatus[0] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(shipClass2);
                    classStatus[0] = CLOSE;
                }
                break;
            }
            case "轻巡/雷巡":{
                if (classStatus[1] != OPEN) {
                    shipAdapter.addAllItem(shipClass2, position);
                    //shipAdapter.addAllItem(shipClass2, position);
                    classStatus[1] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(shipClass2);
                    classStatus[1] = CLOSE;
                }
                break;
            }
            case "重巡/航巡":{
                if (classStatus[2] != OPEN) {
                    shipAdapter.addAllItem(shipClass2,position);
                   // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[2] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(shipClass2);
                    classStatus[2] = CLOSE;
                }
                break;
            }
            case "战舰":{
                if (classStatus[3] != OPEN) {
                    shipAdapter.addAllItem(shipClass2,position);
                   // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[3] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(shipClass2);
                    classStatus[3] = CLOSE;
                }
                break;
            }
            case "正规空母":{
                if (classStatus[4] != OPEN) {
                    shipAdapter.addAllItem(shipClass2,position);
                   // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[4] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(shipClass2);
                    classStatus[4] = CLOSE;
                }
                break;
            }
            case "潜水舰":{
                if (classStatus[5] != OPEN) {
                    shipAdapter.addAllItem(shipClass2,position);
                   // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[5] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(shipClass2);
                    classStatus[5] = CLOSE;
                }
                break;
            }
            case "其它舰艇":{
                if (classStatus[6] != OPEN) {
                    shipAdapter.addAllItem(shipClass2,position);
                   // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[6] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(shipClass2);
                    classStatus[6] = CLOSE;
                }
                break;
            }
            default:{
                startActivity(new Intent(getActivity(), ShipInformationActivity.class));
            }
        }
    }

}
