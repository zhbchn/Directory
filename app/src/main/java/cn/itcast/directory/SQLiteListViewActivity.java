package cn.itcast.directory;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import cn.itcast.Information.Information;
import cn.itcast.Information.InformationService;

public class SQLiteListViewActivity extends AppCompatActivity implements View.OnClickListener{
    //MyHelper myHelper;
    private EditText mEtName;
    private EditText mEtPhone;
    private TextView mTvShow;
    private Button mBtnAdd;
    private Button mBtnQuery;
    private Button mBtnUpdate;
    private Button mBtnDelete;
    private InformationService service;
    private List<Information> list=null;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_list_view);
        service=new InformationService(this);
        init();//初始化控件


    }

    private void init() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mTvShow = (TextView) findViewById(R.id.tv_show);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mListView = (ListView) findViewById(R.id.dataList);
        mBtnAdd.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name;
        String phone;
        SQLiteDatabase db;
        ContentValues values;
        switch (v.getId()) {
            case R.id.btn_add: //添加数据
                name = mEtName.getText().toString();
                phone = mEtPhone.getText().toString();
                if(name.length()>0&& phone.length()>0) {
                    Information info = new Information();
                    info.setName(name);
                    info.setPhone(phone);
                    service.insertInformation(info);
                    Toast.makeText(this, "添加成功！", Toast.LENGTH_SHORT);
                    //ShowData();
                }else{
                    Toast.makeText(this, "请输入名称和电话！", Toast.LENGTH_LONG);
                }
                break;
            case R.id.btn_query: //查询数据
                ShowData();
                break;
            case R.id.btn_update: //修改数据
                name = mEtName.getText().toString();
                phone = mEtPhone.getText().toString();
                if(name.length()>0&& phone.length()>0) {
                    service.updateInformation(name,phone);
                    Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT);
                    //ShowData();
                }else{
                    Toast.makeText(this, "请输入名称和电话！", Toast.LENGTH_LONG);
                }
                break;
            case R.id.btn_delete: //删除数据
                name = mEtName.getText().toString();
                service.deleteInformation(name);
                Toast.makeText(this, name+" 信息删除成功！", Toast.LENGTH_SHORT);
                //ShowData();
                break;
        }
    }

    private void ShowData() {
        list=service.queryInformation();
        //创建一个Adapter的实例
        Intent intent = new Intent(this,ShowInformationActivity.class);
        intent.putExtra("list",(Serializable)list);
        startActivity(intent);

    }


}
