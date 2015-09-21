package com.kantai_wiki.kcw_mobile.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import com.kantai_wiki.kcw_mobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mynavi();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.TabFragment_1)));
        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.TabFragment_2)));
        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.TabFragment_3)));
        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.TabFragment_4)));
        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.TabFragment_5)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void mynavi(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHeader(R.layout.navi_head)
                .withHeaderDivider(false)
                .withActionBarDrawerToggle(true)
                .withTranslucentStatusBarShadow(false)
                .withTranslucentStatusBar(false)
                .withHeaderDivider(false)
                .withStatusBarColorRes(R.color.crepusculo_kantai_main_primarydark)
                .withSliderBackgroundColorRes(R.color.md_white_1000)
                .addDrawerItems(

                        new PrimaryDrawerItem().withName(R.string.drawer_item_back).withIdentifier(1).withIcon(R.drawable.ic_back),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_settings).withIdentifier(2).withIcon(R.drawable.ic_settings),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_update).withIdentifier(3).withIcon(R.drawable.ic_loop),
                        new DividerDrawerItem().withTag("艦隊"),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_help).withIdentifier(4).withIcon(R.drawable.ic_help_outline),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_about).withIdentifier(5).withIcon(R.drawable.ic_favorite_border),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_exit).withIdentifier(6).withIcon(R.drawable.ic_exit),
                        new DividerDrawerItem().withTag("Wiki"),
                        new SwitchDrawerItem().withName(R.string.drawer_item_nightmode).withIdentifier(7)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        int id = drawerItem.getIdentifier();
                        switch (id) {
                            case 1:
                                return true;
                            case 2:
                                closeOptionsMenu();
                                return true;
                            case 3:
                            case 4:
                            case 5:
                                Snackbar.make(view, "You Click " + id + "th button", Snackbar.LENGTH_LONG).show();
                                return true;
                            case 6:
                                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                                dialog.setTitle("POI~");
                                dialog.setMessage("确定退出舰队百科？");
                                dialog.setCancelable(true);
                                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                dialog.show();
                                return true;
                            case 7:
                                return true;
                        }

                        return true;
                    }
    })
                .build();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_out_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);// 设置是否自动缩小为图标
        searchView.setSubmitButtonEnabled(true);// 设置是否显示搜索按钮
        searchView.setIconified(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String key) {
                //After you press Search/Enter control comes here with entered text in "key"
                Snackbar.make(findViewById(R.id.main_layout),"Your input \""+key+"\" for searching has already saved in key",Snackbar.LENGTH_LONG).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String key) {
                //Each time you enter/modify a charcter, control comes here with entered text in "key"
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        int i = 0;
        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings1:
                ++i;
            case R.id.action_settings2:
                ++i;
            case R.id.action_settings3:
                ++i;
            case R.id.action_settings4:
                ++i;
            case R.id.action_settings5:
                ++i;
            case R.id.action_out_search:
                ++i;
                return true;
            case R.id.action_out_share:
                ++i;
                Snackbar.make(this.findViewById(R.id.main_layout),"You Click the id " ,Snackbar.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
