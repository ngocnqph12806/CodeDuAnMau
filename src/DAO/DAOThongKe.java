/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author NgocPJa
 */
public class DAOThongKe {

    private DAOConnection _daoConnection = new DAOConnection();

    public List<Object[]> getListThongKeBangDiem(String maKhoaHoc) {
        List<Object[]> lst = new ArrayList<>();
        String sql = "EXEC SP_BANGDIEM " + maKhoaHoc;
        try (CallableStatement cstm = _daoConnection.getConnection().prepareCall(sql);
                ResultSet rs = cstm.executeQuery();) {
            while (rs.next()) {
                Object[] objects = new Object[3];
                objects[0] = rs.getString(1);
                objects[1] = rs.getString(2);
                objects[2] = rs.getDouble(3);
                lst.add(objects);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<Object[]> getListThongKeNguoiHoc() {
        List<Object[]> lst = new ArrayList<>();
        String sql = "EXEC SP_LUONGNGUOIHOC";
        try (CallableStatement cstm = _daoConnection.getConnection().prepareCall(sql);
                ResultSet rs = cstm.executeQuery();) {
            while (rs.next()) {
                Object[] objects = new Object[4];
                objects[0] = rs.getString(1);
                objects[1] = rs.getInt(2);
                objects[2] = rs.getDate(3);
                objects[3] = rs.getDate(4);
                lst.add(objects);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<Object[]> getListThongKeDiemChuyenDe() {
        List<Object[]> lst = new ArrayList<>();
        String sql = "EXEC SP_DIEMCHUYENDE";
        try (CallableStatement cstm = _daoConnection.getConnection().prepareCall(sql);
                ResultSet rs = cstm.executeQuery();) {
            while (rs.next()) {
                Object[] objects = new Object[5];
                objects[0] = rs.getString(1);
                objects[1] = rs.getDouble(2);
                objects[2] = rs.getDouble(3);
                objects[3] = rs.getDouble(4);
                objects[4] = rs.getDouble(5);
                lst.add(objects);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<Object[]> getListThongKeDoanhThu(int nam) {
        List<Object[]> lst = new ArrayList<>();
        String sql = "EXEC SP_DOANHTHU " + nam;
        try (CallableStatement cstm = _daoConnection.getConnection().prepareCall(sql);
                ResultSet rs = cstm.executeQuery();) {
            while (rs.next()) {
                Object[] objects = new Object[7];
                objects[0] = rs.getString(1);
                objects[1] = rs.getString(2);
                objects[2] = rs.getInt(3);
                objects[3] = rs.getDouble(4);
                objects[4] = rs.getDouble(5);
                objects[5] = rs.getDouble(6);
                objects[6] = rs.getDouble(7);
                lst.add(objects);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<Integer> selectYear() {
        List<Integer> lst = new ArrayList<>();
        String sql = "SELECT DISTINCT YEAR(NGAYKG) NAM\n"
                + "FROM KHOAHOC ORDER BY NAM DESC";
        try (Statement stm = _daoConnection.getConnection().createStatement();
                ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                lst.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

}
