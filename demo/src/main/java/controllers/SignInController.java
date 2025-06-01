package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.demo.BBDD;
import org.example.demo.SceneManager;

public class SignInController {

    @FXML
    private TextField id_username;

    @FXML
    private TextField id_mail;

    @FXML
    private TextField id_pass;

    @FXML
    private TextField id_pass2;

    @FXML
    public void signin(ActionEvent event) throws InterruptedException {
        if (id_pass.getText().equals(id_pass2.getText())) {
            if (BBDD.signin(id_username.getText(), id_pass.getText(), id_mail.getText())) { // VERIFICAR QUE EL USUARIO NO EXISTE Y CREAR CUENTA
                SceneManager.canviarEscena("/org/example/demo/tienda-view.fxml", "Tienda", event);
            }
        }
    }
}
