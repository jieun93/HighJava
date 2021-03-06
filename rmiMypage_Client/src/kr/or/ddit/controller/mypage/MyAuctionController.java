package kr.or.ddit.controller.mypage;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.vo.ArticleInterestMemVO;
import kr.or.ddit.vo.AuctionVO;




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

    public void setArticleData() {
    	try {
			
    	List<ArticleInterestMemVO> articleList = service.getMyArticle("jieun");
    	data = FXCollections.observableArrayList(articleList);
    	auctionResult.setItems(data);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
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
    	
    	prodNum.setCellValueFactory(new PropertyValueFactory<>("A_ART_NO") );
    	prodName.setCellValueFactory(new PropertyValueFactory<>("A_ART_NAME"));
    	acResult.setCellValueFactory(new PropertyValueFactory<>("A_ART_RESULT"));
    	
    	setArticleData();
    	
    
    }
}
