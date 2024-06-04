package com.example.quanligiaibong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBGiaiDau extends SQLiteOpenHelper {
    public DBGiaiDau(@Nullable Context context) {
        super(context, "dbGiaiEuro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase gd) {
        String sql = "Create table tbGiaiDau(maGiaiDau text primary key, tenGiaiDau text, soBangDau text, " +
                "soDoi)";
        gd.execSQL(sql);

        String sql1 = "Create table tbCauThu(mact text primary key,tenct text,nam text, quoctich text, doibong text, gioitinh text)";
        gd.execSQL(sql1);

        String sql2 = "Create table tbDoiBong(madb text primary key,tendb text,quoctich text)";
        gd.execSQL(sql2);

        String sql3 = "Create table tbTDDoiBong(maTDTranDau text, maTDDoiBong text, tenTDVongBang text, tenTDTenDoiBong text)";
        gd.execSQL(sql3);

        String sql4 = "Create table tbTDLichThiDau(maTDTranDau text, maTDLichThiDau text, tenTDBang text," +
                "tenTDDoi1, tenTDDoi2, ngayTDNgayThiDau)";
        gd.execSQL(sql4);

        String sql5 = "Create table tbTDKetQua(maTDTranDau text, maTDKetQua text, tenTDBang text," +
                "tenTDDoi1 text, tenTDDoi2 text, diemTDDoi1 text, diemTDDoi2 text, ketquaTDDoi1 text, ketquaTDDoi2 text)";
        gd.execSQL(sql5);

        String sql6 = "Create table tbTDXepHang(maTDTranDau text, maTDXH text, tenTDBang text," +
                "tenTDDoi text, thangTDXepHang text, hoaTDXepHang text, thuaTDXepHang text, tdXepHang text)";
        gd.execSQL(sql6);
    }
    public void ThemDL(ClassGD gd) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbGiaiDau values (?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{gd.getMaGD(), gd.getTenGD(), gd.getSoBangDau(),
        gd.getSoDoi()});
    }
    public void XoaDL(ClassGD gd) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbGiaiDau where maGiaiDau=?";
        sqLiteDatabase.execSQL(sql, new String[]{gd.getMaGD()});
    }
    public void CapNhat(ClassGD gd) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Update tbGiaiDau set  tenGiaiDau=?, soBangDau=?, soDoi=? where maGiaiDau=?";
        sqLiteDatabase.execSQL(sql, new String[]{gd.getTenGD(), gd.getSoBangDau(), gd.getSoDoi(), gd.getMaGD()});
    }
    public  void XoaHetLuon()
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="delete from tbGiaiDau";
        sqLiteDatabase.execSQL(sql);
    }
    public List<ClassGD> DocDL() {
        List<ClassGD> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbGiaiDau";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ClassGD gd = new ClassGD();
                gd.setMaGD(cursor.getString(0));
                gd.setTenGD(cursor.getString(1));
                gd.setSoBangDau(cursor.getString(2));
                gd.setSoDoi(cursor.getString(3));
                data.add(gd);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
