package com.example;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-4
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class SharedPreferencesActivity extends Activity{


    private EditText nameField;
    private EditText passwordField;
    private final static String SETTING_INFO = "SETTING_INFO" ;
    private final static String NAME = "NAME" ;
    private final static String PASSWORD = "PASSWORD" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        //SharePreferences存储数据非常方便，但只适合存储比较简单的数据

        setContentView(R.layout.login);


        nameField =  (EditText)findViewById(R.id.name);
        passwordField =  (EditText)findViewById(R.id.password);

        //存储到SharedPreference中
        SharedPreferences sharedPreferences =  getSharedPreferences(SETTING_INFO,0);
        //取出保存的NAME 和PASSWORD
        String name = sharedPreferences.getString(NAME,"");
        String password = sharedPreferences.getString(PASSWORD,"");

        nameField.setText(name);
        passwordField.setText(password);

        Intent intent = new Intent();
        String message = "SharePreferences存储数据非常方便，但只适合存储比较简单的数据";
        intent.putExtra("message",message);
        Integer resultCode = 0 ;
        setResult( resultCode , intent );
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SETTING_INFO,0);
        //将用户名和密码保存进去
        sharedPreferences.edit()
                .putString(NAME, nameField.getText().toString())
                .putString(PASSWORD, passwordField.getText().toString())
                .commit();


    }
}
