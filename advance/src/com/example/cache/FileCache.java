package com.example.cache;

import android.content.Context;
import com.example.util.FileManager;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-24
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */
public class FileCache extends AbstractFileCache {

    public FileCache(Context context) {
        super(context);
    }

    @Override
    public String getSavePath(String url) {
        String fileName = String.valueOf( url.hashCode() );
        return getCacheDir() + fileName;
    }

    @Override
    public String getCacheDir() {
        return FileManager.getSaveFilePath();
    }
}
