package com.example.quanligiaibong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBDoiBong extends SQLiteOpenHelper {
    public DBDoiBong(@Nullable Context context) {
        super(context, "dbGiaiEuro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbDoiBong(madb text primary key,tendb text,quoctich text)";
        db.execSQL(sql);
    }
    public void ThemDL(ClassDB db) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbDoiBong values (?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{db.getMaDB(), db.getTenDB(), db.getQtDB()});
    }
    public void XoaDL(ClassDB db) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbDoiBong where madb=?";
        sqLiteDatabase.execSQL(sql, new String[]{db.getMaDB()});
    }
    public void CapNhat(ClassDB db) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Update tbDoiBong set  tendb=?, quoctich=? where madb=?";
        sqLiteDatabase.execSQL(sql, new String[]{db.getTenDB(), db.getQtDB(), db.getMaDB()});
    }
    public  void XoaHetLuon()
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="delete from tbDoiBong";
        sqLiteDatabase.execSQL(sql);
    }
    public List<ClassDB> DocDL() {
        List<ClassDB> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbDoiBong";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ClassDB db = new ClassDB();
                db.setMaDB(cursor.getString(0));
                db.setTenDB(cursor.getString(1));
                db.setQtDB(cursor.getString(2));
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
