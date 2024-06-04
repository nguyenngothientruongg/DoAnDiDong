package com.example.quanligiaibong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    ImageView ivCauThu, ivHome, ivDoiBong, ivTaoGiai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
        setTitle("Quản lí giải Euro");
    }

    private void setEvent() {
        ivHome.setSelected(true);
        if (ivHome.isSelected())
        {
            Fragment fragment = new Home();
            FragmentManager fragmentManager = getSupportFragmentManager();
            ivHome.setColorFilter(Color.BLUE);
            ivCauThu.setColorFilter(Color.BLACK);
            ivDoiBong.setColorFilter(Color.BLACK);
            ivTaoGiai.setColorFilter(Color.BLACK);
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        }

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if (item.getItemId() == R.id.Home) {
                    fragment = new Home();
                    ivHome.setColorFilter(Color.BLUE);
                    ivCauThu.setColorFilter(Color.BLACK);
                    ivDoiBong.setColorFilter(Color.BLACK);
                    ivTaoGiai.setColorFilter(Color.BLACK);
                }
                if (item.getItemId() == R.id.CauThu) {
                    fragment = new CauThu();
                    ivHome.setColorFilter(Color.BLACK);
                    ivCauThu.setColorFilter(Color.BLUE);
                    ivDoiBong.setColorFilter(Color.BLACK);
                    ivTaoGiai.setColorFilter(Color.BLACK);
                }
                if (item.getItemId() == R.id.DoiBong) {
                    fragment = new DoiBong();
                    ivHome.setColorFilter(Color.BLACK);
                    ivCauThu.setColorFilter(Color.BLACK);
                    ivDoiBong.setColorFilter(Color.BLUE);
                    ivTaoGiai.setColorFilter(Color.BLACK);
                }
                if (item.getItemId() == R.id.nav_taoGiai) {
                    fragment = new taogiai();
                    ivHome.setColorFilter(Color.BLACK);
                    ivCauThu.setColorFilter(Color.BLACK);
                    ivDoiBong.setColorFilter(Color.BLACK);
                    ivTaoGiai.setColorFilter(Color.BLUE);
                }
                if (fragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
                }
                return false;
            }
        });
        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Home();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivHome.setColorFilter(Color.BLUE);
                ivCauThu.setColorFilter(Color.BLACK);
                ivDoiBong.setColorFilter(Color.BLACK);
                ivTaoGiai.setColorFilter(Color.BLACK);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });
        ivCauThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CauThu();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivHome.setColorFilter(Color.BLACK);
                ivCauThu.setColorFilter(Color.BLUE);
                ivDoiBong.setColorFilter(Color.BLACK);
                ivTaoGiai.setColorFilter(Color.BLACK);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });
        ivDoiBong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DoiBong();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivHome.setColorFilter(Color.BLACK);
                ivCauThu.setColorFilter(Color.BLACK);
                ivDoiBong.setColorFilter(Color.BLUE);
                ivTaoGiai.setColorFilter(Color.BLACK);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });
        ivTaoGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new taogiai();
                FragmentManager fragmentManager = getSupportFragmentManager();
                ivHome.setColorFilter(Color.BLACK);
                ivCauThu.setColorFilter(Color.BLACK);
                ivDoiBong.setColorFilter(Color.BLACK);
                ivTaoGiai.setColorFilter(Color.BLUE);
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    

    private void setControl() {
        drawerLayout = findViewById(R.id.drawLayout);
        navigationView = findViewById(R.id.navView);

        ivHome = findViewById(R.id.ivHome);
        ivCauThu = findViewById(R.id.ivCT);
        ivDoiBong = findViewById(R.id.ivDB);
        ivTaoGiai = findViewById(R.id.ivTaoGiai);
    }
}