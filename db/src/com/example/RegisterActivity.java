package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-8
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.sqlite_register);

//        原文地址：http://www.linuxidc.com/Linux/2011-12/50343.htm


        Button button = (Button)findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,SQLiteIntroActivity.class));
            }
        });

//        final ImageView imageView = (ImageView)findViewById(R.id.marry_image);
//        final ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggle_button);
//        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                toggleButton.setChecked(isChecked);
//                imageView.setImageResource(isChecked ? R.drawable.on : R.drawable.off);
//            }
//        });
    }
}
