package com.example.quanligiaibong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class adapterDSTDXH extends ArrayAdapter {
    Context context;
    int resource;
    List<ClassTDXepHang> data;
    public adapterDSTDXH(@NonNull Context context, int resource, List<ClassTDXepHang> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(resource,null);
        TextView tvtdTenVongBang = convertView.findViewById(R.id.TDTenBang);

        TextView tvtdTenDoi = convertView.findViewById(R.id.TDTenDoi);
        ImageView ivTDAnhDoi = convertView.findViewById(R.id.TDAnhDoi);

        TextView tvtdThang = convertView.findViewById(R.id.tvTDXepHangThang);
        TextView tvtdHoa = convertView.findViewById(R.id.tvTDXepHangHoa);
        TextView tvtdThua = convertView.findViewById(R.id.tvTDXepHangThua);

        TextView tvXepHang = convertView.findViewById(R.id.tvXepHang);

        ClassTDXepHang dstdXH = data.get(position);

        if (dstdXH.getMaTDLichThiDau().equals("TDLTD001")) {
            if (dstdXH.getTenTDBang().equals("Trận bảng A")) {
                tvtdTenVongBang.setText("Bảng A");

                tvtdTenDoi.setText(dstdXH.getTenTDDoi());

                LayAnhDB(dstdXH.getTenTDDoi(), ivTDAnhDoi);

                tvtdThang.setText(dstdXH.getThangTDXepHang());
                tvtdHoa.setText(dstdXH.getHoaTDXepHang());
                tvtdThua.setText(dstdXH.getThuTDXepHang());

                tvXepHang.setText(dstdXH.getTdXepHang());
            } else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);

                tvtdTenDoi.setText(dstdXH.getTenTDDoi());

                LayAnhDB(dstdXH.getTenTDDoi(), ivTDAnhDoi);

                tvtdThang.setText(dstdXH.getThangTDXepHang());
                tvtdHoa.setText(dstdXH.getHoaTDXepHang());
                tvtdThua.setText(dstdXH.getThuTDXepHang());

                tvXepHang.setText(dstdXH.getTdXepHang());
            }
        }


        else if (dstdXH.getMaTDLichThiDau().equals("TDLTD002")) {
            if (dstdXH.getTenTDBang().equals("Trận bảng B")) {
                tvtdTenVongBang.setText("Bảng B");

                tvtdTenDoi.setText(dstdXH.getTenTDDoi());

                LayAnhDB(dstdXH.getTenTDDoi(), ivTDAnhDoi);

                tvtdThang.setText(dstdXH.getThangTDXepHang());
                tvtdHoa.setText(dstdXH.getHoaTDXepHang());
                tvtdThua.setText(dstdXH.getThuTDXepHang());

                tvXepHang.setText(dstdXH.getTdXepHang());
            } else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);

                tvtdTenDoi.setText(dstdXH.getTenTDDoi());

                LayAnhDB(dstdXH.getTenTDDoi(), ivTDAnhDoi);

                tvtdThang.setText(dstdXH.getThangTDXepHang());
                tvtdHoa.setText(dstdXH.getHoaTDXepHang());
                tvtdThua.setText(dstdXH.getThuTDXepHang());

                tvXepHang.setText(dstdXH.getTdXepHang());
            }
        }


        else if (dstdXH.getMaTDLichThiDau().equals("TDLTD003")) {
            if (dstdXH.getTenTDBang().equals("Trận bảng C")) {
                tvtdTenVongBang.setText("Bảng C");

                tvtdTenDoi.setText(dstdXH.getTenTDDoi());

                LayAnhDB(dstdXH.getTenTDDoi(), ivTDAnhDoi);

                tvtdThang.setText(dstdXH.getThangTDXepHang());
                tvtdHoa.setText(dstdXH.getHoaTDXepHang());
                tvtdThua.setText(dstdXH.getThuTDXepHang());

                tvXepHang.setText(dstdXH.getTdXepHang());
            } else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);

                tvtdTenDoi.setText(dstdXH.getTenTDDoi());

                LayAnhDB(dstdXH.getTenTDDoi(), ivTDAnhDoi);

                tvtdThang.setText(dstdXH.getThangTDXepHang());
                tvtdHoa.setText(dstdXH.getHoaTDXepHang());
                tvtdThua.setText(dstdXH.getThuTDXepHang());

                tvXepHang.setText(dstdXH.getTdXepHang());
            }
        }


        else if (dstdXH.getMaTDLichThiDau().equals("TDLTD004")) {
            if (dstdXH.getTenTDBang().equals("Trận bảng D")) {
                tvtdTenVongBang.setText("Bảng D");

                tvtdTenDoi.setText(dstdXH.getTenTDDoi());

                LayAnhDB(dstdXH.getTenTDDoi(), ivTDAnhDoi);

                tvtdThang.setText(dstdXH.getThangTDXepHang());
                tvtdHoa.setText(dstdXH.getHoaTDXepHang());
                tvtdThua.setText(dstdXH.getThuTDXepHang());

                tvXepHang.setText(dstdXH.getTdXepHang());
            } else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);

                tvtdTenDoi.setText(dstdXH.getTenTDDoi());

                LayAnhDB(dstdXH.getTenTDDoi(), ivTDAnhDoi);

                tvtdThang.setText(dstdXH.getThangTDXepHang());
                tvtdHoa.setText(dstdXH.getHoaTDXepHang());
                tvtdThua.setText(dstdXH.getThuTDXepHang());

                tvXepHang.setText(dstdXH.getTdXepHang());
            }
        }

        return convertView;
    }
    private void LayAnhDB(String s, ImageView iv)
    {
        if (s.equals("Anh"))
        {
            iv.setImageResource(R.drawable.anh);
        }
        if (s.equals("Argentina"))
        {
            iv.setImageResource(R.drawable.argentina);
        }
        if (s.equals("Brasil"))
        {
            iv.setImageResource(R.drawable.brasil);
        }
        if (s.equals("Campuchia"))
        {
            iv.setImageResource(R.drawable.campuchia);
        }
        if (s.equals("Canada"))
        {
            iv.setImageResource(R.drawable.canada);
        }
        if (s.equals("Cuba"))
        {
            iv.setImageResource(R.drawable.cuba);
        }
        if (s.equals("Đức"))
        {
            iv.setImageResource(R.drawable.duc);
        }
        if (s.equals("Nhật bản"))
        {
            iv.setImageResource(R.drawable.nhatban);
        }

        if (s.equals("Ai cập"))
        {
            iv.setImageResource(R.drawable.anh);
        }
        if (s.equals("Áo"))
        {
            iv.setImageResource(R.drawable.argentina);
        }
        if (s.equals("Armenia"))
        {
            iv.setImageResource(R.drawable.brasil);
        }
        if (s.equals("Ba lan"))
        {
            iv.setImageResource(R.drawable.campuchia);
        }
        if (s.equals("Bỉ"))
        {
            iv.setImageResource(R.drawable.canada);
        }
        if (s.equals("Bồ đào nha"))
        {
            iv.setImageResource(R.drawable.cuba);
        }
        if (s.equals("Liberia"))
        {
            iv.setImageResource(R.drawable.duc);
        }
        if (s.equals("Rica"))
        {
            iv.setImageResource(R.drawable.nhatban);
        }
        if (s.equals("Ai cập"))
        {
            iv.setImageResource(R.drawable.duc);
        }
        if (s.equals("Malaysia"))
        {
            iv.setImageResource(R.drawable.nhatban);
        }
    }
}
