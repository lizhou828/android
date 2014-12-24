package com.example.cache;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-24
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */
public class MemoryCache {
    private static final String TAG ="MemoryCache";
    //放入缓存时，是一个同步操作
    //LinkedHashMap构造方法的介绍：
    //      最后一个参数true代表这个map里的元素将按照最近使用次数由少
    //      到多排列，即LRU(least recently used),这样做的好处是:如果要将缓存中的元素替换，
    //      则先遍历出最近最少使用的元素来替换，以提高效率
    //      如果最后一个参数false,则表示按照插入的顺序排序

    private Map<String,Bitmap> cache = Collections.synchronizedMap( new LinkedHashMap<String, Bitmap>(10,1.5f,true) );

    //缓存中图片所占的字节，初始0，将通过此变量严格控制缓存所占用的堆内存
    private Long size = 0L;

    //缓存中只能占用的最大堆内存
    private Long limit = 1000000L;

    public MemoryCache() {
        //use 25% of available heap size
        setLimit( Runtime.getRuntime().maxMemory() / 10 );
    }

    public void setLimit( Long new_limit ){
        limit = new_limit;
        Log.i(TAG,"MemoryCache will use up to " + limit /1024./1024.+"MB");
    }

    public Bitmap get(String id){
        try{
            if( !cache.containsKey(id) ) return null;
            return cache.get(id);
        }catch (NullPointerException e){
            return null;
        }
    }

    public void  put(String id,Bitmap bitmap){
        try{
            if( cache.containsKey(id) ) size -= getSizeInBytes(bitmap);
            cache.put(id,bitmap);
            size += getSizeInBytes(bitmap);
            checkSize();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    //严格控制堆内存，如果超过，则先替换最近最少使用的那个图片缓存
    private void checkSize() {
        Log.i(TAG,"cache size = " + size + " ,length = "+cache.size());
        if(size >= limit){
            //先遍历最近最少使用的元素
            Iterator<Map.Entry<String,Bitmap>> iterator = cache.entrySet().iterator();
            while (iterator.hasNext() ){
                Map.Entry<String,Bitmap> entry  = iterator.next();
                size -= getSizeInBytes( entry.getValue() );
                iterator.remove();
                if( size <= limit ) break;
            }
            Log.i(TAG,"Clean cache,new size = "+cache.size() );
        }

    }

    //图片占用 的 内存
    long getSizeInBytes( Bitmap bitmap ){
        if( bitmap == null ) return 0;
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public void clear(){
        cache.clear();
    }
}
