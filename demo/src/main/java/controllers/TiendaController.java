package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import models.Videojuego;
import org.example.demo.BBDD;
import java.util.ArrayList;

public class TiendaController {
    @FXML
    private HBox videojuegosContainer;

    @FXML
    public void initialize() throws InterruptedException {
        ArrayList<Videojuego> listaVideojuegos = BBDD.getListaVideojuegos(0);

        HBox fila = new HBox(10);
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
                fila = new HBox(10);
                contador = 0;
            }
        }

        if (!fila.getChildren().isEmpty()) {
            videojuegosContainer.getChildren().add(fila);
        }
    }
}
