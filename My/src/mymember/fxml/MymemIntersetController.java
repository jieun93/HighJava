package mymember.fxml;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mymember.service.IMymemberService;
import mymember.service.MymemberServiceImpl;
import mymember.vo.InterestVO;

public class MymemIntersetController {
	
	private IMymemberService service;
	private ObservableList<InterestVO> data;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<InterestVO> interestView;
    //물건 번호
    @FXML
    private TableColumn<?, ?> prodNum;
    // 물건명
    @FXML
    private TableColumn<?, ?> prodName;
    // 경매날짜
    @FXML
    private TableColumn<?, ?> autionDate;

    @FXML
    void interestView(MouseEvent event) {
    	
    } 
    
    // db데이터를 가져와 tableview에 출력하는 메소드
    private void setInterestData() {
    	List<InterestVO> interestList = service.getAllInterstProd("jieun");
    	data = FXCollections.observableArrayList(interestList);
    	interestView.setItems(data);
    	
    }

    @FXML
    void initialize() {
        
    	prodNum.setCellValueFactory(new PropertyValueFactory<>("a_art_no"));
    	prodName.setCellValueFactory(new PropertyValueFactory<>("A_ART_NAME"));
    	autionDate.setCellValueFactory(new PropertyValueFactory<>("A_ART_DAY"));
    
    	service = MymemberServiceImpl.getInstance();
    	setInterestData();
    }
}
