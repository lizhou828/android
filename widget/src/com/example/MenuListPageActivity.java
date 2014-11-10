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


        contextMenuButton = (Button)findViewById(R.id.context_menu_button);
        contextMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        subMenuButton = (Button)findViewById(R.id.sub_menu_button);
        subMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
