package mymember.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import AlertDialog.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import mymember.service.IMymemberService;
import mymember.service.MymemberServiceImpl;
import mymember.vo.MemberVO;

// 내 정보 화면
public class MyInformationController {
	
	private IMymemberService service;
	private ObservableList<MemberVO> memberList;
	private MemberVO memVO;

	private MymemberController mymemberController;

	public MymemberController getMymemberController() {
		return mymemberController;
	}

	public void setMyInfoController(MymemberController mymemberInfoCont) {
		this.mymemberController = mymemberInfoCont;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane memInfoView;

	// 아이디
	@FXML
	private TextField memID;

	// 비밀번호
	@FXML
	private TextField memPass;

	// 비밀번호 재확인
	@FXML
	private TextField memPassRe;

	// 이름
	@FXML
	private TextField memName;

	// 주민번호
	@FXML
	private TextField memReg;

	// 주소
	@FXML
	private TextField memAdd;

	// 주소 2
	@FXML
	private TextField memAdd2;


	// 전화번호
	@FXML
	private TextField memTel;

	// 이메일
	@FXML
	private TextField memEmail;

	 

	// 주소 검색 버튼
	@FXML
	private Button memserch;

	// 정보 수정 버튼
	@FXML
	private Button Modify;

	// 회원탈퇴 버튼
	@FXML
	private Button taltoe;

	// 수정 버튼
	@FXML
	void btnModify(ActionEvent event){
		try {
    		Stage currentStage =  (Stage) Modify.getScene().getWindow();
    		AlertUtil.showAlert(currentStage, "내 정보를 ","수정하시겠습니까?","취소","수정");
    																				
    		FXMLLoader loader = new FXMLLoader(MyInformationController.class.getResource("MySchedual.fxml"));
    		Parent root = loader.load();
    		MyInformationController memif = loader.getController();
    		memif.setMyInfoController(this);
    		Scene scene = new Scene(root);
    		currentStage.setScene(scene);
    		currentStage.show();
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    		
	
		
	}

	private void setMyInfoController(MyInformationController myInformationController) {
		// TODO Auto-generated method stub
		
	}

	// 내정보 화면의 회원 탈퇴 버튼을 누르면 회원탈퇴 화면으로 넘어 간다.
	@FXML
	void btnTaltoe(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(MymemberController.class.getResource("Mymemtaltoe.fxml"));

		for (int i = 0; i < memInfoView.getChildren().size(); i++) {
			memInfoView.getChildren().remove(i);
		}

		memInfoView.getChildren().addAll(root);

	}

	// 주소 검색 버튼
	@FXML
	void btnSerch(ActionEvent event) {

	}

	@FXML
	void memAdd(ActionEvent event) {

	}

	@FXML
	void memAdd2(ActionEvent event) {

	}

	@FXML
	void memEmail(ActionEvent event) {

	}

	@FXML
	void memId(ActionEvent event) {

	}

	@FXML
	void memInfoView(MouseEvent event) {

	}

	@FXML
	void memName(ActionEvent event) {

	}

	@FXML
	void memPass(ActionEvent event) {

	}

	@FXML
	void memPassRe(ActionEvent event) {

	}

	@FXML
	void memReg(ActionEvent event) {

	}

	@FXML
	void memSect(ActionEvent event) {

	}

	@FXML
	void memTel(ActionEvent event) {

	}

	
	  void show() {
	  
//	  this.memVO = memVO;
		 
	  memID.setText(memVO.getMem_id());
	  memPass.setText(memVO.getMem_pass());
	  memPassRe.setText(memVO.getMem_addr());
	  memName.setText(memVO.getMem_name());
	  memReg.setText(memVO.getMem_regno());
	  memAdd.setText(memVO.getMem_addr());
	  memEmail.setText(memVO.getMem_email());
	  
	  // 아이디만 비활성화
	  memID.setEditable(false);
	 }
	 
	
	@FXML
	void initialize() {		
		service = MymemberServiceImpl.getInstance();
		memVO = service.getMyInfoList("jieun");

		// memVO //
		show();

	}
}
