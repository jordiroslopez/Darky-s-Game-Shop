package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Videojuego;
import org.example.demo.BBDD;
import org.example.demo.SceneManager;
import org.example.demo.UserSesion;

import java.util.ArrayList;

public class BibliotecaController {
    @FXML
    private VBox videojuegosContainer;

    @FXML
    public void initialize() throws InterruptedException {
        // OBTENER ID DEL USUARIO ACTUAL
        int id_usuario = UserSesion.usuarioActualProperty().get().getId_usuario();

        ArrayList<Videojuego> listaVideojuegos = BBDD.getListaVideojuegos(id_usuario);
        int espacio = 20;

        VBox contenedor = videojuegosContainer;
        HBox fila = new HBox(espacio);
        fila.setStyle("-fx-background-color: #040404FF");
        int contador = 0;

        for (Videojuego juego : listaVideojuegos) {
            // TARJETA
            VBox tarjeta = new VBox(10);
            tarjeta.setAlignment(Pos.CENTER);
            tarjeta.setPrefWidth(200);
            tarjeta.setPrefHeight(330);
            tarjeta.setStyle("-fx-background-color: transparent;");

            // BOTÓN
            Button btn = new Button(); // Puedes añadirle imagen si quieres
            btn.setPrefWidth(200);
            btn.setPrefHeight(300);
            btn.setStyle("-fx-background-color: #232323FF; -fx-text-fill: white; -fx-font-size: 18.0;");
            // btn.setOnAction(...); // Si quieres que haga algo

            // NOMBRE
            Label nombre = new Label(juego.getNombre_videojuego());
            nombre.setStyle("-fx-text-fill: white; -fx-font-size: 16.0;");
            nombre.setWrapText(true);
            nombre.setMaxWidth(180);
            nombre.setAlignment(Pos.TOP_LEFT);

            tarjeta.getChildren().addAll(btn, nombre);
            fila.getChildren().add(tarjeta);
            contador++;

            if (contador == 6) {
                contenedor.getChildren().add(fila);
                fila = new HBox(espacio);
                fila.setStyle("-fx-background-color: #040404FF");
                contador = 0;
            }
        }

        if (!fila.getChildren().isEmpty()) {
            contenedor.getChildren().add(fila);
        }
    }

    // CARGAR VENTANA TIENDA
    public void irATienda(ActionEvent event) {
        SceneManager.canviarEscena("/org/example/demo/tienda-view.fxml", event);
    }

    // CARGAR VENTANA LOGOUT
    public void LogOut(ActionEvent event) {
        SceneManager.canviarEscena("/org/example/demo/login-view.fxml", event);
    }
}
