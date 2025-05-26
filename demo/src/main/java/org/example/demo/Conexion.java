package org.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Conexion() {
        String url = "jdbc:mysql://localhost:3306/darkysgamesshop";
        String root = "root";
        String pass = "";

        try {
            Connection conexion = DriverManager.getConnection(url, root, pass);
            System.out.println("org.example.demo.Conexion establecida");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
