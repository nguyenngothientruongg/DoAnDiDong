package com.example.quanligiaibong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBTDKetQua extends SQLiteOpenHelper {
    public DBTDKetQua(@Nullable Context context) {
        super(context, "dbGiaiEuro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbTDKetQua(maTDTranDau text, maTDKetQua text, tenTDBang text," +
                "tenTDDoi1 text, tenTDDoi2 text, diemTDDoi1 text, diemTDDoi2 text, ketquaTDDoi1 text, ketquaTDDoi2 text)";
        db.execSQL(sql);
    }

    public void ThemDL(ClassTDKetQua tdKetQua) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbTDKetQua values (?,?,?,?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{tdKetQua.getMaTDTranDau(), tdKetQua.getMaTDKetQua(),
                tdKetQua.getTenTDBang(), tdKetQua.getTenTDDoi1(), tdKetQua.getTenTDDoi2(),
                tdKetQua.getDiemTDKetQuaDoi1(), tdKetQua.getDiemTDKetQuaDoi2(), tdKetQua.getKetquaTDDoi1(),
                tdKetQua.getKetquaTDDoi2()});
    }
    public void XoaDL(String s) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbTDKetQua where maTDTranDau=?";
        sqLiteDatabase.execSQL(sql, new String[]{s});
    }
    public  void XoaTatCa()
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="delete from tbTDKetQua";
        sqLiteDatabase.execSQL(sql);
    }
    public List<ClassTDKetQua> DocDL(String maTranDau) {
        List<ClassTDKetQua> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbTDKetQua where maTDTranDau = ?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{maTranDau});
        if (cursor.moveToFirst()) {
            do {
                ClassTDKetQua db = new ClassTDKetQua();
                db.setMaTDTranDau(cursor.getString(0));
                db.setMaTDKetQua(cursor.getString(1));
                db.setTenTDBang(cursor.getString(2));

                db.setTenTDDoi1(cursor.getString(3));
                db.setTenTDDoi2(cursor.getString(4));

                db.setDiemTDKetQuaDoi1(cursor.getString(5));
                db.setDiemTDKetQuaDoi2(cursor.getString(6));

                db.setKetquaTDDoi1(cursor.getString(7));
                db.setKetquaTDDoi2(cursor.getString(8));

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
