package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-28
 * Time: 下午2:11
 * To change this template use File | Settings | File Templates.
 */
public class AbsoluteLayoutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.absolute_layout);
        setTitle("绝对布局（坐标布局）：对其控件进行直接定位，增加灵活性。");
        String text = "AbsoluteLayout这个布局方式很简单，主要属性就是layout_x和layout_y分别定义这个组件的绝对位置.\n" +
                "即，以屏幕左上角为（0,0）的坐标轴x,y值。 当向下或上有移动时，坐标值将变大。\n" +
                "AbsoluteLayout没有页边框，允许元素之间相互重叠（尽管不推荐)。\n" +
                "通常不推荐使用AbsoluteLayout，除非你有正当理由要使用它。\n" +
                "因为它使界面代码太过刚醒，以至于在不同的设备上可能不能很好地工作\n\n" +
                "常用属性：android:layout_x,android:layout_y";
        TextView textView = (TextView)findViewById(R.id.absolute_text_view);
        textView.setText(text);
    }
}
