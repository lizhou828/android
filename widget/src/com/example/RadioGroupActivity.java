package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-10-30
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public class RadioGroupActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_group);

        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.menu);
        Button clearButton = (Button)findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.clearCheck();
            }
        });
    }
}
