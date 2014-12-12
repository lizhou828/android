package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-12
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
public class IntentBroadcastActivity extends Activity implements View.OnClickListener {
    private TextView textView;
    private Button getSmsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_broadcast);

        initView();

        String text = "利用Intent来广播BroadCast事件：\n" +
                "Intent的作用不仅仅是用来启动一个新的Activity,还有个重要的机制：就是作为不同进程间 传递数据和事件的 媒介\n" +
                "应用场景：\n" +
                "   例如，在电池电量、网络连接发生变化或者来电、来短信的时候，" +
                "Android系统都会讲相关的Intent进行广播。如果自己的app注册了针对这些事件的" +
                "BroadCast Receiver,那么就可以处理这些事件，也可以获取保存在改intent里面的数据\n\n" +
                "一、主动发送广播\n" +
                "   比较简单，代码如下\n" +
                "   Intent intent = new Intent(\"com.example.xxx.NEW_BROAD_CAST\");\n" +
                "   intent.putExtra(\"data1\",\"someData1\");\n" +
                "   intent.putExtra(\"data2\",\"someData2\");\n" +
                "   sendBroadcast(intent);\n\n\n\n" +
                "二、接收广播（BroadCast Receiver)\n" +
                "   不管是系统广播的Intent还是其他程序广播的Intent,如果想接收并且对它处理的话需要注册一个" +
                "BroadCast Receiver，并且一般的要给注册的这个BraodCast Receiver设置一个Intent Filter" +
                "来指定当前的BroadCast Receiver是对哪些Intent进行监听的\n" +
                "1、extends BroadCastReceiver ,override onReceiver()\n" +
                "   onReceiver方法里面最好不要有执行超过5s的代码，否则android弹出系统超时" +
                "需要注意的是，我们自己新建的BroadCastReceiver并非一直在后台运行，而是当事件或相关的" +
                "intent来临时才会被系统调用。\n" +
                "2、注册BroadCastReceiver\n" +
                "   register your BroadCastReceiver in AndroidManifest.xml or using Java code\n" +
                "3、注销BroadCastReceiver\n" +
                "   unregisterReceiver(broadcastReceiver);\n";
            textView.setText(text);

            getSmsButton.setOnClickListener(this);
    }

    private void initView() {
        textView = (TextView)findViewById(R.id.intent_broadcast_text);
        getSmsButton =(Button)findViewById(R.id.get_sms_button);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.get_sms_button :
                startActivity(new Intent(IntentBroadcastActivity.this,SMSReceiveActivity.class));
                break;
            default:break;
        }
    }
}
