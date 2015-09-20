package com.kantai_wiki.kcw_mobile.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.kantai_wiki.kcw_mobile.R;

/**
 * Created by airfr on 2015/9/20.
 */
public class SearchImpl extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_search);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            TextView v = (TextView)this.findViewById(R.id.message);
            v.setText(query);
        }
    }
}
