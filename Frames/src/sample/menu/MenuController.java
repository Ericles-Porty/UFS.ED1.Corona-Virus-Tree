package sample.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {


    public void Cidade(ActionEvent event){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../data/ChaveView.fxml"));

            //MainOnlineController controller = root.<MainOnlineController>getController();
            //controller.initVariable(0);
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Brasil(ActionEvent event){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../data/DataView.fxml"));

            //MainOnlineController controller = root.<MainOnlineController>getController();
            //controller.initVariable(0);
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
