package controllers;

import javafx.fxml.FXML;
import models.Videojuego;
import org.example.demo.BBDD;

import java.util.ArrayList;

public class TiendaController {

    @FXML
    public void initialize() throws InterruptedException {
        ArrayList<Videojuego> listaVideojuegos = BBDD.getListaVideojuegos(0);

        // IMPRIMIR LISTA DE VIDEOJUEGOS
        for (int i = 0; i < listaVideojuegos.size(); i++) {
            System.out.println("ID     : " + listaVideojuegos.get(i).getId_videojuego());
            System.out.println("Nombre : " + listaVideojuegos.get(i).getNombre_videojuego());
            System.out.println("Precio : " + listaVideojuegos.get(i).getPrecio() + " €");
            System.out.println("CATEGORIAS");

            for (int j = 0; j < listaVideojuegos.get(i).getCategorias().size(); j++) {
                System.out.println("- " + listaVideojuegos.get(i).getCategorias().get(j));
            }

            System.out.println();
        }
    }
}
