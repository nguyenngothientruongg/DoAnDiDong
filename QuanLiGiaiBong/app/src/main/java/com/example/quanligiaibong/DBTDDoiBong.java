package com.example.quanligiaibong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBTDDoiBong extends SQLiteOpenHelper {
    public DBTDDoiBong(@Nullable Context context) {
        super(context, "dbGiaiEuro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbTDDoiBong(maTDTranDau text, maTDDoiBong text, tenTDVongBang text, tenTDTenDoiBong text)";
        db.execSQL(sql);
    }
    public void ThemDL(ClassTDDoiBong tdDoiBong) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbTDDoiBong values (?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{tdDoiBong.getMaTDTranDau(), tdDoiBong.getMaTDDoiBong(), tdDoiBong.getTenTDTenVongBang(),
                tdDoiBong.getTenTDTenDoi()});
    }
    public void XoaDL(String s) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbTDDoiBong where maTDTranDau=?";
        sqLiteDatabase.execSQL(sql, new String[]{s});
    }
    public  void XoaTatCa()
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="delete from tbTDDoiBong";
        sqLiteDatabase.execSQL(sql);
    }
    public List<ClassTDDoiBong> DocDL(String maTDTranDau) {
        List<ClassTDDoiBong> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbTDDoiBong where maTDTranDau=?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{maTDTranDau});
        if (cursor.moveToFirst()) {
            do {
                ClassTDDoiBong db = new ClassTDDoiBong();
                db.setMaTDTranDau(cursor.getString(0));
                db.setMaTDDoiBong(cursor.getString(1));
                db.setTenTDTenVongBang(cursor.getString(2));
                db.setTenTDTenDoi(cursor.getString(3));
                data.add(db);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
