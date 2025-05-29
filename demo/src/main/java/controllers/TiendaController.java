package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Videojuego;
import org.example.demo.BBDD;
import javafx.geometry.Insets;

import java.util.ArrayList;

public class TiendaController {
    @FXML
    private HBox videojuegosContainer;

    @FXML
    public void initialize() throws InterruptedException {
        ArrayList<Videojuego> listaVideojuegos = BBDD.getListaVideojuegos(0);

        for (Videojuego juego : listaVideojuegos) {
            Button btn = new Button(juego.getNombre_videojuego());
            btn.setPrefWidth(125);
            btn.setPrefHeight(200);
            btn.setStyle("-fx-background-color: #a100ff; -fx-text-fill: white;");

            VBox.setMargin(btn, new Insets(10));

            videojuegosContainer.getChildren().add(btn);
        }
    }
}

// IMPRIMIR LISTA DE VIDEOJUEGOS
        /*
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

         */