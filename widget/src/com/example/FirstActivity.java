package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Administrator on 2015/1/16.
 */
public class FirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.first_activity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);
        Log.d(this.getClass().getName(), "onCreate() is running");

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
