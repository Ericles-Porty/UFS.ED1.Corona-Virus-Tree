package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.data.DataController;

public class Data extends Application {
    private static Stage stage;



    public static void main(String[] args) {
        launch(args);
    }




    /*
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("data/DataView.fxml"));
        loader.setController(new DataController(33));
        Parent root = loader.load();
        stage.setTitle("Inicio");
        stage.setScene(new Scene(root, 1000, 550));
        stage.setResizable(false);
        stage.show();
        }

*/



    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("data/DataView.fxml"));
        stage.setTitle("Floresta de covid");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        setStage(stage);

    }


    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Data.stage = stage;
    }


}
