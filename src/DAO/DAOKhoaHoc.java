/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.KhoaHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocPJa
 */
public class DAOKhoaHoc extends EduSysDAO<KhoaHoc, String> {

    private DAOHelper _daoHelper = new DAOHelper();

    private PreparedStatement pstm = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private final String SQL_INSERT = "INSERT KHOAHOC (MACD, HOCPHI, THOILUONG, NGAYKG, GHICHU, MANV, NGAYTAO)\n"
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE KHOAHOC SET MACD = ?, HOCPHI = ?, THOILUONG = ?, NGAYKG = ?, \n"
            + "GHICHU = ?, MANV = ?, NGAYTAO = ? WHERE MAKH = ?";
    private final String SQL_DELETE = "DELETE KHOAHOC WHERE MAKH = ?";
    private final String SQL_SELECT_BY_ID = "SELECT MAKH, MACD, HOCPHI, THOILUONG, NGAYKG, GHICHU, MANV, NGAYTAO\n"
            + "FROM KHOAHOC WHERE MAKH = ?";
    private final String SQL_SELECT_ALL = "SELECT MAKH, MACD, HOCPHI, THOILUONG, NGAYKG, GHICHU, MANV, NGAYTAO\n"
            + "FROM KHOAHOC";

    @Override
    public boolean insert(KhoaHoc entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_INSERT);
                pstm.setString(1, entity.getMaChuyenDe());
                pstm.setDouble(2, entity.getHocPhi());
                pstm.setInt(3, entity.getThoiLuong());
                pstm.setString(4, new SimpleDateFormat("yyyy/MM/dd").format(entity.getNgayKhaiGiang()));
                pstm.setString(5, entity.getGhiChu());
                pstm.setString(6, entity.getMaNV());
                pstm.setString(7, new SimpleDateFormat("yyyy/MM/dd").format(entity.getNgayTao()));
                return pstm.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(KhoaHoc entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_UPDATE);
                pstm.setString(1, entity.getMaChuyenDe());
                pstm.setDouble(2, entity.getHocPhi());
                pstm.setInt(3, entity.getThoiLuong());
                pstm.setString(4, new SimpleDateFormat("yyyy/MM/dd").format(entity.getNgayKhaiGiang()));
                pstm.setString(5, entity.getGhiChu());
                pstm.setString(6, entity.getMaNV());
                pstm.setString(7, new SimpleDateFormat("yyyy/MM/dd").format(entity.getNgayTao()));
                pstm.setString(8, entity.getMaKhoaHoc());
                return pstm.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return _daoHelper.delete(id, SQL_DELETE);
    }

    @Override
    public KhoaHoc selectById(String id) {
        rs = _daoHelper.getResultSetSelect(id, SQL_SELECT_BY_ID);
        try {
            if (rs.next()) {
                KhoaHoc khoaHoc = new KhoaHoc();
                khoaHoc.setMaKhoaHoc(rs.getString(1));
                khoaHoc.setMaChuyenDe(rs.getString(2));
                khoaHoc.setHocPhi(rs.getDouble(3));
                khoaHoc.setThoiLuong(rs.getInt(4));
                khoaHoc.setNgayKhaiGiang(rs.getDate(5));
                khoaHoc.setGhiChu(rs.getString(6));
                khoaHoc.setMaNV(rs.getString(7));
                khoaHoc.setNgayTao(rs.getDate(8));
                return khoaHoc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //MAKH, MACD, HOCPHI, THOILUONG, NGAYKG, GHICHU, MANV, NGAYTAO
    @Override
    public List<KhoaHoc> selectAll() {
        List<KhoaHoc> lst = new ArrayList<>();
        try {
            rs = _daoHelper.getResultSetSelect(null, SQL_SELECT_ALL);
            while (rs.next()) {
                KhoaHoc khoaHoc = new KhoaHoc();
                khoaHoc.setMaKhoaHoc(rs.getString(1));
                khoaHoc.setMaChuyenDe(rs.getString(2));
                khoaHoc.setHocPhi(rs.getDouble(3));
                khoaHoc.setThoiLuong(rs.getInt(4));
                khoaHoc.setNgayKhaiGiang(rs.getDate(5));
                khoaHoc.setGhiChu(rs.getString(6));
                khoaHoc.setMaNV(rs.getString(7));
                khoaHoc.setNgayTao(rs.getDate(8));
                lst.add(khoaHoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    protected List<KhoaHoc> selectBySql(String sql, Object args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdentity() {
        String sql = "EXEC PROC_GETID ?";
        try (PreparedStatement pstm = DAOConnection.getConnection().prepareCall(sql);) {
            pstm.setString(1, "KHOAHOC");
            try (ResultSet rs = pstm.executeQuery();) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
