package com.example.quanligiaibong;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CauThu extends Fragment {
    EditText edtMa, edtTen, edtNam, edtQuocTich;
    Spinner spGioiTinh, spDB;
    Button btnThem, btnSua, btnXoa, btnXoaHet;
    ListView lvCauThu;
    List<String> data_gioitinh = new ArrayList<>();
    List<String> data_doibong = new ArrayList<>();
    ArrayAdapter adapterGT, adapterDB;
    adapterDSCT adapter_dsct;
    List<ClassCT> data_ct = new ArrayList<>();
    DBCauThu dbCauThu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cau_thu, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        Khoitao();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassCT ct = new ClassCT(edtMa.getText().toString(), edtTen.getText().toString(),
                        edtNam.getText().toString(), edtQuocTich.getText().toString(), spDB.getSelectedItem().toString(),
                        spGioiTinh.getSelectedItem().toString());
                try {
                    dbCauThu.ThemDL(ct);
                    data_ct.clear();
                    data_ct.addAll(dbCauThu.DocDL());
                    adapter_dsct.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Thêm thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Thêm không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoaHet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbCauThu.XoaHetLuon();
                    data_ct.clear();
                    data_ct.addAll(dbCauThu.DocDL());
                    adapter_dsct.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Xóa database thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Xóa database không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        lvCauThu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassCT ct = data_ct.get(position);
                edtMa.setText(ct.getMaCT().toString());
                edtTen.setText(ct.getTenCT().toString());
                edtNam.setText(ct.getNamCT().toString());
                edtQuocTich.setText(ct.getQtCT().toString());
                String [] db = {"Anh", "Argentina", "Brasil", "Campuchia", "Canada", "Cuba", "Đức",
                        "Nhật bản"};
                for (int i = 0; i < db.length-1; i++) {
                    if (db[i].equals(ct.getDbCT()))
                    {
                        spDB.setSelection(i);
                    }
                }
                if (ct.getGtCT().equals("Nam"))
                {
                    spGioiTinh.setSelection(0);
                }
                else {
                    spGioiTinh.setSelection(1);
                }
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassCT ct = new ClassCT(edtMa.getText().toString(), edtTen.getText().toString(),
                        edtNam.getText().toString(), edtQuocTich.getText().toString(), spDB.getSelectedItem().toString(),
                        spGioiTinh.getSelectedItem().toString());
                try {
                    dbCauThu.CapNhat(ct);
                    data_ct.clear();
                    data_ct.addAll(dbCauThu.DocDL());
                    adapter_dsct.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Sửa thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Sửa không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassCT ct = new ClassCT(edtMa.getText().toString(), edtTen.getText().toString(),
                        edtNam.getText().toString(), edtQuocTich.getText().toString(), spDB.getSelectedItem().toString(),
                        spGioiTinh.getSelectedItem().toString());
                try {
                    dbCauThu.XoaDL(ct);
                    data_ct.clear();
                    data_ct.addAll(dbCauThu.DocDL());
                    adapter_dsct.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Xóa thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Xóa không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Khoitao() {
        data_gioitinh.add("Nam");
        data_gioitinh.add("Nữ");
        String [] db = {"Anh", "Argentina", "Brasil", "Campuchia", "Canada", "Cuba", "Đức",
        "Nhật bản", "Ai cập", "Áo", "Ba lan", "Armenia", "Bỉ", "Bồ đào nha", "Liberia", "Rica", "Ấn độ", "Malaysia"};
        for (String s: db) {
            data_doibong.add(s);
        }
        adapterGT = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data_gioitinh);
        spGioiTinh.setAdapter(adapterGT);
        spGioiTinh.setSelection(0);

        adapterDB = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data_doibong);
        spDB.setAdapter(adapterDB);
        spDB.setSelection(0);

        adapter_dsct = new adapterDSCT(getContext(), R.layout.layout_dscauthu, data_ct);
        lvCauThu.setAdapter(adapter_dsct);

        dbCauThu = new DBCauThu(getContext());

        data_ct.addAll(dbCauThu.DocDL());
        adapter_dsct.notifyDataSetChanged();
    }

    private void setControl(View view) {
        edtMa = view.findViewById(R.id.edtMa);
        edtTen = view.findViewById(R.id.edtTenCauThu);
        edtNam = view.findViewById(R.id.edtNam);
        edtQuocTich = view.findViewById(R.id.edtQuocTich);
        spDB = view.findViewById(R.id.spDoiBong);
        spGioiTinh = view.findViewById(R.id.spGioiTinh);
        btnThem = view.findViewById(R.id.btnThem);
        btnSua = view.findViewById(R.id.btnSua);
        btnXoa = view.findViewById(R.id.btnXoa);
        btnXoaHet = view.findViewById(R.id.btnXoaHet);
        lvCauThu = view.findViewById(R.id.lvCauThu);
    }
}