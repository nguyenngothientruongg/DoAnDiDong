package com.example.quanligiaibong;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    ListView lvHome;
    DBGiaiDau dbGiaiDau;
    adapterDSGD adapter_dsgd;
    static int so;
    static String tenGiaiDau;
    static String maGiaiDau;
    List<ClassGD> data_dsgd = new ArrayList<>();
    DBTDDoiBong dbtdDoiBong;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        adapter_dsgd = new adapterDSGD(getContext(), R.layout.layout_taogiai, data_dsgd);
        lvHome.setAdapter(adapter_dsgd);

        dbGiaiDau = new DBGiaiDau(getContext());
        dbtdDoiBong = new DBTDDoiBong(getContext());

        data_dsgd.addAll(dbGiaiDau.DocDL());
        adapter_dsgd.notifyDataSetChanged();

        lvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                so = position;
                tenGiaiDau = data_dsgd.get(position).getTenGD();
                maGiaiDau = data_dsgd.get(position).getMaGD();

                Intent intent = new Intent(getContext(), TranDau.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);

            }
        });
    }

    private void setControl(View view) {
        lvHome = view.findViewById(R.id.lvCauThu);
    }
}