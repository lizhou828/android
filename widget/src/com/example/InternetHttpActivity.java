package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.utils.HttpUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-18
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class InternetHttpActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet_http);

        String url = "http://www.baidu.com";
        String result = "请求结果:\n";
        result += HttpUtils.get(url);
        TextView textView = (TextView)findViewById(R.id.internet_http_text_view);
        textView.setText(result);

        Intent intent = new Intent();
        intent.putExtra("message","send http get request successful!");
        Integer resultCode = 4 ;
        setResult( resultCode , intent );

    }
}
