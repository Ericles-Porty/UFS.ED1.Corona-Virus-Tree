package sample.menu;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.Data;
import sample.Chave;
import sample.ChaveRegiao;
import sample.Main;
import sample.Menu;
import sample.chave.ChaveController;
import sample.data.DataController;


public class MenuController extends ChaveController implements Initializable {
    @FXML private Button btBrasil;
    @FXML private Button btDadosGerais;
    @FXML private Button btRegiao;
    @FXML private Button btCidade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Botao Dados Gerais
        btDadosGerais.setOnMouseClicked((MouseEvent e) -> {
            chamaDadosGerais();
            Menu.getStage().close();
        });

        btDadosGerais.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaDadosGerais();
                Menu.getStage().close();
            }
        });

        //Botao Cidade
        btCidade.setOnMouseClicked((MouseEvent e) -> {
            chamaCidade();
            Menu.getStage().close();
        });

        btCidade.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaCidade();
                Menu.getStage().close();
            }
        });

        //Botao Regiao
        btRegiao.setOnMouseClicked((MouseEvent e) -> {
            chamaRegião();
            Menu.getStage().close();
        });

        btRegiao.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaRegião();
                Menu.getStage().close();
            }
        });

        //Botao Brasil
        btBrasil.setOnMouseClicked((MouseEvent e) -> {
            chamaBrasil();
            Menu.getStage().close();
        });

        btBrasil.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                chamaBrasil();
                Menu.getStage().close();
            }
        });
        //

    }

    public void chamaDadosGerais(){
        Chave chavePrint = new Chave();
        try {
        chavePrint.start(new Stage());
        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    public void chamaCidade(){
        Chave chavePrint = new Chave();
        try {
            chavePrint.start(new Stage());
        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    public void chamaRegião(){
        ChaveRegiao chaveRegiaoPrint = new ChaveRegiao();
        try {
            chaveRegiaoPrint.start(new Stage());
        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    public void chamaBrasil() {
        Data dadosPrint = new Data();

        //fecha();
        //fecha();

        try {
            dadosPrint.start(new Stage());
        } catch (Exception er) {
            er.printStackTrace();
        }
    }


    public void mudarvalor() {
        System.out.println("oi");
    }


    //public void fecha() {
        //Menu.getStage().close();
 //   }

    /*
    @FXML
    void button_action(ActionEvent event) {
        labelAux.setText("Oi");
        //labelAux.setText(btBrasil.getText());
    }
    */

}


/*
public class MenuController {
    @FXML
    private Button bCidade;


    public void Cidade(ActionEvent event){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../chave/ChaveView.fxml"));

            //MainOnlineController controller = root.<MainOnlineController>getController();
            //controller.initVariable(0);
            System.out.println();
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
*/