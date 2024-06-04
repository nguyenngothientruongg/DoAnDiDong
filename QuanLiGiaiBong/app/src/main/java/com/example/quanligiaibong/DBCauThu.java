package com.example.quanligiaibong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBCauThu extends SQLiteOpenHelper {
    public DBCauThu(@Nullable Context context) {
        super(context, "dbGiaiEuro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbCauThu(mact text primary key,tenct text,nam text, quoctich text, doibong text, gioitinh text)";
        db.execSQL(sql);
    }
    public void ThemDL(ClassCT ct) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbCauThu values (?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{ct.getMaCT(), ct.getTenCT(), ct.getNamCT(), ct.getQtCT(),
                ct.getDbCT(), ct.getGtCT()});
    }
    public void XoaDL(ClassCT ct) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbCauThu where mact=?";
        sqLiteDatabase.execSQL(sql, new String[]{ct.getMaCT()});
    }
    public void CapNhat(ClassCT ct) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Update tbCauThu set  tenct=?,nam=?,quoctich=?, doibong=?, gioitinh=? where mact=?";
        sqLiteDatabase.execSQL(sql, new String[]{ct.getTenCT(), ct.getNamCT(), ct.getQtCT(),
                ct.getDbCT(), ct.getGtCT(), ct.getMaCT()});
    }
    public  void XoaHetLuon()
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="delete from tbCauThu";
        sqLiteDatabase.execSQL(sql);
    }
    public List<ClassCT> DocDL() {
        List<ClassCT> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbCauThu";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ClassCT ct = new ClassCT();
                ct.setMaCT(cursor.getString(0));
                ct.setTenCT(cursor.getString(1));
                ct.setNamCT(cursor.getString(2));
                ct.setQtCT(cursor.getString(3));
                ct.setDbCT(cursor.getString(4));
                ct.setGtCT(cursor.getString(5));
                data.add(ct);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
