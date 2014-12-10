package com.example.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.model.User;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-9
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
public class UserService {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase databaseRead;

    public UserService() {
    }

    public UserService(Context context) {
        this.dataBaseHelper = new DataBaseHelper(context);
        databaseRead = dataBaseHelper.getReadableDatabase();
    }

    public boolean userExists(String username){
        if(username == null || "".equals(username) || "null".equalsIgnoreCase(username)){
            return false;
        }
        String sql = "select * from user where username=?";
        Cursor cursor = databaseRead.rawQuery(sql, new String[]{username});
        if( cursor.moveToFirst() )  return true;
        cursor.close();
        return  false;
    }

    //登录逻辑
    public boolean login(String username,String password){
        String sql = "select * from user where username=? and password=?";
        Cursor cursor = databaseRead.rawQuery(sql, new String[]{username, password});
        if( cursor.moveToFirst() ){
            cursor.close();
            return true;
        }
        return  false;
    }

    //注册逻辑
    public boolean register(User user){
        String sql = "insert into user(username,password,age,gender,married)values(?,?,?,?,?)";
        Object obj[] = {user.getUsername(),user.getPassword(),user.getAge(),user.getGender(),user.getMarried()};
        try{
            databaseRead.execSQL(sql,obj);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return  true;

    }

}
