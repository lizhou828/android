package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.layout_advance);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);

        //android为listView添加表头
        showTableHeaderInListView();

        //固定表头
        showFixedHeader();

        //自定义标题栏
        showCustomTitlePage();

        //底部导航栏选项卡
        showBottomGuideTab();

        //页面左右滑动切换（ViewFlipper实现）
        showPageCutOverButton();

        //上拉加载更多/下拉刷新
        showUpDownPullRefresh();

    }

    private void showUpDownPullRefresh() {
        Button button =(Button)findViewById(R.id.upDown_pull_refresh_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutAdvancePageActivity.this,XListViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showPageCutOverButton() {
        Button button =(Button)findViewById(R.id.page_cut_over_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LayoutAdvancePageActivity.this,PageViewFlipperActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showFixedHeader() {
        Button button =(Button)findViewById(R.id.fixed_header_page);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LayoutAdvancePageActivity.this,FixedHeaderActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showBottomGuideTab() {
        Button button =(Button)findViewById(R.id.custom_guide_page);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LayoutAdvancePageActivity.this,MainTabActivity.class);
                startActivity(intent);
            }
        });
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
