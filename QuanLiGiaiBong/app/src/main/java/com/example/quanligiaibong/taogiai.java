package com.example.quanligiaibong;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class taogiai extends Fragment {
    EditText edtMaGiai, edtTenGiai;
    Spinner spSoBang, spSoDoi;
    Button btnThem, btnSua, btnXoa, btnXoaHet;
    List<String> data_SoBang = new ArrayList<>();
    ArrayAdapter adapter_SoBang, adapter_SoDoi;
    List<String> data_SoDoi = new ArrayList<>();
    List<ClassGD> data_dsgd = new ArrayList<>();
    adapterDSGD adapter_dsgd;
    ListView lvGiaiDau;
    DBGiaiDau dbGiaiDau;
    DBTDDoiBong dbtdDoiBong;
    DBTDLichThiDau dbtdLichThiDau;
    DBTDXepHang dbtdXepHang;
    DBTDKetQua dbtdKetQua;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_taogiai, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        KhoiTao();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassGD gd = new ClassGD(edtMaGiai.getText().toString(), edtTenGiai.getText().toString(),
                        spSoBang.getSelectedItem().toString(), spSoDoi.getSelectedItem().toString());
                try {
                    dbGiaiDau.ThemDL(gd);
                    data_dsgd.clear();
                    data_dsgd.addAll(dbGiaiDau.DocDL());
                    adapter_dsgd.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Thêm thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Thêm không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        spSoBang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spSoBang.getSelectedItem().equals("2")) {
                    data_SoDoi.clear();
                    for (int i = 2; i < 19; i+=2) {
                        data_SoDoi.add(i+"");
                        adapter_SoDoi.notifyDataSetChanged();
                    }
                }
                else if(spSoBang.getSelectedItem().equals("3")){
                    data_SoDoi.clear();
                    for (int i = 3; i < 19; i+=3) {
                        data_SoDoi.add(i+"");
                        adapter_SoDoi.notifyDataSetChanged();
                    }
                }else if(spSoBang.getSelectedItem().equals("4")){
                    data_SoDoi.clear();
                    for (int i = 4; i < 19; i+=4) {
                        data_SoDoi.add(i+"");
                        adapter_SoDoi.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lvGiaiDau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassGD gd = data_dsgd.get(position);
                edtMaGiai.setText(gd.getMaGD());
                edtTenGiai.setText(gd.getTenGD());
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassGD gd = new ClassGD(edtMaGiai.getText().toString(), edtTenGiai.getText().toString(),
                        spSoBang.getSelectedItem().toString(), spSoDoi.getSelectedItem().toString());
                try {
                    dbGiaiDau.XoaDL(gd);
                    data_dsgd.clear();
                    data_dsgd.addAll(dbGiaiDau.DocDL());
                    adapter_dsgd.notifyDataSetChanged();

                    dbtdDoiBong.XoaDL(edtMaGiai.getText().toString());
                    dbtdLichThiDau.XoaDL(edtMaGiai.getText().toString());
                    dbtdXepHang.XoaDL(edtMaGiai.getText().toString());
                    dbtdKetQua.XoaDL(edtMaGiai.getText().toString());

                    Toast.makeText(getContext(), "Xóa thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Xóa không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassGD gd = new ClassGD(edtMaGiai.getText().toString(), edtTenGiai.getText().toString(),
                        spSoBang.getSelectedItem().toString(), spSoDoi.getSelectedItem().toString());
                try {
                    dbGiaiDau.CapNhat(gd);
                    data_dsgd.clear();
                    data_dsgd.addAll(dbGiaiDau.DocDL());
                    adapter_dsgd.notifyDataSetChanged();

                    dbtdDoiBong.XoaDL(edtMaGiai.getText().toString());
                    dbtdLichThiDau.XoaDL(edtMaGiai.getText().toString());
                    dbtdXepHang.XoaDL(edtMaGiai.getText().toString());
                    dbtdKetQua.XoaDL(edtMaGiai.getText().toString());

                    Toast.makeText(getContext(), "Sửa thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Sửa không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXoaHet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbGiaiDau.XoaHetLuon();
                    data_dsgd.clear();
                    data_dsgd.addAll(dbGiaiDau.DocDL());

                    dbtdDoiBong.XoaTatCa();
                    dbtdLichThiDau.XoaTatCa();
                    dbtdXepHang.XoaTatCa();
                    dbtdKetQua.XoaTatCa();

                    adapter_dsgd.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Xóa database thành công!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Xóa database không thành công!!" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void KhoiTao()
    {
        for (int i = 4; i < 19; i++) {
            data_SoDoi.add(i+"");
        }

        for (int i = 2; i < 5; i++) {
            data_SoBang.add(i+"");
        }

        adapter_SoBang = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data_SoBang);
        spSoBang.setAdapter(adapter_SoBang);
        spSoBang.setSelection(0);

        adapter_SoDoi = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data_SoDoi);
        spSoDoi.setAdapter(adapter_SoDoi);

        adapter_dsgd = new adapterDSGD(getContext(), R.layout.layout_taogiai, data_dsgd);
        lvGiaiDau.setAdapter(adapter_dsgd);

        dbGiaiDau = new DBGiaiDau(getContext());
        data_dsgd.addAll(dbGiaiDau.DocDL());
        adapter_dsgd.notifyDataSetChanged();

        dbtdDoiBong = new DBTDDoiBong(getContext());
        dbtdLichThiDau = new DBTDLichThiDau(getContext());
        dbtdXepHang = new DBTDXepHang(getContext());
        dbtdKetQua= new DBTDKetQua(getContext());
    }

    private void setControl(View view) {
        edtMaGiai = view.findViewById(R.id.edtMaGiai);
        edtTenGiai = view.findViewById(R.id.edtTenGiai);

        spSoBang = view.findViewById(R.id.spSoBangDau);
        spSoDoi = view.findViewById(R.id.spSoDoiBong);

        btnThem = view.findViewById(R.id.btnThem);
        btnSua = view.findViewById(R.id.btnSua);
        btnXoa = view.findViewById(R.id.btnXoa);
        btnXoaHet = view.findViewById(R.id.btnXoaHet);

        lvGiaiDau = view.findViewById(R.id.lvTaoGiai);
    }
}