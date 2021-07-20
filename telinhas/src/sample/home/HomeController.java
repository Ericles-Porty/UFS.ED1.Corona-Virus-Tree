package sample.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
//import javafx.scene.control.Menu;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.Main;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import sample.Menu;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController implements Initializable {
    @FXML private Label carregando;
    @FXML private Button btIniciar;
    @FXML private Button btCreditos;
    @FXML private Button btFechar;
    @FXML private Button btInfo;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Botao para acessar o menu
        btIniciar.setOnMouseClicked((MouseEvent e) ->{
            Menu menu = new Menu();
            fecha();

            try {
                menu.start(new Stage());
            } catch (Exception er){
                System.out.println("erorxxerror");;
            }
        });

        btIniciar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER) {
                Menu menu = new Menu();
                fecha();
                try {
                    menu.start(new Stage());
                } catch (Exception er) {
                    System.out.println("erorxxerror");
                    ;
                }
            }
        });
        //

        //para os Creditos
        btCreditos.setOnMouseClicked((MouseEvent e)->{
            creditos();
        });

        btCreditos.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                creditos();
            }
        });

        //para o Info
        btInfo.setOnMouseClicked((MouseEvent e)->{
            info();
        });

        btInfo.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                info();
            }
        });
        //


        //Para Fechar
        btFechar.setOnMouseClicked((MouseEvent e)->{
            fecha();
        });

        btFechar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                fecha();
            }
        });
        //
    }
    public void creditos(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Desenvolvedores");
        alert.setTitle("Desenvolvedores");
        alert.setContentText("Éricles\nKendy\nJoanne\nMileninha\nPedro\nThiago");
        alert.show();
    }
    public void fecha(){
        Main.getStage().close();
    }

    public void info(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Info");
        alert.setTitle("Info");
        alert.setContentText("Modo de usar: Para acessar os dados gerais digite o código do município + data. \n Ex: 2513222020-10-11");
        alert.show();
    }







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
