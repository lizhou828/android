package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity implements View.OnClickListener {
    private Button loadPictureButton;
    private Button listViewLoadPicButton;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        loadPictureButton.setOnClickListener(this);

    }

    private void initView() {
        loadPictureButton = (Button)findViewById(R.id.load_picture_button);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.load_picture_button :
                startActivity( new Intent( MyActivity.this,LoadPictureActivity.class ) );
                break;
            default:break;
        }
    }
}
