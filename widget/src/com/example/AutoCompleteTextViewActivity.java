package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-3
 * Time: 下午5:36
 * To change this template use File | Settings | File Templates.
 */
public class AutoCompleteTextViewActivity extends Activity{
    private  static final String[] countries = {"China","Russia","America","Canada","England","Italy",
            "South Africa","Germany","Australia","Vietnam","Korea","Mexico","Brazil","Singapore","French"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.auto_complete_text_view);
        setTitle("AutoCompleteTextViewActivity");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,countries);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.auto_complete);
        autoCompleteTextView.setAdapter(adapter);

    }
}
