package kr.or.ddit.controller.mypage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

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
import kr.or.ddit.AlerDialog.AlertUtil;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.vo.MemberVO;



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
			//alert 창 띄우는거 
    		Stage currentStage =  (Stage) Modify.getScene().getWindow();
    		AlertUtil.showAlert(currentStage, "내 정보를 ","수정하시겠습니까?","취소","수정");
    						
    		// 수정 버튼 눌렀을 때 처음 화면으로 이동 
    		FXMLLoader loader = new FXMLLoader(MySchedualController.class.getResource("../../fxml/mypage/MySchedual.fxml"));
    		Parent root = loader.load();
    		
    		for (int i = 1; i < memInfoView.getChildren().size(); i++) {
    			memInfoView.getChildren().remove(i);
    		}
    		memInfoView.getChildren().addAll(root);
    		
    		
//    		MyInformationController memif = loader.getController();
//    		memif.setMyInfoController(this);
//    		Scene scene = new Scene(root);
//    		currentStage.setScene(scene);
//    		currentStage.show();
    		
    		
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
		Parent root = FXMLLoader.load(MymemberController.class.getResource("../../fxml/mypage/Mymemtaltoe.fxml"));

		for (int i = 0; i < memInfoView.getChildren().size(); i++) {
			memInfoView.getChildren().remove(i);
		}

		memInfoView.getChildren().addAll(root);

	}

	// 주소 검색 버튼
	 @FXML
	void btnSerch(MouseEvent event) {
		 try {
	            
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxml/mypage/AddSearch.fxml"));
	            Parent root = (Parent)fxmlLoader.load();
	            Stage primaryStage = new Stage();
	            AddSearch controller = fxmlLoader.getController();
	            controller.setDialog(this);
	            Scene scene = new Scene(root);
	            primaryStage.setScene(scene);
	            primaryStage.setTitle("주소 검색");
	            primaryStage.show();
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
		 
		 
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
	 
	  public void inputAddr(String zipcode, String addr) { // 3번째 창한테 받은 정보
		  memAdd.setText(zipcode);
		  memAdd2.setText(addr);
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
		
		
		memVO = service.getMyInfoList("jieun");

		// memVO //
		show();

	}
}
