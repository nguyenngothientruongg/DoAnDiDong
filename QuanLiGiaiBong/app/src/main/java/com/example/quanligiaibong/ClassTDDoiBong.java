package com.example.quanligiaibong;

public class ClassTDDoiBong {
    String maTDTranDau;

    public String getMaTDTranDau() {
        return maTDTranDau;
    }

    public void setMaTDTranDau(String maTDTranDau) {
        this.maTDTranDau = maTDTranDau;
    }

    public String getMaTDDoiBong() {
        return maTDDoiBong;
    }

    public void setMaTDDoiBong(String maTDDoiBong) {
        this.maTDDoiBong = maTDDoiBong;
    }

    public String getTenTDTenVongBang() {
        return tenTDTenVongBang;
    }

    public void setTenTDTenVongBang(String tenTDTenVongBang) {
        this.tenTDTenVongBang = tenTDTenVongBang;
    }

    public String getTenTDTenDoi() {
        return tenTDTenDoi;
    }

    public void setTenTDTenDoi(String tenTDTenDoi) {
        this.tenTDTenDoi = tenTDTenDoi;
    }

    public ClassTDDoiBong(String maTDTranDau, String maTDDoiBong, String tenTDTenVongBang, String tenTDTenDoi) {
        this.maTDTranDau = maTDTranDau;
        this.maTDDoiBong = maTDDoiBong;
        this.tenTDTenVongBang = tenTDTenVongBang;
        this.tenTDTenDoi = tenTDTenDoi;
    }

    public ClassTDDoiBong() {
    }

    String maTDDoiBong;
    String tenTDTenVongBang;
    String tenTDTenDoi;
}
