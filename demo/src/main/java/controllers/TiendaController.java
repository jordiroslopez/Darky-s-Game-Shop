package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Videojuego;
import org.example.demo.BBDD;
import org.example.demo.SceneManager;

import java.util.ArrayList;

public class TiendaController {
    @FXML
    private VBox videojuegosContainer;

    @FXML
    public void initialize() throws InterruptedException {
        ArrayList<Videojuego> listaVideojuegos = BBDD.getListaVideojuegos(0);
        int espacio = 20;

        HBox fila = new HBox(espacio);
        int contador = 0;

        for (Videojuego juego : listaVideojuegos) {
            Button btn = new Button(juego.getNombre_videojuego());
            btn.setPrefWidth(200);
            btn.setPrefHeight(300);
            btn.setStyle("-fx-background-color: #232323FF; -fx-text-fill: white; -fx-font-size: 20.0");

            fila.getChildren().add(btn);
            contador++;

            if (contador == 6) {
                videojuegosContainer.getChildren().add(fila);
                fila = new HBox(espacio);
                contador = 0;
            }
        }

        if (!fila.getChildren().isEmpty()) {
            videojuegosContainer.getChildren().add(fila);
        }
    }

    public void irABiblioteca(ActionEvent event) {
        SceneManager.canviarEscena("/org/example/demo/biblioteca-view.fxml", "Biblioteca", event);
    }
}
