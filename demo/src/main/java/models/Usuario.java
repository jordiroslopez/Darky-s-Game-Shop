package models;

import org.example.demo.UserSesion;

public class Usuario extends UserSesion {
    private int id_usuario;
    private String nombre_usuario;
    private String contrasena;
    private String email;
    private Videojuego[] videojuegos;

    public Usuario(int id_usuario, String nombre_usuario, String contrasena, String email, Videojuego[] videojuegos) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.videojuegos = videojuegos;
    }

    public Usuario(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }
}
