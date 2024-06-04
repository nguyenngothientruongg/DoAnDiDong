package com.example.quanligiaibong;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class td_ketqua extends Fragment {
    EditText edtDiemDoi1, edtDiemDoi2;
    Button btnXacNhan;
    ListView lvTDKQ;
    List<ClassTDKetQua> data_dsTDKQ = new ArrayList<>();
    List<ClassTDLichThiDau> data_dsTDLTD = new ArrayList<>();
    adapterDSTDKQ adapter_dsTDKQ;
    DBTDLichThiDau dbtdLichThiDau;
    DBTDKetQua dbtdKetQua;
    int a=0;

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
        KhoiTao();

        lvTDKQ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtDiemDoi1.setVisibility(View.VISIBLE);
                edtDiemDoi2.setVisibility(View.VISIBLE);
                btnXacNhan.setVisibility(View.VISIBLE);
                lvTDKQ.setVisibility(View.GONE);
                a=position;
            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_dsTDKQ.get(a).setDiemTDKetQuaDoi1(edtDiemDoi1.getText().toString());
                data_dsTDKQ.get(a).setDiemTDKetQuaDoi2(edtDiemDoi2.getText().toString());


                SetKQ(edtDiemDoi1.getText().toString(), edtDiemDoi2.getText().toString());
                adapter_dsTDKQ.notifyDataSetChanged();


                lvTDKQ.setVisibility(View.VISIBLE);
                dbtdKetQua.XoaDL(Home.maGiaiDau);
                for (int i = 0; i < data_dsTDKQ.size(); i++) {
                    dbtdKetQua.ThemDL(data_dsTDKQ.get(i));
                }
                edtDiemDoi1.setVisibility(View.GONE);
                edtDiemDoi2.setVisibility(View.GONE);
                btnXacNhan.setVisibility(View.GONE);
            }
        });
    }
    private void SetKQ(String x, String y)
    {
        if (Integer.parseInt(x)>Integer.parseInt(y)){
            data_dsTDKQ.get(a).setKetquaTDDoi1("Thắng");
            data_dsTDKQ.get(a).setKetquaTDDoi2("Thua");
        } else if (Integer.parseInt(x)<Integer.parseInt(y)) {
            data_dsTDKQ.get(a).setKetquaTDDoi2("Thắng");
            data_dsTDKQ.get(a).setKetquaTDDoi1("Thua");
        }
        else{
            data_dsTDKQ.get(a).setKetquaTDDoi1("Hòa");
            data_dsTDKQ.get(a).setKetquaTDDoi2("Hòa");
        }
    }
    private void KhoiTao(){
        dbtdKetQua = new DBTDKetQua(getContext());
        dbtdLichThiDau = new DBTDLichThiDau(getContext());
        data_dsTDLTD.addAll(dbtdLichThiDau.DocDL(Home.maGiaiDau));
        
        adapter_dsTDKQ = new adapterDSTDKQ(getContext(), R.layout.layout_td_ketqua, data_dsTDKQ);
        lvTDKQ.setAdapter(adapter_dsTDKQ);

        if (dbtdLichThiDau.DocDL(Home.maGiaiDau).size() == 0) {
            Toast.makeText(getContext(), "Chưa có lịch đấu!!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (dbtdKetQua.DocDL(Home.maGiaiDau).size()==0)
            {
                ClassTDKetQua data_tdkq;
                for (int i = 0; i < data_dsTDLTD.size(); i++) {
                    data_tdkq = new ClassTDKetQua(Home.maGiaiDau, data_dsTDLTD.get(i).getMaTDLichThiDau(),
                            data_dsTDLTD.get(i).getTenTDBang(), data_dsTDLTD.get(i).getTenTDDoi1(),
                            data_dsTDLTD.get(i).getTenTDDoi2(), "0","0","---", "---");
                    data_dsTDKQ.add(data_tdkq);
                    dbtdKetQua.ThemDL(data_tdkq);
                }
            }
            else {
                data_dsTDKQ.addAll(dbtdKetQua.DocDL(Home.maGiaiDau));
            }
            adapter_dsTDKQ.notifyDataSetChanged();
        }
    }
    private void setControl(View view) {
        edtDiemDoi1 = view.findViewById(R.id.edtTDDiemDoi1);
        edtDiemDoi2 = view.findViewById(R.id.edtTDDiemDoi2);

        btnXacNhan = view.findViewById(R.id.btnLuuKetQua);

        lvTDKQ = view.findViewById(R.id.lvTDKetQua);
    }
}