package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.demo.Conexion;

public class LoginController {
    @FXML
    private TextField id_mail;

    @FXML
    private TextField id_pass;

    @FXML
    public void login(ActionEvent event) {
        String mail = id_mail.getText();
        String pass = id_pass.getText();
    }
}