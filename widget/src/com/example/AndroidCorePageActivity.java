package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_core);
        initView();
        intentButton.setOnClickListener(this);
        intentBroadcast.setOnClickListener(this);
        intentService.setOnClickListener(this);

    }

    private void initView() {
        intentButton =(Button)findViewById(R.id.core_intent_intro);
        intentBroadcast = (Button)findViewById(R.id.core_intent_broadcast);
        intentService  = (Button)findViewById(R.id.core_intent_service);
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
            default:break;
        }
    }
}
