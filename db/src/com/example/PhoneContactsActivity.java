package com.example;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.*;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-9
 * Time: 下午5:54
 * Addr: http://tienfook.blog.163.com/blog/static/16666201120108144455510
 */
public class PhoneContactsActivity extends Activity {
    private MenuItem addItem;
    private MenuItem exitItem;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        listView = (ListView)findViewById(R.id.contact_list_list);


        //获取联系人信息
        ArrayList<String> contactLists = getContactsInfoInPhone();

        //生成适配器的Item和动态数组对应的元素
        ArrayAdapter<String> listItemAdapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1,contactLists);
        listView.setAdapter(listItemAdapter);
    }


    /**
     * 此方法用户初始化菜单，其中menu参数就是要显示的Menu实例。
     * 返回true则显示该menu.false则不显示
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
//        使用inflate()方法，把布局文件的定义的菜单，加载到第二个参数所对应的menu对象
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add :
                addContact();
                ArrayList<String> contactLists = getContactsInfoInPhone();
                ArrayAdapter<String> listItemAdapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1,contactLists);
                listView.setAdapter(listItemAdapter);
                break;
            case R.id.item_exit : PhoneContactsActivity.this.finish();
                break;
        }
        return true;
    }

    private void addContact() {

    }

    /**
     * 获取手机中的联系人信息
     * @return 以字符串集合的形式返回
     */
    public ArrayList<String> getContactsInfoInPhone() {
        //生成动态数组，加入数据
        ArrayList<String> listItem = new ArrayList<String>();
        Cursor cursor = getContentResolver().query(Contacts.CONTENT_URI,null,null,null,null);
        while( cursor.moveToNext() ){
            String contactInfo = "";
            String phoneName = cursor.getString(  cursor.getColumnIndex(Contacts.DISPLAY_NAME)  );
            contactInfo += phoneName;
            String contactId = cursor.getString(  cursor.getColumnIndex(Contacts._ID)  );
            String hasPhone = cursor.getString(  cursor.getColumnIndex(Contacts.HAS_PHONE_NUMBER)  );

            if( hasPhone.compareTo("1") == 0 ){
                Cursor phones = getContentResolver().query(CommonDataKinds.Phone.CONTENT_URI,null,CommonDataKinds.Phone.CONTACT_ID+"="+contactId,null,null);
                while ( phones.moveToNext() ){
                    String phoneNumber = phones.getString( phones.getColumnIndex(CommonDataKinds.Phone.NUMBER) );
                    String phoneType = phones.getString( phones.getColumnIndex(CommonDataKinds.Phone.TYPE) );
                    contactInfo += ","+phoneNumber;//多个号码如何处理?
                    Log.d("msg","testNum="+phoneNumber+",type="+phoneType);
                }
                phones.close();
            }

            Cursor emails = getContentResolver().query(CommonDataKinds.Email.CONTENT_URI,null,CommonDataKinds.Email.CONTACT_ID+"="+contactId,null,null);
            while (emails.moveToNext()){
                String emailAddress = emails.getString(emails.getColumnIndex(CommonDataKinds.Email.DATA));
                String emailType = emails.getString(emails.getColumnIndex(CommonDataKinds.Email.TYPE));
                Log.d("msg","testNum="+emailAddress+",type="+emailType);
            }
            emails.close();
            listItem.add(contactInfo);
        }
        cursor.close();

        return listItem;
    }
}
