package com.example;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-12
 * Time: 下午5:54
 * Addr: http://www.open-open.com/lib/view/open1322529319718.html
 * Desc：Android 软件自动更新功能的实现
 */
public class UpdateManager {
    private Context mContext;
    private String updateMsg = "有最新的软件包哦，亲快下载吧";
    private AlertDialog noticeDialog;
    private boolean interceptFlag;
    private AlertDialog downloadDialog;
    private Thread downLoadThread;
    //安装包的url
    private String apkUrl="http://www.lizhou828.com/data/2014/12-10/widget.apk";
    //下载包安装路径
    private String savePath = "/sdcard/updatedemo/";
    private String saveFileName = savePath + "UpdateDemoRelease.apk";
    //进度条与通知UI刷新的handler和msg常量
    private MyProgressBar mProgress;
    private static final int DOWN_UPDATE=1;
    private static final int DOWN_OVER=2;
    private int progress;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case DOWN_UPDATE :
                    Log.i("正在下载最新的软件包......","progress="+progress+",mProgress.getMax()=" + mProgress.getMax() );
                    mProgress.setProgress(progress); break;
                case DOWN_OVER : installApk();break;
                default:break;
            }
        }
    };

    private void installApk() {
        File apkFile = new File(saveFileName);
        if( !apkFile.exists()){
            apkFile.mkdir();
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://"+apkFile.toString()),"application/vnd.android.package-archive");
        mContext.startActivity(intent);
    }



    private Runnable mDownApkRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(apkUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.connect();
                int length = httpURLConnection.getContentLength();
                InputStream inputStream = httpURLConnection.getInputStream();

                //创建apk文件下载目录
                File file = new File(savePath);
                if( !file.exists() ){
                    file.mkdir();
                }

                //用输出流读取正在下载的apk文件
                String apkFileName = saveFileName;
                File apkFile = new File(apkFileName);
                FileOutputStream fileOutputStream = new FileOutputStream(apkFile);
                int count = 0;
                byte [] bytes = new byte[1024];
                do{
                    //每次读取1KB
                    int numberRead = inputStream.read(bytes);
                    count += numberRead;
                    progress = (int)( (((float)count)/length)*100 );

                    //更新进度条
                    mHandler.sendEmptyMessage(DOWN_UPDATE);
                    if(numberRead <= 0 ){
                        //下载完成后，通知用户去安装apk
                        mHandler.sendEmptyMessage(DOWN_OVER);
                        break;
                    }
                    fileOutputStream.write(bytes,0,numberRead);
                }while( !interceptFlag);//点击取消,就停止下载
                fileOutputStream.close();
                inputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("msg",e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("msg",e.getMessage());
            }
        }
    };


    public UpdateManager(Context context) {
        this.mContext = context;
    }

    //提供对外接口，然MyActivity访问
    public void checkUpdateInfo() {
        showNoticeDialog();
    }

    private void showNoticeDialog() {
        AlertDialog.Builder builder =  new AlertDialog.Builder(mContext);
        builder.setTitle("软件版本更新");
        builder.setMessage(updateMsg);
        builder.setPositiveButton("下载",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                showDownloadDialog();
            }
        });
        builder.setNegativeButton("以后再说",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        noticeDialog = builder.create();
        noticeDialog.show();
    }

    private void showDownloadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("软件版本更新");

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.progress, null);
        mProgress = (MyProgressBar)view.findViewById(R.id.progress);
        builder.setView(view);

        builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                interceptFlag = true;
            }
        });
        downloadDialog = builder.create();
        downloadDialog.show();
        downloadApk();

    }

    private void downloadApk() {
        downLoadThread = new Thread(mDownApkRunnable);
        downLoadThread.start();
    }
}
