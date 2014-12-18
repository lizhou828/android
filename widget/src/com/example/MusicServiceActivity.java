package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-18
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class MusicServiceActivity extends Activity implements View.OnClickListener {
    private TextView textView;
    private Button musicStartButton;
    private Button musicStopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_demo_music);
        initView();
        String text="Service\n\n" +
                "1、简介：\n" +
                "   在安卓中的Service,可以理解为后台服务，类似于Windows的服务。" +
                "它与Activity的级别差不多，但是不能自己运行。需要通过某个Activity或其他" +
                "context对象来调用，如：this.startService(intent);this.bindService()。" +
                "   如果在service的onCreate()或onStart()中，做一些很耗时的动作" +
                "最好是启动一个新线程来运行这个service.因为，如果service是运行在主线程中，" +
                "会影响到程序的UI操作或者阻塞主线程的其他事情\n" +
                "2、应用场景:\n" +
                "   例如：播放多媒体的时候，用户启动了其他Activity,这个时候程序就要在后台继续" +
                "播放；例如检测到SD卡上文件的变化；又例如后台记录用户的地理位置信息的改变等等。" +
                "   比如，正在从播放列表中播放歌曲的媒体播放器。在一个媒体播放器的应用中" +
                "应该会有多个Activity,让使用者可以选择歌曲并播放。然而播放音乐这个功能并没有对应的Activity" +
                ",这时媒体播放器的这个Activity就会使用startService()来启动service" +
                "从而在后台保持播放音乐\n" +
                "3、启动过程:\n" +
                "   启动一个Service的过程如下：\n" +
                "   context.startService()  ->onCreate()- >onStart()->Service running" +
                "其中onCreate()可以进行一些服务的初始化工作，onStart()则启动服务。\n" +
                "   停止一个Service的过程如下：\n" +
                "context.stopService() | ->onDestroy() ->Service stop\n\n" +
                "   接下来的实例是一个利用后台服务播放音乐的小例子，点击start运行服务，点击stop停止服务。";
        textView.setText(text);

        musicStartButton.setOnClickListener(this);
        musicStopButton.setOnClickListener(this);


    }

    private void initView() {
        textView = (TextView)findViewById(R.id.service_demo_text);
        musicStartButton = (Button)findViewById(R.id.music_start);
        musicStopButton = (Button)findViewById(R.id.music_stop);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.music_start :
                Log.i("MusicServiceActivity","播放音乐");
                startService(new Intent(this, MyDemoService.class));
                break;
            case R.id.music_stop :
                Log.i("MusicServiceActivity","停止播放音乐");
                stopService(new Intent(this, MyDemoService.class));
                break;
            default:break;
        }
    }
}
