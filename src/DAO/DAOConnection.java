/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocPJa
 */
public class DAOConnection {

    private static Connection conn = null;

    public DAOConnection() {
    }

    public static boolean createDatabase(String databaseName, String host, String port, String userName, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + host + ":" + port;
            Connection connCreadatabase = DriverManager.getConnection(url, userName, password);
            Statement stm = connCreadatabase.createStatement();
            String sql = "CREATE DATABASE " + databaseName;
            stm.executeUpdate(sql);
            connCreadatabase.close();
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean creataTableDB(String sql) {
        try {
            Statement stm = getConnection().createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Connection getConnection() {
        if (conn == null) {
            String userDB = Tags.ConnectionSQL._InstallSQL.getUserDB();
            String passDB = Tags.ConnectionSQL._InstallSQL.getPasswordDB();
            String database = Tags.ConnectionSQL._InstallSQL.getDatabaseName();
            String urlDB = "jdbc:sqlserver://" + Tags.ConnectionSQL._InstallSQL.getHost() + ":"
                    + Tags.ConnectionSQL._InstallSQL.getPort() + ";databaseName=" + database;

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(urlDB, userDB, passDB);
            } catch (ClassNotFoundException ex) {
                System.out.println("Lỗi thư viện JDBC");
                Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println("Lỗi kết nối");
                Logger.getLogger(DAOConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOConnection.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        conn = null;
    }

}
