package memberInfo.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import AlertDialog.AlertUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import memberInfo.service.ImemberInfoService;
import memberInfo.service.memberInfoServiceImpl;


// 회원정보 수정 화면
public class memberInfoModifyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textId;

    @FXML
    private TextField textPass;

    @FXML
    private TextField textPassRe;

    @FXML
    private TextField textName;

    @FXML
    private TextField textReg;

    @FXML
    private TextField textAdd;

    @FXML
    private TextField textTel;

    @FXML
    private TextField textEmail;

    @FXML 
    private Label blackList;

    @FXML
    private Button btnModi;

    @FXML
    private Button btnDel;

    @FXML
    private Button home;

    private ImemberInfoService service;
    
    //블랙리스트 버튼
    @FXML
    void blackList(MouseEvent event) {
    	
    }
    
    // 회원정보 삭제 버튼
    @FXML
    void btnDel(ActionEvent event) {

    }
    
    // 회원정보 수정에서 홈으로 버튼을 누르면 홈으로 가기
    @FXML
    void btnHome(ActionEvent event) {

    }
    
    // 회원정보 수정에서 수정버튼 눌렀을 떄 알림창 띄우기
    @FXML
    void btnModi(ActionEvent event) throws IOException {
//    	Stage currentStage =  (Stage) btnModi.getScene().getWindow();
//    	AlertUtil.showAlert(currentStage, "수정하시겠습니까?");\
    	Stage currentStage =  (Stage) btnModi.getScene().getWindow();
    	AlertUtil.showAlert(currentStage, "블랙리스트 확인","확인하셨습니까?","넵~","ㄴㄴ");
    	
    }

    @FXML
    void initialize() {
       service = memberInfoServiceImpl.getinstance();
    }
}
