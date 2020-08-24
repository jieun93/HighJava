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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import prodFxTest.service.prodFxTestServiceImpl;
import prodFxTest.service.prodFxTestservice;
import prodFxTest.vo.prodVO;

public class prodInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private TableView<prodVO> tableInfo;
    
    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;
     
    private prodFxTestservice service;
    
    
    @FXML
    void btnBack(ActionEvent event) throws IOException {
    	
    	// 신에 넣어 주려고 loader하는 과정
    	FXMLLoader loader = new FXMLLoader(prodInfoController.class.getResource("prodFxTest.fxml")); 
    	Parent root = loader.load();   	
    	Scene scene = new Scene(root);
    	    	
    	Stage stage = (Stage)tableInfo.getScene().getWindow();
    	stage.setScene(scene);
    	stage.setTitle("선택한 데이터");
    	stage.show();
    	
    }

    @FXML
    void tbInfo(ActionEvent event) {
    	
    	
    }
    
    
    
    @FXML
    void initialize() {
       service = prodFxTestServiceImpl.getinstance();
    
       colID.setCellValueFactory(new PropertyValueFactory<>("PROD_ID"));
       colName.setCellValueFactory(new PropertyValueFactory<>("PROD_NAME"));
       
    }
}
