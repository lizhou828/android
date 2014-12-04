package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-2
 * Time: 下午4:06
 * To change this template use File | Settings | File Templates.
 */
public class PageViewFlipperActivity extends Activity implements GestureDetector.OnGestureListener {
    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector;
    private Button button;
    ImageView imageView[] = new ImageView[6] ;
    int i = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_flipper);
        imageView[0] = (ImageView)findViewById(R.id.view_flipper_image_scenery1);
        imageView[1] = (ImageView)findViewById(R.id.view_flipper_image_scenery2);
        imageView[2] = (ImageView)findViewById(R.id.view_flipper_image_scenery3);
        imageView[3] = (ImageView)findViewById(R.id.view_flipper_image_scenery4);
        imageView[4] = (ImageView)findViewById(R.id.view_flipper_image_scenery5);
        imageView[5] = (ImageView)findViewById(R.id.view_flipper_image_scenery6);


        gestureDetector = new GestureDetector(this);
        viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
        viewFlipper.addView( addImageView(R.drawable.scenery1) );
        viewFlipper.addView( addImageView(R.drawable.scenery2) );
        viewFlipper.addView( addImageView(R.drawable.scenery3) );
        viewFlipper.addView( addImageView(R.drawable.scenery4) );
        viewFlipper.addView( addImageView(R.drawable.scenery5) );
        viewFlipper.addView( addImageView(R.drawable.scenery6) );


        viewFlipper.addView(addView());

        //实现自动播放和手势滑屏事件（类似广告轮播） http://blog.csdn.net/pi9nc/article/details/9320483
    }

    private View addView() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.layoutwelcome2, null);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(PageViewFlipperActivity.this, "Clicked", 2000).show();
            }
        });
        return view;
    }

    private View addImageView(int id) {
        ImageView iv = new ImageView(this);
        iv.setImageResource(id);
        return iv;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float velocityX, float velocityY) {
        System.out.println("in------------------>>>>>>>>>>>>>");
        if (motionEvent1.getX() - motionEvent2.getX() > 120) {
            if (i < 6) {
                i++;
                setImage(i);

                this.viewFlipper.setInAnimation(this,R.anim.in_right_left);
                this.viewFlipper.setOutAnimation(this,R.anim.out_right_left);
                this.viewFlipper.showNext();
            }
        }else if( motionEvent1.getX() - motionEvent2.getX() < -120 ){
            if( i > 0 ){
                i--;
                setImage(i);
                this.viewFlipper.setInAnimation(this,R.anim.in_left_right);
                this.viewFlipper.setOutAnimation(this,R.anim.out_left_right);
                this.viewFlipper.showPrevious();
            }
        }
        return false;
    }

    public void setImage(int i) {
        for( int j = 0 ;j < 6 ; j++ ){
            if( j != i ){
                imageView[j].setImageResource(R.drawable.xiao);
            }else{
                imageView[i].setImageResource(R.drawable.da);
            }

        }
    }


}
