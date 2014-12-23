package com.example;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-17
 * Time: 下午1:28
 * To change this template use File | Settings | File Templates.
 */
public class HorizonVerticalPageActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.horizon_vertical);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);


        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            showToast("当前屏幕是横屏");
        }else if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            showToast("当前屏幕是竖屏");
        }
        Log.i("--Main--","onCreate");
        textView= (TextView)findViewById(R.id.horizon_vertical_text_view);
        String text = "Android中当屏幕横竖屏切换时，Activity的生命周期是重新加载（说明当前的Activity给销毁了，但又重新执行加载），" +
                "怎么使屏幕横竖屏切换时，当前的Activity不销毁呢？\n";
        text += "一、 在AndroidManifest.xml中为Activity设置configChanges属性\n";
        text += "configChanges有如下选项：\n" +
                "1.orientation ：屏幕在纵向和横向间旋转\n" +
                "2.keyboardHidden：键盘显示或隐藏\n" +
                "3.fontScale：用户变更了首选的字体大小 \n" +
                "4.locale ： 用户选择了不同的语言设定\n" +
                "5.keyboard ：键盘类型变更，例如手机从12键盘切换到全键盘\n" +
                "6.touchscreen或navigation：键盘或导航方式变化\n";
        text += "如果缺少了keyboardHidden选项 不能防止Activity的销毁，" +
                "并且在之后提到的onConfigurationChanged事件中 只能捕获竖屏变横屏的事件 不能捕获横屏变竖屏\n\n\n\n";
        text += "注：如果项目不需要屏幕切换时可以设置为\n" +
                "1. android:screenOrientation=\"portrait\" 始终以竖屏显示 \n" +
                "2. android:screenOrientation=\"landscape\" 始终以横屏显示\n";
        text += "上面的配置文件设置屏幕横竖屏，下面是代码去控制屏幕横竖屏的：\n";
        text +="private OnClickListener onClick=new OnClickListener() {\n" +
                "        @Override\n" +
                "        public void onClick(View v) {\n" +
                "            //设置屏幕为横屏\n" +
                "            if(v==butLandscrpe){\n" +
                "                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);\n" +
                "            //设置为置屏幕为竖屏\n" +
                "            }else{\n" +
                "                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);\n" +
                "            }\n" +
                "        }\n" +
                "    };\n" +
                "    \n" +
                "    //监听系统设置的更改\n" +
                "    @Override\n" +
                "    public void onConfigurationChanged(Configuration newConfig) {\n" +
                "        super.onConfigurationChanged(newConfig);\n" +
                "        String message=newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE ? \"屏幕设置为：横屏\" : \"屏幕设置为：竖屏\";\n" +
                "        showToast(message);\n" +
                "    }";
        text +="\n\n\n\n更多细节请参考:http://blog.csdn.net/jiangxinyu/article/details/8600407";
        textView.setText(text);

    }

    private void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG);
    }


    /**
     * 在AndroidManifest 设置了该类的的android:screenOrientation="sensor"
     * 和android:configChanges="orientation|keyboardHidden"属性后，下面这个方法可监听系统当前横竖屏状态
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("--Main--","onConfigurationChanged");
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i("--Main--","onConfigurationChanged：当前为横屏");
        }else{
            Log.i("--Main--","onConfigurationChanged：当前为竖屏");
        }

    }

}
