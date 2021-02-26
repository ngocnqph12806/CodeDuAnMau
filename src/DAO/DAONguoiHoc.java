/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.ChuyenDe;
import Models.KhoaHoc;
import Models.NguoiHoc;
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
public class DAONguoiHoc extends EduSysDAO<NguoiHoc, String> {
    
    private DAOHelper _daoHelper = new DAOHelper();

    private PreparedStatement pstm = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private final String SQL_INSERT = "INSERT NGUOIHOC (MANH, HOTEN, GIOITINH, NGAYSINH, DIENTHOAI, EMAIL, GHICHU, MANV, NGAYDK)\n"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE NGUOIHOC SET HOTEN = ?, GIOITINH = ?, NGAYSINH = ?, DIENTHOAI = ?,\n"
            + "EMAIL = ?, GHICHU = ?, MANV = ?, NGAYDK = ? WHERE MANH = ?";
    private final String SQL_DELETE = "DELETE NGUOIHOC WHERE MANH = ?";
    private final String SQL_SELECT_BY_ID = "SELECT MANH, HOTEN, GIOITINH, NGAYSINH, DIENTHOAI, EMAIL, GHICHU, MANV, NGAYDK\n"
            + "FROM NGUOIHOC WHERE MANH = ?";
    private final String SQL_SELECT_ALL = "SELECT MANH, HOTEN, GIOITINH, NGAYSINH, DIENTHOAI, EMAIL, GHICHU, MANV, NGAYDK\n"
            + "FROM NGUOIHOC";

    @Override
    public boolean insert(NguoiHoc entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_INSERT);
                pstm.setString(1, entity.getMaNguoiHoc());
                pstm.setString(2, entity.getHoTen());
                pstm.setBoolean(3, entity.isGioiTinh());
                pstm.setString(4, new SimpleDateFormat("yyyy/MM/dd").format(entity.getNgaySinh()));
                pstm.setString(5, entity.getSoDienThoai());
                pstm.setString(6, entity.getEmail());
                pstm.setString(7, entity.getGhiChu());
                pstm.setString(8, entity.getMaNV());
                pstm.setString(9, new SimpleDateFormat("yyyy/MM/dd").format(entity.getNgayDangKy()));
                return pstm.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(NguoiHoc entity) {
        if (entity != null) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_UPDATE);
                pstm.setString(1, entity.getHoTen());
                pstm.setBoolean(2, entity.isGioiTinh());
                pstm.setString(3, new SimpleDateFormat("yyyy/MM/dd").format(entity.getNgaySinh()));
                pstm.setString(4, entity.getSoDienThoai());
                pstm.setString(5, entity.getEmail());
                pstm.setString(6, entity.getGhiChu());
                pstm.setString(7, entity.getMaNV());
                pstm.setString(8, new SimpleDateFormat("yyyy/MM/dd").format(entity.getNgayDangKy()));
                pstm.setString(9, entity.getMaNguoiHoc());
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
    public NguoiHoc selectById(String id) {
        rs = _daoHelper.getResultSetSelect(id, SQL_SELECT_BY_ID);
        try {
            if (rs.next()) {
                NguoiHoc nguoiHoc = new NguoiHoc();
                nguoiHoc.setMaNguoiHoc(rs.getString(1));
                nguoiHoc.setHoTen(rs.getString(2));
                nguoiHoc.setGioiTinh(rs.getBoolean(3));
                nguoiHoc.setNgaySinh(rs.getDate(4));
                nguoiHoc.setSoDienThoai(rs.getString(5));
                nguoiHoc.setEmail(rs.getString(6));
                nguoiHoc.setGhiChu(rs.getString(7));
                nguoiHoc.setMaNV(rs.getString(8));
                nguoiHoc.setNgayDangKy(rs.getDate(9));
                return nguoiHoc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //MANH, HOCVIEN, GIOITINH, NGAYSINH, DIENTHOAI, EMAIL, GHICHU, MANV, NGAYDK
    @Override
    public List<NguoiHoc> selectAll() {
        List<NguoiHoc> lst = new ArrayList<>();
        try {
            rs = _daoHelper.getResultSetSelect(null, SQL_SELECT_ALL);
            while (rs.next()) {
                NguoiHoc nguoiHoc = new NguoiHoc();
                nguoiHoc.setMaNguoiHoc(rs.getString(1));
                nguoiHoc.setHoTen(rs.getString(2));
                nguoiHoc.setGioiTinh(rs.getBoolean(3));
                nguoiHoc.setNgaySinh(rs.getDate(4));
                nguoiHoc.setSoDienThoai(rs.getString(5));
                nguoiHoc.setEmail(rs.getString(6));
                nguoiHoc.setGhiChu(rs.getString(7));
                nguoiHoc.setMaNV(rs.getString(8));
                nguoiHoc.setNgayDangKy(rs.getDate(9));
                lst.add(nguoiHoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    protected List<NguoiHoc> selectBySql(String sql, Object args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
