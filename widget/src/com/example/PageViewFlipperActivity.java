package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-2
 * Time: 下午4:06
 * To change this template use File | Settings | File Templates.
 */
public class PageViewFlipperActivity extends Activity {
    private ViewFlipper viewFlipper;
    private float  startX;
    private float isFirstImage;
    private float isLastImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_flipper);

        viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
        Button button = (Button)findViewById(R.id.view_flipper_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PageViewFlipperActivity.this,"您点击了立即体验按钮",Toast.LENGTH_SHORT).show();
            }
        });

        //实现自动播放和手势滑屏事件（类似广告轮播） http://blog.csdn.net/pi9nc/article/details/9320483
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN : startX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                if( event.getX() > startX ){ //向右滑
                    viewFlipper.setInAnimation(this,R.anim.in_left_right);
                    viewFlipper.setOutAnimation(this,R.anim.out_left_right);
                    viewFlipper.showNext();
                }else if(event.getX() < startX ){ //向左滑
                    viewFlipper.setInAnimation(this,R.anim.in_right_left);
                    viewFlipper.setOutAnimation(this,R.anim.out_right_left);
                    viewFlipper.showPrevious();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
