package cn.itcast.Information;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

import cn.itcast.DBHelper.DBOperator;
import cn.itcast.Information.Information;

/**
 * Created by rain on 2017/11/26.
 */

public class InformationService {
    DBOperator dbo=null;

    public InformationService(Context context) {

        this.dbo = new DBOperator(context);
    }

    public int insertInformation(Information information){
        String sql="insert into information (name,phone) values (?,?)";
        Object[] para= new Object[]{information.getName(),information.getPhone()};
        dbo.insert(sql,para);
        return 1;
    }

    public int updateInformation(String name,String phone){
        String sql = "update information set phone=? where name=?";
        Object[] para=new Object[]{phone, name};
        dbo.update(sql,para);
        return 1;
    }

    public int deleteInformation(){
        String sql = "delete from information";
        dbo.delete(sql,null);
        return 1;
    }
    public int deleteInformation(int id){
        String sql = "delete from information where id=?";
        Object[] para= new Object[]{id};
        dbo.delete(sql,para);
        return 1;
    }
    public int deleteInformation(String  name){
        String sql = "delete from information where name=?";
        Object[] para= new Object[]{name};
        dbo.delete(sql,para);
        return 1;
    }

    public List<Information> queryInformation(){
        List<Information> informations = dbo.query("select * from information",null);
//        Cursor cursor=dbo.query("select * from information",null);
//        List<Information> informations = getInformation(cursor);
//        cursor.close();
        return informations;
    }


}
