package models;

public class Videojuego {
    private int id_videojuego;
    private String nombre_videojuego;
    private float precio;
    private Categoria[] categorias;

    public Videojuego(int id_videojuego, String nombre_videojuego, float precio, Categoria[] categorias) {
        this.id_videojuego = id_videojuego;
        this.nombre_videojuego = nombre_videojuego;
        this.precio = precio;
        this.categorias = categorias;
    }
}
