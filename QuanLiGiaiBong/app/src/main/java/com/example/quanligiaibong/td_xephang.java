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

import java.util.Arrays;

public class td_xephang extends Fragment {

    ListView lvtdXepHang;
    List<ClassTDXepHang> data_dstdxh = new ArrayList<>();
    List<ClassTDKetQua> data_dstdkq = new ArrayList<>();
    List<ClassGD> data_dsgd = new ArrayList<>();
    adapterDSTDXH adapter_dstdxh;
    DBTDKetQua dbtdKetQua;
    DBTDXepHang dbtdXepHang;
    DBGiaiDau dbGiaiDau;
    int thang = 0, hoa = 0, thua = 0, xephang = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_td_ketqua, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        dbtdXepHang = new DBTDXepHang(getContext());
        dbtdKetQua = new DBTDKetQua(getContext());
        dbGiaiDau = new DBGiaiDau(getContext());

        data_dstdkq.addAll(dbtdKetQua.DocDL(Home.maGiaiDau));
        data_dsgd.addAll(dbGiaiDau.DocDL());

        adapter_dstdxh = new adapterDSTDXH(getContext(), R.layout.layout_td_xephang, data_dstdxh);
        lvtdXepHang.setAdapter(adapter_dstdxh);
        if (dbtdKetQua.DocDL(Home.maGiaiDau).size() == 0) {
            Toast.makeText(getContext(), "Chưa có kết quả!!", Toast.LENGTH_SHORT).show();
        } else {
            SapXepDiem();
        }
    }

    private void SapXepDiem() {
        ClassTDXepHang data_tdxh;
        for (int i = 0; i < data_dstdkq.size(); i++) {
            thang = 0;
            hoa = 0;
            thua = 0;
            for (int j = 0; j < data_dstdkq.size(); j++) {
                if (data_dstdkq.get(i).getTenTDDoi1() == data_dstdkq.get(j).getTenTDDoi2()) {
                    if (data_dstdkq.get(j).getKetquaTDDoi2().equals("Thắng")) {
                        thang++;
                    } else if (data_dstdkq.get(j).getKetquaTDDoi2().equals("Hòa")) {
                        hoa++;
                    } else if (data_dstdkq.get(j).getKetquaTDDoi2().equals("Thua")) {
                        thua++;
                    }
                }
            }
            if (data_dstdkq.get(i).getKetquaTDDoi2().equals("Thắng")) {
                thang++;
            } else if (data_dstdkq.get(i).getKetquaTDDoi2().equals("Hòa")) {
                hoa++;
            } else if (data_dstdkq.get(i).getKetquaTDDoi2().equals("Thua")) {
                thua++;
            }
            data_tdxh = new ClassTDXepHang(Home.maGiaiDau, data_dstdkq.get(i).maTDKetQua,
                    data_dstdkq.get(i).getTenTDBang(), data_dstdkq.get(i).getTenTDDoi1(),
                    thang + "", hoa + "", thua + "", xephang + "");
            data_dstdxh.add(data_tdxh);
            dbtdXepHang.ThemDL(data_tdxh);
            adapter_dstdxh.notifyDataSetChanged();
        }
        XepHang();
    }

    private void XepHang() {
        ClassTDXepHang data_tdXH;
        dbtdXepHang.XoaDL(Home.maGiaiDau);
        int xh = 1;
        for (int i = 0; i < data_dstdxh.size(); i++) {
            xh=1;
            for (int j = 0; j < data_dstdxh.size(); j++) {
                if (data_dstdxh.get(i).getMaTDLichThiDau().equals(data_dstdxh.get(j).getMaTDLichThiDau())) {
                    if (Integer.parseInt(data_dstdxh.get(i).getThangTDXepHang()) - Integer.parseInt(data_dstdxh.get(i).getThuTDXepHang()) <
                            Integer.parseInt(data_dstdxh.get(j).getThangTDXepHang()) - Integer.parseInt(data_dstdxh.get(j).getThuTDXepHang())) {
                        xh++;
                    }
                }
            }
            data_dstdxh.get(i).setTdXepHang(xh + "");
            dbtdXepHang.ThemDL(data_dstdxh.get(i));
        }
        adapter_dstdxh.notifyDataSetChanged();
    }

    private void setControl(View view) {
        lvtdXepHang = view.findViewById(R.id.lvTDKetQua);
    }
}