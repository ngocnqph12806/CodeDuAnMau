/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocPJa
 */
public class DAOHelper {

    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Statement stm = null;

//    public boolean setExecuteUpdate(PreparedStatement pstm) {
//        try {
//            if (pstm.executeUpdate() <= 0) {
//                return false;
//            }
//            pstm.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return true;
//    }
    public boolean delete(String id, String SQL_DELETE) {
        if (id != null || !id.isBlank() || !id.isEmpty()) {
            try {
                pstm = DAOConnection.getConnection().prepareStatement(SQL_DELETE);
                pstm.setString(1, id);
                if (pstm.executeUpdate() > 0) {
                    pstm.close();
                    return true;
                }
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ResultSet getResultSetSelect(String id, String SQL) {
        try {
            pstm = DAOConnection.getConnection().prepareStatement(SQL);
            if (id != null) {
                pstm.setString(1, id);
            }
            rs = pstm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
