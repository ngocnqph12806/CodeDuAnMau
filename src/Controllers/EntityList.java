/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.QuanLyChuyenDe;
import Controllers.QuanLyChuyenDeImplement;
import Controllers.QuanLyHocVien;
import Controllers.QuanLyHocVienImplement;
import Controllers.QuanLyKhoaHoc;
import Controllers.QuanLyKhoaHocImplement;
import Controllers.QuanLyNguoiHoc;
import Controllers.QuanLyNguoiHocImplement;
import Controllers.QuanLyNhanVien;
import Controllers.QuanLyNhanVienImplement;
import DAO.DAOChuyenDe;
import DAO.DAOHocVien;
import DAO.DAOKhoaHoc;
import DAO.DAONguoiHoc;
import DAO.DAONhanVien;
import Models.ChuyenDe;
import Models.HocVien;
import Models.KhoaHoc;
import Models.NguoiHoc;
import Models.NhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class EntityList {

    protected static List<ChuyenDe> _lstChuyenDe = new ArrayList<>();
    protected static DAOChuyenDe _daoChuyenDe = new DAOChuyenDe();

    protected static DAOHocVien _daoHocVien = new DAOHocVien();
    protected static List<HocVien> _lstHocVien = new ArrayList<>();

    protected static DAOKhoaHoc _daoKhoaHoc = new DAOKhoaHoc();
    protected static List<KhoaHoc> _lstKhoaHocs = new ArrayList<>();

    protected static DAONguoiHoc _daoNguoiHoc = new DAONguoiHoc();
    protected static List<NguoiHoc> _lstNguoiHocs = new ArrayList<>();

    protected static DAONhanVien _daoNhanVien = new DAONhanVien();
    protected static List<NhanVien> _lstNhanVien = new ArrayList<>();

    public EntityList() {
        _lstChuyenDe = _daoChuyenDe.selectAll();
        _lstHocVien = _daoHocVien.selectAll();
        _lstKhoaHocs = _daoKhoaHoc.selectAll();
        _lstNguoiHocs = _daoNguoiHoc.selectAll();
        _lstNhanVien = _daoNhanVien.selectAll();
    }

}
