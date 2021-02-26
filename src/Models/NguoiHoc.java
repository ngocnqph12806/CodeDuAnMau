/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author NgocPJa
 */
public class NguoiHoc {

    private String maNguoiHoc;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String email;
    private String soDienThoai;
    private String ghiChu;
    private String maNV;
    private Date ngayDangKy;

    public NguoiHoc() {
    }

    public NguoiHoc(String maNguoiHoc, String hoTen, boolean gioiTinh, Date ngaySinh, String email, String soDienThoai, String ghiChu, String maNV, Date ngayDangKy) {
        this.maNguoiHoc = maNguoiHoc;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.ngayDangKy = ngayDangKy;
    }

    public String getMaNguoiHoc() {
        return maNguoiHoc;
    }

    public void setMaNguoiHoc(String maNguoiHoc) {
        this.maNguoiHoc = maNguoiHoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

}
