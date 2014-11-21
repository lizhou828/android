package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.utils.HttpUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

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

        String url = "http://m.baidu.com";

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        //获取请求头信息：
        String requestHeadContent = "RequestHeadContent :";
        Header[] requestHeaders = httpGet.getAllHeaders();
        for(Header h : requestHeaders){
            if( "".equals(requestHeadContent)){
                requestHeadContent += h.getName()+"_"+h.getValue();
            }else{
                requestHeadContent += ",\n"+h.getName()+"_"+h.getValue();
            }
        }


        HttpResponse httpResponse = null;
        Integer statusCode = 0;
        String responseHeadContent = "ResponseHeadContent :";
        try {
            httpResponse = httpClient.execute(httpGet);
            //获取http响应的状态码
            statusCode = httpResponse.getStatusLine().getStatusCode();
            //获取响应头信息
            Header[] headers = httpResponse.getAllHeaders();
            for(Header h : headers){
                if( "".equals(responseHeadContent)){
                    responseHeadContent += h.getName()+"_"+h.getValue();
                }else{
                    responseHeadContent += ",\n"+h.getName()+"_"+h.getValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        String resultContent = "ResultContent:\n";
        //获取返回内容
        try {
            resultContent += EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        String message = "statusCode="+statusCode;
        if( statusCode == HttpStatus.SC_OK ){
            message += ",send http get request successful!";
        }

        TextView textView = (TextView)findViewById(R.id.internet_http_text_view);
        textView.setText(message+"\n\n\n"+requestHeadContent+"\n\n\n"+responseHeadContent+"\n\n\n"+resultContent);

        Intent intent = new Intent();
        intent.putExtra("message",message);
        Integer resultCode = 4 ;
        setResult( resultCode , intent );

    }
}
