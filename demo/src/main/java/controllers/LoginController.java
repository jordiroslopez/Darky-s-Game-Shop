package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.Usuario;
import org.example.demo.BBDD;
import org.example.demo.SceneManager;

public class LoginController {
    @FXML
    private TextField id_mail;

    @FXML
    private TextField id_pass;

    @FXML
    public void login(ActionEvent event) throws InterruptedException {
        Usuario user = new Usuario(id_mail.getText(), id_pass.getText());

        if (BBDD.login(user)) {
            SceneManager.canviarEscena("/org/example/demo/tienda-view.fxml", "Tienda", event);
        }
    }

    @FXML
    public void signin(ActionEvent event) {
        SceneManager.canviarEscena("/org/example/demo/signin-view.fxml", "SignIn", event);
    }
}
