/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.HocVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocPJa
 */
public class DAOHocVien extends EduSysDAO<HocVien, String> {

    private DAOHelper _daoHelper = new DAOHelper();
    private PreparedStatement pstm = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private final String SQL_INSERT = "INSERT HOCVIEN (MAKH, MANH, DIEM) VALUES (?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE HOCVIEN SET MAKH = ?, MANH = ?, DIEM = ? WHERE MAHV = ?";
    private final String SQL_DELETE = "DELETE HOCVIEN WHERE MAHV = ?";
    private final String SQL_SELECT_BY_ID = "SELECT MAHV, MAKH, MANH, DIEM\n"
            + "FROM HOCVIEN WHERE MAHV = ?";
    private final String SQL_SELECT_ALL = "SELECT MAHV, MAKH, MANH, DIEM\n"
            + "FROM HOCVIEN";

    @Override
    public boolean insert(HocVien entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_INSERT);
                pstm.setString(1, entity.getMaKhoaHoc());
                pstm.setString(2, entity.getMaNguoiHoc());
                pstm.setDouble(3, entity.getDiem());
                return pstm.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(HocVien entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_UPDATE);
                pstm.setString(1, entity.getMaKhoaHoc());
                pstm.setString(2, entity.getMaNguoiHoc());
                pstm.setDouble(3, entity.getDiem());
                pstm.setString(4, entity.getMaHocVien());
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
    public HocVien selectById(String id) {
        rs = _daoHelper.getResultSetSelect(id, SQL_SELECT_BY_ID);
        try {
            if (rs.next()) {
                HocVien hocVien = new HocVien();
                hocVien.setMaHocVien(rs.getString(1));
                hocVien.setMaKhoaHoc(rs.getString(2));
                hocVien.setMaNguoiHoc(rs.getString(3));
                hocVien.setDiem(rs.getDouble(4));
                return hocVien;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //MAHV, MAKH, MANH, DIEM
    @Override
    public List<HocVien> selectAll() {
        List<HocVien> lst = new ArrayList<>();
        try {
            rs = _daoHelper.getResultSetSelect(null, SQL_SELECT_ALL);
            while (rs.next()) {
                HocVien hocVien = new HocVien();
                hocVien.setMaHocVien(rs.getString(1));
                hocVien.setMaKhoaHoc(rs.getString(2));
                hocVien.setMaNguoiHoc(rs.getString(3));
                hocVien.setDiem(rs.getDouble(4));
                lst.add(hocVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    protected List<HocVien> selectBySql(String sql, Object args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdentity() {
        String sql = "EXEC PROC_GETID ?";
        try (PreparedStatement pstm = DAOConnection.getConnection().prepareCall(sql);) {
            pstm.setString(1, "HOCVIEN");
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
