package com.kantai_wiki.kcw_mobile.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kantai_wiki.kcw_mobile.R;
import com.kantai_wiki.kcw_mobile.model.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wafer on 2015/9/24.
 *
 */
public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.QuestHolder>{

    private List<Quest> quests;
    private LayoutInflater inflater;

    public QuestAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    //OnClick Interface
    public interface OnItemClickListener {
        void onItemClick (View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //ViewHolder
    public class QuestHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public QuestHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.quest_item);
        }
    }

    @Override
    public QuestHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new QuestHolder(inflater.inflate(R.layout.quest_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final QuestHolder holder, int position) {
        holder.textView.setText(quests.get(position).getName());

        //onItemClick
        if (onItemClickListener != null) {

            holder.textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view,holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (quests != null) {
            return quests.size();
        } else {
            return  0;
        }
    }


    //update data
    public void initData(List<Quest> items) {
        quests = new ArrayList<>();
        for (Quest item : items) {
            quests.add(item);
        }
    }
}
