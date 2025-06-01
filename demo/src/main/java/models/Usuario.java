package models;

import org.example.demo.UserSesion;

public class Usuario extends UserSesion {
    private int id_usuario;
    private String nombre_usuario;
    private String contrasena;
    private String email;
    private boolean esAdmin;
    private Videojuego[] videojuegos;

    // CONSTRUCTOR SIN LISTA DE VIDEOJUEGOS
    public Usuario(int id_usuario, String nombre_usuario, String contrasena, String email, boolean esAdmin) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.esAdmin = esAdmin;
    }

    // CONSTRUCTOR CON TODOS LOS ATRIBUTOS
    public Usuario(String nombre_usuario, String contrasena, String email, boolean esAdmin) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.videojuegos = videojuegos;
        this.esAdmin = esAdmin;
    }

    // CONSTRUCTOR SOLO CON EMAIL Y CONTRASEÑA
    public Usuario(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }
}
