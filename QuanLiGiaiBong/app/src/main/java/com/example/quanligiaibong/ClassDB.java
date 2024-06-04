package com.example.quanligiaibong;

public class ClassDB {
    String maDB, tenDB, qtDB;

    public String getMaDB() {
        return maDB;
    }

    public void setMaDB(String maDB) {
        this.maDB = maDB;
    }

    public String getTenDB() {
        return tenDB;
    }

    public void setTenDB(String tenDB) {
        this.tenDB = tenDB;
    }

    public String getQtDB() {
        return qtDB;
    }

    public void setQtDB(String qtDB) {
        this.qtDB = qtDB;
    }

    public ClassDB(String maDB, String tenDB, String qtDB) {
        this.maDB = maDB;
        this.tenDB = tenDB;
        this.qtDB = qtDB;
    }

    public ClassDB() {
    }
}
