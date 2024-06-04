package com.example.quanligiaibong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBTDLichThiDau extends SQLiteOpenHelper {
    public DBTDLichThiDau(@Nullable Context context) {
        super(context, "dbGiaiEuro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbTDLichThiDau(maTDTranDau text, maTDLichThiDau text, tenTDBang text," +
                "tenTDDoi1, tenTDDoi2, ngayTDNgayThiDau)";
        db.execSQL(sql);
    }
    public void ThemDL(ClassTDLichThiDau tdLichThiDau) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbTDLichThiDau values (?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{tdLichThiDau.getMaTDTranDau(), tdLichThiDau.getMaTDLichThiDau(),
                tdLichThiDau.getTenTDBang(), tdLichThiDau.getTenTDDoi1(), tdLichThiDau.getTenTDDoi2(),
                tdLichThiDau.getNgayTDThiDau()});
    }
    public void XoaDL(String s) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbTDLichThiDau where maTDTranDau=?";
        sqLiteDatabase.execSQL(sql, new String[]{s});
    }
    public  void XoaTatCa()
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="delete from tbTDLichThiDau";
        sqLiteDatabase.execSQL(sql);
    }
    public List<ClassTDLichThiDau> DocDL(String maTranDau) {
        List<ClassTDLichThiDau> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbTDLichThiDau where maTDTranDau = ?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{maTranDau});
        if (cursor.moveToFirst()) {
            do {
                ClassTDLichThiDau db = new ClassTDLichThiDau();
                db.setMaTDTranDau(cursor.getString(0));
                db.setMaTDLichThiDau(cursor.getString(1));
                db.setTenTDBang(cursor.getString(2));
                db.setTenTDDoi1(cursor.getString(3));
                db.setTenTDDoi2(cursor.getString(4));
                db.setNgayTDThiDau(cursor.getString(5));
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
