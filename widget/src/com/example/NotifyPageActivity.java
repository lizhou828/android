package com.example;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-17
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
public class NotifyPageActivity extends Activity{
    private Button sendButton;
    private TextView textView;
    private Button cancelButton;
    private NotificationManager notificationManager;
    private Notification notification;
    private Intent intent;
    private PendingIntent pendingIntent ;
    private static final int ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.notify_page);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);



        textView = (TextView)findViewById(R.id.notify_page_text_view);
        String text = "notification一般用在电话，短信，邮件，闹钟铃声，在手机的状态栏上就会出现一个小图标，提示用户处理这个通知，这时手从上方滑动状态栏就可以展开并处理这个快讯。已添加的Notification.Builder，使其更容易构建通知。notification是一种让你的应用程序在没有开启情况下或在后台运行警示用户。它是看不见的程序组件(Broadcast Receiver，Service和不活跃的Activity)警示用户有需要注意的事件发生的最好途径。\n" +
                "    先来区分以下状态栏和状态条的区别：\n" +
                "    1、状态条就是手机屏幕最上方的一个条形状的区域；\n" +
                "          在状态条有好多信息量：比如usb连接图标，手机信号图标，电池电量图标，时间图标等等；\n" +
                "    2、状态栏就是手从状态条滑下来的可以伸缩的view；\n" +
                "          在状态栏中一般有两类（使用FLAG_标记）：\n" +
                "          （1）正在进行的程序；\n" +
                "          （2）是通知事件；\n" +
                " ";
        text += " 快速创建一个Notification的步骤简单可以分为以下四步：\n" +
                "\t第一步：通过getSystemService（）方法得到NotificationManager对象；\n" +
                "nManager = (NotificationManager) this.getSystemService(service);  \n" +
                "\n" +
                "\n" +
                "\n";
        text += "第二步：对Notification的一些属性进行设置比如：内容，图标，标题，相应notification的动作进行处理等等；\n" +
                "notification.icon = R.drawable.ic_launcher;// 设置通知的图标  \n" +
                "notification.tickerText = tickerText; // 显示在状态栏中的文字  \n" +
                "notification.when = when; // 设置来通知时的时间  \n" +
                "notification.sound = Uri.parse(\"android.resource://com.sun.alex/raw/dida\"); // 自定义声音  \n" +
                "notification.flags = Notification.FLAG_NO_CLEAR; // 点击清除按钮时就会清除消息通知,但是点击通知栏的通知时不会消失  \n" +
                "notification.flags = Notification.FLAG_ONGOING_EVENT; // 点击清除按钮不会清除消息通知,可以用来表示在正在运行  \n" +
                "notification.flags |= Notification.FLAG_AUTO_CANCEL; // 点击清除按钮或点击通知后会自动消失  \n" +
                "notification.flags |= Notification.FLAG_INSISTENT; // 一直进行，比如音乐一直播放，知道用户响应  \n" +
                "notification.defaults = Notification.DEFAULT_SOUND; // 调用系统自带声音  \n" +
                "notification.defaults = Notification.DEFAULT_VIBRATE;// 设置默认震动  \n" +
                "notification.defaults = Notification.DEFAULT_ALL; // 设置铃声震动  \n" +
                "notification.defaults = Notification.DEFAULT_ALL; // 把所有的属性设置成默认 \n\n\n\n" +
                "第三步：通过NotificationManager对象的notify（）方法来执行一个notification的消息；\n" +
                "Java代码  收藏代码\n" +
                "nManager.notify(ID, notification);  \n" +
                "\n" +
                "\n" +
                "\n";
        text += "第四步：通过NotificationManager对象的cancel（）方法来取消一个notificatioin的消息；\n";
        textView.setText(text);

        sendButton = (Button)findViewById(R.id.notify_page_send);
        cancelButton = (Button)findViewById(R.id.notify_page_cancel);
        String service = NOTIFICATION_SERVICE;
        notificationManager = (NotificationManager)this.getSystemService(service);
        notification = new Notification();
        String tickerText = "测试Notification:主淫，这里有你想要的哦，请猛戳我!!";//通知提示
        long when = System.currentTimeMillis();//设置来通知时的时间

        notification.icon = R.drawable.icon;
        notification.tickerText = tickerText;
        notification.when = when;
        notification.sound = Uri.parse("android.resource://com.sun.alex/raw/dida");//自定义声音

        //点击清除按钮是就会清除消息通知，但是点击通知栏的通知时不会消失
        //notification.flags = Notification.FLAG_NO_CLEAR;
      //  notification.flags = Notification.FLAG_ONGOING_EVENT;
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        //Notification其他常量
        /**
         *notification.flags = Notification.FLAG_ONGOING_EVENT; // 点击清除按钮不会清除消息通知,可以用来表示在正在运行
         notification.flags |= Notification.FLAG_AUTO_CANCEL; // 点击清除按钮或点击通知后会自动消失
         notification.flags |= Notification.FLAG_INSISTENT; // 一直进行，比如音乐一直播放，直到用户响应
         */
        notification.defaults = Notification.DEFAULT_SOUND;
        
        sendButton.setOnClickListener(sendClickListener);
        cancelButton.setOnClickListener(cancelClickListener);
    }

    private View.OnClickListener sendClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //单击通知后会跳转到 NotifyPageActivity
            intent = new Intent(NotifyPageActivity.this,NotifyResultActivity.class);
            //获取pendingIntent,点击时发送改Intent
            pendingIntent = PendingIntent.getActivity(NotifyPageActivity.this,0,intent,0);
            //设置同时的标题和内容
            notification.setLatestEventInfo(NotifyPageActivity.this,"这是消息的标题","这是消息的内容",pendingIntent);
            //发出通知
            notificationManager.notify(ID,notification);
        }
    };

    private View.OnClickListener cancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //取消通知
            notificationManager.cancel(ID);
        }
    };
}
