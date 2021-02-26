/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;

/**
 *
 * @author NgocPJa
 */
public interface QuanLyThongKe {

    public List<Object[]> getListThongKeSoLuongNguoiHoc();

    public List<Object[]> getListThongKeDiemChuyenDe();

    public List<Object[]> getListThongKeBangDiem(String khoaHoc);

    public List<Object[]> getListThongKeDoanhThu(int namHoc);

    public List<Integer> getListNamHoc();
}
