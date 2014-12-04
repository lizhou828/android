package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import com.example.view.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-4
 * Time: 下午2:22
 * To change this template use File | Settings | File Templates.
 */
public class XListViewActivity extends Activity implements XListView.IXListViewListener{
    private XListView mListView;
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> items = new ArrayList<String>();
    private Handler mHandler;
    private int start = 0;
    private static int refreshCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xlist_view);
        geneItems();
        mListView = (XListView) findViewById(R.id.xListView);
        mListView.setPullLoadEnable(true);
        mAdapter = new ArrayAdapter<String>(this, R.layout.xlist_item, items);
        mListView.setAdapter(mAdapter);
//		mListView.setPullLoadEnable(false);
//		mListView.setPullRefreshEnable(false);
        mListView.setXListViewListener(this);
        mHandler = new Handler();

    }

    private void geneItems() {
        //初始化数据
        for (int i = 0; i != 25; ++i) {
            items.add("refresh cnt " + (++start));
        }
    }

    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        String updateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        mListView.setRefreshTime(updateTime);
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start = ++refreshCnt;
                items.clear();
                geneItems();
                // mAdapter.notifyDataSetChanged();
                mAdapter = new ArrayAdapter<String>(XListViewActivity.this, R.layout.xlist_item, items);
                mListView.setAdapter(mAdapter);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geneItems();
                mAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }
}
