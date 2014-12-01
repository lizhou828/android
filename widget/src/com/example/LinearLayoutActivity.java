package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-25
 * Time: 下午1:36
 * To change this template use File | Settings | File Templates.
 */
public class LinearLayoutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.linear_layout);
        TextView textView = (TextView)findViewById(R.id.linear_layout_text_view);
        String text = " 线性布局，这个东西，从外框上可以理解为一个div，他首先是一个一个从上往下罗列在屏幕上。" +
                "每一个LinearLayout里面又可分为垂直布局（android:orientation=\"vertical\"）和水平布局（android:orientation=\"horizontal\" ）。" +
                "当垂直布局时，每一行就只有一个元素，多个元素依次垂直往下；水平布局时，只有一行，每一个元素依次向右排列。\n" +
                "  linearLayout中有一个重要的属性 android:layout_weight=\"1\"，这个weight在垂直布局时，代表行距；水平的时候代表列宽；weight值越大就越大。\n" +
                "\n" +
                "线形布局中预览和真机中完全一样。\n" +
                "\n" +
                "TextView占一定的空间，没有赋值也有一定的宽高，要特别注意。";
        textView.setText(text);
    }
}
