package com.example.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-9
 * Time: 上午10:17
 * Desc : 为了实现对数据库版本进行管理，SQLiteOpenHelper类提供了两个重要的方法
 *        onCreate(SQLiteDatabase db) 用于初次使用软件时，生成数据库表
 *        onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)用于升级软件时，更新数据库表结构
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    static String dbName ="user.db";
    static int dbVersion = 1;

    public DataBaseHelper(Context context) {
        super(context, dbName,null, dbVersion);
    }

    //只在创建的时候，调用一次
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create Table user(" +
                "id integer primary key autoincrement," +
                "username varchar(32)," +
                "password varchar(32)," +
                "age integer(3)," +
                "gender varchar(6)," +
                "married varchar(10)" +
                ")";
        db.execSQL(sql);
//        SQLiteDatabase.execSQL(sql)可以用来执行非查询的SQL语句（不会有结果集返回），
//        包括create table/ drop table/ insert into
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
