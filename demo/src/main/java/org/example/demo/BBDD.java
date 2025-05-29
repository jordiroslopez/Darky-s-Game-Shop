package org.example.demo;

import models.Usuario;
import models.Videojuego;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException sqe) {
                System.err.println(sqe.getMessage());
                sleep(100);
            }
        }

        return false;
    }

    public static ArrayList<Videojuego> getListaVideojuegos(int id_usuario) throws InterruptedException {
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();
        Connection conexion = BBDD.connect();

        // ESTABLECER VARIABLES VIDEOJUEGOS
        int id_videojuego = 0;
        String nombre_videojuego = "";
        float precio = 0;
        String getVideojuego;

        try {
            // QUERY PARA OBTENER VALORES VIDEOJUEGO
            if (id_usuario == 0) {  // OBTENER TODOS LOS JUEGOS
                getVideojuego = "SELECT * FROM videojuego;";
            } else {                // OBTENER TODOS LOS JUEGOS DEL USUARIO
                getVideojuego =
                        "SELECT * FROM (usuario u " +
                                "JOIN usuario_videojuego uv " +
                                "JOIN videojuego v " +
                                "ON u.id_usuario = uv.id_usuario " +
                                "AND uv.id_videojuego = v.id_videojuego) " +
                                "WHERE u.id_usuario = " + id_usuario + ";";
            }
            PreparedStatement stmt1 = conexion.prepareStatement(getVideojuego);
            ResultSet rs_videojuego = stmt1.executeQuery();

            while (rs_videojuego.next()) {
                // OBTENER VALORES VIDEOJUEGOS CON LA QUERY
                List categorias = new ArrayList();
                id_videojuego = rs_videojuego.getInt("id_videojuego");
                nombre_videojuego = rs_videojuego.getString("nombre_videojuego");
                precio = rs_videojuego.getFloat("precio");

                // OBTENER CATEGORIAS DE VIDEOJUEGOS
                String getCategoria =
                        "SELECT c.nombre_categoria FROM (videojuego v " +
                                "JOIN videojuego_categoria vc " +
                                "JOIN categoria c " +
                                "ON v.id_videojuego = vc.id_videojuego " +
                                "AND vc.id_categoria = c.id_categoria) " +
                                "WHERE v.id_videojuego = " + id_videojuego + ";";
                PreparedStatement stmt2 = conexion.prepareStatement(getCategoria);
                ResultSet rs_categoria = stmt2.executeQuery();

                while (rs_categoria.next()) { // OBTENER NOMBRES CATEGORIAS
                    String nombreCategoria = rs_categoria.getString("nombre_categoria");
                    categorias.add(nombreCategoria);
                }

                // CREARE Y GUARDAR VIDEOJUEGO
                Videojuego videojuego = new Videojuego(id_videojuego, nombre_videojuego, precio, categorias);
                listaVideojuegos.add(videojuego);
            }
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            sleep(100);
        }

        return listaVideojuegos;
    }
}
