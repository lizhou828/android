package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-12
 * Time: 下午1:26
 * To change this template use File | Settings | File Templates.
 */
public class AndroidCorePageActivity extends Activity implements View.OnClickListener {
    private Button intentButton;
    private Button intentBroadcast;
    private Button intentService;
    private Button startMethodForActivity;
    private Button activityLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.android_core);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);

        initView();
        intentButton.setOnClickListener(this);
        intentBroadcast.setOnClickListener(this);
        intentService.setOnClickListener(this);
        startMethodForActivity.setOnClickListener(this);
        activityLife.setOnClickListener(this);
    }

    private void initView() {
        intentButton =(Button)findViewById(R.id.core_intent_intro);
        intentBroadcast = (Button)findViewById(R.id.core_intent_broadcast);
        intentService  = (Button)findViewById(R.id.core_intent_service);
        startMethodForActivity = (Button)findViewById(R.id.start_methods_for_activity_button);
        activityLife = (Button)findViewById(R.id.activity_life_button);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.core_intent_intro :
                startActivity( new Intent(AndroidCorePageActivity.this,IntentIntroActivity.class) );
                break;
            case R.id.core_intent_broadcast :
                startActivity( new Intent(AndroidCorePageActivity.this , IntentBroadcastActivity.class));
                break;
            case R.id.core_intent_service :
                startActivity( new Intent(AndroidCorePageActivity.this,MusicServiceActivity.class) );
                break;
            case R.id.start_methods_for_activity_button :
                startActivity( new Intent(AndroidCorePageActivity.this,StartMethodForActivity.class) );
                break;
            case R.id.activity_life_button :
                startActivity( new Intent(AndroidCorePageActivity.this,ActivityLifeActivity.class));
                break;
            default:break;
        }
    }
}
