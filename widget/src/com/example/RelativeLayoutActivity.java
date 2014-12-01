package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-28
 * Time: 上午11:44
 * To change this template use File | Settings | File Templates.
 */
public class RelativeLayoutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.relative_layout);
        String text = "相对布局可以理解为某一个元素为参照物，来定位的布局方式\n" +
                "android:layout_方向 = id       表示在这个id对应的控件的方向上（上|下）\n" +
                "android:layout_to方向Of = id   表示在这个控件的左或者右\n\n" +
                "android:layout_margin方向 = 像素单位 表示在这个控件的左或者右，空出相应的空间\n"+
                "android:layout_align方向 = id  表示和这个控件的（上下左右）对齐\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "eg:\n" +
                "　android:layout_below=\"@id/la1\"\n" +
                "                将当前控件放置于id为la1 的控件下方。\n" +
                "                         android:layout_alignParentRight=\"true\"\n" +
                "                使当前控件的右端和父控件的右端对齐。这里属性值只能为true或false，默认false。\n" +
                "                 android:layout_marginLeft=\"10dip\"\n" +
                "                使当前控件左边空出相应的空间。\n" +
                "                         android:layout_toLeftOf=\"@id/true\"\n" +
                "                使当前控件置于id为true的控件的左边。\n" +
                "                         android:layout_alignTop=\"@id/ok\"\n" +
                "                使当前控件与id为ok的控件上端对齐。";
        TextView textView = (TextView)findViewById( R.id.relativeTextView);
        textView.setText(text);

    }
}
