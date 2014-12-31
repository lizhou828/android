package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Administrator on 2014/12/30.
 */
public class SingleTaskActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.single_task);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);
    }
}
