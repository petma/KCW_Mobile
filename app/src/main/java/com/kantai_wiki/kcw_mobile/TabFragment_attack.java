package com.kantai_wiki.kcw_mobile;

/**
 * Created by airfr on 2015/8/25.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Modified by Wafer on 2015/8/25
 *
 * The attack map fragment
 */
public class TabFragment_attack extends Fragment {

    //Test Data
    String [] mapList = {
            "1. 鎮守府海域","1-1 鎮守府正面海域", "1-2 南西諸島沖", "1-3 製油所地帯沿岸", "1-4 南西諸島防衛線", "1-5 [Extra] 鎮守府近海", "1-6 [Extra] 鎮守府近海航路",
            "2. 南西诸岛海域","2-1 カムラン半島", "2-2 バシー島沖", "2-3 東部オリョール海", "2-4 沖ノ島海域", "2-5 [Extra] 沖ノ島沖",
            "3. 北方海域","3-1 モーレイ海", "3-2 キス島沖", "3-3 アルフォンシーノ方面", "3-4 北方海域全域", "3-5 [Extra] 北方AL海域",
            "4. 西方海域","4-1 ジャム島攻略作戦", "4-2 カレー洋制圧戦", "4-3 リランカ島空襲", "4-4 カスガダマ沖海戦", "4-5 [Extra] カレー洋リランカ島沖",
            "5. 南方海域","5-1 南方海域前面", "5-2 珊瑚諸島沖", "5-3 サブ島沖海域", "5-4 サーモン海域", "5-5 [Extra] サーモン海域北方",
            "6. 中部海域","6-1 中部海域哨戒線", "6-2 MS諸島沖", "6-3 グアノ環礁沖海域"
    };

    private ArrayList<MapCategory> getData() {
        ArrayList<MapCategory> tempMapCategories = new ArrayList<>();

        for(int i = 0,j = 0;i<mapList.length;i++) {

            if(mapList[i].contains(".")) {
                MapCategory tempMapCategory = new MapCategory(mapList[i]);
                tempMapCategories.add(tempMapCategory);
                j++;
            } else {
                tempMapCategories.get(j - 1).addItem(mapList[i]);
            }

        }

        return tempMapCategories;
    }


    ListView listView;
    MapCategoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        //Data
        final ArrayList<MapCategory> listData = getData();
        adapter = new MapCategoryAdapter(getActivity(),listData);

        //View
        View v = inflater.inflate(R.layout.tab_fragment_attack, container, false);
        listView = (ListView)v.findViewById(R.id.attack_map_list);
        listView.setAdapter(adapter);

        //Click Event
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String map = (String)adapter.getItem(position);
                Toast.makeText(getActivity(),"You clicked " + map,Toast.LENGTH_SHORT).show();

                //// TODO: 2015/8/25 Start new activity to display attack map info
            }
        });

        return v;
    }
}
