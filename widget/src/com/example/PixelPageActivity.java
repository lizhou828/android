package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-2
 * Time: 下午1:49
 * To change this template use File | Settings | File Templates.
 */
public class PixelPageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.pixel_page);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);
        String text = "Android长度单位详解（dp、sp、px、in、pt、mm、dip）\n" +
                "\n" +
                "android中定义的dimension单位有以下这些：\n" +
                "px（Pixels ，像素）：对应屏幕上的实际像素点。\n" +
                "in（Inches ，英寸）：屏幕物理长度单位。\n" +
                "mm（Millimeters ，毫米）：屏幕物理长度单位。\n" +
                "pt（Points ，磅）：屏幕物理长度单位，1/72英寸。\n" +
                "dp（与密度无关的像素）：逻辑长度单位，在 160 dpi 屏幕上，1dp=1px=1/160英寸。随着密度变化，对应的像素数量也变化，但并没有直接的变化比例。\n" +
                "dip：与dp相同，多用于Google示例中。\n" +
                "sp（与密度和字体缩放度无关的像素）：与dp类似，但是可以根据用户的字体大小首选项进行缩放。";
        TextView textView = (TextView)findViewById(R.id.pixel_page_text_view);
        textView.setText(text);
    }
}
