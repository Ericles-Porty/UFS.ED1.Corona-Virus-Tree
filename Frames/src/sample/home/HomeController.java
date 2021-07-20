package sample.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label carregando;

    public void exibirCarregando(ActionEvent event){
        carregando.setText("O ARQUIVO ESTÁ SENDO CARREGADO...");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../menu/menuView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
