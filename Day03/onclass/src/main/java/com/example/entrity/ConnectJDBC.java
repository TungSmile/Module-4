package com.example.entrity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {
    private static String url="jdbc:mysql://localhost:3306/hocvien?useSSL=false";;
    private static String id="root";
    private static String pass="123456";

    public static Connection getConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,id,pass);
        }
        catch (Exception e){
            return null;
        }
    }
}
