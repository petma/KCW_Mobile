package com.kcw_production.kcw_mobile;

import java.util.ArrayList;

/**
 * Created by Wafer on 2015/8/25.
 *
 * The MapCategory for attack map
 */
public class MapCategory {

    private String categoryName;
    private ArrayList<String> categoryItems;

    public MapCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addItem(String itemName) {
        this.categoryItems.add(itemName);
    }

    //Count for the whole items
    //The category name also count in
    public int getItemCount() {
        return categoryItems.size() + 1;
    }

    public String getItem(int position) {

        if(position == 0) {
            return categoryName;
        } else {
            return categoryItems.get(position - 1);
        }

    }
}
