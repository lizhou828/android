package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2014/12/30.
 * 安卓中Activity的4种启动方式：
 * Standard, singletop, singletask和singleinstance
 *
 * http://www.cnblogs.com/fanchangfa/archive/2012/08/25/2657012.html
 * http://www.cnblogs.com/meizixiong/archive/2013/07/03/3170591.html
 */
public class StartMethodForActivity extends Activity implements View.OnClickListener{
    private Button standard;
    private Button singleTop;
    private Button singleTask;
    private Button singleInstance;
    private TextView taskStackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.start_method_for_activity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);

        initView();
        standard.setOnClickListener(this);
        singleTop.setOnClickListener(this);
        singleTask.setOnClickListener(this);
        singleInstance.setOnClickListener(this);

        String text = "讲解启动模式之前，有必要先讲解一下“任务栈”的概念;\n\n" +
                "任务栈:\n" +
                "　　每个安卓应用都有一个任务栈，是用来存放Activity的，功能类似于函数调用的栈，先后顺序代表了Activity的出现顺序；" +
                "比如Activity1-->Activity2-->Activity3,则任务栈为：";
        taskStackText.setText(text);



    }

    private void initView() {
        standard = (Button)findViewById(R.id.standard_button);
        singleTop = (Button)findViewById(R.id.singleTop_button);
        singleTask = (Button)findViewById(R.id.singleTask_button);
        singleInstance = (Button)findViewById(R.id.singleInstance_button);

        taskStackText = (TextView)findViewById(R.id.task_stack_text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.standard_button :
                startActivity( new Intent(StartMethodForActivity.this,StandardActivity.class));
                break;
            case R.id.singleTop_button :
                startActivity( new Intent(StartMethodForActivity.this,SingleTopActivity.class));
                break;
            case R.id.singleTask_button :
                startActivity( new Intent(StartMethodForActivity.this,SingleTaskActivity.class));
                break;
            case R.id.singleInstance_button :
                startActivity( new Intent(StartMethodForActivity.this,SingleInstanceActivity.class));
                break;
            default:break;
        }
    }
}
