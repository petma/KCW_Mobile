package com.kantai_wiki.kcw_mobile.activity;

/**
 * Created by Wafer on 2015/8/25.
 *
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kantai_wiki.kcw_mobile.R;
import com.kantai_wiki.kcw_mobile.background_task.LoadTask;
import com.kantai_wiki.kcw_mobile.background_task.TaskListener;
import com.kantai_wiki.kcw_mobile.background_task.TaskTypeContract;
import com.kantai_wiki.kcw_mobile.model.Quest;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Wafer on 2015/8/24.
 *
 */
public class TabFragment_mission extends Fragment implements TaskListener{

    private RecyclerView recyclerView;
    private QuestAdapter adapter;
    private List<Quest> quests;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        /**
         *
         * init Data
         */

        quests = new ArrayList<>();
        LoadTask loadTask = new LoadTask(getActivity(), TaskTypeContract.TASK_TYPE_QUEST);
        loadTask.setTaskListener(this);
        loadTask.execute();

        View v = inflater.inflate(R.layout.tab_fragment_mission, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new QuestAdapter(getActivity());
        adapter.initData(quests);

        //set onClick
        adapter.setOnItemClickListener(new QuestAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               // Snackbar.make(getView().findViewById(R.id.main_layout), "Test", Snackbar.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onResult(List<?> list) {
        for (Object item :list) {
            quests.add((Quest) item);
        }

        //update ui
        adapter.initData(quests);
        adapter.notifyDataSetChanged();
    }
}
