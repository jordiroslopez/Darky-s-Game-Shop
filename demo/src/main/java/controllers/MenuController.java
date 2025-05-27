package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

import java.util.List;

public class MenuController {
    @FXML
    public void initialize() {
        List<String> items = List.of("Juego 1", "Juego 2", "Juego 3", "Juego 4", "Juego 5", "Juego 6", "Juego 7");

        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(10);

        for (String item : items) {
            Button btn = new Button(item);
            btn.setPrefSize(100, 150);
            flowPane.getChildren().add(btn);
        }
    }
}
