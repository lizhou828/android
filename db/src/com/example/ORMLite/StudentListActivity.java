package com.example.ORMLite;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.example.R;
import com.example.model.Student;
import com.example.model.XueSheng;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-5
 * Time: 下午3:29
 * To change this template use File | Settings | File Templates.
 */
public class StudentListActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    private Context mContext;
    private ListView studentListView;
    private int position;
    private final int MENU_VIEW = Menu.FIRST;
    private final int MENU_EDIT = Menu.FIRST+1;
    private final int MENU_DELETE = Menu.FIRST+2;
    private Dao<XueSheng, Integer> stuDao;
    private List<XueSheng> students;
    private XueSheng mStudent;
    private StudentsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students);
        mContext = getApplicationContext();
        studentListView = (ListView)findViewById(R.id.student_list);
        registerForContextMenu(studentListView);//注册上下文菜单

        queryListViewItem();

        adapter = new StudentsAdapter(students);
        studentListView.setAdapter(adapter);

        //原文地址：http://blog.csdn.net/cjjky/article/details/7096987
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if( v == studentListView){
            position  = ( (AdapterView.AdapterContextMenuInfo)menuInfo ).position;
        }
        menu.add(0,MENU_VIEW,0,"查看");
        menu.add(0,MENU_EDIT,0,"编辑");
        menu.add(0,MENU_DELETE,0,"删除");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_VIEW : viewListViewItem(position);break;
            case MENU_EDIT : editListViewItem(position);break;
            case MENU_DELETE : deleteListViewItem(position);break;
            default:break;
        }
        return super.onContextItemSelected(item);
    }

    private void deleteListViewItem(int position) {
        final int pos = position;
        AlertDialog.Builder builder2 = new AlertDialog.Builder(StudentListActivity.this);
        builder2.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("警告")
                .setMessage("确定要删除该记录");
        builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                XueSheng mDelStudent = (XueSheng)studentListView.getAdapter().getItem(pos);
                try {
                    stuDao.delete(mDelStudent); //删除记录
                    queryListViewItem();
                    Toast.makeText(StudentListActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        builder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder2.show();
    }

    private void editListViewItem(int position) {
        mStudent = students.get(position);
        Intent intent = new Intent();
        intent.setClass(mContext, MainActivity.class);
        intent.putExtra("action", "edit");
        intent.putExtra("entity", mStudent);
        startActivity(intent);
    }

    private void viewListViewItem(int position) {
        mStudent = students.get(position);
        Intent intent = new Intent();
        intent.setClass(mContext, MainActivity.class);
        intent.putExtra("action", "viewone");
        intent.putExtra("entity", mStudent);
        startActivity(intent);
    }


    private void queryListViewItem() {
        try {
            stuDao = getHelper().getStudentDao();
            //查询所有的记录项
            students = stuDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    class StudentsAdapter extends BaseAdapter {

        private List<XueSheng> listStu;

        public StudentsAdapter(List<XueSheng> students){
            super();
            this.listStu = students;
        }

        @Override
        public int getCount() {
            return listStu.size();
        }

        @Override
        public XueSheng getItem(int position) {
            return listStu.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                LayoutInflater mInflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.student_item, null);
                holder = new ViewHolder();
                holder.tvNO = (TextView)convertView.findViewById(R.id.itemno);
                holder.tvName = (TextView)convertView.findViewById(R.id.itemname);
                holder.tvScore = (TextView)convertView.findViewById(R.id.itemscore);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            XueSheng objStu = listStu.get(position);
            holder.tvNO.setText(objStu.getStuNO());
            holder.tvName.setText(objStu.getName());
            holder.tvScore.setText(String.valueOf(objStu.getScore()));

            return convertView;
        }

    }
    static class ViewHolder{
        TextView tvNO;
        TextView tvName;
        TextView tvScore;
    }
}
