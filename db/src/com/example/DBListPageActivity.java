package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-17
 * Time: 下午5:30
 * To change this template use File | Settings | File Templates.
 */
public class DBListPageActivity extends Activity{
    private final int httpRequestCode = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.db_list);

//        五种数据存储技术相关文档：
//        http://wenku.baidu.com/link?url=IBGmzru6EvrHM7CUMuKV6eFrPnsumtDVdxAsMeTINdLEPqMVKS7zLiDdK_cxV0S94XcOPMB_3kY8NNylocWakxcQVAxpn9mOZ33AlAKVy7O
//        http://www.cnblogs.com/smalltigerlee/archive/2011/11/10/2244143.html

//        SQLite 官网:  http://www.sqlite.org/

        Button sharePreferenceButton =(Button)findViewById(R.id.sharePreference_button);



        //http网络通信
        Button IntentHttpButton = (Button)findViewById(R.id.internet_button);
        IntentHttpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendHttpIntent = new Intent();
                sendHttpIntent.setClass(DBListPageActivity.this, InternetHttpActivity.class);
                startActivityForResult(sendHttpIntent,httpRequestCode);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch ( requestCode ){
            case httpRequestCode:
                String message = data.getStringExtra("message");
                Toast.makeText(this,message,Toast.LENGTH_LONG).show();
                break;
            default:break;
        }
    }
}
