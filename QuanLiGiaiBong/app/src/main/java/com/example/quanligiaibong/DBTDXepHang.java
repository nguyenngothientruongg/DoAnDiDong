package com.example.quanligiaibong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBTDXepHang extends SQLiteOpenHelper {
    public DBTDXepHang(@Nullable Context context) {
        super(context, "dbGiaiEuro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbTDXepHang(maTDTranDau text, maTDXH text, tenTDBang text," +
                "tenTDDoi text, thangTDXepHang text, hoaTDXepHang text, thuaTDXepHang text, tdXepHang text)";
        db.execSQL(sql);
    }

    public void ThemDL(ClassTDXepHang tdXepHang) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbTDXepHang values (?,?,?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{tdXepHang.getMaTDTranDau(), tdXepHang.getMaTDLichThiDau(),
                tdXepHang.getTenTDBang(),
                tdXepHang.getTenTDDoi(),
                tdXepHang.getThangTDXepHang(), tdXepHang.getHoaTDXepHang(),
                tdXepHang.getThuTDXepHang(), tdXepHang.getTdXepHang()});
    }
    public void XoaDL(String ma) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbTDXepHang where maTDTranDau=?";
        sqLiteDatabase.execSQL(sql, new String[]{ma});
    }
    public void XoaTatCa() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbTDXepHang";
        sqLiteDatabase.execSQL(sql);
    }

    public List<ClassTDXepHang> DocDL(String maTDTranDau) {
        List<ClassTDXepHang> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbTDXepHang where maTDTranDau=?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{maTDTranDau});
        if (cursor.moveToFirst()) {
            do {
                ClassTDXepHang db = new ClassTDXepHang();
                db.setMaTDTranDau(cursor.getString(0));
                db.setMaTDLichThiDau(cursor.getString(1));
                db.setTenTDBang(cursor.getString(2));
                db.setTenTDDoi(cursor.getString(3));
                db.setThangTDXepHang(cursor.getString(4));
                db.setHoaTDXepHang(cursor.getString(5));
                db.setThuTDXepHang(cursor.getString(6));
                db.setTdXepHang(cursor.getString(7));
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
