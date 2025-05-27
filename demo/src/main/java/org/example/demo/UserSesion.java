package org.example.demo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.Usuario;

public class UserSesion {
    public UserSesion() {}

    private static final ObjectProperty<UserSesion> usuarioActual = new SimpleObjectProperty<>();

    public static void setUser(Usuario usuario) {
        usuarioActual.set(usuario);
    }
}
