package com.kantai_wiki.kcw_mobile.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kantai_wiki.kcw_mobile.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/8/26.
 */
public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.ShipViewHolder> {

    private List<String> shipData;
    private List<String> shipTitle;
    private LayoutInflater inflater;
    private  final int LAYOUT_ITEM_TITlE = 0;
    private  final int LAYOUT_ITEM_LIST = 1;
    private static int type = 0;

    //Constructor
    public ShipAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    //Choose type
    public void setType(int yourType){
        this.type = yourType;
    }

    //Get the type you choose
    public int getType(){
        return type;
    }

    //The interface for OnItemClick
    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    private OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    //Decided the ViewType that which is the title and list
    @Override
    public int getItemViewType(int position) {
        if(shipTitle.indexOf(shipData.get(position)) >= 0)
            return LAYOUT_ITEM_TITlE;
        else
            return LAYOUT_ITEM_LIST;

    }

    @Override
    public int getItemCount(){
        return shipData.size();
    }

    @Override
    public ShipViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ShipViewHolder holder;
        //According the viewType to inflate the layout
        if(viewType == LAYOUT_ITEM_TITlE) {
             holder = new ShipViewHolder(inflater
                    .inflate(R.layout.ship_map_item, parent, false), viewType);
        }
        else{
             holder = new ShipViewHolder(inflater.inflate(R.layout.ship_map_item_list,parent,false), viewType);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder (ShipViewHolder holder,final int position) {
        //According the vieType to set ViewHolder
        switch (getItemViewType(position)){
            case LAYOUT_ITEM_LIST:
                ShipViewHolder holder1 = (ShipViewHolder) holder;
                holder1.shipItem.setText(shipData.get(position));
                break;
            case LAYOUT_ITEM_TITlE:
                ShipViewHolder holder2 = (ShipViewHolder) holder;
                holder2.shipItem.setText(shipData.get(position));
                break;
        }

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

        public ShipViewHolder(View v, int viewType)
        {
            super(v);
            if(viewType == LAYOUT_ITEM_TITlE) {
                shipItem = (TextView) v.findViewById(R.id.ship_map_list_title);
            }
            else{
                shipItem = (TextView) v.findViewById(R.id.ship_map_list_item);
            }
        }

    }

    protected void iniData_Title(String[] shipName){
        shipData = new ArrayList<String>();
        shipTitle = new ArrayList<String>();
        for(String sn: shipName){
            shipData.add(sn);
            shipTitle.add(sn);
        }

    }

    public void addItem(String content, int position) {
        shipData.add(position, content);
        notifyItemInserted(position); //Attention!
        notifyItemRangeChanged(position, shipData.size());//Here it refresh the position
    }

    public void removeItem(String model) {
        int position = shipData.indexOf(model);
        shipData.remove(position);
        notifyItemRemoved(position);//Attention!
        notifyItemRangeChanged(position, shipData.size());//Here it refresh the position
    }

    public void removeAllItem(String[] data){
        for(String temp: data) {
            removeItem(temp);
        }
    }

    //add new String array from the first position
    public void addAllItem(String[] data){
        for(int position = 0; position < data.length; position++) {
            setType(LAYOUT_ITEM_LIST);
            addItem(data[position], shipData.size());
        }
    }

    //add String array from the position
    public void addAllItem(String[] data, int position ){
        for(int i = position + 1, j = 0; j < data.length; i++,j++){
            addItem(data[j], i);
        }
    }

    public List<String> getShipData(){
        return shipData;
    }

    public List<String> getShipTitle(){
        return shipTitle;
    }

}
