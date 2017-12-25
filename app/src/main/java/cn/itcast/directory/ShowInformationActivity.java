package cn.itcast.directory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import cn.itcast.Information.Information;

public class ShowInformationActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);
        mListView = (ListView) findViewById(R.id.dataList);
//        ArrayList<SerInfo> listObj =  (ArrayList<SerInfo>) getIntent().getSerializableExtra("listobj");
        List<Information> list=(List<Information>)getIntent().getSerializableExtra("list");
        MyBaseAdapter mAdapter = new MyBaseAdapter(this,list);
        //设置Adapter
        mListView.setAdapter(mAdapter);
    }
}
