package memberInfo.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.css.Style;

import AlertDialog.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import memberInfo.dao.memberInfoDaoImpl;
import memberInfo.fxml.MemberInfoModifyController;
import memberInfo.service.ImemberInfoService;
import memberInfo.service.memberInfoServiceImpl;
import memberInfo.vo.MemberInfoVO;
// 회원정보 관리 첫 화면 
public class MemberInfoController {
	
	private MemberInfoModifyController memberInfoController;
	
	public MemberInfoModifyController getMainInfoController() {
		return  memberInfoController;
	}
	
	public void  setMainController(MemberInfoModifyController mainController) {
		this.memberInfoController = mainController;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    // 검색창     
    @FXML
    private TextField textfiled;
    
    // 회원 id  검색 버튼 
    @FXML
    private Button search;

    @FXML
    private TableView<MemberInfoVO> memTable;

    @FXML
    private TableColumn<?, ?> memid;

    @FXML
    private TableColumn<?, ?> memName;

    @FXML
    private TableColumn<?, ?> memReg;
    
    // 정보수정 버튼
    @FXML
    private Button memberModi;
    
    // 블랙리스트 버튼 
    @FXML
    private Button blacklist;
    
    // 홈으로 버튼 
    @FXML
    private Button home;
    
    private ImemberInfoService service;
    private ObservableList<MemberInfoVO> memberInfoList; //  검색을 눌렀을 떄
    
    private MemberInfoModifyController modifyController;
    private ObservableList<MemberInfoVO> data;
    // 블랙리스트 버튼
    @FXML
    void blacklistBtn(ActionEvent event) {
		
		  
    	
    	
    	
    }
    
    
    // 홈으로 버튼을 누르면 메인창으로 이동한다. fxml파일 연결해야 함 
    @FXML
    void homeBtn(ActionEvent event) {
    	try {
    		Stage currentStage =  (Stage) home.getScene().getWindow();
        	AlertUtil.showAlert(currentStage, "메인페이지로  ","이동하시겠습니까?","취소","이동");
        		
    		FXMLLoader loader = new FXMLLoader(MemberInfoController.class.getResource("")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
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
    
    
    
    private void setMainController(MemberInfoController memberInfoController2) {
		// TODO Auto-generated method stub
		
	}

	// 회원 수정 버튼을 누르면 화면 전환 
    @FXML
    void memModiBtn(ActionEvent event) throws IOException {
    
    	
    	FXMLLoader loader = new FXMLLoader(MemberInfoController.class.getResource("memberInfoModify.fxml"));
    	Parent root = loader.load();
    	Stage stage = (Stage) memTable.getScene().getWindow();
    	
    	Scene scene = new Scene (root);
    	stage.setScene(scene);
    	stage.setTitle("회원정보 수정");
    	stage.show();
    	
    	// 회원 정보 채워 넣는 부분
    	modifyController = loader.getController();
    	if(!memTable.getSelectionModel().isEmpty()) {
    		MemberInfoVO mifvo = memTable.getSelectionModel().getSelectedItem();
    		modifyController.show(mifvo);
    	}
    	
    	
    }
    
    // 회원관리 테이블 뷰
    // 테이블 뷰를 선택하면 수정버튼이 활성화 되도록 바뀌어 진다.

    @FXML
    void memTableView(MouseEvent event) {
			
		  if(memTable.getSelectionModel().isEmpty()){	
			  return;
		  }
		  memberModi.setDisable(false);
    	
    }
    
    // 검색버튼
    @FXML
    void serchBtn(ActionEvent event) {
    	
    	 String text = textfiled.getText();
    	 
    	  List <MemberInfoVO> memList = service.getSearchMember(text); 
    	  memberInfoList = FXCollections.observableArrayList(memList);
    	  memTable.setItems(memberInfoList);
    	  
    }
    
    // 검색 창
    @FXML
    void textfiled(ActionEvent event) {
    	
    	
    }   
    
	
    
    @FXML
    void initialize() {
    	
    	// 서비스 객체 생성
    	service = memberInfoServiceImpl.getinstance();
    	
    	//뷰에 각 컬럼 설정
    	memid.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
    	memName.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
    	memReg.setCellValueFactory(new PropertyValueFactory<>("mem_regno"));
    	
		
    	
    	
    	
    }
}

