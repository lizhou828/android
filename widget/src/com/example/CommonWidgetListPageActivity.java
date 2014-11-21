package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-21
 * Time: 下午1:35
 * To change this template use File | Settings | File Templates.
 */
public class CommonWidgetListPageActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.common_widget_list);

        showCommonButton();
        showTextViewButton();
        showCheckBoxButton();
        showRadioGroupButton();
        showSpinnerButton();
        showAutoCompleteTextViewButton();
        showDatePickerButton();

        showProgressBarButton();
        showSeekBarButton();
        showRatingBarButton();
        showDialogPageButton();
        showTabButton();
        showEditViewButton();
    }
    private void showCheckBoxButton() {
        Button checkBoxButton = (Button)findViewById(R.id.check_box_button);
        checkBoxButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(CommonWidgetListPageActivity.this,CheckBoxActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,RadioGroupActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,SpinnerActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,DatePickerActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this, AutoCompleteTextViewActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,TextViewActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,TabDemoActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,DialogPageActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,RatingBarActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,SeekBarActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,ProgressBarActivity.class);
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
                intent.setClass(CommonWidgetListPageActivity.this,EditViewActivity.class);
                startActivity(intent);
            }
        });
    }

}
