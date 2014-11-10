package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-10-30
 * Time: 上午10:27
 * To change this template use File | Settings | File Templates.
 */
public class CheckBoxActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CheckBoxActivity");
        setContentView(R.layout.check_box);

        Button getCheckBoxValueButton= (Button)findViewById(R.id.get_check_box_value_button);
        final CheckBox plainCB = (CheckBox) findViewById(R.id.plain_cb);
        final CheckBox serifCB = (CheckBox) findViewById(R.id.serif_cb);
        final CheckBox boldCB = (CheckBox) findViewById(R.id.bold_cb);
        final CheckBox italicCB = (CheckBox) findViewById(R.id.italic_cb);
        getCheckBoxValueButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "";
                if(plainCB.isChecked()){
                    text +=","+plainCB.getText();
                }
                if(serifCB.isChecked()){
                    text +=","+serifCB.getText();
                }
                if(boldCB.isChecked()){
                    text +=","+boldCB.getText();
                }
                if(italicCB.isChecked()){
                    text +=","+italicCB.getText();
                }
                setTitle("CheckBox:"+text);
            };
        });
    }
}
