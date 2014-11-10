package com.example;

import android.app.*;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: lizhou
 * Date: 14-11-9
 * Time: 上午12:52
 * To change this template use File | Settings | File Templates.
 */
public class DialogPageActivity extends Activity {
    private Button alertDialog;
    private Button dateDialog;
    private Button timeDialog;
    private Button progressDialog;
    Calendar dateAndTime = Calendar.getInstance();
    final int alert_dialog_num = 1 ;
    final int date_dialog_num = 2 ;
    final int time_dialog_num = 3 ;
    final int progress_dialog_num = 4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.dialog_page);
        findWidget();
    }

    private void findWidget() {
        alertDialog = (Button) findViewById(R.id.alert_dialog);
        dateDialog = (Button) findViewById(R.id.date_pick_dialog);
        timeDialog = (Button) findViewById(R.id.time_pick_dialog);
        progressDialog = (Button) findViewById(R.id.progress_dialog);

        alertDialog.setOnClickListener( onClickListener );
        dateDialog.setOnClickListener( onClickListener );
        timeDialog.setOnClickListener( onClickListener );
        progressDialog.setOnClickListener( onClickListener );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch ( id ){
             case alert_dialog_num :
                 Dialog dialog = new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("这是一个弹出框")
                         .setMessage("一个自己设置的对话框哦，好看不?").setNegativeButton("不好看...",buttonOptionClickListener)
                         .setNeutralButton("一般般",buttonOptionClickListener).setPositiveButton("很喜欢!",buttonOptionClickListener).create();
                 return dialog;
            case date_dialog_num :
                DatePickerDialog datePickerDialog = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dateOfMonth) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }
                },dateAndTime.get(Calendar.YEAR),dateAndTime.get(Calendar.MONTH),dateAndTime.get(Calendar.DAY_OF_MONTH));
                return datePickerDialog;
            case time_dialog_num :
                TimePickerDialog timePickerDialog = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }
                },dateAndTime.get(Calendar.HOUR_OF_DAY),dateAndTime.get(Calendar.MINUTE),true);
                return timePickerDialog;
            case progress_dialog_num :
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                return progressDialog;
        }
        return null;
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case  R.id.alert_dialog :
                    showDialog(alert_dialog_num); break;
                case R.id.date_pick_button :
                    showDialog(date_dialog_num); break;
                case R.id.time_pick_dialog :
                    showDialog(time_dialog_num); break;
                case R.id.progress_dialog:
                    showDialog(progress_dialog_num); break;
            }
        }
    };

    DialogInterface.OnClickListener buttonOptionClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            switch (which){
                case Dialog.BUTTON_NEGATIVE :
                    break;
                case Dialog.BUTTON_NEUTRAL :
                    break;
                case Dialog.BUTTON_POSITIVE :
                    break;
            }
        }
    };
}
