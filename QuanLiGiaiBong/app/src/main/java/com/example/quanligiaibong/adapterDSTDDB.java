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

public class adapterDSTDDB extends ArrayAdapter {
    Context context;
    int resource;
    List<ClassTDDoiBong> data;
    public adapterDSTDDB(@NonNull Context context, int resource, List<ClassTDDoiBong> data) {
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
        ClassTDDoiBong dstdDB = data.get(position);

        if (dstdDB.getMaTDDoiBong().equals("TDDB001"))
        {
            if (dstdDB.getTenTDTenVongBang().equals("Bảng A"))
            {
                tvtdTenVongBang.setText(dstdDB.getTenTDTenVongBang());
                tvtdTenDoi.setText(dstdDB.getTenTDTenDoi());
                LayAnhDB(dstdDB.getTenTDTenDoi(), ivTDAnhDoi);
            }
            else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);
                tvtdTenDoi.setText(dstdDB.getTenTDTenDoi());
                LayAnhDB(dstdDB.getTenTDTenDoi(), ivTDAnhDoi);
            }
        } else if (dstdDB.getMaTDDoiBong().equals("TDDB002")) {
            if (dstdDB.getTenTDTenVongBang().equals("Bảng B"))
            {
                tvtdTenVongBang.setText(dstdDB.getTenTDTenVongBang());
                tvtdTenDoi.setText(dstdDB.getTenTDTenDoi());
                LayAnhDB(dstdDB.getTenTDTenDoi(), ivTDAnhDoi);
            }
            else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);
                tvtdTenDoi.setText(dstdDB.getTenTDTenDoi());
                LayAnhDB(dstdDB.getTenTDTenDoi(), ivTDAnhDoi);
            }
        } else if (dstdDB.getMaTDDoiBong().equals("TDDB003")) {
            if (dstdDB.getTenTDTenVongBang().equals("Bảng C"))
            {
                tvtdTenVongBang.setText(dstdDB.getTenTDTenVongBang());
                tvtdTenDoi.setText(dstdDB.getTenTDTenDoi());
                LayAnhDB(dstdDB.getTenTDTenDoi(), ivTDAnhDoi);
            }
            else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);
                tvtdTenDoi.setText(dstdDB.getTenTDTenDoi());
                LayAnhDB(dstdDB.getTenTDTenDoi(), ivTDAnhDoi);
            }
        } else if (dstdDB.getMaTDDoiBong().equals("TDDB004")) {
            if (dstdDB.getTenTDTenVongBang().equals("Bảng D"))
            {
                tvtdTenVongBang.setText(dstdDB.getTenTDTenVongBang());
                tvtdTenDoi.setText(dstdDB.getTenTDTenDoi());
                LayAnhDB(dstdDB.getTenTDTenDoi(), ivTDAnhDoi);
            }
            else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);
                tvtdTenDoi.setText(dstdDB.getTenTDTenDoi());
                LayAnhDB(dstdDB.getTenTDTenDoi(), ivTDAnhDoi);
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
