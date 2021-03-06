package kr.or.ddit.controller.mypage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

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
import kr.or.ddit.AlerDialog.AlertUtil;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.vo.calDateVO;


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
    	
    	FXMLLoader loader = new FXMLLoader(MymemberController.class.getResource("../../fxml/mypage/MyMinwon.fxml")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
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
      try {
    	  Registry reg = LocateRegistry.getRegistry(9999);
    	  
    	  service = (IMymemberService) reg.lookup("IMymemberService");
	} catch (RemoteException e) {
		e.printStackTrace();
	}catch (NotBoundException e) {
		e.printStackTrace();
	}
      
      
    }
}
