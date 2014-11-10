package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-3
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public class DatePickerActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.date_picker);
        DatePicker datePicker = (DatePicker)findViewById(R.id.date_picker);
        datePicker.init(2014,11,3,null);

        TimePicker timePicker = (TimePicker)findViewById(R.id.time_picker);
        timePicker.setIs24HourView(true);

    }
}
