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
 * Created by Wafer on 2015/8/26.
 *
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {

    private List<String> data;
    private List<String> title;
    private LayoutInflater inflater;
    private List<Boolean> typeState;

    private final boolean CLOSE = false;
    private final boolean OPEN = true;


    // PUBLIC CONSTANT
    public static final int LAYOUT_ATTACK = 0;
    public static final int LAYOUT_EQUIPMENT = 1;
    public static final int LAYOUT_EXPEDITION = 2;
    public static final int LAYOUT_MISSION = 3;
    public static final int LAYOUT_SHIP = 4;



    private final int LAYOUT_ITEM_TITlE = 0;
    private final int LAYOUT_ITEM_LIST = 1;

    private static int MAIN_TYPE;

    //Constructor
    public DrawerAdapter(Context context, int theType) {
        inflater = LayoutInflater.from(context);
        MAIN_TYPE = theType;
    }

    //Choose type
    public void setMainType(int yourType){ MAIN_TYPE = yourType;}

    //Get the type you choose
    public int getMainType(){ return MAIN_TYPE;}

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
        if(title.indexOf(data.get(position)) >= 0)
            return LAYOUT_ITEM_TITlE;
        else
            return LAYOUT_ITEM_LIST;

    }

    @Override
    public int getItemCount(){
        return data.size();
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        DrawerViewHolder holder = null;
        //According the viewType to inflate the layout
        switch(MAIN_TYPE) {
            case LAYOUT_SHIP: {
                if (viewType == LAYOUT_ITEM_TITlE) {
                    holder = new DrawerViewHolder(inflater
                            .inflate(R.layout.ship_map_item, parent, false), viewType);
                } else {
                    holder = new DrawerViewHolder(inflater.inflate(R.layout.ship_map_item_list, parent, false), viewType);
                }
            }

            case LAYOUT_ATTACK:{
                //TODO:get the Attack layout
            }
            case LAYOUT_EQUIPMENT:{
                //TODO:get the Equipment layout
            }
            case LAYOUT_EXPEDITION:{
                //TODO:get the Expedition layout
            }
            case LAYOUT_MISSION:{
                //TODO:get the Mission layout
            }
            default:{
               //TODO:throw a error expection
            }
        }
        return holder;
    }

    @Override
    public void onBindViewHolder (DrawerViewHolder holder,final int position) {
        //According the vieType to set ViewHolder
        switch (getItemViewType(position)){
            case LAYOUT_ITEM_LIST:
                holder.shipItem.setText(data.get(position));
                break;
            case LAYOUT_ITEM_TITlE:
                holder.shipItem.setText(data.get(position));
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


    class DrawerViewHolder extends RecyclerView.ViewHolder{

        TextView shipItem;

        public DrawerViewHolder(View v, int viewType)
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
        data = new ArrayList<>();
        title = new ArrayList<>();
        typeState = new ArrayList<>();
        for(String sn: shipName){
            data.add(sn);
            title.add(sn);
        }
        //initiate the typeState
        for(int i = 0; i < title.size(); i++){
            typeState.add(CLOSE);
        }
    }

    public void addItem(String content, int position) {
        data.add(position, content);
        notifyItemInserted(position); //Attention!
        notifyItemRangeChanged(position, data.size());//Here it refresh the position
    }

    public void removeItem(String model) {
        int position = data.indexOf(model);
        data.remove(position);
        notifyItemRemoved(position);//Attention!
        notifyItemRangeChanged(position, data.size());//Here it refresh the position
    }

    public void removeAllItem(String[] data){
        for(String temp: data) {
            removeItem(temp);
        }
    }

    //add String array from the position
    public void addAllItem(String[] data, int position ){
        for(int i = position + 1, j = 0; j < data.length; i++,j++){
            addItem(data[j], i);
        }
    }

    public List<Boolean> getTypeState(){return typeState;}

    public List<String> getShipData(){
        return data;
    }

    public List<String> getShipTitle(){
        return title;
    }

    public void itemViewChoose(int position, List<String[]> allShipName) {
        int itemChoose = title.indexOf(data.get(position));
        if(itemChoose >= 0) {
            if(typeState.get(itemChoose)) {
                removeAllItem(allShipName.get(itemChoose));
                typeState.set(itemChoose, CLOSE);
            }
            else{
                addAllItem(allShipName.get(itemChoose), position);
                typeState.set(itemChoose, OPEN);
            }
        }
        else{
            //TODO start the new activity
        }
    }
}
