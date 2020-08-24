package mymember.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import AlertDialog.AlertUtil;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mymember.service.IMymemberService;
import mymember.service.MymemberServiceImpl;

public class MymemTaltoe {
	
	private IMymemberService service;
	
	@FXML
	private AnchorPane taltoeView;
	  
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField input;

    @FXML
    private Button confirm;
    
    @FXML
    void taltoeView(MouseEvent event) {

    }
    @FXML
    void btnCon(ActionEvent event) throws IOException {
    	Stage currentStage =  (Stage) taltoeView.getScene().getWindow();
    	AlertUtil.showAlert(currentStage, "메인페이지로  ","이동하시겠습니까?","취소","이동");
    	
    	FXMLLoader loader = new FXMLLoader(MymemberController.class.getResource("MyMinwon.fxml")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
    	Parent root = loader.load();

    	for(int i = 0; i <taltoeView.getChildren().size(); i++ ) {
    		taltoeView.getChildren().remove(i);
    	}
    	taltoeView.getChildren().addAll(root);
    }

    @FXML
    void inputpass(ActionEvent event) {

    }

    @FXML
    void initialize() {
      service = MymemberServiceImpl.getInstance();
      
      
      
    }
}
