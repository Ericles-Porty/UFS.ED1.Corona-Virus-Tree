package sample.chave;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Chave;
import sample.Data;
import sample.Menu;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class ChaveController implements Initializable {

    @FXML private TextField chaveEntrada;
    @FXML private Button btContinuar;
    @FXML private Button btVoltar;
    @FXML private Label txText;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            Voltar();
        });

        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Voltar();
            }
        });

        btContinuar.setOnMouseClicked((MouseEvent e)->{
            txText.setText(chaveEntrada.getText());  //assim??
        });

        btContinuar.setOnKeyPressed((KeyEvent e) ->{
            if (e.getCode() == KeyCode.ENTER){
                txText.setText(chaveEntrada.getText());
            }
        });

    }


    public void Voltar(){
        Menu menu = new Menu();
        Chave.getStage().close();

        try {
            menu.start(new Stage());
        } catch (Exception er){
            System.out.println("erorxxerror");
        }
    }

}

