/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20150202_report;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Henri_2
 */
public class MySQL {

    String driver;

    String server, dbname, url, user, password;

    Connection con;
    Statement stmt;
    ResultSet rs;

    public MySQL() {
        this.driver = "org.git.mm.mysql.Driver";
        this.server = "j11000.sangi01.net";
        this.dbname = "50013040";
        this.url = "jdbc:mysql://" + server + "/" + dbname
                + "?useUnicode=true&characterEncoding=UTF-8";
        this.user = "50013040";
        this.password = "50013040";
        try {
            this.con = DriverManager.getConnection(url, user, password);
            this.stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //this.rs = rs;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectAll() {
        String sql = "SELECT * FROM citytemperature";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
