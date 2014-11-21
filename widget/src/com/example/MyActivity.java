package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        showImageViewButton();
        showImageButton();
        showImageSwitchGallery();
        showBigImagePage();
        showCommonButton();
        showTextViewButton();
        showEditViewButton();
        showCheckBoxButton();
        showRadioGroupButton();
        showSpinnerButton();
        showAutoCompleteTextViewButton();
        showDatePickerButton();
        showHtmlPageButton();
        showProgressBarButton();
        showSeekBarButton();
        showRatingBarButton();
        showDialogPageButton();
        showTabButton();
        showMenuListPageButton();
        showStartActivityForResultDemoPage();
        showHorizonVerticalPage();
        showNotifyPage();


    }

    private void showBigImagePage() {
        Button imagePageButton = (Button)findViewById(R.id.image_small_enlarge);
        imagePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this, BigImageActivity.class);
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

    private void showTabButton() {
        Button tabButton = (Button)findViewById(R.id.tab_button);
        tabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,TabDemoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showDialogPageButton() {
        Button imageButton = (Button)findViewById(R.id.dialog_page);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,DialogPageActivity.class);
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
                intent.setClass(MyActivity.this,ImageSwitchGalleryActivity.class);
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
                intent.setClass(MyActivity.this,ImageButtonActivity.class);
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
                intent.setClass(MyActivity.this,ImageViewActivity.class);
                startActivity(intent);
            }
        });


    }

    private void showRatingBarButton() {
        Button ratingBar = (Button)findViewById(R.id.rating_bar_button);
        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,RatingBarActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showSeekBarButton() {
        Button progressBar = (Button)findViewById(R.id.seek_bar_button);
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,SeekBarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showProgressBarButton() {
        Button progressBar = (Button)findViewById(R.id.progress_bar_button);
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,ProgressBarActivity.class);
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

    private void showDatePickerButton() {
        Button datePickButton = (Button)findViewById(R.id.date_pick_button);
        datePickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,DatePickerActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showAutoCompleteTextViewButton() {
        Button autoCompleteButton = (Button)findViewById(R.id.auto_complete_button);
        autoCompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this, AutoCompleteTextViewActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showCommonButton() {
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("哎呦，确定按钮被点了一下");
            }
        });
    }


    private void showTextViewButton() {
        Button textViewButton = (Button)findViewById(R.id.text_view_button);
        textViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,TextViewActivity.class);
                startActivity(intent);
            }
        });
    }
    private void showEditViewButton() {
        Button editViewButton =  (Button)findViewById(R.id.edit_view_button);
        editViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,EditViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showCheckBoxButton() {
        Button checkBoxButton = (Button)findViewById(R.id.check_box_button);
        checkBoxButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(MyActivity.this,CheckBoxActivity.class);
                    startActivity(intent);
                }
            }
        );
    }

    private void showRadioGroupButton() {
        Button radioGroupButton = (Button)findViewById(R.id.radio_group_button);
        radioGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,RadioGroupActivity.class);
                startActivity(intent);
            }
        });
    }
    private void showSpinnerButton() {
        Button spinnerButton = (Button)findViewById(R.id.spinner_button);
        spinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,SpinnerActivity.class);
                startActivity(intent);
            }
        });
    }

}
