package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cache.ImageLoader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-24
 * Time: 上午10:10
 * To change this template use File | Settings | File Templates.
 */
public class LoaderAdapter extends BaseAdapter {
    private static final String TAG = "LoaderAdapter";
    private Integer mCount;
    private Context mContext;
    private String [] urlArrays;
    private ImageLoader imageLoader;
    private boolean busy = false;


    public LoaderAdapter(Integer mCount, Context mContext, String[] urlArrays) {
        this.mCount = mCount;
        this.mContext = mContext;
        this.urlArrays = urlArrays;
        imageLoader = new ImageLoader(mContext);
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if( convertView == null ){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView)convertView.findViewById(R.id.tv_tips);
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.iv_image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) convertView.getTag();
        }
        String url = "";
        url = urlArrays[position % urlArrays.length];
        viewHolder.imageView.setImageResource(R.drawable.icon);
        //加载图片
        imageLoader.displayImage(url,viewHolder.imageView,false);

        if( !busy ){
            viewHolder.textView.setText("这是第"+position+"张图片...");
        }else{
            viewHolder.textView.setText("加载中...");
        }
        return convertView;
    }

    static class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
