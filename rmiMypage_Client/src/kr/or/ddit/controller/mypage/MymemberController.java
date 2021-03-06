package kr.or.ddit.controller.mypage;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.AlerDialog.AlertUtil;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.vo.MemberVO;



// 마이페이지 화면
public class MymemberController {
	
	private MyInformationController myinfoController;
	private ObservableList <MemberVO> data; 
	
	// 내정보 controller
	 private  MyInformationController mymemverinfoController;
	 
	 public MyInformationController getMymemberInfoController() {
		 return mymemverinfoController;
	 }
	 
	 public void setMainController(MyInformationController mymembercontroller) {
		 this.mymemverinfoController = mymembercontroller;
	 }
	 private void setMainController(MymemberController mymemberController) {}
	 
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mypage; 

    @FXML
    private Button myShcedual;  // 내일정 버튼

    @FXML
    private Button myInteres;	// 내 관심물건

    @FXML
    private Button myInformation;	// 내 정보 

    @FXML
    private Button myMinwon;	// 내민원

    @FXML
    private Button myAut;	// 내 경매 내역

    @FXML
    private Button mySection;	// 회원탈퇴

    @FXML
    private Button home;	// 돌아가기 
    
    public IMymemberService service;
    
    
    //내일정 버튼 선택시  내일정 달력나오는걸로 화면  바뀌는거
    @FXML
    void btcShcedual(ActionEvent event) throws IOException {
    	Parent root =  FXMLLoader.load(MymemberController.class.getResource("../../fxml/mypage/MySchedual.fxml"));
    	
    	for(int i = 0; i < mypage.getChildren().size(); i++ ) {
    		mypage.getChildren().remove(i);
    	}
    	mypage.getChildren().addAll(root);
    }
    
    
    // 내 경매 내역 버튼
    @FXML
    void btnAut(ActionEvent event) throws IOException {
    	Parent root =  FXMLLoader.load(MymemberController.class.getResource("../../fxml/mypage/MyAuction.fxml"));
    	
    	for(int i = 0; i <mypage.getChildren().size(); i++ ) {
    		mypage.getChildren().remove(i);
    	}
    	mypage.getChildren().addAll(root);
    }


    
    
    // 홈으로 버튼
    @FXML
    void btnHome(ActionEvent event) {
    	try {
    		Stage currentStage =  (Stage) home.getScene().getWindow();
        	AlertUtil.showAlert(currentStage, "메인페이지로  ","이동하시겠습니까?","취소","이동");
        	
        	FXMLLoader loader = new FXMLLoader(MymemberController.class.getResource("../../fxml/mypage/MyMinwon.fxml")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
        	Parent root = loader.load();
   
        	for(int i = 0; i <mypage.getChildren().size(); i++ ) {
        		mypage.getChildren().remove(i);
        	}
        	mypage.getChildren().addAll(root);
        	
        	
			/* 화면 전환 하는 부분 
			 * MymemberController memberInfo = loader.getController();
			 * memberInfo.setMainController(this); Scene scene = new Scene(root);
			 * currentStage.setScene(scene); currentStage.show();
			 */
    		
		} catch (IOException e) {
			// TODO: handle exception
		}
    	
    	
    	
    	
    }
    

    
    // 내 정보 버튼
    @FXML
    void btnInfo(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(MymemberController.class.getResource("../../fxml/mypage/MyInformation.fxml"));
    	Parent root =  loader.load();
    	
    	for(int i = 0; i < mypage.getChildren().size(); i++ ) {
    		mypage.getChildren().remove(i);
    	}
    	mypage.getChildren().addAll(root);
   
 
    	
    }
    
    // 내 관심 물건 버튼
    @FXML
    void btnInters(ActionEvent event) throws IOException {
    	Parent root =  FXMLLoader.load(MymemberController.class.getResource("../../fxml/mypage/MymemInterest.fxml"));
    	
    	for(int i = 0; i <mypage.getChildren().size(); i++ ) {
    		mypage.getChildren().remove(i);
    	}
    	mypage.getChildren().addAll(root);
    	
    }
    
    
    // 내 민원버튼
    @FXML
    void btnMinwon(ActionEvent event) throws IOException {
    	Parent root =  FXMLLoader.load(MymemberController.class.getResource("../../fxml/mypage/Com_QuestionController.fxml"));
    	
    	for(int i = 0; i <mypage.getChildren().size(); i++ ) {
    		mypage.getChildren().remove(i);
    	}
    	mypage.getChildren().addAll(root);
    	
    	
    	
    	
    }
    
    // 회원탈퇴
    @FXML
    void btnSection(ActionEvent event) throws IOException {
    	Parent root =  FXMLLoader.load(MymemberController.class.getResource("../../fxml/mypage/Mymemtaltoe.fxml"));
    	
    	for(int i = 0; i <mypage.getChildren().size(); i++ ) {
    		mypage.getChildren().remove(i);
    	}
    	mypage.getChildren().addAll(root);
    }
    
    // 내일정에서의 화면 창 
    @FXML
    void mypageView(MouseEvent event) throws IOException {
    	
    }

    @FXML
    void initialize() {
        
    	
    	
    }
}
