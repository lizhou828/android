package com.example;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-2
 * Time: 上午9:51
 * To change this template use File | Settings | File Templates.
 */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    private TabHost mTabHost;
    private Intent mAIntent;
    private Intent mBIntent;
    private Intent mCIntent;
    private Intent mDIntent;
    private Intent mEIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_tab);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);


        this.mAIntent = new Intent(this,AActivity.class);
        this.mBIntent = new Intent(this,BActivity.class);
        this.mCIntent = new Intent(this,CActivity.class);
        this.mDIntent = new Intent(this,DActivity.class);
        this.mEIntent = new Intent(this,EActivity.class);

        ((RadioButton) findViewById(R.id.radio_button0))
                .setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button1))
                .setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button2))
                .setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button3))
                .setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button4))
                .setOnCheckedChangeListener(this);

        setupIntent();

    }

    private void setupIntent() {
        this.mTabHost = getTabHost();
        TabHost localTabHost = this.mTabHost;
        localTabHost.addTab(buildTabSpec("A_TAB",R.string.main_home,R.drawable.icon_1_n,this.mAIntent));
        localTabHost.addTab(buildTabSpec("B_TAB",R.string.main_news,R.drawable.icon_2_n,this.mBIntent));
        localTabHost.addTab(buildTabSpec("C_TAB",R.string.main_manage_date,R.drawable.icon_3_n,this.mCIntent));
        localTabHost.addTab(buildTabSpec("D_TAB",R.string.main_friends,R.drawable.icon_4_n,this.mDIntent));
        localTabHost.addTab(buildTabSpec("MORE_TAB",R.string.more,R.drawable.icon_5_n,this.mEIntent));
    }

    private TabHost.TabSpec buildTabSpec(String tag, int tab_name, int icon, Intent intent) {
        return this.mTabHost.newTabSpec(tag).setIndicator(  getString(tab_name),getResources().getDrawable(icon)  ).setContent(intent);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            switch (buttonView.getId()){
                case R.id.radio_button0 :
                    this.mTabHost.setCurrentTabByTag("A_TAB");
                    break;
                case R.id.radio_button1 :
                    this.mTabHost.setCurrentTabByTag("B_TAB");
                    break;
                case R.id.radio_button2 :
                    this.mTabHost.setCurrentTabByTag("C_TAB");
                    break;
                case R.id.radio_button3 :
                    this.mTabHost.setCurrentTabByTag("D_TAB");
                    break;
                case R.id.radio_button4 :
                    this.mTabHost.setCurrentTabByTag("MORE_TAB");
                    break;

            }
        }

    }
}
