package com.example.cache;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-24
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
public class ImageLoader {
    private MemoryCache memoryCache = new MemoryCache();
    private AbstractFileCache fileCache;
    private Map<ImageView,String> imageViewMap  = Collections.synchronizedMap( new WeakHashMap<ImageView, String>() );
    //线程池
    private ExecutorService executorService;

    public ImageLoader(Context context) {
        fileCache = new FileCache(context);
        executorService = Executors.newFixedThreadPool(5);
    }

    //最主要的方法
    public void displayImage( String url,ImageView imageView,Boolean isLoadOnlyForCache ){
        imageViewMap.put(imageView,url);

        //先从内存缓中查找
        Bitmap bitmap = memoryCache.get(url);
        if( bitmap != null ){
            imageView.setImageBitmap( bitmap );
        //若没有，则开启新线程加载图片
        }else if( !isLoadOnlyForCache ){
            queueImage(url,imageView);
        }

    }

    private void queueImage(String url, ImageView imageView) {
        PhotoToLoad photoToLoad= new PhotoToLoad(url,imageView);
        executorService.submit( new ImageLoaderThread(photoToLoad) );
    }

    private class ImageLoaderThread implements  Runnable {
        PhotoToLoad photoToLoad;
        public ImageLoaderThread(PhotoToLoad photoToLoad) {
            this.photoToLoad = photoToLoad;
        }
        @Override
        public void run() {
            //在内存缓存中查找，
            if( imageViewReused(photoToLoad) ) return;

            //根据图片 url 生成 bitmap（查找策略是：从文件去查找，如果没有就去下载）
            Bitmap bitmap = getBitmap(photoToLoad.url);

            memoryCache.put(photoToLoad.url,bitmap);
            if( imageViewReused(photoToLoad) ) return;

            //用户在UI线程中 更新界面
            BitmapDisplayThread bitmapDisplayThread = new BitmapDisplayThread(bitmap,photoToLoad);
            Activity activity = (Activity)photoToLoad.imageView.getContext();
            activity.runOnUiThread(bitmapDisplayThread);
        }
    }

    //防止图片错位
    boolean imageViewReused(PhotoToLoad photoToLoad){
        String url = imageViewMap.get(photoToLoad.imageView);
        if( url == null || !photoToLoad.url.equals(url) ) return true;
        return false;
    }

    //用户在UI线程中 更新界面
    class BitmapDisplayThread implements Runnable{
        Bitmap bitmap;
        PhotoToLoad photoToLoad;
        BitmapDisplayThread(Bitmap bitmap, PhotoToLoad photoToLoad) {
            this.bitmap = bitmap;
            this.photoToLoad = photoToLoad;
        }
        @Override
        public void run() {
            if(imageViewReused(photoToLoad)) return;
            if( bitmap != null ) photoToLoad.imageView.setImageBitmap(bitmap);
        }
    }

    public void clearCache(){
        memoryCache.clear();
        fileCache.clear();
    }

    public static void copyStream(InputStream inputStream,OutputStream outputStream){
        final int bufferSize = 1024;
        try{
            byte [] bytes = new byte[bufferSize];
            for (;;){
                int  count = inputStream.read(bytes,0,bufferSize);
                if( count == -1 ) break;
                outputStream.write( bytes,0 ,count);
            }
        }catch (Exception e){
            Log.e("","copyStream catch Exception.....");
        }
    }

    private Bitmap getBitmap( String url ){
        File file = fileCache.getFile( url );
        //从文件缓存中查找是否存在
        Bitmap bitmap = null;
        if( file != null && file.exists() ) bitmap = decodeFile( file );
        if( bitmap != null ) return bitmap;
        try {
            URL imageUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)imageUrl.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.setInstanceFollowRedirects(true);
            InputStream inputStream = connection.getInputStream();
            OutputStream outputStream = new FileOutputStream( file );
            copyStream( inputStream,outputStream );
            outputStream.close();
            bitmap = decodeFile(file);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("","getBitmap catch Exception...message="+e.getMessage());
            return null;
        }

    }

    /**
     * decode这个图片，并且按比例缩放以减少内存消耗，
     * 虚拟机对每张图片的缓存大小也是有限制的
     * @param file
     * @return
     */
    private Bitmap decodeFile(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream( new FileInputStream(file),null,options );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("","decode File to File error....exception = " + e.getMessage() );
            return null;
        }
        //find a correct scale value,it should be the power of 2
        //找一个合适的缩放比例值，应该是它的2次幂
        final int requiredSize  = 100;
        int widthTemp = options.outWidth,heightTemp = options.outHeight;
        int scale = 1;
        while (true){
            if( widthTemp / 2 < requiredSize || heightTemp /2 < requiredSize) break;
            widthTemp /= 2;
            heightTemp /= 2;
            scale *= 2;
        }
        BitmapFactory.Options options1 = new BitmapFactory.Options();
        options1.inSampleSize = scale;
        try {
            return  BitmapFactory.decodeStream(new FileInputStream(file),null,options1);
        } catch (FileNotFoundException e) {
            Log.e("","decode File to File error again....exception = " + e.getMessage() );
            e.printStackTrace();
            return null;
        }
    }
    private class PhotoToLoad {
        public String url;
        public ImageView imageView;
        public PhotoToLoad(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }
    }
}
