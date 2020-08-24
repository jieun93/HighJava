package kr.or.ddit.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class memberInfoModifyController {
	
	
	private ImemberInfoService service;
	private IMymemberService intservice;
	private ObservableList<MemberInfoVO> data;
	private MemberInfoVO memInfoVO;
	private InterestVO interVO;
	private InterestArticleVO intArtiVO;
	private Article_ResultVO aresutVO;
	
	
	private  MymemIntersetController interestController;
	
	public MymemIntersetController getInterestController() {
		return interestController;
	}
	
	public void setMainController(MymemIntersetController interestController) {
		this.interestController=interestController;
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane memberView;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfPass;

    @FXML
    private TextField tfRePass;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfReg;

    @FXML
    private TextField tfAdd;
    
    @FXML
    private TextField tfAdd2;

    @FXML
    private TextField tfTel;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfInputNum;

    @FXML
    private Button btnnumCom;

    @FXML
    private Button btnAddSerach;

    @FXML
    private Button btnemailCon;

    @FXML
    private Label passLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label telLabel;

    @FXML
    private Label regLabel;

    @FXML
    private Label blacklistLabel;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnhome;

    @FXML
    private Button btnDelete;
    
    
    // 주소 검색 버튼 
    @FXML
    void btnAddSearch(MouseEvent event) {
    	try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxml/adminmypage/AddSearch.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Stage primaryStage = (Stage) serach.getScene().getWindow();
            
            Stage primaryStage2 = new Stage(StageStyle.DECORATED);
            primaryStage2.initModality(Modality.WINDOW_MODAL);
            primaryStage2.initOwner(primaryStage);
            
            AddSearch controller = fxmlLoader.getController();
            controller.setDialog(this);
            
            Scene scene = new Scene(root);
            primaryStage2.setScene(scene);
            primaryStage2.setTitle("주소 검색");
            primaryStage2.show();
            
         } catch (Exception e) {
            e.printStackTrace();
         }
    }

    	
    public void inputAddr(String zipcode, String addr) { // 3번째 창한테 받은 정보
    	tfAdd.setText(zipcode);
    	tfAdd2.setText(addr);
    }
    // 회원정보 삭제 버튼 
    @FXML
    void btnDelete(ActionEvent event) {
    	//삭제 버튼 누르면 경고창 나오고 나가는 거 메인화면으로 
    	try {

//        	AlertUtil.showAlert(currentStage, "내 정보를 삭제 ","하시겠습니까?","취소","삭제");
    		
    		Parent alert = FXMLLoader
    				.load(MemberInfoModifyController.class.getResource("../../AlertDialog/AlertDialog2.fxml "));
    		Stage del =  (Stage) btnDel.getScene().getWindow();
    		String yes = "삭제";
    		String no = "취소";
    		boolean a = AlertUtil.showAlert(del, "삭제하시겠습니까?", "",yes,no);
    		int cnt  = 0;
    		if(a == false) {
    			return;
    		}else {
    			// 관심물건도 같이 삭제 해줘야 한다. 
    			InterestVO intArtiVO = new InterestVO();
    			intArtiVO.setMem_id(mifVO.getMem_id());
    			cnt = intservice.delInterstProd(intArtiVO);
    			
    			// 경매 결과 
    			
    			
    			Article_ResultVO aresult = new Article_ResultVO();
    			aresult.setMEM_ID(mifVO.getMem_id());
    			cnt = intservice.delAresult(aresult);
    			
    			// 기존 회원 정보 삭제 
    			MemberInfoVO memifVO = new MemberInfoVO();
    			memifVO.setMem_id(mifVO.getMem_id());
    			cnt = service.deleteMember(memifVO);
    		}
    				
    		if(cnt>0) {
    			AlertUtil.showAlert(del, "삭제하였습니다.");
    		}else {
    			AlertUtil.showAlert(del, "삭제 작업 실패!!");
    		}
    		
        	
    		Stage currentStage =  (Stage) btnDel.getScene().getWindow();
        	FXMLLoader loader = new FXMLLoader(MemberInfoController.class.getResource("../../fxml/adminmypage/memberInfo.fxml")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
    		Parent root = loader.load();
    		MemberInfoController memberInfo = loader.getController();
    		memberInfo.setMainController(this);
    		Scene scene = new Scene(root);
    		currentStage.setScene(scene);
    		currentStage.show();
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
		    
    }
    // 이메일 보내는거 
    @FXML
    void btnEmailCon(MouseEvent event) {

    }
    // 홈으로 버튼
    @FXML
    void btnHome(ActionEvent event) {
    	//홈으로 버튼 누르면 경고창 나오고  이동버튼 누르면 첫 화면으로 이동
    	try {
    		Stage currentStage =  (Stage) home.getScene().getWindow();
        	AlertUtil.showAlert(currentStage, "메인페이지로 이동하시겠습니까? ","변경된 정보는 저장되지 않습니다.","취소","이동");
        		
    		FXMLLoader loader = new FXMLLoader(MemberInfoController.class.getResource("../../fxml/adminmypage/memberInfo.fxml")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
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
    // 수정버튼
    @FXML
    void btnModify(ActionEvent event) {
    	Stage currentStage =  (Stage) btnModi.getScene().getWindow();
    	if(AlertUtil.showAlert((Stage) btnModi.getScene().getWindow(), "회원정보를 수정하시겠습니까?")) {
    		
    	// 수정한 데이터 저장하는거 
    	memInfoVO = new MemberInfoVO();
    	memInfoVO.setMem_id(textId.getText());
    	memInfoVO.setMem_pass(textPass.getText());
    	memInfoVO.setMem_email(textEmail.getText());
    	memInfoVO.setMem_name(textName.getText());
    	memInfoVO.setMem_regno(textReg.getText());
    	memInfoVO.setMem_tel(textTel.getText());
    	memInfoVO.setMem_zip(textAdd.getText());
    	memInfoVO.setMem_addr(textAdd2.getText());
    	
    	
    	
    	
    	try {
			int cnt = service.updateMember(memInfoVO);
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	
    	
    	
    	}
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(MemberInfoController.class.getResource("../../fxml/adminmypage/memberInfo.fxml"));
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
		  //textPassRe.setText(mifVO.getMem_pass());
		  textName.setText(mifVO.getMem_name()); 
		  textReg.setText(mifVO.getMem_regno());
		  textTel.setText(mifVO.getMem_tel());
		  textEmail.setText(mifVO.getMem_email());
		  blackList.setText(mifVO.getMem_blacklist());
		  textAdd.setText(mifVO.getMem_zip()); 
		  textAdd2.setText(mifVO.getMem_addr());
		  // 아이디 값은 비활성화 
		  textId.setEditable(false);
		  
		  
		  
    }
    
    
    // 인증번호 확인 버튼 
    @FXML
    void btnNumCon(MouseEvent event) {

    }

    @FXML
    void initialize() {
    	 // service 생성
    	try {
			Registry reg = LocateRegistry.getRegistry(8888);
			
			service = (ImemberInfoService) reg.lookup("ImemberInfoService");
		} catch (RemoteException e) {
			e.printStackTrace();
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
       
       
    }
    }
}
