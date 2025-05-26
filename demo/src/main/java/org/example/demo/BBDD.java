package org.example.demo;

import models.Usuario;
import java.sql.*;

import static java.lang.Thread.sleep;

public class BBDD {
    public BBDD() {
        // CONSTRUCTOR
    }

    public static Connection connect() throws InterruptedException {
        Connection conexion = null;
        String url = "jdbc:mysql://localhost:3306/darkysgamesshop";
        String root = "root";
        String pass = "";

        try {
            conexion = DriverManager.getConnection(url, root, pass);
            System.out.println("Conexion establecida");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            sleep(100);
        }

        return conexion;
    }

    public static boolean login(Usuario usuario) throws InterruptedException {
        Connection conexion = BBDD.connect();

        if (conexion != null) {
            String query = "SELECT * FROM usuario WHERE email = ? AND contrasena = ?;";

            try (PreparedStatement stmt1 = conexion.prepareStatement(query)) {
                stmt1.setString(1, usuario.getEmail());
                stmt1.setString(2, usuario.getContrasena());
                ResultSet rs = stmt1.executeQuery();

                if (rs.next()) {
                    int id_usuario = rs.getInt("id_usuario");
                    String nombreUsuario = rs.getString("nombre_usuario");
                    String contrasena = rs.getString("contrasena");
                    String email = rs.getString("email");
                    UserSesion.setUser(new Usuario(id_usuario, nombreUsuario, contrasena, email));
                }
            } catch (SQLException sqe) {
                System.err.println(sqe.getMessage());
                sleep(100);
            }
        }

        return false;
    }
}
