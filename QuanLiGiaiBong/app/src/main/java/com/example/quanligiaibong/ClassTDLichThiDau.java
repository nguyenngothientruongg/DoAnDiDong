package com.example.quanligiaibong;

public class ClassTDLichThiDau {
    String maTDTranDau, maTDLichThiDau,tenTDBang, tenTDDoi1, tenTDDoi2, ngayTDThiDau;

    public String getMaTDTranDau() {
        return maTDTranDau;
    }

    public void setMaTDTranDau(String maTDTranDau) {
        this.maTDTranDau = maTDTranDau;
    }

    public String getMaTDLichThiDau() {
        return maTDLichThiDau;
    }

    public void setMaTDLichThiDau(String maTDLichThiDau) {
        this.maTDLichThiDau = maTDLichThiDau;
    }

    public String getTenTDBang() {
        return tenTDBang;
    }

    public void setTenTDBang(String tenTDBang) {
        this.tenTDBang = tenTDBang;
    }

    public String getTenTDDoi1() {
        return tenTDDoi1;
    }

    public void setTenTDDoi1(String tenTDDoi1) {
        this.tenTDDoi1 = tenTDDoi1;
    }

    public String getTenTDDoi2() {
        return tenTDDoi2;
    }

    public void setTenTDDoi2(String tenTDDoi2) {
        this.tenTDDoi2 = tenTDDoi2;
    }

    public String getNgayTDThiDau() {
        return ngayTDThiDau;
    }

    public void setNgayTDThiDau(String ngayTDThiDau) {
        this.ngayTDThiDau = ngayTDThiDau;
    }

    public ClassTDLichThiDau(String maTDTranDau, String maTDLichThiDau, String tenTDBang, String tenTDDoi1, String tenTDDoi2, String ngayTDThiDau) {
        this.maTDTranDau = maTDTranDau;
        this.maTDLichThiDau = maTDLichThiDau;
        this.tenTDBang = tenTDBang;
        this.tenTDDoi1 = tenTDDoi1;
        this.tenTDDoi2 = tenTDDoi2;
        this.ngayTDThiDau = ngayTDThiDau;
    }

    public ClassTDLichThiDau() {
    }
}
