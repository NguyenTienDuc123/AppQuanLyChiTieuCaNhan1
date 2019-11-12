package com.example.appquanlychitieucanhan.model;

/**
 * Created by Develop on 5/6/2018.
 */

public class TaiKhoan {

    int id;
    String TenTaiKhoan,SoTienTaiKhoan;

    public TaiKhoan() {
    }

    public TaiKhoan(int id, String tenTaiKhoan, String soTienTaiKhoan) {
        this.id = id;
        TenTaiKhoan = tenTaiKhoan;
        SoTienTaiKhoan = soTienTaiKhoan;
    }

    public TaiKhoan(String tenTaiKhoan, String soTienTaiKhoan) {
        TenTaiKhoan = tenTaiKhoan;
        SoTienTaiKhoan = soTienTaiKhoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        TenTaiKhoan = tenTaiKhoan;
    }

    public String getSoTienTaiKhoan() {
        return SoTienTaiKhoan;
    }

    public void setSoTienTaiKhoan(String soTienTaiKhoan) {
        SoTienTaiKhoan = soTienTaiKhoan;
    }


    @Override
    public String toString() {
        return TenTaiKhoan;
    }
}
