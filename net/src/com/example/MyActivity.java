package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity implements View.OnClickListener {
    private Button webServiceButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        initViews();

        webServiceButton.setOnClickListener(this);
    }

    private void initViews() {
        webServiceButton = (Button)findViewById(R.id.net_web_service);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.net_web_service :
                startActivity(new Intent(MyActivity.this,WeatherForecastActivity.class));
                break;
            default:break;
        }
    }
}
