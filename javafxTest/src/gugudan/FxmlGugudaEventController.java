package gugudan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FxmlGugudaEventController {

		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField submit;

	    @FXML
	    private Label dan;

	    @FXML
	    private Button input;

	    @FXML
	    private TextArea content;

	    @FXML
	    void btnClick(MouseEvent event) {

	    }


	    @FXML
	    void btncClick(ActionEvent event) {
    	// TextField 에 값 입력하기
    	int temp = Integer.parseInt(submit.getText());
    	
    	// 내용지우기
    	//submit.clear();
    	//dan.requestFocus(); //포커스 주기
    	
    	
    	
    	for(int i=1; i<=9; i++) {
    		content.appendText(temp+"*"+i+"="+temp*i);
    		
    	}

    }

    @FXML
    void initialize() {
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'gugudan.event.fxml'.";
        assert input != null : "fx:id=\"input\" was not injected: check your FXML file 'gugudan.event.fxml'.";
        assert content != null : "fx:id=\"content\" was not injected: check your FXML file 'gugudan.event.fxml'.";

    }
}
