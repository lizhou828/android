package com.example.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-18
 * Time: 下午1:30
 * To change this template use File | Settings | File Templates.
 */
public class HttpUtils {
    public static HttpClient httpClient;
    public static HttpResponse httpResponse;
    public static  HttpEntity httpEntity;

    /**
     * 发送http get请求
     * @param url
     * @return
     */
    public static String get(String url){
        httpClient = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        String responseText = null;
        try {
            httpResponse = httpClient.execute(get);
            httpEntity = httpResponse.getEntity();
            EntityUtils.toString(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
            //to do something
        }finally {
            httpClient.getConnectionManager().shutdown();
        }
        return responseText == null ? "" : responseText.toString() ;
    }


    public static void post(String url,List<NameValuePair> params){
        post(url,params,HTTP.UTF_8);
    }

    /**
     * 发送http post请求
     * @param url
     * @param params
     * @return
     */
    public static HttpResponse post(String url,List<NameValuePair> params,String charSet){
        httpClient = new DefaultHttpClient();
        if(charSet == null || "".equals(charSet)){
            charSet = HTTP.UTF_8;
        }
        HttpPost post = new HttpPost(url);
        try {
            //设置请求参数
            post.setEntity(new UrlEncodedFormEntity( params,charSet ));
            httpResponse = httpClient.execute(post);
        } catch (Exception e) {
            //to do something
            e.printStackTrace();
        }finally {
            httpClient.getConnectionManager().shutdown();
        }
        return httpResponse;
    }
}
