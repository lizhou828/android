package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Administrator on 2014/12/30.
 * 安卓中Activity的4种启动方式：
 * Standard, singletop, singletask和singleinstance
 */
public class StartMethodForActivity extends Activity implements View.OnClickListener{
    private Button standard;
    private Button singleTop;
    private Button singleTask;
    private Button singleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.start_method_for_activity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);

        initView();
    }

    private void initView() {
        standard = (Button)findViewById(R.id.standard_button);
        singleTop = (Button)findViewById(R.id.singleTop_button);
        singleTask = (Button)findViewById(R.id.singleTask_button);
        singleInstance = (Button)findViewById(R.id.singleInstance_button);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.standard_button :
                startActivity( new Intent(StartMethodForActivity.this,StandardActivity.class));
                break;
            case R.id.singleTop_button :
                startActivity( new Intent(StartMethodForActivity.this,SingleTopActivity.class));
                break;
            case R.id.singleTask_button :
                startActivity( new Intent(StartMethodForActivity.this,SingleTaskActivity.class));
                break;
            case R.id.singleInstance_button :
                startActivity( new Intent(StartMethodForActivity.this,SingleInstanceActivity.class));
                break;
            default:break;
        }
    }
}
