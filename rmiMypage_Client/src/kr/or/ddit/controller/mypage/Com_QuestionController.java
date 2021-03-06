package kr.or.ddit.controller.mypage;


import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;


// 내 민원 창 
public class Com_QuestionController {
	
	private  IMymemberService service;
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
    	
    	try {
			Registry reg = LocateRegistry.getRegistry(9999);
			service = (IMymemberService) reg.lookup("IMymemberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
    	Title.setCellValueFactory(new PropertyValueFactory<>("COM_QUE_TITLE"));
    	Date.setCellValueFactory(new PropertyValueFactory<>("COM_QUE_WRITEDAY"));
    	state.setCellValueFactory(new PropertyValueFactory<>("CAT_A_NO"));
    	
    	setComQuestionData();
    	
//    	state.setCellFactory(new Callback<TableColumn<Com_AnswerVO,String>, TableCell<Com_AnswerVO,String>>() {
//			
//			@Override
//			public TableCell<Com_AnswerVO, String> call(TableColumn<Com_AnswerVO, String> param) {
//				
//				return new TableCell<Com_AnswerVO, String>(){
//					@Override
//					protected void updateItem(String item, boolean empty) {
//						super.updateItem(item, empty);
////						if(!empty) {
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
//					}
//				};
//			}
//		});
    	
    }
}
