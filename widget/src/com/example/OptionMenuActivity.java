package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-10
 * Time: 下午3:56
 * To change this template use File | Settings | File Templates.
 */
public class OptionMenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.option_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        * menu.add()方法的四个参数解释：
         * 1、组别，如果不分组的话就写Menu.NONE
         * 2、Id,这个很重要，Android根据这个Id来确定不同的菜单
         * 3、顺序，哪个菜单现在在前面，由这个参数的大小决定
         * 4、文本，菜单的显示文本
         *
        * */
        menu.add( Menu.NONE, Menu.FIRST+1,5,"删除").setIcon( android.R.drawable.ic_menu_delete );
        menu.add( Menu.NONE, Menu.FIRST+2,2,"保存").setIcon( android.R.drawable.ic_menu_save );
        menu.add( Menu.NONE, Menu.FIRST+3,6,"帮助").setIcon( android.R.drawable.ic_menu_help );
        menu.add( Menu.NONE, Menu.FIRST+4,1,"添加").setIcon( android.R.drawable.ic_menu_add);
        menu.add( Menu.NONE, Menu.FIRST+5,4,"详细").setIcon( android.R.drawable.ic_menu_info_details );
        menu.add( Menu.NONE, Menu.FIRST+6,3,"发送").setIcon( android.R.drawable.ic_menu_send );
        menu.add( Menu.NONE, Menu.FIRST+7,7,"编辑").setIcon( android.R.drawable.ic_menu_edit );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case Menu.FIRST+1 :
                Toast.makeText(this,"删除菜单被点击了",Toast.LENGTH_LONG).show();
                break;
            case Menu.FIRST+2 :
                Toast.makeText(this,"保存菜单被点击了",Toast.LENGTH_LONG).show();
                break;

            case Menu.FIRST+3 :
                Toast.makeText(this,"帮助菜单被点击了",Toast.LENGTH_LONG).show();
                break;

            case Menu.FIRST+4 :
                Toast.makeText(this,"添加菜单被点击了",Toast.LENGTH_LONG).show();
                break;

            case Menu.FIRST+5 :
                Toast.makeText(this,"详细菜单被点击了",Toast.LENGTH_LONG).show();
                break;

            case Menu.FIRST+6 :
                Toast.makeText(this,"发送菜单被点击了",Toast.LENGTH_LONG).show();
                break;
            case Menu.FIRST+7 :
                Toast.makeText(this,"编辑菜单被点击了",Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

    @Override
    public boolean  onPrepareOptionsMenu(Menu menu) {
        Toast.makeText(this,"选项菜单显示之前，onPrepareOptionMenu方法会被调用。" +
                "你可以用此方法来根据当时的情况来调整菜单",Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Toast.makeText(this,"选项菜单关闭了",Toast.LENGTH_LONG).show();
    }
}
