package com.kantai_wiki.kcw_mobile.background_task;

import android.content.Context;
import android.os.AsyncTask;

import com.kantai_wiki.kcw_mobile.db.KCWDB;
import com.kantai_wiki.kcw_mobile.model.EquipmentEnemy;
import com.kantai_wiki.kcw_mobile.model.EquipmentKMS;
import com.kantai_wiki.kcw_mobile.model.EquipmentUpgrade;
import com.kantai_wiki.kcw_mobile.model.Expedition;
import com.kantai_wiki.kcw_mobile.model.Quest;
import com.kantai_wiki.kcw_mobile.util.HTTPUtils;
import com.kantai_wiki.kcw_mobile.util.Parser;

import java.io.IOException;
import java.util.List;

/**
 * Created by Wafer on 2015/8/31.
 *
 */
public class SyncTask extends AsyncTask<String, Void, Boolean>{

    Context context;
    final int syncType;

    /**
     * The SyncTask extends AsyncTask
     * Use it to sync data from server
     * @param context The context that you current running
     * @param syncType Please indicate the syncType,
     *                 The Type is contained at SyncTypeContract Class
     */

    public SyncTask(Context context,int syncType) {
        super();
        this.context = context;
        this.syncType = syncType;
    }

    @Override
    protected Boolean doInBackground(String... urls) {
        KCWDB kcwdb = KCWDB.getInstance(context);
        try {
            String response = HTTPUtils.download(urls[0]);
            switch (syncType) {
                case SyncTypeContract.SYNC_TYPE_QUEST :
                    List<Quest> questList;
                    questList = Parser.praseQuest(response);
                    kcwdb.syncQuest(questList);
                    break;

                case SyncTypeContract.SYNC_TYPE_EXPEDITION:
                    List<Expedition> expeditionList;
                    expeditionList = Parser.praseExpedition(response);
                    kcwdb.syncExpedition(expeditionList);
                    break;

                case SyncTypeContract.SYNC_TYPE_EQUIPMENT_KMS:
                    List<EquipmentKMS> equipmentKMSList;
                    equipmentKMSList = Parser.parseEquipmentKMS(response);
                    kcwdb.EquipmentKMS(equipmentKMSList);
                    break;

                case SyncTypeContract.SYNC_TYPE_EQUIPMENT_ENEMY:
                    List<EquipmentEnemy> equipmentEnemyList;
                    equipmentEnemyList = Parser.parseEquipmentEnemy(response);
                    kcwdb.syncEquipmentEnemy(equipmentEnemyList);
                    break;

                case SyncTypeContract.SYNC_TYPE_EQUIPMENT_UPGRADE:
                    List<EquipmentUpgrade> equipmentUpgradeList;
                    equipmentUpgradeList = Parser.parseEquipmentUpgrade(response);
                    kcwdb.syncEquipmentUpgrade(equipmentUpgradeList);
                    break;

                default:throw new IOException();
            }
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }
}
