package com.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.R;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-4
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public class XListViewHeader extends LinearLayout {
    private LinearLayout mContainer;
    private ImageView mArrowImageView;
    private TextView mHintTextView;
    private ProgressBar mProgressBar;
    private RotateAnimation mRotateUpAnim;
    private final  long ROTATE_ANIM_DURATION = 180L;
    private RotateAnimation mRotateDownAnim;

    private int mState = STATE_NORMAL;

    public final static int STATE_NORMAL = 0;
    public final static int STATE_READY = 1;
    public final static int STATE_REFRESHING = 2;


    public XListViewHeader(Context context) {
        super(context);
        initView(context);
    }

    public XListViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        //初始情况，设置下拉刷新view的高度为0
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,0);
        mContainer = (LinearLayout)LayoutInflater.from(context).inflate(R.layout.xlistview_header,null);
        addView(mContainer,layoutParams);
        setGravity(Gravity.BOTTOM);

        mArrowImageView = (ImageView)findViewById(R.id.xlistview_header_arrow);
        mHintTextView = (TextView)findViewById(R.id.xlistview_header_hint_textview);
        mProgressBar = (ProgressBar)findViewById(R.id.xlistview_header_progressbar);

        mRotateUpAnim = new RotateAnimation(0.0f,-180.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);

        mRotateDownAnim = new RotateAnimation(-180.0f,0.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
    }

    public void setState(int state){
        if( state == mState ) return;

        if( state == STATE_REFRESHING ){//显示进度
            mArrowImageView.clearAnimation();
            mArrowImageView.setVisibility(View.INVISIBLE);
            mProgressBar.setVisibility(View.VISIBLE);
        }else{  //显示箭头图片
            mArrowImageView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.INVISIBLE);
        }

        switch (state){
            case STATE_NORMAL :
                if( mState == STATE_READY ){
                    mArrowImageView.startAnimation(mRotateDownAnim);
                }
                if(mState == STATE_REFRESHING){
                    mArrowImageView.clearAnimation();
                }
                mHintTextView.setText(R.string.xlistview_footer_hint_normal);
                break;
            case STATE_READY :
                if(mState != STATE_READY){
                    mArrowImageView.clearAnimation();
                    mArrowImageView.startAnimation(mRotateUpAnim);
                    mHintTextView.setText(R.string.xlistview_footer_hint_ready);
                }
                break;
            case STATE_REFRESHING :
                mHintTextView.setText(R.string.xlistview_header_hint_loading);
                break;
            default:
        }
        mState = state;
    }

    public void setVisibleHeight(int height){
        if( height < 0 ) height = 0;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)mContainer.getLayoutParams();
        layoutParams.height = height;
        mContainer.setLayoutParams( layoutParams );
    }

    public int getVisibleHeight(){
        return mContainer.getHeight();
    }




}
