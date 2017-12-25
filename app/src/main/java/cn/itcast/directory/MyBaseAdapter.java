package cn.itcast.directory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.itcast.Information.Information;

/**
 * Created by rain on 2017/11/29.
 */

public class MyBaseAdapter extends BaseAdapter {
    private List<Information> list;
    private Context context;
    public MyBaseAdapter(Context context,List<Information> list) {
        this.context=context;
        this.list=list;
    }

    //得到item的总数
    @Override
    public int getCount() {
        //返回ListView Item条目的总数
        return list.size();
    }
    //得到Item代表的对象
    @Override
    public Object getItem(int position) {
        //返回ListView Item条目代表的对象
        return list.get(position);
    }
    //得到Item的id
    @Override
    public long getItemId(int position) {
        //返回ListView Item的id
        return position;
    }
    //得到Item的View视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = getViewByHolder(position, convertView, parent);
        return convertView;
    }

    @NonNull
    private View getViewByHolder(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.listview,parent,false);
            holder = new ViewHolder();
            holder.mID = (TextView)convertView.findViewById(R.id.stu_number);
            holder.mName = (TextView)convertView.findViewById(R.id.stu_name);
            holder.mPhone = (TextView)convertView.findViewById(R.id.stu_phone);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mID.setText(list.get(position).getId()+"");
        holder.mName.setText(list.get(position).getName());
        holder.mPhone.setText(list.get(position).getPhone());
        return convertView;
    }

    class ViewHolder {
        TextView mID;
        TextView mName;
        TextView mPhone;
    }


}
