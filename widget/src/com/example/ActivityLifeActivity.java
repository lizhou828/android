package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Administrator on 2015/1/15.
 */
public class ActivityLifeActivity extends Activity implements View.OnClickListener{
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_life);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);

        button1 = (Button)findViewById(R.id.activity_life_button_1);
        button1.setOnClickListener(this);

        Log.d(this.getClass().getName(),"onCreate() is running");
    }
    @Override
    public void onClick(View v) {
        Log.d(this.getClass().getName(),"onClick() is running");
        if(v != null ){
            switch (v.getId()){
                case R.id.activity_life_button_1 :
                    startActivity( new Intent(ActivityLifeActivity.this,FirstActivity.class));
                    break;
                default:break;
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(this.getClass().getName(),"onStart() is running");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(this.getClass().getName(),"onResume() is running");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(this.getClass().getName(),"onPause() is running");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(this.getClass().getName(),"onStop() is running");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(this.getClass().getName(),"onDestroy() is running");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(this.getClass().getName(),"onRestart() is running");
    }


}
