package com.example;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-22
 * Time: 下午5:26
 * Desc: 加载图片的三级缓存策略(内存、文件、网络)
 * Addr: http://download.csdn.net/detail/geniuseoe2012/5046389
 */
public class LoadPictureActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_picture);

    }
}
