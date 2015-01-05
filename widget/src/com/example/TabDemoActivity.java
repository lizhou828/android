package com.example;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-10
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class TabDemoActivity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("tab标签介绍");
        TabHost tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.tab_demo,tabHost.getTabContentView(),true);

        tabHost.addTab( tabHost.newTabSpec("tab1").setIndicator("tab1").setContent(R.id.tab_view_1) );
        tabHost.addTab( tabHost.newTabSpec("tab2").setIndicator("tab2").setContent(R.id.tab_view_2) );
        tabHost.addTab( tabHost.newTabSpec("tab3").setIndicator("tab3").setContent(R.id.tab_view_3) );
        tabHost.addTab( tabHost.newTabSpec("tab4").setIndicator("tab4").setContent(R.id.tab_view_4) );
        tabHost.addTab( tabHost.newTabSpec("tab5").setIndicator("tab5").setContent(R.id.tab_view_5) );
        tabHost.setCurrentTab(R.id.tab_view_1);


    }
}
