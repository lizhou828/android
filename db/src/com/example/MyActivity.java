package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.ORMLite.MainActivity;

public class MyActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button1 = (Button)findViewById(R.id.sqlite_crud_button);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.db_page_button);
        button2.setOnClickListener(this);

        Button button3 = (Button)findViewById(R.id.sqlite_introduce_button);
        button3.setOnClickListener(this);

        Button button4 = (Button)findViewById(R.id.ormlite_crud_button);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sqlite_crud_button :
                Intent intent = new Intent(MyActivity.this,SQLiteCRUDActivity.class);
                startActivity(intent);
                break;
            case R.id.db_page_button :
                startActivity(new Intent(MyActivity.this,DBListPageActivity.class));
                break;
            case R.id.sqlite_introduce_button :
                startActivity(new Intent(MyActivity.this,SQLiteIntroActivity.class));
                break;
            case R.id.ormlite_crud_button :
                startActivity(new Intent(MyActivity.this, MainActivity.class));
            default:break;
        }
    }
}
