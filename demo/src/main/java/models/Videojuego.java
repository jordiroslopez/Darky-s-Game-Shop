package models;

import java.util.List;

public class Videojuego {
    private int id_videojuego;
    private String nombre_videojuego;
    private float precio;
    private List categorias;

    public Videojuego(int id_videojuego, String nombre_videojuego, float precio, List categorias) {
        this.id_videojuego = id_videojuego;
        this.nombre_videojuego = nombre_videojuego;
        this.precio = precio;
        this.categorias = categorias;
    }

    public String getNombre_videojuego() {
        return nombre_videojuego;
    }
}
