package com.example.appquanlychitieucanhan.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.appquanlychitieucanhan.model.KhoangThu;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Develop on 5/4/2018.
 */

public class DatabaseKhoanThu {

    String Ngay,TaiKhoan,SoTien,MoTa,LoaiThu;
    SQLiteDatabase database;
    String TB="TAB";
    public DatabaseKhoanThu(Context context)
    {

        CreateDatabase createDatabase=new CreateDatabase(context);
        database=createDatabase.Open();
    }

    public static String Today="SELECT * FROM " + CreateDatabase.TB_KHOANTHU+" WHERE "+CreateDatabase.TB_KHOANTHU_NGAY+" ='"+chooseDate()+"'";

    public static String ThisWeek = "SELECT * FROM "+CreateDatabase.TB_KHOANTHU+" WHERE strftime('%W',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%W',date('now')) " +
            "AND  strftime('%m',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%m',date('now'))"+
            "AND strftime('%Y',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%Y',date('now'))";

    public static String ThisYear="SELECT * FROM "+CreateDatabase.TB_KHOANTHU+" WHERE strftime('%Y',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%Y',date('now'))";

    public static String ThisMonth="SELECT * FROM "+CreateDatabase.TB_KHOANTHU+" WHERE strftime('%Y',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%Y',date('now')) " +
            "AND  strftime('%m',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%m',date('now'))";




    public long AddKhoanThu(KhoangThu khoangThu)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(CreateDatabase.TB_KHOANTHU_NGAY,khoangThu.getNgay());
        contentValues.put(CreateDatabase.TB_KHOANTHU_TAIKHOAN,khoangThu.getTaiKhoan());
        contentValues.put(CreateDatabase.TB_KHOANTHU_SOTIEN,khoangThu.getSoTien());
        contentValues.put(CreateDatabase.TB_KHOANTHU_MOTA,khoangThu.getMoTa());
        contentValues.put(CreateDatabase.TB_KHOANTHU_LOAITHU,khoangThu.getLoaiThu());
        long check=database.insert(CreateDatabase.TB_KHOANTHU,null,contentValues);
        Log.d(TB, String.valueOf(check));
        return check;
    }
    public List<KhoangThu> getKhoangThu(){

        List<KhoangThu> list=new ArrayList<>();

        String TruyVan=" SELECT * FROM " + CreateDatabase.TB_KHOANTHU;

        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            KhoangThu khoangThu=new KhoangThu();
            khoangThu.setId(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_ID)));
            khoangThu.setNgay(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_NGAY)));
            khoangThu.setLoaiThu(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_LOAITHU)));
            khoangThu.setMoTa(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_MOTA)));
            khoangThu.setSoTien(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_SOTIEN)));
            khoangThu.setTaiKhoan(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_TAIKHOAN)));
            list.add(khoangThu);
            cursor.moveToNext();
        }
        //Log.d("checkNao", String.valueOf(list));
        return list;
    }

    public List<KhoangThu> getKhoangThuTheoNgayThangNam(String truyvan){

        List<KhoangThu> list=new ArrayList<>();

        Cursor cursor=database.rawQuery(truyvan,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            KhoangThu khoangThu=new KhoangThu();
            khoangThu.setId(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_ID)));
            khoangThu.setNgay(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_NGAY)));
            khoangThu.setLoaiThu(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_LOAITHU)));
            khoangThu.setMoTa(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_MOTA)));
            khoangThu.setSoTien(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_SOTIEN)));
            khoangThu.setTaiKhoan(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_TAIKHOAN)));
            list.add(khoangThu);
            cursor.moveToNext();
        }
        //Log.d("checkNao", String.valueOf(list));
        return list;
    }




    public static String chooseDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// bắt buộc phải định dạng theo năm tháng ngày
        String currentDate = sdf.format(calendar.getTime());
        return currentDate;
    }

}
