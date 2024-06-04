package com.example.quanligiaibong;

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

public class DoiBong extends Fragment {
    EditText edtMa, edtQuocTich;
    Spinner spDB;
    Button btnThem, btnSua, btnXoa, btnXoaHet;
    ListView lvDoiBong;
    List<String> data_doibong = new ArrayList<>();
    ArrayAdapter adapterDB;
    adapterDSDB adapter_dsdb;
    List<ClassDB> data_dsdb = new ArrayList<>();
    DBDoiBong dbDoiBong;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doi_bong, container, false);
        setControl(view);
        setEvent();
        return view;
    }
    private void setEvent() {
        Khoitao();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassDB db = new ClassDB(edtMa.getText().toString(), spDB.getSelectedItem().toString(), edtQuocTich.getText().toString());
                try {
                    dbDoiBong.ThemDL(db);
                    data_dsdb.clear();
                    data_dsdb.addAll(dbDoiBong.DocDL());
                    adapter_dsdb.notifyDataSetChanged();
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
                    dbDoiBong.XoaHetLuon();
                    data_dsdb.clear();
                    data_dsdb.addAll(dbDoiBong.DocDL());
                    adapter_dsdb.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Xóa database thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Xóa database không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        lvDoiBong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassDB db = data_dsdb.get(position);
                edtMa.setText(db.getMaDB().toString());
                edtQuocTich.setText(db.getQtDB().toString());
                String [] dbb = {"Anh", "Argentina", "Brasil", "Campuchia", "Canada", "Cuba", "Đức",
                        "Nhật bản"};
                for (int i = 0; i < dbb.length-1; i++) {
                    if (dbb[i].equals(db.getTenDB()))
                    {
                        spDB.setSelection(i);
                    }
                }
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassDB db = new ClassDB(edtMa.getText().toString(), spDB.getSelectedItem().toString(), edtQuocTich.getText().toString());
                try {
                    dbDoiBong.CapNhat(db);
                    data_dsdb.clear();
                    data_dsdb.addAll(dbDoiBong.DocDL());
                    adapter_dsdb.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Sửa thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Sửa không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassDB db = new ClassDB(edtMa.getText().toString(), edtQuocTich.getText().toString(), spDB.getSelectedItem().toString());
                try {
                    dbDoiBong.XoaDL(db);
                    data_dsdb.clear();
                    data_dsdb.addAll(dbDoiBong.DocDL());
                    adapter_dsdb.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Xóa thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Xóa không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void Khoitao() {
        String [] db = {"Anh", "Argentina", "Brasil", "Campuchia", "Canada", "Cuba", "Đức",
                "Nhật bản", "Ai cập", "Áo", "Ba lan", "Armenia", "Bỉ", "Bồ đào nha", "Liberia", "Rica", "Ấn độ", "Malaysia"};
        for (String s: db) {
            data_doibong.add(s);
        }

        adapterDB = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data_doibong);
        spDB.setAdapter(adapterDB);
        spDB.setSelection(0);

        adapter_dsdb = new adapterDSDB(getContext(), R.layout.layout_dsdb, data_dsdb);
        lvDoiBong.setAdapter(adapter_dsdb);

        dbDoiBong = new DBDoiBong(getContext());

        data_dsdb.addAll(dbDoiBong.DocDL());
        adapter_dsdb.notifyDataSetChanged();
    }

    private void setControl(View view) {
        edtMa = view.findViewById(R.id.edtMa);
        edtQuocTich = view.findViewById(R.id.edtQuocTich);
        spDB = view.findViewById(R.id.spDoiBong);
        btnThem = view.findViewById(R.id.btnThem);
        btnSua = view.findViewById(R.id.btnSua);
        btnXoa = view.findViewById(R.id.btnXoa);
        btnXoaHet = view.findViewById(R.id.btnXoaHet);
        lvDoiBong = view.findViewById(R.id.lvCauThu);
    }
}