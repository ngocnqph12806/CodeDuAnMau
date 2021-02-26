/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author NgocPJa
 */
public class InstallSQL implements Serializable {

    private String databaseName;
    private String userDB;
    private String passwordDB;
    private String host;
    private int port;

    public InstallSQL() {
    }

    public InstallSQL(String databaseName, String userDB, String passwordDB, String host, int port) {
        this.databaseName = databaseName;
        this.userDB = userDB;
        this.passwordDB = passwordDB;
        this.host = host;
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserDB() {
        return userDB;
    }

    public void setUserDB(String userDB) {
        this.userDB = userDB;
    }

    public String getPasswordDB() {
        return passwordDB;
    }

    public void setPasswordDB(String passwordDB) {
        this.passwordDB = passwordDB;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
