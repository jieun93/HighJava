package mymember.fxml;


import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import mymember.dao.MymemberDaoImpl;
import mymember.service.IMymemberService;
import mymember.vo.Com_AnswerVO;
import mymember.vo.Com_QuestionVO;

// 내 민원 창 
public class Com_QuestionController {
	
	private MymemberDaoImpl service;
	private ObservableList<Com_QuestionVO>  data;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Com_QuestionVO> inforView;

    @FXML
    private TableColumn<?, ?> Title;

    @FXML
    private TableColumn<?, ?> Date;
    
    @FXML
    private TableColumn<Com_AnswerVO, String> state;

    @FXML
    void inforView(ActionEvent event) {
    	
    }
    
    //db데이터를 가져와 tableView에 출력하는 메소드 
    private void setComQuestionData() {
    	List <Com_QuestionVO> comQusetionList = service.getMyQuestion("연습용 아이디");
    	data = FXCollections.observableArrayList(comQusetionList);
    	inforView.setItems(data);
    	
    }
    

    @FXML
    void initialize() {
    	
    	service = MymemberDaoImpl.getInstance();
    	Title.setCellValueFactory(new PropertyValueFactory<>("cOM_QUE_TITLE"));
    	Date.setCellValueFactory(new PropertyValueFactory<>("cOM_QUE_WRITEDAY"));
    	state.setCellValueFactory(new PropertyValueFactory<>("cAT_A_NO"));
    	setComQuestionData();
    	
    	state.setCellFactory(new Callback<TableColumn<Com_AnswerVO,String>, TableCell<Com_AnswerVO,String>>() {
			
			@Override
			public TableCell<Com_AnswerVO, String> call(TableColumn<Com_AnswerVO, String> param) {
				
				return new TableCell<Com_AnswerVO, String>(){
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
//						if(!empty) {
//							
//							Map<String,String> data = new HashMap<>();
//							data.put("no", item);
////							data.put("id", Session.getMemID());
//							Com_AnswerVO answerVO = service.getMyAnswer(data);
//							//answerVO의 No과 item(Question의 NO)이 같은지 비교
//							if(answerVO.getCOM_ANS_NO()== getItem()answerVO.) {
//								setText("답변완료");
//							}else {
//								setText("답변대기");
//							}
//						
//							
//							
//						}else {
//							setText(null);
//						}
					}
				};
			}
		});
    	
    }
}
