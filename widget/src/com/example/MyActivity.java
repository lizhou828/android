package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MyActivity extends Activity {
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






}
