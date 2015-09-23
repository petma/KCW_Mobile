package com.kantai_wiki.kcw_mobile.activity;

/**
 * Created by airfr on 2015/8/25.
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.kantai_wiki.kcw_mobile.R;

import java.util.List;


/**
 * Created by airfr on 2015/8/24.
 */

public  class TabFragment_ship extends Fragment {
    private static final int CLOSE = 0;
    private static final int OPEN = 1;
    /**
     *  Here are the ship class and their name
     */
    private String[] shipType = {"驱逐舰", "轻巡/雷巡", "重巡/航巡", "战舰", "正规空母", "轻母/水母", "潜水舰", "其它舰艇"};
    private String[] DD = {"睦月", "如月", "弥生", "卯月", "皋月", "文月", "长月", "菊月", "三日月", "望月"
            ,"吹雪", "白雪", "初雪", "深雪", "从云", "矶波", "绫波", "敷波"
            ,"胧", "曙", "涟", "潮", "晓", "响", "雷", "电","初春", "子日", "若叶", "初霜"
            ,"白露", "时雨", "村雨", "夕立", "春雨", "五月雨", "海风", "江风", "凉风"
            ,"朝潮", "大潮", "满潮", "荒潮"
            ,"朝云", "山云", "霰", "霞", "阳炎", "不知火", "黑潮", "初风", "雪风", "天津风", "时津风", "浦风", "叽风"
            ,"滨风", "谷风", "野分", "秋云", "秋月", "照月", "岛风", "Z1", "Z3", "利伯齐奥"
            , "夕云", "卷云", "风云", "长波", "高波", "朝霜", "早霜", "清霜"};
    private String[] CL = {"天龙", "龙田", "球磨", "多摩", "北上", "大井", "木曾", "长良", "五十铃"
            ,"名取", "由良", "鬼怒", "阿武隈", "川内", "神通", "那珂", "夕张"
            ,"阿贺野", "能代", "矢矧", "酒匂", "大淀" };
    private String[] CA = {"古鹰", "加古", "青叶", "衣笠", "妙高", "那智", "足柄", "羽黑", "高雄"
            ,"爱宕", "摩耶", "鸟海", "最上", "三隈", "铃谷", "熊野", "利根", "筑摩"
            ,"欧根亲王"};
    private String[] BB = {"金刚", "比叡", "榛名", "雾岛", "扶桑", "山城"
            ,"伊势", "日向", "长门", "陆奥", "大和", "武藏"
            ,"俾斯麦", "维托里奥", "罗马"};
    private String[] CV = {"赤城", "加贺", "苍龙", "飞龙", "翔鹤", "瑞鹤"
            ,"云龙", "天成", "葛城", "大凤"};
    private String[] SS = {"伊168", "伊8", "伊19", "伊58", "吕500", "丸输", "U-511", "伊401"};
    private String[] CVL ={"瑞穗", "秋津洲", "凤翔", "龙骧", "龙凤"
            ,"翔凤", "瑞凤", "飞鹰", "隼鹰", "千岁", "千代田"};
    private String[] OS = {"大鲸"};
    /******************* ships' name end here ************************/

    private int[] classStatus = {0,0,0,0,0,0,0,0};
    private ShipAdapter shipAdapter;
    private RecyclerView shipRecyclerView;
    private LinearLayoutManager shipLM;

