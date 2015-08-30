package com.kantai_wiki.kcw_mobile.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kantai_wiki.kcw_mobile.model.EquipmentEnemy;
import com.kantai_wiki.kcw_mobile.model.EquipmentKMS;
import com.kantai_wiki.kcw_mobile.model.EquipmentUpgrade;
import com.kantai_wiki.kcw_mobile.model.Expedition;
import com.kantai_wiki.kcw_mobile.model.Quest;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Wafer on 2015/8/31.
 *
 */
public class Parser {

    /**
     * The parser with GSON
     *
     */

    //Quest
    public List<Quest> praseQuest (String jsonString) {

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Quest>>(){}.getType();

        return gson.fromJson(jsonString, listType);
    }

    //Expedition
    public List<Expedition> praseExpedition (String jsonString) {
        Gson gson = new Gson();
        Type listType = new  TypeToken<List<Expedition>>(){}.getType();

        return gson.fromJson(jsonString,listType);
    }

    //EquipmentKMS
    public List<EquipmentKMS> parseEquipmentKMS (String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<EquipmentKMS>>() {}.getType();

        return gson.fromJson(jsonString,listType);
    }

    //EquipmentEnemy
    public List<EquipmentEnemy> parseEquipmentEnemy (String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<EquipmentEnemy>>() {}.getType();

        return gson.fromJson(jsonString,listType);
    }

    //EquipmentUpgrade
    public List<EquipmentUpgrade> parseEquipmentUpgrade (String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<EquipmentUpgrade>>() {}.getType();

        return gson.fromJson(jsonString,listType);
    }
}
