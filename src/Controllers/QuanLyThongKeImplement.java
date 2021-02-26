/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAOThongKe;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class QuanLyThongKeImplement implements QuanLyThongKe {

    private DAOThongKe _daoThongKe = new DAOThongKe();

    @Override
    public List<Object[]> getListThongKeSoLuongNguoiHoc() {
        return _daoThongKe.getListThongKeNguoiHoc();
    }

    @Override
    public List<Object[]> getListThongKeDiemChuyenDe() {
        return _daoThongKe.getListThongKeDiemChuyenDe();
    }

    @Override
    public List<Object[]> getListThongKeBangDiem(String khoaHoc) {
        return _daoThongKe.getListThongKeBangDiem(khoaHoc);
    }

    @Override
    public List<Object[]> getListThongKeDoanhThu(int namHoc) {
        return _daoThongKe.getListThongKeDoanhThu(namHoc);
    }

    @Override
    public List<Integer> getListNamHoc() {
        return _daoThongKe.selectYear();
    }
}
