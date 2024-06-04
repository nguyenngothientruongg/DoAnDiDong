package com.example.quanligiaibong;

public class ClassGD {
    String maGD, tenGD, soBangDau, soDoi;

    public String getMaGD() {
        return maGD;
    }

    public void setMaGD(String maGD) {
        this.maGD = maGD;
    }

    public String getTenGD() {
        return tenGD;
    }

    public void setTenGD(String tenGD) {
        this.tenGD = tenGD;
    }

    public String getSoBangDau() {
        return soBangDau;
    }

    public void setSoBangDau(String soBangDau) {
        this.soBangDau = soBangDau;
    }

    public String getSoDoi() {
        return soDoi;
    }

    public void setSoDoi(String soDoi) {
        this.soDoi = soDoi;
    }

    public ClassGD(String maGD, String tenGD, String soBangDau, String soDoi) {
        this.maGD = maGD;
        this.tenGD = tenGD;
        this.soBangDau = soBangDau;
        this.soDoi = soDoi;
    }

    public ClassGD() {
    }
}
