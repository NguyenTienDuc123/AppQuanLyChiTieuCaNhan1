package com.example.appquanlychitieucanhan.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Develop on 5/4/2018.
 */

public class CreateDatabase extends SQLiteOpenHelper {

    public static final String TB_LOAITHU="LOAITHU";

    public static final String TB_LOAITHU_ID="ID";
    public static final String TB_LOAITHU_NAMELOAITHU="NAMELOAITHU";


    public static final String TB_KHOANTHU="KHOANTHU";

    public static final String TB_KHOANTHU_ID="ID";
    public static final String TB_KHOANTHU_NGAY="ngay";
    public static final String TB_KHOANTHU_TAIKHOAN="TAIKHOAN";
    public static final String TB_KHOANTHU_SOTIEN="SOTIEN";
    public static final String TB_KHOANTHU_LOAITHU="LOAITHUKHOANTHU";
    public static final String TB_KHOANTHU_MOTA="MOTA";


    public static final String TB_LOAICHI="LOAICHI";

    public static final String TB_LOAICHI_ID="ID";
    public static final String TB_LOAICHI_NAMELOAICHI="NAMELOAICHI";

    public static final String TB_KHOANCHI="KHOANCHI";

    public static final String TB_KHOANCHI_ID="ID";
    public static final String TB_KHOANCHI_NGAY="NGAY";
    public static final String TB_KHOANCHI_TAIKHOAN="TAIKHOAN";
    public static final String TB_KHOANCHI_SOTIEN="SOTIEN";
    public static final String TB_KHOANCHI_LOAICHI="LOAICHIKHOANCHI";
    public static final String TB_KHOANCHI_MOTA="MOTA";

    public static final String TB_TAIKHOAN="TAIKHOAN";

    public static final String TB_TAIKHOAN_ID="ID";
    public static final String TB_TAIKHOAN_NAME="NAME";
    public static final String TB_TAIKHOAN_SOTIEN="SOTIEN";



    public CreateDatabase(Context context) {
        super(context, "DB3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tb_Loaithu = "CREATE TABLE " + TB_LOAITHU + " ( " + TB_LOAITHU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                 + TB_LOAITHU_NAMELOAITHU + " TEXT ) ";
        db.execSQL(tb_Loaithu);

        String tb_Khoanthu = "CREATE TABLE " + TB_KHOANTHU + " ( " + TB_KHOANTHU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_KHOANTHU_NGAY + " TEXT, "
                + TB_KHOANTHU_TAIKHOAN + " TEXT, "
                + TB_KHOANTHU_SOTIEN + " TEXT, "
                + TB_KHOANTHU_MOTA + " TEXT, "
                + TB_KHOANTHU_LOAITHU + " TEXT ) ";

        db.execSQL(tb_Khoanthu);

        String tb_Loaichi = "CREATE TABLE " + TB_LOAICHI + " ( " + TB_LOAICHI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_LOAICHI_NAMELOAICHI + " TEXT ) ";
        db.execSQL(tb_Loaichi);

        String tb_Khoanchi = "CREATE TABLE " + TB_KHOANCHI + " ( " + TB_KHOANCHI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_KHOANCHI_NGAY + " TEXT, "
                + TB_KHOANCHI_TAIKHOAN + " TEXT, "
                + TB_KHOANCHI_SOTIEN + " TEXT, "
                + TB_KHOANCHI_MOTA + " TEXT, "
                + TB_KHOANCHI_LOAICHI + " TEXT ) ";

        db.execSQL(tb_Khoanchi);

        String tb_TaiKhoan = "CREATE TABLE " + TB_TAIKHOAN + " ( " + TB_TAIKHOAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_TAIKHOAN_NAME + " TEXT,"
                + TB_TAIKHOAN_SOTIEN + " TEXT ) ";

        db.execSQL(tb_TaiKhoan);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public SQLiteDatabase Open(){
        return this.getWritableDatabase();
    }

}
