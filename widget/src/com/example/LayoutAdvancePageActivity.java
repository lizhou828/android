package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-28
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
public class LayoutAdvancePageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.layout_advance);

        //android为listView添加表头
        showTableHeaderInListView();

        //自定义标题栏
        showCustomTitlePage();

    }

    private void showCustomTitlePage() {
        Button button =(Button)findViewById(R.id.custom_title_page);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LayoutAdvancePageActivity.this,CustomTitleActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showTableHeaderInListView() {
        Button button =(Button)findViewById(R.id.set_table_header_for_list_view_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LayoutAdvancePageActivity.this,TableHeaderInListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
