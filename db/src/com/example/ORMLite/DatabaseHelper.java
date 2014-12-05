package com.example.ORMLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.model.XueSheng;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-5
 * Time: 下午3:34
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String databaseName = "ormlite.db";
    private static final int databaseVersion = 1;
    private Dao<XueSheng,Integer> studentDao = null;

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    //创建SQLite数据库
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, XueSheng.class);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(DatabaseHelper.class.getName(),"Unable to create databases",e);
        }
    }

    //更新SQLites数据库版本
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,XueSheng.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(DatabaseHelper.class.getName(),"Unable to upgrade databases from "+oldVersion +" to "+newVersion,e);
        }
    }

    public Dao<XueSheng,Integer> getStudentDao() throws SQLException {
        if( studentDao == null ){
            studentDao = getDao(XueSheng.class);
        }
        return studentDao;
    }
}
