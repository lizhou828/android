package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-25
 * Time: 下午5:26
 * To change this template use File | Settings | File Templates.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.login);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.login_head);

    }
}
