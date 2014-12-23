package com.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import com.example.pojo.Contact;
import com.example.service.ContactService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-4
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public class HtmlPageActivity extends Activity {
    private WebView webView;
    private ContactService contactService = new ContactService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.html_page);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);




        webView = (WebView)findViewById(R.id.web_view);
        //webView 设置：允许使用javascript
        webView.getSettings().setJavaScriptEnabled(true);
        //WebView中导入html页面
        webView.loadUrl("file:///android_asset/contactList.html");
        //使用java创建一个js对象，html页面的js中 可以直接调用contact这个对象
        webView.addJavascriptInterface( new JSObject() ,"contact");
    }

    private final class JSObject {

        public void loadContactData(){
            List<Contact> contactList = contactService.getContacts();
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = null;
            try{
                for(Contact c : contactList){
                    jsonObject = new JSONObject();
                    jsonObject.put("name",c.getName());
                    jsonObject.put("amount",c.getAmount());
                    jsonObject.put("mobile",c.getMobile());
                    jsonArray.put(jsonObject);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            String json = jsonArray.toString();
            webView.loadUrl("javascript:show('"+json+"')");
        }
        public void call( String mobileNumber ){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse( "tel:" + mobileNumber ) );
            startActivity(intent);

        }

    }
}
