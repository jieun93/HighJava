package RadioButtonTest2;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RadioButtonT2controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label name;

    @FXML
    private TextField nametext;

    @FXML
    private ToggleGroup genderr;

    @FXML
    private Label gender;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private Label hobby;

    @FXML
    private CheckBox travel;

    @FXML
    private CheckBox hiking;

    @FXML
    private CheckBox book;

    @FXML
    private CheckBox baduk;

    @FXML
    private CheckBox janggi;

    @FXML
    private CheckBox game;

    @FXML
    private CheckBox tenis;

    @FXML
    private CheckBox badmin;

    @FXML
    private Button show;

    @FXML
    private TextArea contentbox;

    	
    @FXML
    void show(ActionEvent event) {
    	//이름
    	String name=""; // 입력 받을  이름 변수 만들기
    	name = nametext.getText(); // 입력 받는  값을  담는거
    	contentbox.appendText(name);	// 입력 받은것을  TextArea contentbox로 지정한곳에 이름을 넣는다.
    	
    	//성별
    	male.setUserData("남"); // male의 데이터를 가져와서 "남" 으로 한다.
    	female.setUserData("여"); 
    	
    	String url = genderr.getSelectedToggle().getUserData().toString(); // 남, 여 선택된 라디오에 toggle를 설정해서 넣어준다.
    	String temp = url;
    	contentbox.appendText(temp); //TextArea contentbox 부분에 temp 값을 넣어준다.
    	
    	//취미
    	CheckBox[] chkbox = new CheckBox[] {travel, hiking, book, baduk, janggi, 
    			game, tenis, badmin};  // 체크박스 배열을 만들어서 선택지를 넣어준다.
    	
    	int lastNum = -1;   // 인덱스 번호로 num을 값을 가져올것 ==> 취미없습니다. 할거
    	String temp2 = "";  //  선택 값이 들어갈 변수
    	
    	
    	for(int i = 0; i<chkbox.length; i++) {
    		if(chkbox[i].isSelected()) {
    			lastNum = i; 	// 마지막 체크된 값의  인덱스의 번호
    		}
    	}
    	
    	
    	for(int j = 0; j <chkbox.length; j++) {
    		if(chkbox[j].isSelected()) {
    			if(j==lastNum){
    				temp2 += chkbox[j].getText();
    			}else{
    				temp2 += chkbox[j].getText()+",";
    			}
    		}
    	}
    	
    	if(lastNum == -1){
    		contentbox.appendText("당신의 취미는 없군요!");
    		
    	}else {
    		contentbox.appendText("취미는 "+temp2);
    	}
    	
    	
    	
    	
    	
    	
    	

    }

    @FXML
    void initialize() {
    	
    	//초기화 하는 작업을 처리하는 곳 
       
    }
}
