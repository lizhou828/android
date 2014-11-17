package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-17
 * Time: 上午11:18
 * To change this template use File | Settings | File Templates.
 */
public class SubStartActivityForResultDemoPageActivity extends Activity{
    private Integer resultCode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_page);
        Intent intent = new Intent();
        intent.putExtra("change01","1000");
        intent.putExtra("change02","2000");
        //设置结果，并进行传送
        this.setResult(resultCode,intent);

        //this.finish(); //加上这行代码，将不会显示R.layout.sub_page这个页面


    }
}
