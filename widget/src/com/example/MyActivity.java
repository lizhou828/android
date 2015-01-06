package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MyActivity extends Activity {
    //监听退出对话框中的button点击事件
    private DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            switch(which){
                case AlertDialog.BUTTON_POSITIVE:finish();  //确定退出“按钮”
                    break;
                case AlertDialog.BUTTON_NEGATIVE :   //取消退出“按钮”
                    break;
                default:break;
            }
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);



        showCommonSensePage();
        showFiveCommonLayout();
        showLayoutAdvancePage();
        showImageListPage();
        showCommonWidgetListPage();
        showHtmlPageButton();
        showMenuListPageButton();
        showStartActivityForResultDemoPage();
        showHorizonVerticalPage();
        showNotifyPage();
        showAndroidCorePage();
        showLoginPage();

        //check for updating
        UpdateManager updateManager = new UpdateManager(this);
        updateManager.checkUpdateInfo();


    }

    private void showLoginPage() {
        Button login = (Button)findViewById(R.id.to_login_page_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MyActivity.this,LoginActivity.class) );
            }
        });
    }

    private void showAndroidCorePage() {
        Button button = (Button)findViewById(R.id.android_core);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,AndroidCorePageActivity.class));
            }
        });
    }

    private void showCommonSensePage() {
        Button button = (Button)findViewById(R.id.common_sense_page);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,CommonSensePageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showLayoutAdvancePage() {
        Button button = (Button)findViewById(R.id.layout_advance_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,LayoutAdvancePageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showFiveCommonLayout() {
        Button button = (Button)findViewById(R.id.five_common_layout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,FiveCommonLayoutPageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showCommonWidgetListPage() {
        Button button = (Button)findViewById(R.id.common_widget_list_page);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,CommonWidgetListPageActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showImageListPage() {
       Button button = (Button)findViewById(R.id.image_list_page);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,ImageListPageActivity.class);
                startActivity(intent);
            }
        });
    }




    private void showNotifyPage() {
        Button notifyPageButton = (Button)findViewById(R.id.notify_page);
        notifyPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this, NotifyPageActivity.class);
                startActivity(intent);
            }
        });
    }

    //横竖屏切换页面
    private void showHorizonVerticalPage() {
        Button horizonVerticalPageButton = (Button)findViewById(R.id.horizon_and_vertical_page);
        horizonVerticalPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this, HorizonVerticalPageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showStartActivityForResultDemoPage() {
        Button demoPageButton = (Button)findViewById(R.id.startActivityForResultDemoPage);
        demoPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this, StartActivityForResultDemoPageActivity.class);
                startActivity(intent);
            }
        });


    }

    private void showMenuListPageButton() {
        Button menuListPageButton = (Button)findViewById(R.id.menu_list_page);
        menuListPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,MenuListPageActivity.class);
                startActivity(intent);
            }
        });

    }


    private void showHtmlPageButton() {
        Button htmlPageButton = (Button)findViewById(R.id.html_page_button);
        htmlPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,HtmlPageActivity.class);
                startActivity(intent);
            }
        });

    }


    /**
     * 监听Back键的两种方法，请勿一起使用
     *监听按下Back键事件:方法1
     *  super.onBackPressed();会自动调用finish()方法，关闭当前Activity
     *  若要屏蔽Back键，注释掉该行代码即可
     */
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Log.i(this.getClass().getName(),"You press the back button");
//    }


    /**
     * 监听按下Back键事件：方法2
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Log.i(this.getClass().getName(),"You press the back button");
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("系统提示:");
            alertDialog.setMessage("您确定要退出吗?");
            alertDialog.setButton("确定",listener);
            alertDialog.setButton2("取消", listener);

//            Sources code:
//            @Deprecated
//            public void setButton(CharSequence text, final OnClickListener listener) {
//                setButton(BUTTON_POSITIVE, text, listener);
//            }
//            public void setButton2(CharSequence text, final OnClickListener listener) {
//                setButton(BUTTON_NEGATIVE, text, listener);
//            }
//            public void setButton3(CharSequence text, final OnClickListener listener) {
//                setButton(BUTTON_NEUTRAL, text, listener);
//            }

            alertDialog.show();
            return false;
        }else{
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.getClass().getName(),"onDestroy is running....");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(this.getClass().getName(),"onStop is running...");
    }
}
