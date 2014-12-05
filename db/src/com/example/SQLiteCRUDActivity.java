package com.example;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-5
 * Time: 上午11:15
 * To change this template use File | Settings | File Templates.
 */
public class SQLiteCRUDActivity extends Activity implements View.OnClickListener {
    public static final String DB_NAME = "student_data.db";
    private ListView mListView;
    private Button insertButton;
    private Button updateAgeButton;
    private Button updateGradeButton;
    private Button deleteButton;
    private Button selectButton;
    private Button displayDbButton;
    private Button closeButton;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_crud);
        mListView  = new ListView(this);

        //初始化页面按钮的点击事件
        initButton();

        openDB();
        createTable();

    }

    private void createTable() {
        db.execSQL("drop table if exists students");
        String createTableSql = "create table if not exists students(" +
                "id integer primary key autoincrement," +
                "name varchar," +
                "age integer," +
                "grade integer," +
                "info varchar" +
                ")";
        db.execSQL(createTableSql);
    }

    private void initButton() {
        insertButton = (Button)findViewById(R.id.insert);
        insertButton.setOnClickListener(this);

        updateAgeButton = (Button)findViewById(R.id.updateAge);
        updateAgeButton.setOnClickListener(this);

        updateGradeButton = (Button)findViewById(R.id.updateGrade);
        updateGradeButton.setOnClickListener(this);

        deleteButton = (Button)findViewById(R.id.delete);
        deleteButton.setOnClickListener(this);

        selectButton = (Button)findViewById(R.id.select);
        selectButton.setOnClickListener(this);

        displayDbButton = (Button)findViewById(R.id.display_current_db);
        displayDbButton.setOnClickListener(this);

        closeButton = (Button)findViewById(R.id.close);
        closeButton.setOnClickListener(this);

        mListView = (ListView)findViewById(R.id.sqlite_crud_list_view);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.insert : insertData();
                break;
            case R.id.updateAge :updateAge();
                break;
            case R.id.updateGrade : updateGrade();
                break;
//            case R.id.display_current_db : displayDB();
//                break;
            case R.id.select: select();
                break;
            case R.id.delete : delete();
                break;
            case R.id.close :close();
                break;
            case  R.id.open :openDB();
                break;
        }

    }

    private void openDB() {
        if( db == null ){
            db = openOrCreateDatabase(DB_NAME,this.MODE_PRIVATE,null);
        }
    }

    private void select() {
        if( ! db.isOpen() ){
            Toast.makeText(this,"数据库已关闭",Toast.LENGTH_SHORT).show();
            return;
        }

        List<String> list = new ArrayList<String>();
        String querySql= "select * from students ";
        Cursor cursor = db.rawQuery(querySql, new String[]{});
        Student student =null;
        while( cursor.moveToNext() ){
            student = new Student();
            student.setId( cursor.getInt( cursor.getColumnIndex("id") ) );
            student.setName(  cursor.getString(cursor.getColumnIndex("name"))  );
            student.setGrade(  cursor.getInt(cursor.getColumnIndex("grade"))  );
            student.setAge(  cursor.getInt(cursor.getColumnIndex("age"))  );
            student.setInfo( cursor.getString(cursor.getColumnIndex("info"))   );
            String string = ""+student.getId()+" "+student.getName()+" "+student.getGrade()
                    +" "+student.getAge()+" "+student.getInfo();
            list.add(string);
            Log.d("msg",string);
        }
        cursor.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        mListView.setAdapter(adapter);
    }

    private void close() {
        db.close();
    }

    private void delete() {
        if( ! db.isOpen() ){
            Toast.makeText(this,"数据库已关闭",Toast.LENGTH_SHORT).show();
            return;
        }

        db.execSQL("delete from students where name='张三'");
        Log.d("msg","张三的信息已经被删除");
        Toast.makeText(this,"张三的信息已经被删除",Toast.LENGTH_SHORT).show();
    }



    private void updateGrade() {
        if( ! db.isOpen() ){
            Toast.makeText(this,"数据库已关闭",Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("grade",80);
        db.update("students",contentValues,"name=?" ,new String[]{"赵六"});
        Log.d("msg","赵六的成绩已更新");
        Toast.makeText(this, "赵六的成绩已更新", Toast.LENGTH_SHORT).show();
    }

    private void updateAge() {
        if( ! db.isOpen() ){
            Toast.makeText(this,"数据库已关闭",Toast.LENGTH_SHORT).show();
            return;
        }

        String sqlString="UPDATE students SET age=18 WHERE name='李四'";
        db.execSQL(sqlString);
        Log.d("msg","李四的年龄已更新");
        Toast.makeText(this, "李四的年龄已更新", Toast.LENGTH_SHORT).show();
    }

    private void insertData() {
        if( ! db.isOpen() ){
            Toast.makeText(this,"数据库已关闭",Toast.LENGTH_SHORT).show();
            return;
        }

        Student lisi = new Student("李四",23,56,"湖南师范大学 外语系");
        Student wangwu = new Student("王五",24,66,"北京大学 中文系");
        db.execSQL("insert into students values(null,?,?,?,?)" ,new Object[]{
                "张三",21,48,"清华大学 信工系"
        });
        db.execSQL("insert into students values(null,?,?,?,?)" ,new Object[]{
                "赵六",25,62,"清华大学 历史系"
        });
        db.execSQL("insert into students values(null,?,?,?,?)" ,new Object[]{
              lisi.getName(),lisi.getAge(),lisi.getGrade(),lisi.getInfo()
        });

        ContentValues contentValues = new ContentValues();
        contentValues.put("name",wangwu.getName());
        contentValues.put("age",wangwu.getAge());
        contentValues.put("grade",wangwu.getGrade());
        contentValues.put("info",wangwu.getInfo());
        db.insert("students",null,contentValues);
        Log.d("msg","插入数据结束");
        Toast.makeText(this,"插入数据结束",Toast.LENGTH_SHORT).show();
    }
}
