package com.example.ORMLite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.example.R;
import com.example.model.XueSheng;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-5
 * Time: 下午3:28
 * To change this template use File | Settings | File Templates.
 */
public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    private EditText stuNO;
    private EditText stuName;
    private EditText stuAge;
    private EditText stuSex;
    private EditText stuScore;
    private EditText stuAddress;

    private Bundle mBundle;

    private final int MENU_ADD=Menu.FIRST;
    private final int MENU_VIEWALL=Menu.FIRST+1;
    private final int MENU_EDIT=Menu.FIRST+2;
    private XueSheng mStudent;
    private Dao<XueSheng, Integer> stuDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.student_add);
        initViews();
    }

    private void initViews() {
        stuNO = (EditText)findViewById(R.id.stuno);
        stuName = (EditText)findViewById(R.id.name);
        stuAge = (EditText)findViewById(R.id.age);
        stuSex = (EditText)findViewById(R.id.sex);
        stuScore = (EditText)findViewById(R.id.score);
        stuAddress = (EditText)findViewById(R.id.address);

        mBundle = getIntent().getExtras();
        if( mBundle != null && mBundle.getString("action").equals("viewone")){
            mStudent = (XueSheng)getIntent().getSerializableExtra("entity");
            setStudentUIData(mStudent);
        }
        if( mBundle != null && mBundle.getString("action").equals("edit")){
            mStudent = (XueSheng)getIntent().getSerializableExtra("entity");
            setStudentUIData(mStudent);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(mBundle != null && mBundle.getString("action").equals("viewone")){
            return false;
        }else{
            return super.onPrepareOptionsMenu(menu);    //To change body of overridden methods use File | Settings | File Templates.
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(mBundle != null && mBundle.getString("action").equals("edit")){
            menu.add(1,MENU_EDIT,0,"保存");
        }else{
            menu.add(0,MENU_ADD,0,"增加");
            menu.add(0,MENU_VIEWALL,0,"查看");
        }
        return super.onCreateOptionsMenu(menu);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ADD:
                try {
                    stuDao = getHelper().getStudentDao();
                    getStudentData();
                    if(mStudent != null){
                        //创建记录项
                        stuDao.create(mStudent);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case MENU_VIEWALL:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, StudentListActivity.class);
                startActivity(intent);
                break;
            case MENU_EDIT:
                try {
                    getStudentData();
                    stuDao = getHelper().getStudentDao();
                    if(mStudent != null){
                        //更新某记录项
                        stuDao.update(mStudent);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //赋值给UI界面
    private void setStudentUIData(XueSheng student) {
        stuNO.setText(student.getStuNO());
        stuName.setText(student.getName());
        stuAge.setText(String.valueOf(student.getAge()));
        stuSex.setText(student.getSex());
        stuScore.setText(String.valueOf(student.getScore()));
        stuAddress.setText(student.getAddress());
    }
    private  void getStudentData(){
        mStudent = new XueSheng();
        mStudent.setStuNO(stuNO.getText().toString());
        mStudent.setName(stuName.getText().toString());
        mStudent.setAge(Integer.parseInt(stuAge.getText().toString()));
        mStudent.setSex(stuSex.getText().toString());
        mStudent.setScore(Double.parseDouble(stuScore.getText().toString()));
        mStudent.setAddress(stuAddress.getText().toString());
    }
}
