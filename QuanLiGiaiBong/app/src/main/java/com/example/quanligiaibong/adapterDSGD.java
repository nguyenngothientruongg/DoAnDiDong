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

public class adapterDSGD extends ArrayAdapter {
    Context context;
    int resource;
    List<ClassGD> data;
    public adapterDSGD(@NonNull Context context, int resource, List<ClassGD> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(resource,null);
        TextView tvMaGD = convertView.findViewById(R.id.tvmaGiaiDau);
        TextView tvTenGD = convertView.findViewById(R.id.tvtenGiaiDau);
        TextView tvSoBang = convertView.findViewById(R.id.tvSoBangDau);
        TextView tvSoDoi = convertView.findViewById(R.id.tvSoDoi);
        ClassGD dsCT = data.get(position);
        tvMaGD.setText(dsCT.getMaGD());
        tvTenGD.setText(dsCT.getTenGD());
        tvSoBang.setText(dsCT.getSoBangDau());
        tvSoDoi.setText(dsCT.getSoDoi());
        return convertView;
    }
}
