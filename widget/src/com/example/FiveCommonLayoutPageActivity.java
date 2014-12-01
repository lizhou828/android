package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-21
 * Time: 下午2:05
 * To change this template use File | Settings | File Templates.
 */
public class FiveCommonLayoutPageActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_common_layout);

        //android五种布局模式:  http://www.cnblogs.com/chiao/archive/2011/08/24/2152435.html

        showLinearLayoutPage();
        showFrameLayoutPage();
        showAbsoluteLayoutPage();
        showRelativeLayoutPage();
        showTableLayoutPage();
    }

    private void showTableLayoutPage() {
        Button button = (Button)findViewById(R.id.table_layout_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FiveCommonLayoutPageActivity.this,TableLayoutActivity.class);
                startActivity(intent);
            }
        });


    }

    private void showRelativeLayoutPage() {
        Button button = (Button)findViewById(R.id.relative_layout_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FiveCommonLayoutPageActivity.this,RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showAbsoluteLayoutPage() {
        Button button = (Button)findViewById(R.id.absolute_layout_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FiveCommonLayoutPageActivity.this,AbsoluteLayoutActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showLinearLayoutPage() {
        Button button = (Button)findViewById(R.id.linear_layout_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FiveCommonLayoutPageActivity.this,LinearLayoutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showFrameLayoutPage() {
        Button button = (Button)findViewById(R.id.frame_layout_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FiveCommonLayoutPageActivity.this,FrameLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
