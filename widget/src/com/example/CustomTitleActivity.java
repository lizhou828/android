package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-1
 * Time: 上午10:00
 * Desc: Customized title in Android app
 */
public class CustomTitleActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //自定义标题栏时，需要修改标题栏的样式，但是android自身的标题栏是不支持修改样式的，
        //因此需要通过下面的方式让android支持自定义标题栏

        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        //添加这行代码后，4.0x版本需要在AndroidMainfest.xml中对应的activity添加风格样式: android:theme="xxxxx"。
        // 该样式默认定义在在/values/style.xml文件中

        setContentView(R.layout.custom_title);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);
        //注意上面的代码顺序不要改变，否则不会有效果


        String themes =
                "Android系统自带样式（android:theme)详解\n" +
                "\n" +
                "android:theme=\"@android:style/Theme.Dialog\" : Activity显示为对话框模式\n" +
                "\n" +
                "android:theme=\"@android:style/Theme.NoTitleBar\" : 不显示应用程序标题栏\n" +
                "\n" +
                "android:theme=\"@android:style/Theme.NoTitleBar.Fullscreen\" : 不显示应用程序标题栏，并全屏\n" +
                "\n" +
                "android:theme=\"Theme.Light \": 背景为白色\n" +
                "\n" +
                "android:theme=\"Theme.Light.NoTitleBar\" : 白色背景并无标题栏\n" +
                "\n" +
                "android:theme=\"Theme.Light.NoTitleBar.Fullscreen\" : 白色背景，无标题栏，全屏\n" +
                "\n" +
                "android:theme=\"Theme.Black\" : 背景黑色\n" +
                "\n" +
                "android:theme=\"Theme.Black.NoTitleBar\" : 黑色背景并无标题栏\n" +
                "\n" +
                "android:theme=\"Theme.Black.NoTitleBar.Fullscreen\" : 黑色背景，无标题栏，全屏\n" +
                "\n" +
                "android:theme=\"Theme.Wallpaper\" : 用系统桌面为应用程序背景\n" +
                "\n" +
                "android:theme=\"Theme.Wallpaper.NoTitleBar\" : 用系统桌面为应用程序背景，且无标题栏\n" +
                "\n" +
                "android:theme=\"Theme.Wallpaper.NoTitleBar.Fullscreen\" : 用系统桌面为应用程序背景，无标题栏，全屏\n" +
                "\n" +
                "android:theme=\"Theme.Translucent : 透明背景\n" +
                "\n" +
                "android:theme=\"Theme.Translucent.NoTitleBar\" : 透明背景并无标题\n" +
                "\n" +
                "android:theme=\"Theme.Translucent.NoTitleBar.Fullscreen\" : 透明背景并无标题，全屏\n" +
                "\n" +
                "android:theme=\"Theme.Panel \": 面板风格显示\n" +
                "\n" +
                "android:theme=\"Theme.Light.Panel\" : 平板风格显示\n";
        TextView textView = (TextView)findViewById(R.id.custom_title_text_view);
        textView.setText(themes);
    }
}
