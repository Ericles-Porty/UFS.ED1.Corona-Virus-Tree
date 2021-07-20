package sample.chaveRegiao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Data;
import sample.Chave;
import sample.ChaveRegiao;
import sample.Menu;


import java.net.URL;
import java.util.ResourceBundle;

public class ChaveRegiaoController implements Initializable {
    @FXML private Button btNO;
    @FXML private Button btNE;
    @FXML private Button btCO;
    @FXML private Button btS;
    @FXML private Button btSE;
    @FXML private Button btVoltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Botao Norte
        btNO.setOnMouseClicked((MouseEvent e) -> {
            chamaData();
            Menu.getStage().close();
        });

        btNO.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaData();
                Menu.getStage().close();
            }
        });

        //Botao Nordeste
        btNE.setOnMouseClicked((MouseEvent e) -> {
            chamaData();
            Menu.getStage().close();
        });

        btNE.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaData();
                Menu.getStage().close();
            }
        });

        //Botao Centro-Oeste
        btCO.setOnMouseClicked((MouseEvent e) -> {
            chamaData();
            Menu.getStage().close();
        });

        btCO.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaData();
                Menu.getStage().close();
            }
        });

        //Botao Sul
        btS.setOnMouseClicked((MouseEvent e) -> {
            chamaData();
            Menu.getStage().close();
        });

        btS.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaData();
                Menu.getStage().close();
            }
        });
        // Botao Sudeste
        btSE.setOnMouseClicked((MouseEvent e) -> {
            chamaData();
            Menu.getStage().close();
        });

        btSE.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaData();
                Menu.getStage().close();
            }
        });

        // Botao Voltar
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            Voltar();
        });

        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Voltar();
            }
        });

    }

    public void chamaData(){
        Data dadosPrint = new Data();
        try {
            dadosPrint.start(new Stage());
        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    public void Voltar(){
        Menu menu = new Menu();
        ChaveRegiao.getStage().close();
        try {
            menu.start(new Stage());
        } catch (Exception er){
            System.out.println("erorxxerror");
        }
    }


}
