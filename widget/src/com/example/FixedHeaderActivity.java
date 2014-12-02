package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-2
 * Time: 下午2:10
 * To change this template use File | Settings | File Templates.
 */
public class FixedHeaderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.fixed_header);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);

        ListView listView = (ListView)findViewById(R.id.fixed_header_list_view);
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
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

    }
}
