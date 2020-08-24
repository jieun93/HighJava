package ComboBoxGugu;

import java.net.URL;
import java.util.ResourceBundle;

import basic.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

public class ComboBoxGuguController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> input;

    @FXML
    private Button btn;

    @FXML
    private TextArea text;

    
    // Button을 클릭했을 때  이벤트 처리 
    @FXML
    void btnA(ActionEvent event) {
    	// 콤보박스에서 선택한 값을 읽어온다.
    	
   	Integer gugu = Integer.parseInt(input.getValue());
   	
   	text.clear();
   /*	 
   	if(gugu == null) {
   		Alert alert = new Alert(AlertType.ERROR);
	   		alert.setTitle("오류");
	   		alert.setHeaderText("작업오류");
	   		alert.setContentText("출력할 단을 선택하세요");
	   		alert.showAndWait();
   		return;
   	}
   	*/
   	AlertUtil.errorMsg("작업오류", "출력할 단을 선택하세요");   //  AlertUtil 클래스에 만들어 놓은걸 불러오는거 
   	
   	
   	
    	// 구구단 값 나타내는거 
    	for(int i=1; i<=9; i++) {
			int r = gugu * i;
			text.appendText(gugu+"*"+i+"="+r+"\n");
    	}
    	
    }
    // ObservableList<Integer> danList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
    	
// 단 선택 받는 박스
    	
    	input.getItems().addAll("1","2","3","4","5","6","7");
    	
    	input.setValue(input.getItems().get(0));
    	
    	//danList.addAll(1,2,3,4,5,6,7,8,9);
    	//input.setItems(danList);
    	
 

    }
}

