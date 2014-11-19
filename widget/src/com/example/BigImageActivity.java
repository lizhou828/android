package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.Gallery;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-19
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public class BigImageActivity extends Activity implements View.OnTouchListener{

    // 屏幕宽度
    public static int screenWidth;
    // 屏幕高度
    public static int screenHeight;
    private MyGallery gallery;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.big_image);

        gallery = (MyGallery) findViewById(R.id.gallery);
        gallery.setVerticalFadingEdgeEnabled(false);// 取消竖直渐变边框
        gallery.setHorizontalFadingEdgeEnabled(false);// 取消水平渐变边框
        gallery.setAdapter(new GalleryAdapter(this));
        // gallery.setOnTouchListener(this);
        // gallery.setOnItemSelectedListener(new GalleryChangeListener());
        // FrameLayout.LayoutParams params=(FrameLayout.LayoutParams)
        // gallery.getLayoutParams();
        // params.height=400;
        // params.width=300;

        screenWidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        screenHeight = getWindow().getWindowManager().getDefaultDisplay().getHeight();

    }

    float beforeLenght = 0.0f; // 两触点距离
    float afterLenght = 0.0f; // 两触点距离
    boolean isScale = false;
    float currentScale = 1.0f;// 当前图片的缩放比率

    private class GalleryChangeListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            currentScale = 1.0f;
            isScale = false;
            beforeLenght = 0.0f;
            afterLenght = 0.0f;

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        // Log.i("","touched---------------");
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_POINTER_DOWN:// 多点缩放
                beforeLenght = spacing(event);
                if (beforeLenght > 5f) {
                    isScale = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (isScale) {
                    afterLenght = spacing(event);
                    if (afterLenght < 5f)
                        break;
                    float gapLenght = afterLenght - beforeLenght;
                    if (gapLenght == 0) {
                        break;
                    } else if (Math.abs(gapLenght) > 5f) {
                        // FrameLayout.LayoutParams params =
                        // (FrameLayout.LayoutParams) gallery.getLayoutParams();
                        float scaleRate = gapLenght / 854;// 缩放比例
                        // Log.i("",
                        // "scaleRate："+scaleRate+" currentScale:"+currentScale);
                        // Log.i("", "缩放比例：" +
                        // scaleRate+" 当前图片的缩放比例："+currentScale);
                        // params.height=(int)(800*(scaleRate+1));
                        // params.width=(int)(480*(scaleRate+1));
                        // params.height = 400;
                        // params.width = 300;
                        // gallery.getChildAt(0).setLayoutParams(new
                        // Gallery.LayoutParams(300, 300));
                        Animation myAnimation_Scale = new ScaleAnimation(currentScale, currentScale + scaleRate, currentScale, currentScale + scaleRate, Animation.RELATIVE_TO_SELF, 0.5f,
                                Animation.RELATIVE_TO_SELF, 0.5f);
                        // Animation myAnimation_Scale = new
                        // ScaleAnimation(currentScale, 1+scaleRate, currentScale,
                        // 1+scaleRate);
                        myAnimation_Scale.setDuration(100);
                        myAnimation_Scale.setFillAfter(true);
                        myAnimation_Scale.setFillEnabled(true);
                        // gallery.getChildAt(0).startAnimation(myAnimation_Scale);

                        // gallery.startAnimation(myAnimation_Scale);
                        currentScale = currentScale + scaleRate;
                        // gallery.getSelectedView().setLayoutParams(new
                        // Gallery.LayoutParams((int)(480), (int)(800)));
                        // Log.i("",
                        // "===========:::"+gallery.getSelectedView().getLayoutParams().height);
                        // gallery.getSelectedView().getLayoutParams().height=(int)(800*(currentScale));
                        // gallery.getSelectedView().getLayoutParams().width=(int)(480*(currentScale));
                        gallery.getSelectedView().setLayoutParams(new Gallery.LayoutParams((int) (480 * (currentScale)), (int) (854 * (currentScale))));
                        // gallery.getSelectedView().setLayoutParams(new
                        // Gallery.LayoutParams((int)(320*(scaleRate+1)),
                        // (int)(480*(scaleRate+1))));
                        // gallery.getSelectedView().startAnimation(myAnimation_Scale);
                        // isScale = false;
                        beforeLenght = afterLenght;
                    }
                    return true;
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                isScale = false;
                break;
        }

        return false;
    }

    /**
     * 就算两点间的距离
     */
    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return FloatMath.sqrt(x * x + y * y);
    }
}
