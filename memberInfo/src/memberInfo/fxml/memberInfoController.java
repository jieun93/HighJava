package memberInfo.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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
import javafx.stage.Stage;
import memberInfo.dao.memberInfoDaoImpl;
import memberInfo.service.ImemberInfoService;
import memberInfo.service.memberInfoServiceImpl;
import memberInfo.vo.memberInfoVO;
// 회원정보 관리 첫 화면 
public class memberInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textfiled;

    @FXML
    private Button search;

    @FXML
    private TableView<?> memTable;

    @FXML
    private TableColumn<?, ?> memid;

    @FXML
    private TableColumn<?, ?> memName;

    @FXML
    private TableColumn<?, ?> memReg;

    @FXML
    private Button memberModi;

    @FXML
    private Button blacklist;

    @FXML
    private Button home;
    
    private ImemberInfoService service;
    private ObservableList<memberInfoVO> memberInfoList; //  검색을 눌렀을 떄
    private ObservableList<memberInfoVO> memberList;	 //  회원수정페이지 
    
    
    
    // 블랙리스트 버튼
    @FXML
    void blacklistBtn(ActionEvent event) {

    }
    // 홈으로 버튼
    @FXML
    void homeBtn(ActionEvent event) {

    }
    // 회원 수정 버튼을 누르면 화면 전환 
    @FXML
    void memModiBtn(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(memberInfoController.class.getResource("memberInfoModify.fxml"));
    	Parent root = loader.load();
    	Stage stage = (Stage) memTable.getScene().getWindow();
    	
    	Scene scene = new Scene (root);
    	stage.setScene(scene);
    	stage.setTitle("회원정보 수정");
    	stage.show();
    }
    // 회원관리 테이블 뷰
    @FXML
    void memTableView(ActionEvent event) {

    }
    // 검색버튼
    @FXML
    void serchBtn(ActionEvent event) {

    }
    // 검색 창
    @FXML
    void textfiled(ActionEvent event) {

    }

    @FXML
    void initialize() {
     // 서비스 객체 생성
    	service = memberInfoServiceImpl.getinstance();
    	
    	
    	
    	
    }
}

