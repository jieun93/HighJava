package prodFxTest.fxml;



import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import prodFxTest.service.prodFxTestServiceImpl;
import prodFxTest.service.prodFxTestservice;
import prodFxTest.vo.LprodVO;
import prodFxTest.vo.prodVO;

public class ProdFxTestController {
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<LprodVO> lprod;

    @FXML
    private TableView<prodVO> tableView;

    @FXML
    private TableColumn<?, ?> prodId;

    @FXML
    private TableColumn<?, ?> prodName;

    @FXML
    private TableColumn<?, ?> prodLgu;

    @FXML
    private TableColumn<?, ?> prodBuyer;

    @FXML
    private TableColumn<?, ?> prodCost;

    @FXML
    private TableColumn<?, ?> prodPrice;

    @FXML
    private TableColumn<?, ?> prodSale;

    private prodFxTestservice service;
    private ObservableList<LprodVO> lprodCmbList;		// lprod 리스트 담을거  ObservableList 리스트를 추가할때 사용하는 메소드?
    private ObservableList<prodVO> prodCmbList;			// prod 리스트 담을거
    private ObservableList<prodVO> prodSelList;			//  prod 테이블에서 선택한거   화면 전환되서 나오는 창???
    
    // 콤보박스를 눌렀을때 actionevent
    @FXML
    void lprodList(ActionEvent event) {
 
    }
    
    
    // 테이블창에 나오는거 
    @FXML
    void tableViewShow(MouseEvent event) throws IOException {
    	if(tableView.getSelectionModel().getSelectedItem()==null) {
    		System.out.println("선택된게 없다.");
    		return;
    	}
    	
    	FXMLLoader loader = new FXMLLoader(ProdFxTestController.class.getResource("prodInfo.fxml"));
    	Parent root = loader.load();

    	Stage stage =(Stage)tableView.getScene().getWindow(); // 화면전환 하는 부분
    	
    	prodInfoController controller = loader.getController();
    	//controller.setData(tableView.getSelectionModel().getSelectedItem().getPROD_NAME());
    	
    	Scene scene = new Scene(root);
    
    	stage.setScene(scene);
    	stage.setTitle("상세보기");
    	stage.show();
    	
    	
    	
    	//선택한 곳의 데이터 구하기
    	prodVO prodselec = tableView.getSelectionModel().getSelectedItem();
	    	
    	
	}

    @FXML
    void initialize() {
    	// service 객체 생성
        service = prodFxTestServiceImpl.getinstance();
        
        // tableView의 각 컬럼 설정
        prodId.setCellValueFactory(new PropertyValueFactory<>("PROD_ID"));
        prodName.setCellValueFactory(new PropertyValueFactory<>("PROD_NAME"));
        prodLgu.setCellValueFactory(new PropertyValueFactory<>("PROD_LGU"));
        prodBuyer.setCellValueFactory(new PropertyValueFactory<>("PROD_BUYER"));
        prodCost.setCellValueFactory(new PropertyValueFactory<>("PROD_COST"));
        prodPrice.setCellValueFactory(new PropertyValueFactory<>("PROD_PRICE"));
        prodSale.setCellValueFactory(new PropertyValueFactory<>("PROD_SALE"));
        
        // 콤보 박스에 데이터 채워 넣기
        List <LprodVO> lprodList = service.getAllLprod();
        lprodCmbList = FXCollections.observableArrayList(lprodList);
        lprod.setItems(lprodCmbList);
        lprod.setValue(lprodCmbList.get(0));
        
        // 콤보박스의 내용을 상품분류명으로 나타나도록 설정 setCellFactory
        lprod.setCellFactory(new Callback<ListView<LprodVO>, ListCell<LprodVO>>(){
        	@Override
        	public ListCell<LprodVO> call(ListView<LprodVO> param) {
        		return new ListCell<LprodVO>() {
        			@Override
        			protected void updateItem(LprodVO item, boolean empty) {
        				super.updateItem(item, empty);
        				if(empty) {
        					setText(null);
        				}else{
        					setText(item.getLPROD_NM()); // 상품 분류명으로 지정
        				}
        				
        			}
        			
        			
        		};
        	}
        });
        
        // 콤보 박스에 1번 목록이 보여지게 만드는거 setButtonCell
        lprod.setButtonCell(new ListCell<LprodVO>() {
        	@Override
        	protected void updateItem(LprodVO item, boolean empty) {
        		super.updateItem(item, empty);
        		if(empty){
					setText(null);
				}else{
					setText(item.getLPROD_NM()); // 상품 분류명으로 지정
				}
        	}
		});
     
        // 콤보박스에서 선택한 lprod_gu의    prod  테이블에 보이는거 
        
        lprod.valueProperty().addListener(new ChangeListener<LprodVO>() { // LprodVO의 정보를 PROD롤 바꿔서 정보를 뿌려주는거
        	@Override
        	public void changed(ObservableValue<? extends LprodVO> observable, LprodVO oldValue, LprodVO newValue) {
        		if(newValue == null) return;
        		
        		// 현재 선택한 항목에서 lprod_gu값 구하기
        		String lprodgu = newValue.getLPROD_GU();
        		
        		
        		// 선택된 Lprod의 값의 prod정보를 테이블뷰에 뿌려주는거 
        		List <prodVO> TvList = service.tableView(lprodgu);
        		prodCmbList = FXCollections.observableArrayList(TvList);
        		tableView.setItems(prodCmbList);
        		
        	}
		});
    }
}

