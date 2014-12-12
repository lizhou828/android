package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-12
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
public class WeatherForecastActivity extends Activity{
    //定义需要获取的内容来源地址
//    private static final String SERVER_URL =
//            "http://www.webservicex.net/WeatherForecast.asmx/GetWeatherByZipCode";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String SERVER_URL1 ="http://www.weather.com.cn/data/sk/101010100.html" ;
        HttpGet request1 = new HttpGet(SERVER_URL1);
//        List<NameValuePair> params =  new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("ZipCode","200120"));  //美国Washington D.C.
        String content = "SERVER_URL:\n"+SERVER_URL1+"\n\n";
        try {
//            request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpResponse = new DefaultHttpClient().execute(request1);
            if( httpResponse.getStatusLine().getStatusCode() != 404 ){
                String result = EntityUtils.toString( httpResponse.getEntity() );
                Log.i("天气预报接口1，httpResponse result:", result);
                content += "天气预报接口1，httpResponse result:\n\n"+result;
            }
        } catch ( Exception e) {
            Log.e("msg",e.getMessage());
        }


        String SERVER_URL2 = "http://www.weather.com.cn/data/cityinfo/101010100.html";
        content += "\n\nSERVER_URL2:\n"+SERVER_URL2;
        HttpGet request2 = new HttpGet(SERVER_URL2);
        try {
            HttpResponse httpResponse = new DefaultHttpClient().execute(request2);
            if( httpResponse.getStatusLine().getStatusCode() != 404 ){
                String result = EntityUtils.toString( httpResponse.getEntity() );
                Log.i("天气预报接口2，httpResponse result:", result);
                content += "\n\n天气预报接口2，httpResponse result:\n\n"+result;
            }
        } catch (Exception e) {
            Log.e("msg",e.getMessage());
        }


        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(content);
        LinearLayout linearLayout  = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(textView);
        setContentView(linearLayout);
    }
}
