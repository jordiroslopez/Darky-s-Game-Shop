package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.demo.BBDD;
import org.example.demo.SceneManager;

public class SignInController {
    @FXML
    private Label lbl_error;

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
        if (id_pass.getText().equals(id_pass2.getText())) {                                                             // VERIFICAR QUE LAS CONTRASEÑAS COINCIDEN
            if (!id_username.getText().equals("") && !id_pass.getText().equals("") && !id_mail.getText().equals("")) {  // VERIFICAR QUE LOS CAMPOS NO ESTEN VACIOS
                if (BBDD.signin(id_username.getText(), id_pass.getText(), id_mail.getText())) {                         // VERIFICAR QUE EL EMAIL NO ESTE EN USO
                    SceneManager.canviarEscena("/org/example/demo/tienda-view.fxml", event);
                } else {
                    lbl_error.setVisible(true);
                    lbl_error.setText("Email en uso");
                }
            } else {
                lbl_error.setVisible(true);
                lbl_error.setText("Campos vacios");
            }
        } else {
            lbl_error.setVisible(true);
            lbl_error.setText("Las contraseñas no coinciden");
        }
    }

    @FXML
    public void login(ActionEvent event) {
        SceneManager.canviarEscena("/org/example/demo/login-view.fxml", event);
    }
}
