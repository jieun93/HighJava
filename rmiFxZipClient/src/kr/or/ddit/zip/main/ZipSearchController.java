package kr.or.ddit.zip.main;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.zip.service.IZipSearchService;
import kr.or.ddit.zip.util.AlertUtil;
import kr.or.ddit.zip.vo.ZipVO;

public class ZipSearchController {

	private IZipSearchService service;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbSelect;

    @FXML
    private TextField tfSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<ZipVO> zipTable;

    @FXML
    private TableColumn<?, ?> zipCol;

    @FXML
    private TableColumn<?, ?> sidoCol;

    @FXML
    private TableColumn<?, ?> gugunCol;

    @FXML
    private TableColumn<?, ?> dongCol;

    @FXML
    private TableColumn<?, ?> riCol;

    @FXML
    private TableColumn<?, ?> bldgCol;

    @FXML
    private TableColumn<?, ?> bunjiCol;
    
    

    // 검색 버튼
    @FXML
    void btnSearchClicked(ActionEvent event) {
    	
    	try {
	    	
	    	// 검색할 문자열 구하기
	    	String searchData = tfSearch.getText();
	    	
	    	if(searchData.isEmpty()) {
	    		AlertUtil.errorMsg("입력 오류", "검색할 문자를 입력하세요");
	    		tfSearch.requestFocus();
	    		return;
	    	}
	    	
	    	// 콤보박스에서 선택한 값 구하기
	    	String cmbData = cmbSelect.getValue();
	    	
	    	List<ZipVO> ziplList = null;
	    	if("동이름".equals(cmbData)) {
	    		ziplList = service.getZipSearchDong(searchData);
	    	}else if("우편번호".equals(cmbData)) {
	    		ziplList = service.getZipSearchCode(searchData);
	    	}
	    	
	    	if(ziplList==null) {
	    		AlertUtil.infoMsg("작업결과", "검색한 데이터가 없습니다.");
	    		zipTable.getItems().clear();
	    	}else {
	    		zipTable.setItems(FXCollections.observableArrayList(ziplList));
	    	}
	    	
    	}catch (RemoteException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
    	// Service 객체 생성
    	try {
			Registry reg = LocateRegistry.getRegistry(9999);
			
			service = (IZipSearchService) reg.lookup("zipService");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	// TableView의 각 컬럼 설정
    	zipCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
    	sidoCol.setCellValueFactory(new PropertyValueFactory<>("sido"));
    	gugunCol.setCellValueFactory(new PropertyValueFactory<>("gugun"));
    	dongCol.setCellValueFactory(new PropertyValueFactory<>("dong"));
    	riCol.setCellValueFactory(new PropertyValueFactory<>("ri"));
    	bldgCol.setCellValueFactory(new PropertyValueFactory<>("bldg"));
    	bunjiCol.setCellValueFactory(new PropertyValueFactory<>("bunji"));
    	
    	// ComboBox 설정
    	cmbSelect.getItems().addAll("동이름", "우편번호");
    	cmbSelect.setValue("동이름");
    	
    	
    }
}







