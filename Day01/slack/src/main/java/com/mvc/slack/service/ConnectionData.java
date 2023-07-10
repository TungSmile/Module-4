package com.mvc.slack.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionData {
    private static String sql = "jdbc:mysql://localhost:3306/student?useSSL=false;";
    private static String id = "root";
    private static String pass = "123456";

    public static Connection getConnection() {
        Connection cnt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnt = DriverManager.getConnection(sql, id, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }

}