    //StickTitle
    private CardView stickTitle;
    private TextView stickTitle_text;
    private RelativeLayout.LayoutParams stickTitleLayoutParams;
    private int y = 30;
    private boolean scrollKey;
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle saveInstanceBundle) {
        View v = layoutInflater.inflate(R.layout.tab_fragment_ship, container, false);
        //StickTitle
        stickTitle = (CardView) v.findViewById(R.id.ship_map_list_Sticktitle);
        stickTitle.setVisibility(View.GONE);
        stickTitle_text = (TextView) v.findViewById(R.id.ship_map_list_Sticktitle_text);
        //ShipAdapter
        shipAdapter = new ShipAdapter(getActivity());
        shipAdapter.iniData_Title(shipType);
        shipLM = new LinearLayoutManager(getActivity());
        shipRecyclerView = (RecyclerView) v.findViewById(R.id.ship_map_list);
        shipRecyclerView.setLayoutManager(shipLM);
        shipRecyclerView.setAdapter(shipAdapter);
        //Click
        shipAdapter.setOnItemClickListener(new ShipAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                itemViewChoose(position);
                Log.d("Click:", "it is " + position);
            }
        });

        shipRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int firstVisibleCompletelyPosition = shipLM.findFirstCompletelyVisibleItemPosition();
                int firstVisiblePosition = shipLM.findFirstVisibleItemPosition();
                int firstInVisibleTitle;
                if (dy > 0) {
                    if (shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstVisibleCompletelyPosition)) < 0) {
                        for (firstInVisibleTitle = firstVisibleCompletelyPosition;
                             shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstInVisibleTitle)) < 0;
                             firstInVisibleTitle--)
                            ;// find the last title position
                        /**init the stickTitle location**/
                        stickTitleLayoutParams = (RelativeLayout.LayoutParams) stickTitle.getLayoutParams();
                        stickTitleLayoutParams.setMargins(5, 0, 5, 0);
                        stickTitle.setLayoutParams(stickTitleLayoutParams);
                        /********************************/
                        y = 0;
                        scrollKey = false;
                        stickTitle.setVisibility(View.VISIBLE);
                        stickTitle_text.setText(shipAdapter.getShipData().get(firstInVisibleTitle));
                    } else if (shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstVisibleCompletelyPosition)) >= 0) {
                        y += dy;
                        //scroll delay
                        if (y >= 15 && scrollKey == false) {
                            scrollKey = true;
                            y = 0;
                        }
                        // start to scroll
                        if (scrollKey == true) {
                            stickTitleLayoutParams = (RelativeLayout.LayoutParams) stickTitle.getLayoutParams();
                            stickTitleLayoutParams.setMargins(5, -y, 5, 0);
                            stickTitle.setLayoutParams(stickTitleLayoutParams);
                        }
                    } else {
                        stickTitle.setVisibility(View.GONE);
                    }
                } else if (dy < 0) {
                    if (shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstVisibleCompletelyPosition)) >= 0
                            && shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstVisiblePosition)) < 0) {
                        if (firstVisibleCompletelyPosition != 0) {
                            for (firstInVisibleTitle = firstVisibleCompletelyPosition - 1;
                                 shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstInVisibleTitle)) < 0;
                                 firstInVisibleTitle--)
                                ;
                            if (classStatus[shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstInVisibleTitle))] == OPEN && scrollKey == false) {
                                /**init the stickTitle location***/
                                stickTitleLayoutParams = (RelativeLayout.LayoutParams) stickTitle.getLayoutParams();
                                stickTitleLayoutParams.setMargins(5, -50, 5, 0);
                                stickTitle.setVisibility(View.VISIBLE);
                                stickTitle.setLayoutParams(stickTitleLayoutParams);
                                scrollKey = true;
                                y = 50;
                                /********************************/
                            } else if (classStatus[shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstInVisibleTitle))] == OPEN && scrollKey == true) {
                                if (y > 0) {
                                    y += dy;
                                }
                                if (y <= 0){
                                    y = 0;
                                }
                                stickTitle_text.setText(shipAdapter.getShipData().get(firstInVisibleTitle));
                                //Scroll
                                stickTitleLayoutParams = (RelativeLayout.LayoutParams) stickTitle.getLayoutParams();
                                stickTitleLayoutParams.setMargins(5, -y, 5, 0);
                                stickTitle.setLayoutParams(stickTitleLayoutParams);
                            }
                        }
                    } else if (shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstVisibleCompletelyPosition)) >= 0) {
                        stickTitle.setVisibility(View.GONE);
                        scrollKey = false;
                    }
                    else{
                        for (firstInVisibleTitle = firstVisibleCompletelyPosition;
                             shipAdapter.getShipTitle().indexOf(shipAdapter.getShipData().get(firstInVisibleTitle)) < 0;
                             firstInVisibleTitle--)
                            ;
                        stickTitleLayoutParams = (RelativeLayout.LayoutParams) stickTitle.getLayoutParams();
                        stickTitleLayoutParams.setMargins(5, 0, 5, 0);
                        stickTitle.setLayoutParams(stickTitleLayoutParams);
                        stickTitle_text.setText(shipAdapter.getShipData().get(firstInVisibleTitle));
                    }
                }

            }
        });
        stickTitle_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = shipAdapter.getShipData().indexOf(stickTitle_text.getText());
                shipLM.scrollToPosition(position);
                Log.d("stickTitle", "Click");
                stickTitle.setVisibility(View.GONE);
                itemViewChoose(position);
            }
        });
        return v;
    }


    public void itemViewChoose(int position) {
        switch(shipAdapter.getShipData().get(position)){
            case"驱逐舰": {
                if (classStatus[0] != OPEN) {
                    shipAdapter.addAllItem(DD,position);
                    //shipAdapter.addAllItem(shipClass2, position);
                    classStatus[0] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(DD);
                    classStatus[0] = CLOSE;
                }
                break;
            }
            case "轻巡/雷巡":{
                if (classStatus[1] != OPEN) {
                    shipAdapter.addAllItem(CL, position);
                    //shipAdapter.addAllItem(shipClass2, position);
                    classStatus[1] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(CL);
                    classStatus[1] = CLOSE;
                }
                break;
            }
            case "重巡/航巡":{
                if (classStatus[2] != OPEN) {
                    shipAdapter.addAllItem(CA,position);
                    // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[2] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(CA);
                    classStatus[2] = CLOSE;
                }
                break;
            }
            case "战舰":{
                if (classStatus[3] != OPEN) {
                    shipAdapter.addAllItem(BB,position);
                    // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[3] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(BB);
                    classStatus[3] = CLOSE;
                }
                break;
            }
            case "正规空母":{
                if (classStatus[4] != OPEN) {
                    shipAdapter.addAllItem(CV,position);
                    // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[4] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(CV);
                    classStatus[4] = CLOSE;
                }
                break;
            }
            case "轻母/水母":{
                if (classStatus[5] != OPEN) {
                    shipAdapter.addAllItem(CVL,position);
                    // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[5] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(CVL);
                    classStatus[5] = CLOSE;
                }
                break;
            }
            case "潜水舰":{
                if (classStatus[6] != OPEN) {
                    shipAdapter.addAllItem(SS,position);
                    // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[6] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(SS);
                    classStatus[6] = CLOSE;
                }
                break;
            }
            case "其它舰艇":{
                if (classStatus[7] != OPEN) {
                    shipAdapter.addAllItem(OS,position);
                    // shipAdapter.addAllItem(shipClass2, position);
                    classStatus[7] = OPEN;
                }
                else{
                    shipAdapter.removeAllItem(OS);
                    classStatus[7] = CLOSE;
                }
                break;
            }
            default:{
                startActivity(new Intent(getActivity(), ShipInformationActivity.class));
            }
        }
    }
}
