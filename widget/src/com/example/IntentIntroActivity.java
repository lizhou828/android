package com.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-12
 * Time: 下午1:40
 * To change this template use File | Settings | File Templates.
 */
public class IntentIntroActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String content = "Intent(详细介绍)\n" +
                "android四大组件分别为Activity 、Service、BroadcastReceiver、ContentProvider." +
                "而Intent是Android的核心和灵魂，是各组件之间的桥梁。" +
                "而这四种组件是独立的，它们之间可以互相调用，协调工作，最终组成一个真正的Android应用。\n\n"+
                "1、启动一个特定的Activity\n" +
                "   将当前的Context,和要去的Activity作为参数传到Intent中\n" +
                "   例如：\n" +
                "   startActivity(new Intent(MyActivity.this,AndroidCorePageActivity.class));\n\n" +
                "2、启动一个未指明的Activity\n" +
                "   代码如下：\n" +
                "   startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(\"tel:135-1234-1234\")));\n" +
                "   解释：\n" +
                "   我们并没有指定那个Activity去执行，只是把我们对启动Activity的描述信息" +
                "放到Intent当中，执行startActivity后，Android系统会去寻找，到底哪个Activity" +
                "最合适，最后它根据描述信息找到处理电话的Activity,然后启动、执行\n\n" +
                "3、处理Activity的返回值\n" +
                "   类似于回调函数（操作效果类似于Ajax）\n" +
                "   startActivityForResult(intent,requestCode);" +
                "   详细代码略.\n\n\n\n" +
                "Intent的详细讲解:\n" +
                "在安卓参考文档中，对Intent的定义是执行某操作的一个抽象描述(确实很抽象)。" +
                "一般来说，一个Intent里边，对某操作的抽象描述包含以下几个部分\n" +
                "  > 对执行动作的描述：操作（Action）\n" +
                "  > 对这次动作相关联的数据进行描述：数据(data)\n" +
                "  > 对数据类型的描述：数据类型（type）\n" +
                "  > 对执行动作的附加信息进行描述：类别（category）\n" +
                "  > 其他一切附加信息的描述:附件信息（extras）\n" +
                "  > 对目标组件的描述 ：目标组件（component）";




        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(content);

        LinearLayout linearLayout  = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(textView);

        ScrollView scrollView = new ScrollView(this);
        ScrollView.LayoutParams scrollViewParams=new ScrollView.LayoutParams(ScrollView.LayoutParams.FILL_PARENT,ScrollView.LayoutParams.WRAP_CONTENT);
        scrollView.setLayoutParams(scrollViewParams);
        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }
}
