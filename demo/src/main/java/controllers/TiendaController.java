package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Videojuego;
import org.example.demo.BBDD;

import java.util.ArrayList;

public class TiendaController {
    @FXML private TableView<Videojuego> tabla_videojuegos;
    @FXML private TableColumn<Videojuego, Integer> colID;
    @FXML private TableColumn<Videojuego, String> colNombre;
    @FXML private TableColumn<Videojuego, Double> colPrecio;

    private ObservableList<Videojuego> videojuegos;

    @FXML
    public void initialize() throws InterruptedException {
        ArrayList<Videojuego> listaVideojuegos = BBDD.getListaVideojuegos();

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tabla_videojuegos.setItems(videojuegos);
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
