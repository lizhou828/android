package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-10
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */
public class MenuListPageActivity extends Activity {
    private Button optionMenuButton ;
    private Button optionMenuButtonCustom ;
    private Button contextMenuButton ;
    private Button subMenuButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.menu_list_page);

        optionMenuButton = (Button)findViewById(R.id.option_menu_button);
        optionMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MenuListPageActivity.this,OptionMenuActivity.class);
                startActivity(intent);
            }
        });

        optionMenuButtonCustom = (Button)findViewById(R.id.option_menu_button_custom);
        optionMenuButtonCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MenuListPageActivity.this,OptionMenuCustomActivity.class);
                startActivity(intent);
            }
        });


        /**
         * 概述：
         * Android 的上下文菜单类似于 PC 上的右键菜单。
         * 当为一个视图注册了上下文菜单之后，长按（2 秒左右）这个视图对象就会弹出一个浮动菜单，即上下文菜单。
         * 任何视图都可以注册上下文菜单，不过，最常见的是用于列表视图ListView的item。
         * 注意：Android 的上下文菜单不支持图标或快捷键。
         *
         * 创建一个上下文菜单的步骤：
         * 1. 覆盖 Activity 的 onCreateContenxtMenu() 方法，调用 Menu 的 add 方法添加菜单项（MenuItem）。
         * 2. 覆盖 Activity 的 onContextItemSelected() 方法，响应上下文菜单菜单项的单击事件。
         * 3. 调用 registerForContextMenu() 方法，为视图注册上下文菜单。
         */
        contextMenuButton = (Button)findViewById(R.id.context_menu_button);
        contextMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MenuListPageActivity.this,ContextMenuActivity.class);
                startActivity(intent);
            }
        });

        subMenuButton = (Button)findViewById(R.id.sub_menu_button);
        subMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( MenuListPageActivity.this,SubMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
