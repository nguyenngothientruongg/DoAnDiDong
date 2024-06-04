package com.example.quanligiaibong;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class td_taolichthidau extends Fragment {
    ListView lvTDLichThiDau;
    Button btnTDTaoTranDau, btnTDTaoLich;
    DatePicker dpNgayLich;
    List<ClassTDLichThiDau> data_dsTDlTD = new ArrayList<>();
    List<ClassTDDoiBong> data_dsTDDB = new ArrayList<>();
    List<ClassGD> data_dsGD = new ArrayList<>();
    adapterDSTDLTD adapter_dsTDLTD;
    DBTDDoiBong dbtdDoiBong;
    DBTDLichThiDau dbtdLichThiDau;
    DBGiaiDau dbGiaiDau;
    int a = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_td_taolichthidau, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        dbtdLichThiDau = new DBTDLichThiDau(getContext());
        adapter_dsTDLTD = new adapterDSTDLTD(getContext(), R.layout.layout_td_taolich, data_dsTDlTD);
        lvTDLichThiDau.setAdapter(adapter_dsTDLTD);


        if (dbtdLichThiDau.DocDL(Home.maGiaiDau).size() == 0) {
            btnTDTaoTranDau.setVisibility(View.VISIBLE);
        } else {
            btnTDTaoTranDau.setVisibility(View.GONE);
            data_dsTDlTD.addAll(dbtdLichThiDau.DocDL(Home.maGiaiDau));
            adapter_dsTDLTD.notifyDataSetChanged();
        }
        btnTDTaoTranDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTDTaoTranDau.setVisibility(View.GONE);
                TaoTranDauNgauNhien();
            }
        });
        lvTDLichThiDau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvTDLichThiDau.setVisibility(View.GONE);
                a = position;
                dpNgayLich.setVisibility(View.VISIBLE);
                btnTDTaoLich.setVisibility(view.VISIBLE);
            }
        });
        btnTDTaoLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_dsTDlTD.get(a).setNgayTDThiDau(dpNgayLich.getDayOfMonth()+"/"+dpNgayLich.getMonth()+"/"+dpNgayLich.getYear());
                adapter_dsTDLTD.notifyDataSetChanged();
                lvTDLichThiDau.setVisibility(View.VISIBLE);
                dbtdLichThiDau.XoaDL(Home.maGiaiDau);
                for (int i = 0; i < data_dsTDlTD.size(); i++) {
                    dbtdLichThiDau.ThemDL(data_dsTDlTD.get(i));
                }
                dpNgayLich.setVisibility(View.GONE);
                btnTDTaoLich.setVisibility(View.GONE);
            }
        });
    }

    private void TaoTranDauNgauNhien() {
        dbtdDoiBong = new DBTDDoiBong(getContext());
        dbGiaiDau = new DBGiaiDau(getContext());
        data_dsTDDB.addAll(dbtdDoiBong.DocDL(Home.maGiaiDau));
        data_dsGD.addAll(dbGiaiDau.DocDL());

        ClassTDLichThiDau data_TDLTD;
        Random random = new Random();

        if (data_dsGD.get(Home.so).soBangDau.equals("2")) {
            int a = data_dsTDDB.size() / 2;

            data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "Trận bảng A", data_dsTDDB.get(0).getTenTDTenDoi(),
                    data_dsTDDB.get(random.nextInt(a) + a).getTenTDTenDoi(), "--/--/--");
            data_dsTDlTD.add(data_TDLTD);
            dbtdLichThiDau.ThemDL(data_TDLTD);
            adapter_dsTDLTD.notifyDataSetChanged();

            for (int i = 1; i < a; i++) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(a) + a).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }

            data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "Trận bảng B", data_dsTDDB.get(a).getTenTDTenDoi(),
                    data_dsTDDB.get(random.nextInt(a)).getTenTDTenDoi(), "--/--/--");
            data_dsTDlTD.add(data_TDLTD);
            dbtdLichThiDau.ThemDL(data_TDLTD);
            adapter_dsTDLTD.notifyDataSetChanged();

            for (int i = a + 1; i < data_dsTDDB.size(); i++) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(a)).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }
        }
        else if (data_dsGD.get(Home.so).soBangDau.equals("3")) {
            int b = data_dsTDDB.size() / 3;
            int a = 0;

            a = random.nextInt(2);
            if (a == 0) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "Trận bảng A", data_dsTDDB.get(0).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            } else {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "Trận bảng A", data_dsTDDB.get(0).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b * 2).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }

            for (int i = 1; i < b; i++) {
                a = random.nextInt(2);
                if (a == 0) {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                } else {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b * 2).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
            }

            a = random.nextInt(2);
            if (a == 0) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "Trận bảng B", data_dsTDDB.get(b).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            } else {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "Trận bảng B", data_dsTDDB.get(b).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b * 2).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }

            int c = b + b;
            for (int i = b + 1; i < c; i++) {
                a = random.nextInt(2);
                if (a == 0) {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                } else {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b * 2).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
            }

            a = random.nextInt(2);
            if (a == 0) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "Trận bảng C", data_dsTDDB.get(c).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            } else {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "Trận bảng C", data_dsTDDB.get(c).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }

            for (int i = c+1; i < data_dsTDDB.size(); i++) {
                if (a == 0) {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                } else {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
            }
        }
        else if (data_dsGD.get(Home.so).soBangDau.equals("4")) {
            int b = data_dsTDDB.size() / 4;
            int a = 0;

            a = random.nextInt(3);
            if (a == 0) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "Trận bảng A", data_dsTDDB.get(0).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            } else if(a == 1){
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "Trận bảng A", data_dsTDDB.get(0).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b * 2).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }
            else{
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "Trận bảng A", data_dsTDDB.get(0).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b * 3).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }

            for (int i = 1; i < b; i++) {
                a = random.nextInt(3);
                if (a == 0) {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                } else if(a == 1){
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b * 2).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
                else{
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD001", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b * 3).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
            }

            a = random.nextInt(3);
            if (a == 0) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "Trận bảng B", data_dsTDDB.get(b).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            } else if(a == 1){
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "Trận bảng B", data_dsTDDB.get(b).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b * 2).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }
            else{
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "Trận bảng B", data_dsTDDB.get(b).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b * 3).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }

            int c = b + b;
            for (int i = b + 1; i < c; i++) {
                a = random.nextInt(3);
                if (a == 0) {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
                else if(a == 1){
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b * 2).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }

                else{
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD002", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b * 3).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
            }

            a = random.nextInt(3);
            if (a == 0) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "Trận bảng C", data_dsTDDB.get(c).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            } else if(a == 1){
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "Trận bảng C", data_dsTDDB.get(c).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }
            else{
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "Trận bảng C", data_dsTDDB.get(c).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b * 3).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }

            int d = c+b;
            for (int i = c+1; i < d; i++) {
                a = random.nextInt(3);
                if (a == 0) {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                } else if(a == 1){
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
                else{
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD003", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b * 3).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
            }

            a = random.nextInt(3);
            if (a == 0) {
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD004", "Trận bảng D", data_dsTDDB.get(d).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            } else if(a == 1){
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD004", "Trận bảng D", data_dsTDDB.get(d).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }
            else{
                data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD004", "Trận bảng D", data_dsTDDB.get(d).getTenTDTenDoi(),
                        data_dsTDDB.get(random.nextInt(b) + b * 3).getTenTDTenDoi(), "--/--/--");
                data_dsTDlTD.add(data_TDLTD);
                dbtdLichThiDau.ThemDL(data_TDLTD);
                adapter_dsTDLTD.notifyDataSetChanged();
            }

            for (int i = d+1; i < data_dsTDDB.size(); i++) {
                a = random.nextInt(3);
                if (a == 0) {
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD004", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b)).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                } else if(a == 1){
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD004", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
                else{
                    data_TDLTD = new ClassTDLichThiDau(Home.maGiaiDau, "TDLTD004", "", data_dsTDDB.get(i).getTenTDTenDoi(),
                            data_dsTDDB.get(random.nextInt(b) + b * 3).getTenTDTenDoi(), "--/--/--");
                    data_dsTDlTD.add(data_TDLTD);
                    dbtdLichThiDau.ThemDL(data_TDLTD);
                    adapter_dsTDLTD.notifyDataSetChanged();
                }
            }
        }
        adapter_dsTDLTD.notifyDataSetChanged();
    }

    private void setControl(View view) {
        lvTDLichThiDau = view.findViewById(R.id.lvTDTaoLich);
        btnTDTaoTranDau = view.findViewById(R.id.btnTDTaoTranDau);
        btnTDTaoLich = view.findViewById(R.id.btnTDLichThiDau);
        dpNgayLich = view.findViewById(R.id.dpTDNgayThiDau);
    }
}