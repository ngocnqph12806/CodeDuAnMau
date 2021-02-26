/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.ChuyenDe;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocPJa
 */
public class DAOChuyenDe extends EduSysDAO<ChuyenDe, String> {

    private DAOHelper _daoHelper = new DAOHelper();

    private PreparedStatement pstm = null;
    private Statement stm = null;
    private ResultSet rs = null;

    private final String SQL_INSERT = "INSERT CHUYENDE (MACD, TENCD, HOCPHI, THOILUONG, HINH, MOTA) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE CHUYENDE SET TENCD = ?, HOCPHI = ?, THOILUONG = ?, HINH = ?, MOTA = ? WHERE MACD = ?";
    private final String SQL_DELETE = "DELETE CHUYENDE WHERE MACD = ?";
    private final String SQL_SELECT_BY_ID = "SELECT MACD, TENCD, HOCPHI, THOILUONG, HINH, MOTA\n"
            + "FROM CHUYENDE WHERE MACD = ?";
    private final String SQL_SELECT_ALL = "SELECT MACD, TENCD, HOCPHI, THOILUONG, HINH, MOTA\n"
            + "FROM CHUYENDE";

    @Override
    public boolean insert(ChuyenDe entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_INSERT);
                pstm.setString(1, entity.getMaChuyenDe());
                pstm.setString(2, entity.getTenChuyenDe());
                pstm.setDouble(3, entity.getHocPhi());
                pstm.setInt(4, entity.getThoiLuong());
                pstm.setString(5, entity.getHinhAnh());
                pstm.setString(6, entity.getMoTa());
                return pstm.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(ChuyenDe entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_UPDATE);
                pstm.setString(1, entity.getTenChuyenDe());
                pstm.setDouble(2, entity.getHocPhi());
                pstm.setInt(3, entity.getThoiLuong());
                pstm.setString(4, entity.getHinhAnh());
                pstm.setString(5, entity.getMoTa());
                pstm.setString(6, entity.getMaChuyenDe());
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
    public ChuyenDe selectById(String id) {
        rs = _daoHelper.getResultSetSelect(id, SQL_SELECT_BY_ID);
        ChuyenDe chuyenDe = new ChuyenDe();
        try {
            if (rs.next()) {
                chuyenDe.setMaChuyenDe(rs.getString(1));
                chuyenDe.setTenChuyenDe(rs.getString(2));
                chuyenDe.setHocPhi(rs.getDouble(3));
                chuyenDe.setThoiLuong(rs.getInt(4));
                chuyenDe.setHinhAnh(rs.getString(5));
                chuyenDe.setMoTa(rs.getString(6));
                return chuyenDe;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // MACD, TENCD, HOCPHI, THOILUONG, HINH, MOTA
    @Override
    public List<ChuyenDe> selectAll() {
        List<ChuyenDe> lst = new ArrayList<>();
        try {
            rs = _daoHelper.getResultSetSelect(null, SQL_SELECT_ALL);
            while (rs.next()) {
                ChuyenDe chuyenDe = new ChuyenDe();
                chuyenDe.setMaChuyenDe(rs.getString(1));
                chuyenDe.setTenChuyenDe(rs.getString(2));
                chuyenDe.setHocPhi(rs.getDouble(3));
                chuyenDe.setThoiLuong(rs.getInt(4));
                chuyenDe.setHinhAnh(rs.getString(5));
                chuyenDe.setMoTa(rs.getString(6));
                lst.add(chuyenDe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    protected List<ChuyenDe> selectBySql(String sql, Object args) {
        List<ChuyenDe> lst = new ArrayList<>();
        return lst;
    }

}
