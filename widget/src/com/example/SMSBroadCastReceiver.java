package com.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-12
 * Time: 下午4:06
 *
 * 配置广播接收者
 <receiver android:name=".SMSBroadCastReceiver">
     此处android:priority="1000",表示此广播接收这的级别为最高
     <intent-filter android:priority="1000">
        <action android:name="android.provider.Telephony.SMS_RECEIVED"/>
     </intent-filter>
 </receiver>
 */


public class SMSBroadCastReceiver extends BroadcastReceiver {
    private static MessageListener messageListener;

    public SMSBroadCastReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        /**
         SmsMessage的数据结构
          _id => 短消息序号 如100
         thread_id => 对话的序号 如100
         address => 发件人地址，手机号.如+8613811810000
         person => 发件人，返回一个数字就是联系人列表里的序号，陌生人为null
         date => 日期  long型。如1256539465022
         protocol => 协议 0 SMS_RPOTO, 1 MMS_PROTO
         read => 是否阅读 0未读， 1已读
         status => 状态 -1接收，0 complete, 64 pending, 128 failed
         type => 类型 1是接收到的，2是已发出
         body => 短消息内容
         service_center => 短信服务中心号码编号。如+8613800755500
         */
        Object[] pdus =(Object[])intent.getExtras().get("pdus");
        for( Object pdu : pdus ){
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])pdu);
            String sender = smsMessage.getDisplayOriginatingAddress();
            String content = smsMessage.getMessageBody();
            long date = smsMessage.getTimestampMillis();
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(date));
            Log.i("SmsMessage from:",sender);
            Log.i("SmsMessage content:",content);
            Log.i("SmsMessage time :",time);
            if("5555".equals(sender) ){
                Log.i("SmsMessage :","abort");
                abortBroadcast();
            }
        }
    }
    public interface MessageListener{
        public void onReceived(String message);
    }

    public  void setMessageListener(MessageListener messageListener) {
        SMSBroadCastReceiver.messageListener = messageListener;
    }
}
