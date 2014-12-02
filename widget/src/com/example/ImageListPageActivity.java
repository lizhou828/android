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
 * Date: 14-11-21
 * Time: 上午11:59
 * To change this template use File | Settings | File Templates.
 */
public class ImageListPageActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.image_list_page);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.head);

        showImageViewButton();
        showImageButton();
        showImageSwitchGallery();
        showBigImagePage();
    }

    private void showBigImagePage() {
        Button imagePageButton = (Button)findViewById(R.id.image_small_enlarge);
        imagePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ImageListPageActivity.this, BigImageActivity.class);
                startActivity(intent);
            }
        });

    }
    private void showImageSwitchGallery() {
        Button imageButton = (Button)findViewById(R.id.image_show_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ImageListPageActivity.this,ImageSwitchGalleryActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showImageButton() {
        Button imageButton = (Button)findViewById(R.id.image_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ImageListPageActivity.this,ImageButtonActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showImageViewButton() {
        Button imageButton = (Button)findViewById(R.id.photo_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ImageListPageActivity.this,ImageViewActivity.class);
                startActivity(intent);
            }
        });


    }
}


