package kr.or.ddit.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class AgreeViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane viewAIMS;

    @FXML
    private CheckBox CKbox1;

    @FXML
    private CheckBox CKbox2;

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

    @FXML
    void CKbox1(ActionEvent event) {

    }

    @FXML
    void CKbox2(ActionEvent event) {

    }

    @FXML
    void btnCancel(ActionEvent event) {

    }

    @FXML
    void btnOk(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert viewAIMS != null : "fx:id=\"viewAIMS\" was not injected: check your FXML file 'AgreeView.fxml'.";
        assert CKbox1 != null : "fx:id=\"CKbox1\" was not injected: check your FXML file 'AgreeView.fxml'.";
        assert CKbox2 != null : "fx:id=\"CKbox2\" was not injected: check your FXML file 'AgreeView.fxml'.";
        assert ok != null : "fx:id=\"ok\" was not injected: check your FXML file 'AgreeView.fxml'.";
        assert cancel != null : "fx:id=\"cancel\" was not injected: check your FXML file 'AgreeView.fxml'.";

    }
}
