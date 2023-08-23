package com.osttra.onlinebook.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
    public static Connection getConnection( )  {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Parv@123");


        }
        catch (Exception e) {
            System.out.println("Inside catch of getConnection()...");
            e.printStackTrace();
        }

        return con;
    }
}
