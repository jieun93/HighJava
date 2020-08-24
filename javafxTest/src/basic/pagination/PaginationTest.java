package basic.pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class PaginationTest extends Application {
	private int rowsPerPage = 10; // 한 화면에 보여줄 데이터 개수 지정
	private int totalCount;			// 전체 레코드 수가 저장 될 변수 선언 
	private int pageCount; 			// 페이지 수 
	
	
	private TableView<MemberVO> table; // TableView 객체 변수 선언
	private Pagination pagination; // Pagination 객체 변수 선언
	
	private List<MemberVO> data; // 
	
	private IMemberService service; // service 객체 변수 선언 

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {
		service = MemberServiceImpl.getInstance();
		
		
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		
		table = new TableView<MemberVO>();
		
		
		TableColumn<MemberVO, String> idCol = new TableColumn<MemberVO, String>("아이디");
		idCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		idCol.setPrefWidth(150);
		
		
		TableColumn<MemberVO, String> nameCol = new TableColumn<MemberVO, String>("이름");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
		nameCol.setPrefWidth(200);
		
		TableColumn<MemberVO, String> telCol = new TableColumn<MemberVO, String>("전화번호");
		telCol.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
		telCol.setPrefWidth(200);
		
		TableColumn<MemberVO, String> addrCol = new TableColumn<MemberVO, String>("주소");
		addrCol.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
		addrCol.setPrefWidth(300);
		
		table.getColumns().addAll(idCol, nameCol, telCol, addrCol);
		
		// 전체 레코드 수를 구한다. 
		totalCount = service.getAllMemberCount();
		
		// 전체 페이지 수를 구한다.  ==> 102 / 10
	/*방법1*/ //	pageCount = (totalCount % rowsPerPage == 0) ? totalCount / rowsPerPage :(totalCount % rowsPerPage )+1;
	/*방법2*/	pageCount = (int) Math.ceil((double)totalCount/rowsPerPage);
		
		pagination = new Pagination();
		// Pagination객체에 전체 페이지 수와 처음에 보여줄 index값을 설정한다.
		//index값을  1페이지일 경우 0으로 지정한다.
		pagination.setPageCount(pageCount);
		pagination.setCurrentPageIndex(0);  // 처음 선택될 페이지의 index값 지정  1페이지를 보여줘야 하니깐 0으로 지정
		
		//첫 페이지의 데이터를 가져온다.
		changeTableView(0);
		
		pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				changeTableView(newValue.intValue());
				
			}
			
		});
		
		
		root.setCenter(table);
		root.setBottom(pagination);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("pagination연습");
		primaryStage.show();
		
	}
	
	//pagination 의 현재 선택된 index값을 매개값으로 받아서 해당 페이지에 맞는 데이터를 가져와 테이블뷰에 넣어주는 메서드
	// index는  0 => 1페이지, 1 => 2페이지 
	  public void changeTableView(int index) {
		int start =  index * rowsPerPage;   // 시작 번호 계산 
		int end = Math.min(start + rowsPerPage, totalCount);      // 끝 번호 계산
		
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("start",start);
		pageMap.put("end",end);
		
		
		data = service.getPagingMemberList(pageMap);
		
		table.setItems(FXCollections.observableArrayList(data));
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
