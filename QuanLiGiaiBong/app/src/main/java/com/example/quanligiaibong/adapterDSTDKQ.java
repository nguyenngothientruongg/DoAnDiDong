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

public class adapterDSTDKQ extends ArrayAdapter {
    Context context;
    int resource;
    List<ClassTDKetQua> data;

    public adapterDSTDKQ(@NonNull Context context, int resource, List<ClassTDKetQua> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        TextView tvtdTenVongBang = convertView.findViewById(R.id.TDTenBang);

        TextView tvtdKetQua1 = convertView.findViewById(R.id.tvTDKetQua1);
        TextView tvtdKetQua2 = convertView.findViewById(R.id.tvTDKetQua2);

        ImageView ivTDAnhDoi1 = convertView.findViewById(R.id.TDAnhDoi1);
        ImageView ivTDAnhDoi2 = convertView.findViewById(R.id.TDAnhDoi2);

        TextView tvtdKetQuaDoi1 = convertView.findViewById(R.id.tvTDKetQuaDoi1);
        TextView tvtdKetQuaDoi2 = convertView.findViewById(R.id.tvTDKetQuaDoi2);
        ClassTDKetQua dsTDKQ = data.get(position);

        if (dsTDKQ.getMaTDKetQua().equals("TDLTD001")) {
            if (dsTDKQ.getTenTDBang().equals("Trận bảng A")) {
                tvtdTenVongBang.setText("Kết quả trận đấu bảng A");

                tvtdKetQua1.setText(dsTDKQ.getKetquaTDDoi1());
                tvtdKetQua2.setText(dsTDKQ.getKetquaTDDoi2());

                LayAnhDB(dsTDKQ.getTenTDDoi1(), ivTDAnhDoi1);
                LayAnhDB(dsTDKQ.getTenTDDoi2(), ivTDAnhDoi2);

                tvtdKetQuaDoi1.setText(dsTDKQ.getDiemTDKetQuaDoi1());
                tvtdKetQuaDoi2.setText(dsTDKQ.getDiemTDKetQuaDoi2());
            } else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);

                tvtdKetQua1.setText(dsTDKQ.getKetquaTDDoi1());
                tvtdKetQua2.setText(dsTDKQ.getKetquaTDDoi2());

                LayAnhDB(dsTDKQ.getTenTDDoi1(), ivTDAnhDoi1);
                LayAnhDB(dsTDKQ.getTenTDDoi2(), ivTDAnhDoi2);

                tvtdKetQuaDoi1.setText(dsTDKQ.getDiemTDKetQuaDoi1());
                tvtdKetQuaDoi2.setText(dsTDKQ.getDiemTDKetQuaDoi2());
            }
        }


        else if (dsTDKQ.getMaTDKetQua().equals("TDLTD002")) {
            if (dsTDKQ.getTenTDBang().equals("Trận bảng B")) {
                tvtdTenVongBang.setText("Kết quả trận đấu bảng B");

                tvtdKetQua1.setText(dsTDKQ.getKetquaTDDoi1());
                tvtdKetQua2.setText(dsTDKQ.getKetquaTDDoi2());

                LayAnhDB(dsTDKQ.getTenTDDoi1(), ivTDAnhDoi1);
                LayAnhDB(dsTDKQ.getTenTDDoi2(), ivTDAnhDoi2);

                tvtdKetQuaDoi1.setText(dsTDKQ.getDiemTDKetQuaDoi1());
                tvtdKetQuaDoi2.setText(dsTDKQ.getDiemTDKetQuaDoi2());
            } else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);

                tvtdKetQua1.setText(dsTDKQ.getKetquaTDDoi1());
                tvtdKetQua2.setText(dsTDKQ.getKetquaTDDoi2());

                LayAnhDB(dsTDKQ.getTenTDDoi1(), ivTDAnhDoi1);
                LayAnhDB(dsTDKQ.getTenTDDoi2(), ivTDAnhDoi2);

                tvtdKetQuaDoi1.setText(dsTDKQ.getDiemTDKetQuaDoi1());
                tvtdKetQuaDoi2.setText(dsTDKQ.getDiemTDKetQuaDoi2());
            }
        }


        else if (dsTDKQ.getMaTDKetQua().equals("TDLTD003")) {
            if (dsTDKQ.getTenTDBang().equals("Trận bảng C")) {
                tvtdTenVongBang.setText("Kết quả trận đấu bảng C");

                tvtdKetQua1.setText(dsTDKQ.getKetquaTDDoi1());
                tvtdKetQua2.setText(dsTDKQ.getKetquaTDDoi2());

                LayAnhDB(dsTDKQ.getTenTDDoi1(), ivTDAnhDoi1);
                LayAnhDB(dsTDKQ.getTenTDDoi2(), ivTDAnhDoi2);

                tvtdKetQuaDoi1.setText(dsTDKQ.getDiemTDKetQuaDoi1());
                tvtdKetQuaDoi2.setText(dsTDKQ.getDiemTDKetQuaDoi2());
            } else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);

                tvtdKetQua1.setText(dsTDKQ.getKetquaTDDoi1());
                tvtdKetQua2.setText(dsTDKQ.getKetquaTDDoi2());

                LayAnhDB(dsTDKQ.getTenTDDoi1(), ivTDAnhDoi1);
                LayAnhDB(dsTDKQ.getTenTDDoi2(), ivTDAnhDoi2);

                tvtdKetQuaDoi1.setText(dsTDKQ.getDiemTDKetQuaDoi1());
                tvtdKetQuaDoi2.setText(dsTDKQ.getDiemTDKetQuaDoi2());
            }
        }


        else if (dsTDKQ.getMaTDKetQua().equals("TDLTD004")) {
            if (dsTDKQ.getTenTDBang().equals("Trận bảng D")) {
                tvtdTenVongBang.setText("Kết quả trận đấu bảng D");

                tvtdKetQua1.setText(dsTDKQ.getKetquaTDDoi1());
                tvtdKetQua2.setText(dsTDKQ.getKetquaTDDoi2());

                LayAnhDB(dsTDKQ.getTenTDDoi1(), ivTDAnhDoi1);
                LayAnhDB(dsTDKQ.getTenTDDoi2(), ivTDAnhDoi2);

                tvtdKetQuaDoi1.setText(dsTDKQ.getDiemTDKetQuaDoi1());
                tvtdKetQuaDoi2.setText(dsTDKQ.getDiemTDKetQuaDoi2());
            } else {
                tvtdTenVongBang.setText("");
                tvtdTenVongBang.setTextSize(0);

                tvtdKetQua1.setText(dsTDKQ.getKetquaTDDoi1());
                tvtdKetQua2.setText(dsTDKQ.getKetquaTDDoi2());

                LayAnhDB(dsTDKQ.getTenTDDoi1(), ivTDAnhDoi1);
                LayAnhDB(dsTDKQ.getTenTDDoi2(), ivTDAnhDoi2);

                tvtdKetQuaDoi1.setText(dsTDKQ.getDiemTDKetQuaDoi1());
                tvtdKetQuaDoi2.setText(dsTDKQ.getDiemTDKetQuaDoi2());
            }
        }
        return convertView;
    }

    private void LayAnhDB(String s, ImageView iv) {
        if (s.equals("Anh")) {
            iv.setImageResource(R.drawable.anh);
        }
        if (s.equals("Argentina")) {
            iv.setImageResource(R.drawable.argentina);
        }
        if (s.equals("Brasil")) {
            iv.setImageResource(R.drawable.brasil);
        }
        if (s.equals("Campuchia")) {
            iv.setImageResource(R.drawable.campuchia);
        }
        if (s.equals("Canada")) {
            iv.setImageResource(R.drawable.canada);
        }
        if (s.equals("Cuba")) {
            iv.setImageResource(R.drawable.cuba);
        }
        if (s.equals("Đức")) {
            iv.setImageResource(R.drawable.duc);
        }
        if (s.equals("Nhật bản")) {
            iv.setImageResource(R.drawable.nhatban);
        }

        if (s.equals("Ai cập")) {
            iv.setImageResource(R.drawable.aicap);
        }
        if (s.equals("Áo")) {
            iv.setImageResource(R.drawable.ao);
        }
        if (s.equals("Armenia")) {
            iv.setImageResource(R.drawable.armenia);
        }
        if (s.equals("Ba lan")) {
            iv.setImageResource(R.drawable.balan);
        }
        if (s.equals("Bỉ")) {
            iv.setImageResource(R.drawable.bi);
        }
        if (s.equals("Bồ đào nha")) {
            iv.setImageResource(R.drawable.bodaonha);
        }
        if (s.equals("Liberia")) {
            iv.setImageResource(R.drawable.liberia);
        }
        if (s.equals("Rica")) {
            iv.setImageResource(R.drawable.rica);
        }
        if (s.equals("Ấn độ")) {
            iv.setImageResource(R.drawable.ando);
        }
        if (s.equals("Malaysia")) {
            iv.setImageResource(R.drawable.malaysia);
        }
    }
}
