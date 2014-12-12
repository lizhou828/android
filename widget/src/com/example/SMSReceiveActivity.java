package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-12
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
public class SMSReceiveActivity extends Activity {
    private TextView textView;
    private SMSBroadCastReceiver smsBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        init();
    }

    private void init() {
        textView = (TextView)findViewById(R.id.textView);
        smsBroadCastReceiver = new SMSBroadCastReceiver();
        smsBroadCastReceiver.setMessageListener(new SMSBroadCastReceiver.MessageListener() {
            @Override
            public void onReceived(String message) {
                textView.setText(message);
            }
        });
    }
}
