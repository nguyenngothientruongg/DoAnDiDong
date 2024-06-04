package com.example.quanligiaibong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class TranDau extends AppCompatActivity {

    ImageView ivTDDoiBong, ivTDXepLich, ivTDXepHang, ivTDKetQua, ivTDThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran_dau);
        setControl();
        setEvent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(Home.tenGiaiDau);

    }

    private void setEvent() {
        ivTDDoiBong.setSelected(true);
        if (ivTDDoiBong.isSelected()) {
            Fragment fragment = new tdDoiBong();
            FragmentManager fragmentManager = getSupportFragmentManager();
            ivTDDoiBong.setColorFilter(Color.BLUE);
            ivTDXepLich.setColorFilter(Color.BLACK);
            ivTDKetQua.setColorFilter(Color.BLACK);
            ivTDXepHang.setColorFilter(Color.BLACK);
            ivTDThongKe.setColorFilter(Color.BLACK);
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        }

        ivTDDoiBong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new tdDoiBong();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivTDDoiBong.setColorFilter(Color.BLUE);
                ivTDXepLich.setColorFilter(Color.BLACK);
                ivTDKetQua.setColorFilter(Color.BLACK);
                ivTDXepHang.setColorFilter(Color.BLACK);
                ivTDThongKe.setColorFilter(Color.BLACK);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });

        ivTDXepLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new td_taolichthidau();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivTDDoiBong.setColorFilter(Color.BLACK);
                ivTDXepLich.setColorFilter(Color.BLUE);
                ivTDKetQua.setColorFilter(Color.BLACK);
                ivTDXepHang.setColorFilter(Color.BLACK);
                ivTDThongKe.setColorFilter(Color.BLACK);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });

        ivTDKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new td_ketqua();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivTDDoiBong.setColorFilter(Color.BLACK);
                ivTDXepLich.setColorFilter(Color.BLACK);
                ivTDKetQua.setColorFilter(Color.BLUE);
                ivTDXepHang.setColorFilter(Color.BLACK);
                ivTDThongKe.setColorFilter(Color.BLACK);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });

        ivTDXepHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new td_xephang();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivTDDoiBong.setColorFilter(Color.BLACK);
                ivTDXepLich.setColorFilter(Color.BLACK);
                ivTDKetQua.setColorFilter(Color.BLACK);
                ivTDXepHang.setColorFilter(Color.BLUE);
                ivTDThongKe.setColorFilter(Color.BLACK);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });

        ivTDThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new td_thongke();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivTDDoiBong.setColorFilter(Color.BLACK);
                ivTDXepLich.setColorFilter(Color.BLACK);
                ivTDKetQua.setColorFilter(Color.BLACK);
                ivTDXepHang.setColorFilter(Color.BLACK);
                ivTDThongKe.setColorFilter(Color.BLUE);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setControl() {

        ivTDDoiBong = findViewById(R.id.ivTDDoiBong);
        ivTDXepLich = findViewById(R.id.ivTDXepLich);
        ivTDKetQua = findViewById(R.id.ivTDKetQua);
        ivTDXepHang = findViewById(R.id.ivTDXepHang);
        ivTDThongKe = findViewById(R.id.ivTDThongKe);

    }
}