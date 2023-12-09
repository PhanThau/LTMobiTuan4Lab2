package com.example.tuan4lab3recycrview;

public class MonHoc {
    private String maMonHoc;
    private String tenMonHoc;
    private String tenGiangVien;

    public MonHoc(String maMonHoc, String tenMonHoc, String tenGiangVien, int hinhAnh) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.tenGiangVien = tenGiangVien;
        this.hinhAnh = hinhAnh;
    }

    private int hinhAnh;

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
