package com.kantai_wiki.kcw_mobile.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kantai_wiki.kcw_mobile.R;

import java.util.ArrayList;

/**
 * Created by Wafer on 2015/8/25.
 */
public class MapCategoryAdapter extends BaseAdapter{

    private static final int TYPE_CATEGORY_ITEM = 0;
    private static final int TYPE_ITEM = 1;

    private LayoutInflater inflater;
    private ArrayList<MapCategory> categories;

    public MapCategoryAdapter(Context context, ArrayList<MapCategory> mapCategories) {
        inflater = LayoutInflater.from(context);
        categories = mapCategories;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        int count = 0;

        if(!(categories == null)) {
            for (MapCategory category : categories) {
                count += category.getItemCount();
            }
        }

        return count;
    }


    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {

        //Exception
        if (categories == null || position < 0 || position >getCount()) {
            return null;
        }

        int categoryFirstIndex = 0;

        for(MapCategory category : categories) {
            int size = category.getItemCount();

            int categoryIndex  = position - categoryFirstIndex;

            if(categoryIndex < size) {
                return category.getItem(categoryIndex);
            }

            categoryFirstIndex += size;
        }

        return null;
    }


    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {

        //Exception
        if(categories == null || position < 0 || position > getCount()) {
            return TYPE_ITEM;
        }

        int categoryFirstIndex = 0;

        for(MapCategory category : categories) {
            int size = category.getItemCount();

            int categoryIndex = position - categoryFirstIndex;

            if(categoryIndex == 0) {
                return  TYPE_CATEGORY_ITEM;
            }

            categoryFirstIndex += size;
        }

        return TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);

        switch (itemViewType) {
            case TYPE_CATEGORY_ITEM:
                if(convertView == null) {
                    convertView = inflater.inflate(R.layout.attack_map_category,null);
                }

                TextView textView = (TextView) convertView.findViewById(R.id.attack_map_list_header);
                String headerValue = (String) getItem(position);
                textView.setText(headerValue);
                break;

            case TYPE_ITEM:
                if(convertView == null) {
                    convertView = inflater.inflate(R.layout.attack_map_item,null);
                }

                TextView itemTextView = (TextView) convertView.findViewById(R.id.attack_map_list_item);
                String itemValue = (String) getItem(position);
                itemTextView.setText(itemValue);
                break;
        }

        return convertView;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {

        boolean flag = false;

        switch (getItemViewType(position)) {
            case TYPE_CATEGORY_ITEM:
                flag = false;
                break;
            case TYPE_ITEM:
                flag = true;
                break;
        }

        return flag;
    }
}
