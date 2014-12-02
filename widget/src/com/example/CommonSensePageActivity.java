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
 * Date: 14-12-2
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public class CommonSensePageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.common_sense);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);

        showPixelPage();

    }

    private void showPixelPage() {
        Button button = (Button)findViewById(R.id.pixel_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(CommonSensePageActivity.this,PixelPageActivity.class);
                startActivity(intent);
            }
        });
    }
}
