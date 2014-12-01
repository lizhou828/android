package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-28
 * Time: 下午2:52
 * To change this template use File | Settings | File Templates.
 */
public class TableLayoutActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.table_layout);
        String text = "表格布局类似Html里面的Table。\n" +
                "每一个TableLayout里面都有表格行TableRow，\n" +
                "TableRow里面可以具体定义每一个元素\n" +
                "每一个TableRow都会定义一个row,\n" +
                "(事实上，你可以定义其他的子对象，这在下面会解释到)。\n" +
                "TableLayout容器不会显示row,columns或cell的边框线。\n" +
                "每个row拥有0个或者多个cell;每个cell拥有一个View对象。\n" +
                "表格由列和行组成许多的单元格。表格允许单元格为空。\n" +
                "单元格不能夸列，这与HTML中的不一样\n\n\n" +
                "TableRow只论行，不论列（列自定义）";
        TextView textView = (TextView)findViewById(R.id.table_layout_text_view);
        textView.setText(text);
    }
}
