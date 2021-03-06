package memberInfo.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;

import AlertDialog.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import memberInfo.service.ImemberInfoService;
import memberInfo.service.memberInfoServiceImpl;
import memberInfo.vo.MemberInfoVO;

// 화면수정하는 창
public class MemberInfoModifyController {
	
	private  MemberInfoController mainController;
	
	public MemberInfoController getMainController() {
		return mainController;
	}
	
	public void setMainController(MemberInfoController mainController) {
		this.mainController=mainController;
	}
	
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
    private Button serach;

    @FXML
    private TextField textAdd2;

    @FXML
    private Button btnModi;

    @FXML
    private Button btnDel;

    @FXML
    private Button home;


    private ImemberInfoService service;
    private ObservableList<MemberInfoVO> data;
    



    
    //블랙리스트  o x 나타내는거 
    @FXML
    void blackList(MouseEvent event) {
    	
    }
    	
    // 주소 검색 
    @FXML
    void textAdd2(ActionEvent event) {

    }
    
    // 주소 검색 버튼누르는거 
    @FXML 
    void btnSerach(MouseEvent event) {
    	
    }
    
    
    
    // 회원정보 삭제 버튼
    @FXML
    void btnDel(ActionEvent event) {
    	Stage currentStage =  (Stage) btnDel.getScene().getWindow();
    	AlertUtil.showAlert(currentStage, "선택한 회원의 정보를 ","삭제하시겠습니까?","취소","삭제");
    	// 입력상자의 내용을 모두 삭제 
    	textId.clear();
    	textName.clear();
    	textPass.clear();
    	textPassRe.clear();
    	textReg.clear();
    	textTel.clear();
    	textAdd.clear();
    	textEmail.clear();
    	textAdd2.clear();
    	
    }
    
    
    // 회원정보 수정에서 홈으로 버튼을 누르면 홈으로 가기
    @FXML
    void btnHome(ActionEvent event) throws IOException {
    	//홈으로 버튼 누르면 경고창 나오고  이동버튼 누르면 첫 화면으로 이동
    	try {
    		Stage currentStage =  (Stage) home.getScene().getWindow();
        	AlertUtil.showAlert(currentStage, "메인페이지로 이동하시겠습니까? ","변경된 정보는 저장되지 않습니다.","취소","이동");
        		
    		FXMLLoader loader = new FXMLLoader(MemberInfoController.class.getResource("memberInfo.fxml")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
    		Parent root = loader.load();
    		MemberInfoController memberInfo = loader.getController();
    		memberInfo.setMainController(this);
    		Scene scene = new Scene(root);
    		currentStage.setScene(scene);
    		currentStage.show();
    		
		} catch (IOException e) {
			// TODO: handle exception
		}
    	
    		
    	
    }
    
    // 회원정보 수정에서 수정버튼 눌렀을 떄 알림창 띄우기
    @FXML
    void btnModi(ActionEvent event) throws IOException {
    	try {
    		Stage currentStage =  (Stage) btnModi.getScene().getWindow();
    		AlertUtil.showAlert(currentStage, "선택한 회원의 정보를 ","수정하시겠습니까?","취소","수정");
    		
    		FXMLLoader loader = new FXMLLoader(MemberInfoController.class.getResource("memberInfo.fxml"));
    		Parent root = loader.load();
    		MemberInfoController memif = loader.getController();
    		memif.setMainController(this);
    		Scene scene = new Scene(root);
    		currentStage.setScene(scene);
    		currentStage.show();
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    		
    	
    	
    	
    }
    private MemberInfoVO mifVO;
    
    
    // 화면 전환해서 보여지는거 
    public void show(MemberInfoVO mifVO) {
		
		  this.mifVO = mifVO; 
		  textId.setText(mifVO.getMem_id());
		  textPass.setText(mifVO.getMem_pass());
		  textPassRe.setText(mifVO.getMem_pass());
		  textName.setText(mifVO.getMem_name()); 
		  textReg.setText(mifVO.getMem_regno());
		  textAdd.setText(mifVO.getMem_addr()); 
		  textTel.setText(mifVO.getMem_tel());
		  textEmail.setText(mifVO.getMem_email());
		  // 아이디 값은 비활성화 
		  textId.setEditable(false);
		 
    }
    
    @FXML
    void initialize() {
       service = memberInfoServiceImpl.getinstance();
       
       
       
    }
}
