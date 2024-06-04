package com.example.quanligiaibong;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class td_thongke extends Fragment {
    TextView tvTenMuaGiai, tvSoBangDau, tvSoDoiBong, tvSoTranDau;
    TextView tvDoiThangA, tvDoiThangA1, tvDoiThangB, tvDoiThangB1, tvDoiThangC, tvDoiThangC1, tvDoiThangD, tvDoiThangD1;
    List<ClassTDLichThiDau> data_dstdltd = new ArrayList<>();

    List<ClassTDXepHang> data_dstdxh = new ArrayList<>();
    List<ClassGD> data_dsgd = new ArrayList<>();
    DBTDLichThiDau dbtdLichThiDau;
    DBTDXepHang dbtdXepHang;
    DBGiaiDau dbGiaiDau;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_td_thongke, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        dbtdLichThiDau = new DBTDLichThiDau(getContext());
        dbtdXepHang = new DBTDXepHang(getContext());
        dbGiaiDau = new DBGiaiDau(getContext());

        if (dbtdXepHang.DocDL(Home.maGiaiDau).size() == 0) {
            Toast.makeText(getContext(), "Chưa có kết quả!!", Toast.LENGTH_SHORT).show();
        } else {

            data_dstdltd.addAll(dbtdLichThiDau.DocDL(Home.maGiaiDau));
            data_dstdxh.addAll(dbtdXepHang.DocDL(Home.maGiaiDau));
            data_dsgd.addAll(dbGiaiDau.DocDL());
            tvTenMuaGiai.setText(Home.tenGiaiDau);
            tvSoBangDau.setText(data_dsgd.get(Home.so).getSoBangDau());
            tvSoDoiBong.setText(data_dsgd.get(Home.so).getSoDoi());
            tvSoTranDau.setText(data_dstdltd.size()+"");
            if (data_dsgd.get(Home.so).getSoBangDau().equals("2")) {
                for (int i = 0; i < data_dstdxh.size(); i++) {
                    if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD001")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangA1.setText(data_dstdxh.get(i).getTenTDDoi());
                            tvDoiThangC.setText("");
                            tvDoiThangD.setText("");
                        }
                    } else if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD002")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangB1.setText(data_dstdxh.get(i).getTenTDDoi());
                        }
                    }
                }
            } else if (data_dsgd.get(Home.so).getSoBangDau().equals("3")) {
                for (int i = 0; i < data_dstdxh.size(); i++) {
                    if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD001")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangA1.setText(data_dstdxh.get(i).getTenTDDoi());
                            tvDoiThangD.setText("");
                        }
                    } else if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD002")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangB1.setText(data_dstdxh.get(i).getTenTDDoi());
                        }
                    } else if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD003")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangC1.setText(data_dstdxh.get(i).getTenTDDoi());
                        }
                    }
                }
            } else if (data_dsgd.get(Home.so).getSoBangDau().equals("4")) {
                for (int i = 0; i < data_dstdxh.size(); i++) {
                    if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD001")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangA1.setText(data_dstdxh.get(i).getTenTDDoi());
                        }
                    } else if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD002")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangB1.setText(data_dstdxh.get(i).getTenTDDoi());
                        }
                    } else if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD003")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangC1.setText(data_dstdxh.get(i).getTenTDDoi());
                        }
                    } else if (data_dstdxh.get(i).getMaTDLichThiDau().equals("TDLTD004")) {
                        if (data_dstdxh.get(i).getTdXepHang().equals("1")) {
                            tvDoiThangD1.setText(data_dstdxh.get(i).getTenTDDoi());
                        }
                    }
                }
            }
        }
    }

    private void setControl(View view) {
        tvTenMuaGiai = view.findViewById(R.id.tvTDTKTenMuaGiai);
        tvSoBangDau = view.findViewById(R.id.tvTDTKBangDau);
        tvSoDoiBong = view.findViewById(R.id.tvTDTKDoiBong);
        tvSoTranDau = view.findViewById(R.id.tvTDTKTranDau);

        tvDoiThangA = view.findViewById(R.id.tvTDTKBangA);
        tvDoiThangA1 = view.findViewById(R.id.tvTDTKBangA1);

        tvDoiThangB = view.findViewById(R.id.tvTDTKBangB);
        tvDoiThangB1 = view.findViewById(R.id.tvTDTKBangB1);

        tvDoiThangC = view.findViewById(R.id.tvTDTKBangC);
        tvDoiThangC1 = view.findViewById(R.id.tvTDTKBangC1);

        tvDoiThangD = view.findViewById(R.id.tvTDTKBangD);
        tvDoiThangD1 = view.findViewById(R.id.tvTDTKBangD1);
    }
}