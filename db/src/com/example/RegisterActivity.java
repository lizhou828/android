package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.model.User;
import com.example.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-8
 * Time: 下午5:33
 * Addr: To change this template use File | Settings | File Templates.
 */
public class RegisterActivity extends Activity implements View.OnClickListener {
    private EditText userNameEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    private RadioGroup genderRadioGroup;
    private ToggleButton marriedToggleButton;
    private Button loginButton;
    private Button registerButton;

    public UserService userService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.sqlite_register);
        userService = new UserService(RegisterActivity.this);

        findViews();
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

    }

    private void findViews() {
        loginButton = (Button)findViewById(R.id.login_button);
        registerButton = (Button)findViewById(R.id.register_button);
        userNameEditText = (EditText)findViewById(R.id.user_name);
        passwordEditText = (EditText)findViewById(R.id.pass_word);
        ageEditText = (EditText)findViewById(R.id.age);
        genderRadioGroup = (RadioGroup)findViewById(R.id.gender);
        marriedToggleButton = (ToggleButton)findViewById(R.id.married);

        //文本框失去焦点事件
        userNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus ){
                    String username = userNameEditText.getText().toString().trim();
                    boolean  exist = userService.userExists(username);
                    if( exist ){
                        Toast.makeText(RegisterActivity.this, "用户名已存在...",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.login_button :
               startActivity(new Intent(RegisterActivity.this, SQLiteIntroActivity.class));
               break;
           case R.id.register_button:
               register();
           default:break;
       }
    }

    private void register() {
        String username = userNameEditText.getText().toString().trim();
        boolean  exist = userService.userExists(username);
        if( exist ){
            Toast.makeText(RegisterActivity.this, "用户名已存在...",Toast.LENGTH_SHORT).show();
            return;
        }

        String password = passwordEditText.getText().toString().trim();
        String ageTemp = ageEditText.getText().toString().trim();
        String age = "".equals(ageTemp) || "null".equalsIgnoreCase(ageTemp) || ageTemp == null ? "0" : ageTemp  ;
        String gender = genderRadioGroup.getCheckedRadioButtonId() == R.id.male ? "男" : "女";
        String married = marriedToggleButton.getText().toString();
        Log.i("msg",username+"_"+password+"_"+age+"_"+gender+"_"+married);




        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));
        user.setGender(gender);
        user.setMarried(married);

        Boolean flag = userService.register(user);
        Toast.makeText(RegisterActivity.this,flag ? "注册成功" : "注册失败",Toast.LENGTH_SHORT).show();
    }
}
