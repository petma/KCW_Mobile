package com.kantai_wiki.kcw_mobile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/8/26.
 */
public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.ShipViewHolder> {

    private List<String> shipData;
    private LayoutInflater inflater;

    //Constructor
    public ShipAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    //The interface for OnItemClick
    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    private OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount(){
        return shipData.size();
    }

    @Override
    public ShipViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ShipViewHolder holder = new ShipViewHolder(inflater
                .inflate(R.layout.ship_map_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder (ShipViewHolder holder,final int position) {
        holder.shipItem.setText(shipData.get(position));
        if (listener != null) {
            holder.shipItem.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(v, position);
                }
            });
        }
    }

    class ShipViewHolder extends RecyclerView.ViewHolder{

        TextView shipItem;

        public ShipViewHolder(View v)
        {
            super(v);
            shipItem = (TextView) v.findViewById(R.id.ship_map_list_item);
        }
    }

    protected void iniData(String[] shipName){
        shipData = new ArrayList<String>();
        for(String sn: shipName){
            shipData.add(sn);
        }

    }
}
