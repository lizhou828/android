package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-8
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class SQLiteIntroActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.sqlite_login);
        String text = "SQLite 是一个开源的嵌入式关系数据库，它可以减少应用程序管理数据的开销 ， SQLite 可移植性好 、 很容易使用 、 很小 、 高效而且可靠 。目前在Android 系统中集成的是 SQLite3 版本 ，SQLite 不支持静态数据类型 ， 而是使用列关系 。 这意味着它的数据类型不具有表列属性 ， 而具有数据本身的属性 。 当某个值插入数据库时， SQLite 将检查它的类型。如果该类型与关联的列不匹配，则 SQLite 会尝试将该值转换成列类型。如果不能转换，则该值将作为其本身具有的类型存储。SQLite 支持 NULL 、INTEGER 、 REAL 、 TEXT 和 BLOB 数据类型。例如：可以在 Integer 字段中存放字符串，或者在布尔型字段中存放浮点数，或者在字符型字段中存放日期型值。但是有一种例外，如果你的主键是 INTEGER ，那么只能存储 6 4位整数 ， 当向这种字段中保存除整数以外的数据时， 将会产生错误 。 另外 ， SQLite 在解 析REATE TABLE语句时，会忽略 CREATE TABLE 语句中跟在字段名后面的数据类型信息。" +
                "SQLite 的特点\n" +
                "\n" +
                "SQlite数据库总结起来有五大特点:\n" +
                "\n" +
                "1. 零配置\n" +
                "\n" +
                "SQlite3不用安装、不用配置、不用启动、关闭或者配置数据库实例。当系统崩溃后不用做任何恢复操作，在下次使用数据库的时候自动恢复。\n" +
                "\n" +
                "2. 可移植\n" +
                "\n" +
                "它是运行在 Windows 、 Linux 、BSD 、 Mac OS X 和一些商用 Unix 系统， 比如 Sun 的 Solaris 、IBM 的 AIX ，同样，它也可以工作在许多嵌入式操作系统下，比如 Android 、 QNX 、VxWorks、 Palm OS 、 Symbin 和 Windows CE 。\n" +
                "\n" +
                "3. 紧凑\n" +
                "\n" +
                "SQLite是被设计成轻量级、自包含的。一个头文件、一个 lib 库，你就可以使用关系数据库了，不用任何启动任何系统进程。\n" +
                "\n" +
                "4. 简单\n" +
                "\n" +
                "SQLite有着简单易用的 API 接口。\n" +
                "\n" +
                "5. 可靠\n" +
                "\n" +
                "SQLite的源码达到 100% 分支测试覆盖率。";
        TextView textView = (TextView)findViewById(R.id.sqlite_intro_text);
        textView.setText(text);

        Button button = (Button)findViewById(R.id.register_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SQLiteIntroActivity.this,RegisterActivity.class));
            }
        });

        login();

    }

    private void login() {
        final EditText username = (EditText)findViewById(R.id.user_name);
        final EditText password = (EditText)findViewById(R.id.pass_word);
        Button loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserService userService = new UserService(SQLiteIntroActivity.this);
                String name = username.getText().toString();
                //检查用户是否存在
                Boolean exist = userService.userExists(name);
                if (!exist){
                    Log.i("msg","用户不存在!");
                    Toast.makeText(SQLiteIntroActivity.this,"用户不存在!",Toast.LENGTH_SHORT).show();
                    return;
                }

                String pass = password.getText().toString();
                Log.i("msg",name+"_"+pass);

                Boolean flag = userService.login(name,pass);
                if (flag){
                    Log.i("msg","登录成功");
                    Toast.makeText(SQLiteIntroActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                }else{
                    Log.i("msg","密码错误");
                    Toast.makeText(SQLiteIntroActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
