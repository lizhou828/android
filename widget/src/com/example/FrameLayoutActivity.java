package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-27
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
public class FrameLayoutActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.frame_layout);
        TextView textView = (TextView)findViewById(R.id.frame_layout_text_view);
        String text="   FrameLayout是最简单的一个布局对象。\n" +
                "它被定制为你屏幕上的一个空白备用区域，之后你可以在其中填充一个单一对象\n" +
                " 比如，一张你要发布的图片。" +
                "\n所有的子元素将会固定在屏幕的左上角；你不能为FrameLayout中的一个子元素指定一个位置。" +
                "\n后一个子元素将会直接在前一个子元素之上进行覆盖填充，把它们部份或全部挡住（除非后一个子元素是透明的）。    ";
        textView.setText(text);
    }
}
