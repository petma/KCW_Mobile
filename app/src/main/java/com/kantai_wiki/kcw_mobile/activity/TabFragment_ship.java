package com.kantai_wiki.kcw_mobile.activity;

/**
 * Created by airfr on 2015/8/25.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private String[] shipName = {"长门", "长门改","陆奥", "陆奥改"};
    private ShipAdapter shipAdapter;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container,Bundle saveInstanceBundle){
        View v = layoutInflater.inflate(R.layout.tab_fragment_ship, container, false);
        shipAdapter = new ShipAdapter(getActivity());
        shipAdapter.iniData(shipName);
        shipRecyclerView = (RecyclerView) v.findViewById(R.id.ship_map_list);
        shipRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        shipRecyclerView.setAdapter(shipAdapter);
        //OnItemClick
        shipAdapter.setOnItemClickListener(new ShipAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(getActivity(),"You Click " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ShipInformationActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        return v;
    }
}
