package com.example.quanligiaibong;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class tdDoiBong extends Fragment {

    ListView lvtdDoiBong;
    List<ClassTDDoiBong> data_dstddb = new ArrayList<>();

    adapterDSTDDB adapter_dstddb;
    DBGiaiDau dbGiaiDau;
    DBDoiBong dbDoiBong;
    List<ClassGD> data_dsgd = new ArrayList<>();

    List<ClassDB> data_dsdb = new ArrayList<>();
    DBTDDoiBong dbtdDoiBong;
    ClassTDDoiBong data_tddb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_td_doi_bong, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        dbtdDoiBong = new DBTDDoiBong(getContext());

        adapter_dstddb = new adapterDSTDDB(getContext(), R.layout.layout_td_doibong, data_dstddb);
        lvtdDoiBong.setAdapter(adapter_dstddb);

        dbDoiBong = new DBDoiBong(getContext());
        dbGiaiDau = new DBGiaiDau(getContext());

        data_dsdb.addAll(dbDoiBong.DocDL());
        data_dsgd.addAll(dbGiaiDau.DocDL());

        if (data_dsgd.get(Home.so).soBangDau.equals("2")) {
            int a = Integer.parseInt(data_dsgd.get(Home.so).getSoDoi()) / 2;
            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB001", "Bảng A", data_dsdb.get(0).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);

            for (int i = 1; i < a; i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB001", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }

            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB002", "Bảng B", data_dsdb.get(a).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);

            for (int i = a + 1; i < Integer.parseInt(data_dsgd.get(Home.so).getSoDoi()); i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB002", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }

        } else if (data_dsgd.get(Home.so).soBangDau.equals("3")) {

            int a = Integer.parseInt(data_dsgd.get(Home.so).getSoDoi()) / 3;
            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB001", "Bảng A", data_dsdb.get(0).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);

            for (int i = 1; i < a; i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB001", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }

            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB002", "Bảng B", data_dsdb.get(a).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);

            int b = a + a;
            for (int i = a + 1; i < b; i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB002", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }

            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB003", "Bảng C", data_dsdb.get(b).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);
            for (int i = b + 1; i < Integer.parseInt(data_dsgd.get(Home.so).getSoDoi()); i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB003", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }

        } else if (data_dsgd.get(Home.so).soBangDau.equals("4")) {

            int a = Integer.parseInt(data_dsgd.get(Home.so).getSoDoi()) / 4;
            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB001", "Bảng A", data_dsdb.get(0).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);
            for (int i = 1; i < a; i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB001", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }

            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB002", "Bảng B", data_dsdb.get(a).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);
            int b = a + a;
            for (int i = a + 1; i < b; i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB002", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }

            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB003", "Bảng C", data_dsdb.get(b).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);
            int c = b + a;
            for (int i = b + 1; i < c; i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB003", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }

            data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB004", "Bảng D", data_dsdb.get(c).getTenDB());
            data_dstddb.add(data_tddb);
            dbtdDoiBong.ThemDL(data_tddb);
            for (int i = c + 1; i < Integer.parseInt(data_dsgd.get(Home.so).getSoDoi()); i++) {
                data_tddb = new ClassTDDoiBong(Home.maGiaiDau, "TDDB004", "", data_dsdb.get(i).getTenDB());
                data_dstddb.add(data_tddb);
                dbtdDoiBong.ThemDL(data_tddb);
            }
        }
        adapter_dstddb.notifyDataSetChanged();
    }

    private void setControl(View view) {
        lvtdDoiBong = view.findViewById(R.id.lvTDDoiBong);
    }
}