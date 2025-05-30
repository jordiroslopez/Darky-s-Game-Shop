package org.example.demo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.Usuario;

public class UserSesion {
    private static final ObjectProperty<Usuario> usuarioActual = new SimpleObjectProperty<>();

    public static void setUser(Usuario usuario) {
        usuarioActual.set(usuario);
    }

    public static ObjectProperty<Usuario> usuarioActualProperty() {
        return usuarioActual;
    }
}
