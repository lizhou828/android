package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-10
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
public class OptionMenuCustomActivity extends Activity {
    View menuView;
    AlertDialog menuDialog; //menu菜单Dialog
    GridView menuGrid;
    private boolean isMore = true;//menu菜单翻页控制

    private final int ITEM_SEARCH = 0;// 搜索
    private final int ITEM_FILE_MANAGER = 1;// 文件管理
    private final int ITEM_DOWN_MANAGER = 2;// 下载管理
    private final int ITEM_FULLSCREEN = 3;// 全屏
    private final int ITEM_MORE = 11;// 菜单

    /** 菜单图片 **/
    int[] menu_image_array = { R.drawable.menu_search,
            R.drawable.menu_filemanager, R.drawable.menu_downmanager,
            R.drawable.menu_fullscreen, R.drawable.menu_inputurl,
            R.drawable.menu_bookmark, R.drawable.menu_bookmark_sync_import,
            R.drawable.menu_sharepage, R.drawable.menu_quit,
            R.drawable.menu_nightmode, R.drawable.menu_refresh,
            R.drawable.menu_more };
    /** 菜单文字 **/
    String[] menu_name_array = { "搜索", "文件管理", "下载管理", "全屏", "网址", "书签",
            "加入书签", "分享页面", "退出", "夜间模式", "刷新", "更多" };
    /** 菜单图片2 **/
    int[] menu_image_array2 = { R.drawable.menu_auto_landscape,
            R.drawable.menu_penselectmodel, R.drawable.menu_page_attr,
            R.drawable.menu_novel_mode, R.drawable.menu_page_updown,
            R.drawable.menu_checkupdate, R.drawable.menu_checknet,
            R.drawable.menu_refreshtimer, R.drawable.menu_syssettings,
            R.drawable.menu_help, R.drawable.menu_about, R.drawable.menu_return };
    /** 菜单文字2 **/
    String[] menu_name_array2 = { "自动横屏", "笔选模式", "阅读模式", "浏览模式", "快捷翻页",
            "检查更新", "检查网络", "定时刷新", "设置", "帮助", "关于", "返回" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_menu_custom);

        menuView = View.inflate(this,R.layout.gridview_menu,null);

        //创建AlertDialog
        menuDialog = new AlertDialog.Builder(this).create();
        menuDialog.setView(menuView);
        menuDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent) {
                if( keyCode  == KeyEvent.KEYCODE_MENU ){
                    dialogInterface.dismiss();
                }
                return false;
            }
        });

        menuGrid = (GridView)menuView.findViewById(R.id.gridview);
        menuGrid.setAdapter(getMenuAdapter(menu_name_array,menu_image_array));

        menuGrid.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case ITEM_SEARCH :
                        break;
                    case ITEM_FILE_MANAGER :
                        break;
                    case ITEM_DOWN_MANAGER :
                        break;
                    case ITEM_FULLSCREEN :
                        break;
                    case ITEM_MORE :
                        if( isMore ){
                            menuGrid.setAdapter(getMenuAdapter(menu_name_array2,menu_image_array2));
                            isMore = false;
                        }else {
                            menuGrid.setAdapter(getMenuAdapter(menu_name_array,menu_image_array));
                            isMore = true;
                        }
                        //更新menu
                        menuGrid.invalidate();
                        menuGrid.setSelection(ITEM_MORE);
                        break;
                }
            }
        });

    }

    private ListAdapter getMenuAdapter(String[] menu_name_array, int[] menu_image_array) {
        ArrayList<HashMap<String,Object>> data = new ArrayList<HashMap<String,Object>>();
        for( int i= 0 ; i<menu_name_array.length;i++){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("itemImage",menu_image_array[i]);
            map.put("itemText",menu_name_array[i]);
            data.add(map);
        }
         return new SimpleAdapter(this,data,R.layout.item_menu,
                    new String[]{"itemImage","itemText"},
                    new int[]{R.id.item_image,R.id.item_text});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("menu");//必须创建一项
        return super.onCreateOptionsMenu(menu);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if(menuDialog == null ){
            menuDialog = new AlertDialog.Builder(this).setView(menuView).show();
        }else{
            menuDialog.show();
        }
        return false;//返回true 则显示系统menu
    }
}
