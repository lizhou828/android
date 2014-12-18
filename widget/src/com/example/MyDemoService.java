package com.example;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-18
 * Time: 下午4:27
 * To change this template use File | Settings | File Templates.
 */
public class MyDemoService extends Service {
    private static final String TAG = "MyDemoService";
    MediaPlayer player;
    @Override
    public void onCreate() {
        Toast.makeText(this,"MyDemoService Created",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"MyDemoService Created");
        player = MediaPlayer.create(this,R.raw.angry_bird);
        player.setLooping(false);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this,"MyDemoService started",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"MyDemoService started");
        player.start();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"MyDemoService destroyed",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"MyDemoService destroyed");
        player.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
