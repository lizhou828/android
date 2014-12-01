package com.example;

import android.*;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-28
 * Time: 下午3:56
 * Desc: android为listView添加表头
 * Addr: http://jessyzhangch.blog.51cto.com/2021036/401988
 */
public class TableHeaderInListViewActivity extends Activity{
    private TextView textView;
    private ListView listView;
    private ImageView imageView;
    private LinearLayout linearLayout;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        listView = new ListView(this);
        imageView = new ImageView(this);

        Resources resources = getResources();
        Drawable drawable = resources.getDrawable(R.drawable.loading);
        imageView.setImageDrawable(drawable);
        textView.setText("It's waiting...");

        //头部
        linearLayout = new LinearLayout(this);
        linearLayout.addView(imageView,120,100);//linearLayout里面增加一个view,并设置宽高
        linearLayout.addView(textView,400,100);

        //中间数据部分
        listView.addHeaderView(linearLayout);//ListView设置头部view
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData()));



        setContentView(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(i == 0 ){
                   Toast.makeText(getApplicationContext(),"It's waiting",Toast.LENGTH_SHORT).show();
               }
            }
        });

    }


    public List<String> getData() {
        List<String> list = new ArrayList<String>();
        list.add("数据1");
        list.add("数据2");
        list.add("数据3");
        list.add("数据4");
        list.add("数据5");
        list.add("数据6");
        list.add("数据7");
        list.add("数据8");
        list.add("数据9");
        list.add("数据10");
        list.add("数据11");
        list.add("数据12");

        return list;
    }
}
