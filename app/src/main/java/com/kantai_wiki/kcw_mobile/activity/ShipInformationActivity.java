package com.kantai_wiki.kcw_mobile.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kantai_wiki.kcw_mobile.R;

/**
 * Created by Jushe on 2015/8/29.
 *
 */
public class ShipInformationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ship_information);
        /** show the ships' information
         *  through the position by Intent to judge which ship it is
         *  Intent intent = getIntent()
         *  ...
         */
    }
}
