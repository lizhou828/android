package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-12
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class SubMenuActivity extends Activity{
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_menu);
        textView = (TextView)findViewById(R.id.sub_menu_text_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //调用Menu的addSubMenu()方法来添加子菜单
        SubMenu fileSubMenu =  menu.addSubMenu("文件操作");
        SubMenu otherSubMenu =  menu.addSubMenu("其他操作");

        //添加子菜单
        fileSubMenu.add(0,Menu.FIRST+1,0,"新建");
        fileSubMenu.add(0,Menu.FIRST+2,0,"打开");

        otherSubMenu.add(0, Menu.FIRST + 3, 0, "删除");
        otherSubMenu.add(0, Menu.FIRST + 4, 0, "编辑");

        return true;
    }

    //重写 onOptionsItemSelected() 方法，响应子菜单的单击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == Menu.FIRST + 1){
            textView.setText("您选择了："+item.getTitle());
        }
        if(item.getItemId() == Menu.FIRST + 2){
            textView.setText("您选择了："+item.getTitle());
        }
        return true;
    }
}
