/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.NhanVien;
import java.sql.*;

/**
 *
 * @author NgocPJa
 */
public class DAODangNhap {

    public NhanVien getDangNhap(String taiKhoan, String matKhau) {
        if (taiKhoan.isBlank() || taiKhoan.isEmpty()
                || matKhau.isBlank() || matKhau.isEmpty()) {
            return null;
        }
        String sql = "SELECT * FROM NHANVIEN WHERE MANV = '" + taiKhoan + "' AND MATKHAU = '" + matKhau + "'";
        try (Statement stm = DAOConnection.getConnection().createStatement();
                ResultSet rs = stm.executeQuery(sql);) {
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MANV"));
                nv.setMatKhau(rs.getString("MATKHAU"));
                nv.setHoTen(rs.getString("HOTEN"));
                nv.setVaiTro(rs.getBoolean("VAITRO"));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
