package sample.data;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Data;
import sample.Menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DataController implements Initializable {
    @FXML private Label txTipo;
    @FXML private Label TxCasos;
    @FXML private Label TxObitos;
    @FXML private Label TxAVL;
    @FXML private Label TxABB;
    @FXML private Button btVoltar;
/*
    public int id;


    public DataController(int id){
        this.id = id;
    }
*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {




        //System.out.println("<< " + id + " >>");

        //Botao Voltar
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            Voltar();
        });

        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Voltar();
            }
        });
        //


        //txTipo.setText("TESTEXXXAF@");
        /*
        TxCasos.setText(variavel);
        TxCasos.setText(variavel);
        TxABB.setText("Árvore Binária:  " + nomedavariavel.getText());
        TxAVL.setText("Árvore AVL:  " +nomedavariavel.getText());
        */

    }

    public void Voltar(){
        Menu menu = new Menu();
        Data.getStage().close();

        try {
            menu.start(new Stage());
        } catch (Exception er){
            System.out.println("erorxxerror");
        }
    }


}
