package com.example;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-11
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
public class ContextMenuActivity extends ListActivity {
    private static final int ITEM1 = Menu.FIRST;
    private static final int ITEM2 = Menu.FIRST+1;
    private static final int ITEM3 = Menu.FIRST+2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        showListView();

        //ListView 的所有Item注册ContextMenu
        registerForContextMenu(getListView());
        //这里的registerForContextMenu()也可以用下面的语句替代
        //getListView().setOnCreateContextMenuListener(this);
    }

    private void showListView() {
        String[] mString = new String[]{
                "路飞-Monkey D Luffy",
                "奈美-Nami",
                "卓洛-Zoro",
                "山治-Sanji",
                "尼可·罗宾-Ms. All Sunday",
                "乌索普-usoppu",
                "托尼托尼·乔巴-Tony Tony Chopper",
        };
        ArrayAdapter<String> mla = new ArrayAdapter<String>(ContextMenuActivity.this,R.layout.context_menu,mString);
        ContextMenuActivity.this.setListAdapter(mla);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("人物简介");
        menu.add(0,ITEM1,0,"特长");
        menu.add(0,ITEM2,0,"战斗力");
        menu.add(0,ITEM3,0,"经典语录");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //获取当前被选择的菜单项的信息
        //AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
        //Log.i("braincol",String.valueOf(info.id));
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
            item.getTitleCondensed()
        switch(item.getItemId()){

            case ITEM1:
                Toast.makeText(this,"您选中了"+item.getTitle()+",ITEM1="+ITEM1+",菜单id="+menuInfo.id,Toast.LENGTH_LONG).show();
                break;
            case ITEM2:
                Toast.makeText(this,"您选中了"+item.getTitle()+",ITEM2="+ITEM2+",菜单id="+menuInfo.id,Toast.LENGTH_LONG).show();
                break;
            case ITEM3:
                Toast.makeText(this,"您选中了"+item.getTitle()+",ITEM3="+ITEM3+",菜单id="+menuInfo.id,Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}
