package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_flipper);

        viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
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
