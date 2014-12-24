package com.example.cache;

import android.content.Context;
import android.util.Log;
import com.example.util.FileHelper;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-24
 * Time: 上午10:17
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFileCache {
    private String dirString;

    public AbstractFileCache(Context context) {
        dirString = getCacheDir();
        boolean  ret = FileHelper.createDirectory(dirString);
        Log.i( "","FileHelper.createDirectory:"+dirString+",ret = "+ret );
    }
    public File getFile(String url){
        return  new File(getSavePath(url));
    }

    public abstract String getSavePath(String url);
    public abstract String getCacheDir();

    public void clear(){
        FileHelper.deleteDirectory(dirString);
    }

}
