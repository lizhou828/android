package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-10-29
 * Time: 下午5:47
 * To change this template use File | Settings | File Templates.
 */
public class EditViewActivity extends Activity {
    private View.OnClickListener editViewButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText editText= (EditText)findViewById(R.id.edit_view);
            CharSequence text = editText.getText();
            setTitle("EditText的值："+text);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_view);

        Button  editViewButton = (Button)findViewById(R.id.edit_view_button);
        editViewButton.setOnClickListener(editViewButtonListener);

    }
}
