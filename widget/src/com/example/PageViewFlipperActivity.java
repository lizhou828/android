package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

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
        imageView[0] = (ImageView)findViewById(R.id.view_flipper_point_scenery1);
        imageView[1] = (ImageView)findViewById(R.id.view_flipper_point_scenery2);
        imageView[2] = (ImageView)findViewById(R.id.view_flipper_point_scenery3);
        imageView[3] = (ImageView)findViewById(R.id.view_flipper_point_scenery4);
        imageView[4] = (ImageView)findViewById(R.id.view_flipper_point_scenery5);
        imageView[5] = (ImageView)findViewById(R.id.view_flipper_point_scenery6);


        gestureDetector = new GestureDetector(this);

//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
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
//        我们在添加视图文件的时候有两种方式，一种是通过在xml文件定义layout,另一种方式是在java代码中动态生成布局文件。
//        在xml中定义的layout要想转化为view，需要使用到LayoutInflater类。

        //LayoutInflater创建的3种方式
//        1、LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        2、LayoutInflater inflater = LayoutInflater.from(Activity.this)；
//        3、LayoutInflater inflater = getLayoutInflater();

        LayoutInflater inflater = LayoutInflater.from(this);

        /**
         * 为了便于理解，我们可以将它与findViewById()作一比较，二者都是实例化某一对象。
         * findViewById()是找xml布局文件下的具体widget控件实例化，
         * LayoutInflater找res/layout/下的xml布局文件来实例化的。
         */

        View view = inflater.inflate(R.layout.welcome, null);
        button = (Button) view.findViewById(R.id.welcome_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(PageViewFlipperActivity.this , MainTabActivity.class );
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.in_right_left,R.anim.out_right_left);
            }
        });
        return view;
    }

    private View addImageView(int id) {
        ImageView iv = new ImageView(this);
        iv.setImageResource(id);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);//全屏显示
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

    /**
     *
     * @param motionEvent1 触摸到屏幕时候
     * @param motionEvent2 离开屏幕的时候
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float velocityX, float velocityY) {

        //开始位置 大于 结束位置 :向左滑
        if (motionEvent1.getX() - motionEvent2.getX() > 120) {
            if (i < 6) {
                i++;
                setImage(i);

                this.viewFlipper.setInAnimation(this,R.anim.in_right_left);
                this.viewFlipper.setOutAnimation(this,R.anim.out_right_left);
                this.viewFlipper.showNext();
            }
         //开始位置 小雨 结束位置 :向右滑
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

    //重新设置image下方的白色导航点
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
