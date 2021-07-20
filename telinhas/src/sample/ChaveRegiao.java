package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChaveRegiao extends Application{

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("chaveRegiao/ChaveRegiaoView.fxml"));

        stage.setTitle("Floresta de covid");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

        setStage(stage);

    }
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ChaveRegiao.stage = stage;
    }
}



