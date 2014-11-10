package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-10-30
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
public class SpinnerActivity  extends Activity{
    private  static final String[] countries = {"China","Russia","America","Canada","England","Italy",
            "South Africa","Germany","Australia","Vietnam","Korea","Mexico","Brazil","Singapore","French"};
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("SpinnerActivity");
        setContentView(R.layout.spinner);

        for( String str : countries ){
            list.add( str );
        }
        final TextView textViewCity = (TextView)findViewById(R.id.text_view_city);
        Spinner spinnerCity = (Spinner)findViewById(R.id.spinner_city);

        //为下拉列表定义一个适配器
        final ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);

       //为适配器设置下拉列表时的菜单样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //讲适配器添加到下拉列表中
        spinnerCity.setAdapter(adapter);

        //为下拉列表设置各种事件的响应，下面这个事件是菜单被选中
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //将spinnerCity的值带入textViewCity中
                textViewCity.setText("你选择的是："+adapter.getItem(i));
                //将spinnerCity显示
                adapterView.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textViewCity.setText("None");
                adapterView.setVisibility(View.VISIBLE);
            }
        });

        //下拉菜单弹出的内容选项 触屏事件处理
        spinnerCity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });

        //下拉菜单弹出的内容选项 焦点改变事件处理
        spinnerCity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });



    }


}
