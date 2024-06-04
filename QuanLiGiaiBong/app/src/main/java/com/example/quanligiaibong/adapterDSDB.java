package com.example.quanligiaibong;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class adapterDSDB extends ArrayAdapter {
    Context context;
    int resource;
    List<ClassDB> data;
    public adapterDSDB(@NonNull Context context, int resource, List<ClassDB> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(resource,null);
        TextView tvmaCT = convertView.findViewById(R.id.tvmaCT);
        TextView tvtenCT = convertView.findViewById(R.id.tvtenCT);
        ImageView ivgt = convertView.findViewById(R.id.ivGioiTinh);
        ClassDB dsCT = data.get(position);
        tvmaCT.setText(dsCT.getMaDB());
        tvtenCT.setText(dsCT.getQtDB());
        LayAnhDB(dsCT.getTenDB(), ivgt);
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
            iv.setImageResource(R.drawable.aicap);
        }
        if (s.equals("Áo"))
        {
            iv.setImageResource(R.drawable.ao);
        }
        if (s.equals("Armenia"))
        {
            iv.setImageResource(R.drawable.armenia);
        }
        if (s.equals("Ba lan"))
        {
            iv.setImageResource(R.drawable.balan);
        }
        if (s.equals("Bỉ"))
        {
            iv.setImageResource(R.drawable.bi);
        }
        if (s.equals("Bồ đào nha"))
        {
            iv.setImageResource(R.drawable.bodaonha);
        }
        if (s.equals("Liberia"))
        {
            iv.setImageResource(R.drawable.liberia);
        }
        if (s.equals("Rica"))
        {
            iv.setImageResource(R.drawable.rica);
        }
        if (s.equals("Ấn độ"))
        {
            iv.setImageResource(R.drawable.ando);
        }
        if (s.equals("Malaysia"))
        {
            iv.setImageResource(R.drawable.malaysia);
        }
    }
}
