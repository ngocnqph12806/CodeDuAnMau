/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.ChuyenDe;
import Models.NguoiHoc;
import Models.NhanVien;
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
public class DAONhanVien extends EduSysDAO<NhanVien, String> {

    private DAOHelper _daoHelper = new DAOHelper();

    private PreparedStatement pstm = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private final String SQL_INSERT = "INSERT NHANVIEN (MANV, MATKHAU, HOTEN, VAITRO) VALUES (?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE NHANVIEN SET MATKHAU = ?, HOTEN = ?, VAITRO = ? WHERE MANV = ?";
    private final String SQL_DELETE = "DELETE NHANVIEN WHERE MANV = ?";
    private final String SQL_SELECT_BY_ID = "SELECT MANV, MATKHAU, HOTEN, VAITRO\n"
            + "FROM NHANVIEN WHERE MANV = ?";
    private final String SQL_SELECT_ALL = "SELECT MANV, MATKHAU, HOTEN, VAITRO\n"
            + "FROM NHANVIEN";

    @Override
    public boolean insert(NhanVien entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_INSERT);
                pstm.setString(1, entity.getMaNV());
                pstm.setString(2, entity.getMatKhau());
                pstm.setString(3, entity.getHoTen());
                pstm.setBoolean(4, entity.isVaiTro());
                return pstm.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(NhanVien entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_UPDATE);
                pstm.setString(1, entity.getMatKhau());
                pstm.setString(2, entity.getHoTen());
                pstm.setBoolean(3, entity.isVaiTro());
                pstm.setString(4, entity.getMaNV());
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
    public NhanVien selectById(String id) {
        rs = _daoHelper.getResultSetSelect(id, SQL_SELECT_BY_ID);
        try {
            if (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(rs.getString(1).toUpperCase());
                nhanVien.setMatKhau(rs.getString(2));
                nhanVien.setHoTen(rs.getString(3));
                nhanVien.setVaiTro(rs.getBoolean(4));
                return nhanVien;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //MANV, MATKHAU, HOCVIEN, VAITRO
    @Override
    public List<NhanVien> selectAll() {
        List<NhanVien> lst = new ArrayList<>();
        try {
            rs = _daoHelper.getResultSetSelect(null, SQL_SELECT_ALL);
            if (rs != null) {
                while (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setMaNV(rs.getString(1).toUpperCase());
                    nhanVien.setMatKhau(rs.getString(2));
                    nhanVien.setHoTen(rs.getString(3));
                    nhanVien.setVaiTro(rs.getBoolean(4));
                    lst.add(nhanVien);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
