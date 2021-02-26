/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author NgocPJa
 */
public class HocVien {

    private String maHocVien;
    private String maKhoaHoc;
    private String maNguoiHoc;
    private double diem;

    public HocVien() {
    }

    public HocVien(String maHocVien, String maKhoaHoc, String maNguoiHoc, double diem) {
        this.maHocVien = maHocVien;
        this.maKhoaHoc = maKhoaHoc;
        this.maNguoiHoc = maNguoiHoc;
        this.diem = diem;
    }

    public String getMaHocVien() {
        return maHocVien;
    }

    public void setMaHocVien(String maHocVien) {
        this.maHocVien = maHocVien;
    }

    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getMaNguoiHoc() {
        return maNguoiHoc;
    }

    public void setMaNguoiHoc(String maNguoiHoc) {
        this.maNguoiHoc = maNguoiHoc;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

}
