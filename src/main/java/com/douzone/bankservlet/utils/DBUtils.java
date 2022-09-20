package com.douzone.bankservlet.utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    static Properties propertiesInfo = new Properties();
    static {
        try {
            propertiesInfo.load( new FileInputStream("db.properties") );
            Class.forName(propertiesInfo.getProperty("jdbc.driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(propertiesInfo.getProperty("jdbc.url"),
                propertiesInfo.getProperty("jdbc.id"),
                propertiesInfo.getProperty("jdbc.pw"));
    }

    // 자원반환
    public static void close(Connection con, Statement stmt, ResultSet rset) {
        try {
            if (rset != null) {
                rset.close();
                rset = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 자원반환
    public static void close(Connection con, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
