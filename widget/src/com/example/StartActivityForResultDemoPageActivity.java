package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-17
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public class StartActivityForResultDemoPageActivity extends Activity implements View.OnClickListener {

    private TextView mText01;
    private TextView mText02;
    private Button mButton01;
    private Button mButton02;
    private Intent intent;

    private Integer requestCode;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mButton01 :
                //请求码的值随便设置，但必须 >= 0
                requestCode = 0 ;
                startActivityForResult(intent,requestCode);
                break;
            case R.id.mButton02 :
                requestCode = 2;
                startActivityForResult(intent,requestCode);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main_page);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);


        mText01 = (TextView)findViewById(R.id.mText01);
        mText02 = (TextView)findViewById(R.id.mText02);
        mText01.setText("mText01");
        mText02.setText("mText02");

        mButton01 = (Button)findViewById(R.id.mButton01);
        mButton02 = (Button)findViewById(R.id.mButton02);
        mButton01.setOnClickListener(this);
        mButton02.setOnClickListener(this);

        intent = new Intent();
        intent.setClass(StartActivityForResultDemoPageActivity.this,SubStartActivityForResultDemoPageActivity.class);

    }

    /**
     * 回调方法，从第二个页面回来的时候 会执行这个方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String change01 = data.getStringExtra("change01");
        String change02 = data.getStringExtra("change02");
        //根据上面发送过去的请求码来区别
        switch (requestCode){
            case 0 : mText01.setText(change01);
                break;
            case 2 : mText02.setText(change02);
                break;
            default:
                break;
        }
    }
}
