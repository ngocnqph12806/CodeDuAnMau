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
public class ChuyenDe {

    private String maChuyenDe;
    private String tenChuyenDe;
    private double hocPhi;
    private int thoiLuong;
    private String hinhAnh;
    private String moTa;

    public ChuyenDe() {
    }

    public ChuyenDe(String maChuyenDe, String tenChuyenDe, double hocPhi, int thoiLuong, String hinhAnh, String moTa) {
        this.maChuyenDe = maChuyenDe;
        this.tenChuyenDe = tenChuyenDe;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.hinhAnh = hinhAnh;
        this.moTa = moTa;
    }

    public String getMaChuyenDe() {
        return maChuyenDe;
    }

    public void setMaChuyenDe(String maChuyenDe) {
        this.maChuyenDe = maChuyenDe;
    }

    public String getTenChuyenDe() {
        return tenChuyenDe;
    }

    public void setTenChuyenDe(String tenChuyenDe) {
        this.tenChuyenDe = tenChuyenDe;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
