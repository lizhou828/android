package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-4
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
public class ProgressBarActivity extends Activity{

    private Button btn_go = null;
    private MyProgressBar myProgress = null;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.progress_bar);

        findView();

        addListener();

        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Log.i("进度条:","="+msg.what);
                myProgress.setProgress(msg.what);
                return false;
            }
        });

    }

    private void findView(){
        btn_go = (Button) findViewById(R.id.btn_go);
        myProgress = (MyProgressBar) findViewById(R.id.progress_bar_horizontal);
    }

    private void setParam(){
        btn_go.setText("开始");
    }
    private void addListener(){
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0;i <=50; i++){
                            mHandler.sendEmptyMessage(i * 2);
                            try {
                                Thread.sleep(80);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }
}
