/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NhanVien;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public interface QuanLyNhanVien {

    List<NhanVien> getListNhanVien();

    boolean doiMatKhau(NhanVien nhanVien);

    NhanVien getNhanVienById(String maNhanVien);

    boolean removeNhanVien(NhanVien nhanVien);

    boolean addNhanVien(NhanVien nhanVien);

    boolean editNhanVien(NhanVien nhanVien);
}
