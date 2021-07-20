package sample.data;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.io.IOException;

public class DataController {
    @FXML
    private Label tipo;

    public void labelTipo(ActionEvent event){
        tipo.setText("idade");
    }
}
