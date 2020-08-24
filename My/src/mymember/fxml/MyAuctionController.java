package mymember.fxml;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mymember.service.IMymemberService;
import mymember.service.MymemberServiceImpl;
import mymember.vo.A_ArticleVO;
import mymember.vo.ArticleInterestMemVO;



// 내 경매 내역 화면

public class MyAuctionController {
	
	private IMymemberService service;
	private ObservableList<ArticleInterestMemVO> data;
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ArticleInterestMemVO> auctionResult;
    
    // 물건번호
    @FXML
    private TableColumn<?, ?> prodNum;

    // 물건 이름
    @FXML
    private TableColumn<?, ?> prodName;

    // 경매 결과 
    @FXML
    private TableColumn<?, ?> acResult;

    private void setArticleData() {
    	
    	ArticleInterestMemVO articleList = service.getMyArticle("2");
    	data = FXCollections.observableArrayList(articleList);
    	ArticleInterestMemVO.setItems(data);
    }
    
    @FXML
    void initialize() {
       
    	service = MymemberServiceImpl.getInstance();
    	
    	prodNum.setCellValueFactory(new PropertyValueFactory<>("A_ART_NO") );
    	prodName.setCellValueFactory(new PropertyValueFactory<>("A_ART_NAME"));
    	acResult.setCellValueFactory(new PropertyValueFactory<>("A_ART_RESULT"));
    	
    	setArticleData();
    	
    
    }
}
