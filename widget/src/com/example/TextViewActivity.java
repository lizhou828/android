package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-10-29
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
public class TextViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("ViewTextActivity");
        setContentView(R.layout.text_view);
        find_and_modify_text_view();
    }
    private void find_and_modify_text_view(){
        TextView textView = (TextView)findViewById(R.id.text_view);
        CharSequence textViewOld = textView.getText();
        textView.setText("修改前是"+textViewOld+","+"\n修改为：TextView的值也是可以动态修改的。。。");
    }
}
